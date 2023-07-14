# 消息应答



为了保证消息在发送过程中不丢失，rabbitmq 引入消息应答机制，消息应答就是**消费者在接收到消息并且处理该消息之后，告诉 rabbitmq 它已经处理了，rabbitmq 可以把该消息删除了**。



## 自动应答



自动应答**只以消费者接收到消息**为准，不可靠



## 手动应答



- `channel.basicAck`：用于肯定确认，RabbitMQ 已经知道该消息并且成功的处理消息，可以将其丢弃了
- `channel.basicNack`：用于否定确认，可以一次**否定确认多条**消息
- `channel.basicReject`：用于否定确认，只能**否定确认单条**消息



手动应答的好处是可以**批量应答并且减少网络拥堵**



批量应答示意图如下：

<img src="https://img-blog.csdnimg.cn/a45a4e42912b4139876c6e5ed6c7a47d.png" alt="在这里插入图片描述" style="zoom:67%;" />



由图可见**批量应答不可靠**，可能会造成消息丢失，因此开发中不进行批量应答，即 multiple 改为 false



```java
channel.basicAck(long deliveryTag, boolean multiple)
```



multiple：true 代表批量应答，false 代表取消批量应答



## 消息自动重新入队



如果消费者由于某些原因失去连接，导致消息未发送 ACK 确认，RabbitMQ 将了解到消息未完全处理，并将对其重新排队，示意图如下：



