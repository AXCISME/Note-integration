1. 引入依赖

```xml
<dependency>
    <groupId>org.redisson</groupId>
    <artifactId>redisson</artifactId>
    <version>3.13.6</version>
</dependency>
```



2. 配置Redisson客户端

```java
@Configuration
public class RedisConfig {
    @Bean
    public RedissonClient redissonClient() {
        // 配置类
        Config config = new Config();
        config.useSingleServer().setAddress("redis://60.205.2.70:6379").setPassword("axc123AXC");
        // 创建客户端
        return Redisson.create(config);
    }
}
```

3. 使用

```java
@Resource
private RedissonClient redissonClient;

@Test
void testRedisson() throws InterruptedException {
  // 获取锁（可重入），指定锁的名称
  RLock lock = redissonClient.getLock("lock:order:" + userId);
  // 尝试获取锁，参数分别是：获取锁的最大等待时间（期间会重试），锁自动释放时间，时间单位
  boolean isLock = lock.tryLock(1, 10, TimeUnit.SECONDS);
  // 判断锁是否获取成功
  if(isLock) {
    try {
      System.out.println("执行业务");
    }finally {
      // 释放锁
      lock.unlock();
    }
  }
}
```