![在这里插入图片描述](https://img-blog.csdnimg.cn/7b186a08572f4eac8e821fa8d5c49152.png)



# 持久化



## 队列持久化



如果创建的队列没有设置持久化，rabbitmq 重启的化该队列就会被删除掉，如果要队列实现持久化，需要在声明队列的时候把 durable 参数设置为持久化：

```java
queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete,
                                 Map<String, Object> arguments) throws IOException;
```



> 需要注意的是如果之前声明的队列不是持久化的，那么需要把原先队列先删除，或者重新创建一个持久化的队列。
>
> 而不能在之前声明的队列上重新声明持久化，否则会报错。



下图为控制台中持久化与非持久化队列的 UI 显示区：

![在这里插入图片描述](https://img-blog.csdnimg.cn/15dd7a39840c463a8531cf90884855ba.png)



这个时候即使重启 rabbitmq 队列 ack_queue 也依然存在。



## 消息持久化



在消息生产者发送消息时实现消息实现持久化（保存在磁盘上）：

```java
basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
```



设置 props 参数为 `MessageProperties.PERSISTENT_TEXT_PLAIN`



> 将消息标记为持久化并**不能完全保证**不会丢失消息，因为它还存在当消息刚准备存储在磁盘的时候 但是还没有存储完，消息还在缓存的这样一个间隔点。



# 不公平分发



RabbitMQ 分发消息默认采用的轮询分发，可以通过在消费者中设置参数 `channel.basicQos(1)` 来更改为不公布分发，消费者只有在消费完消息后队列才会再分配给他消息。



## 预取值



`channel.basicQos(int prefetchCount)` ：prefetchCount 就是设置的预取值，它决定了消费者在未发送确认消息之前可以接收多少个消息。



# 发布确认



![在这里插入图片描述](https://img-blog.csdnimg.cn/f378b3ad1f2e4e919af86241322a4874.png)



之前的队列和消息持久化只能确保消息在 RabbitMQ 重启或故障恢复后仍然可用，但无法提供对消息发送结果的监控和处理，发布确认机制则可以提供**对消息发送结果的实时监控和处理**，将三者相结合，以提供更全面的消息可靠性和处理能力。



- `channel.confirmSelect()`：开启发布确认
- `boolean waitForConfirms()`：
  - true：表示所有已经发出的消息都得到了成功的确认存储到 RabbitMQ 的磁盘中
  - false：表示至少有一条消息未被成功确认



## 单个发布确认



**同步**的方式，也就是发布一个消息之后只有它被发布确认，后续的消息才能继续发布，发布速度特别的慢，示例代码如下：

```java
  Channel channel = RabbitMqUtils.getChannel();
        // 队列的声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        // 开启发布确认
        channel.confirmSelect();
        // 开始时间
        long begin = System.currentTimeMillis();
        // 批量发消息
        for (int i = 0; i < 1000; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            // 单个消息进行发布确认
            boolean flag = channel.waitForConfirms();
            if (flag) {
                System.out.println("消息确认被存到磁盘");
            }
        }
        // 结束时间
        long end = System.currentTimeMillis();
        System.err.println("发布 1000 个消息耗时" + (end - begin) + "ms");
```



## 批量发布确认



也是**同步**的方式，比单个发布确认极大的提高了吞吐量，缺点在于发生异常时，并不知道是哪个消息出现问题，示例代码如下：

```java
        Channel channel = RabbitMqUtils.getChannel();
        // 队列的声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        // 开启发布确认
        channel.confirmSelect();
        // 开始时间
        long begin = System.currentTimeMillis();
        // 批量发消息
        for (int i = 1; i <= 1000; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            // 每达到 100 条消息的时候批量确认一次
            if (i % 100 == 0) {
                // 发布确认
                channel.waitForConfirms();
            }
        }
        // 结束时间
        long end = System.currentTimeMillis();
        System.err.println("发布 1000 个消息耗时" + (end - begin) + "ms");
```



## 异步发布确认



异步发布确认的可靠性和效率都会比同步的好很多，他是利用**回调函数**来达到消息可靠性传递的。



<img src="https://img-blog.csdnimg.cn/8abef23f8e9a45009b8b269ab1466cb8.png" alt="在这里插入图片描述" style="zoom:80%;" />



示例代码如下：

```java
       Channel channel = RabbitMqUtils.getChannel();
        // 队列的声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        // 开启发布确认
        channel.confirmSelect();
        // 开始时间
        long begin = System.currentTimeMillis();

        // 准备消息的监听器，监听发送消息的成功与失败，第一个参数监听成功，第二个参数监听失败
        channel.addConfirmListener(( deliveryTag,  multiple)-> {
            // 消息发布确认成功的回调函数
            System.out.println("确认的消息" + deliveryTag);
        }, ( deliveryTag,  multiple)-> {
            // 消息发布确认失败的回调函数
            System.out.println("未确认的消息" + deliveryTag);
        });

        // 批量发送消息
        for (int i = 0; i < 1000; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());

        }
        // 结束时间
        long end = System.currentTimeMillis();
        System.err.println("发布 1000 个消息耗时" + (end - begin) + "ms");
```



需要处理未确认消息，解决方案是把未确认的消息放到一个基于内存的能被发布线程访问的集合，比如 ConcurrentSkipListMap ，让发布消息的线程和两个回调函数线程之间进行消息的传递，示例代码如下：

```java
        Channel channel = RabbitMqUtils.getChannel();
        // 队列的声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        // 开启发布确认
        channel.confirmSelect();

        /**
         * 线程安全有序的一个哈希表，适用于高并发的情况下
         * 作用：
         *      1.能够将序号和消息进行关联（key_value）
         *      2.能够批量删除已确认的消息
         *      3、支持高并发（多线程）
         */
        ConcurrentSkipListMap<Long, String> map =
                new ConcurrentSkipListMap<>();

        // 准备消息的监听器，监听发送消息的成功与失败，第一个参数监听成功，第二个参数监听失败
        channel.addConfirmListener(( deliveryTag,  multiple)-> {
            // 消息发布确认成功的回调函数
            System.out.println("确认的消息" + deliveryTag);
            // 2.删除已经确认的消息
            map.remove(deliveryTag);
        }, ( deliveryTag,  multiple)-> {
            // 消息发布确认失败的回调函数
            System.out.println("未确认的消息" + deliveryTag);
            // 3.打印未确认的消息
            System.out.println("未确认的消息是" + map.get(deliveryTag) + "标记是" + deliveryTag);
        });

        // 开始时间
        long begin = System.currentTimeMillis();
        // 批量发送消息
        for (int i = 0; i < 1000; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            // 1. 记录下所有要发布的消息
            // channel.getNextPublishSeqNo()：返回下一条消息的序列号
            map.put(channel.getNextPublishSeqNo() - 1, message);
        }

        // 结束时间
        long end = System.currentTimeMillis();
        System.err.println("发布 1000 个消息耗时" + (end - begin) + "ms");
```



>3 种分发确认对比：
>
>- 单个发布确认：同步等待确认，简单，但吞吐量非常有限。
>- 批量发布确认：批量同步等待确认，简单，合理的吞吐量，但是一旦出现问题但很难推断出是那条消息出现了问题
>- 异步发布确认：最佳性能和资源使用，在出现错误的情况下可以很好地控制，实现起来稍麻烦





