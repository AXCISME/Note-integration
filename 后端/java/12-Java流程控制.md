# Java流程控制

## 1. 用户交互Scanner

- 我们可以通过Scanner类类获取用户的输入

  包：java.util.Scanner

- 基本语法

```java
Scanner s = new Scanner(System.in);
```

- 通过Scanner类的next()与nextLine()方法获取输入的字符串，在读取前一般需要使用hasNext()与hasNextLine()判断是否还有输入的数据（nextInt()、nextDouble()、nextChar()等用法类似）
  - next():

    1. 一定要读取到有效字符后才可以结束输入

    2. 对输入有效字符之前遇到的空白，next()方法会自动将其去掉

    3. 只有输入有效字符后才能将其后面输入的空白作为分隔符或者结束符

    4. next()不能得到带有空格的字符串

```java
 package com.kuang.scanner;

import java.util.Scanner;

public class Case1 {
    public static void main(String[] args) {

        //创建一个扫描器对象，用于接受键盘数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用next方式接收：");

        //判断用户有没有输入字符串
        if(scanner.hasNext()){
            //使用next方式接收
            String str1 = scanner.next();
            System.out.println("输出的内容为："+str1);
        }

        //凡是属于IO流类的如果不关闭会一直占用资源，要养成好习惯用完就关掉
        scanner.close();
    }
}
```

  - nextLine()
    
    1. 以Enter为结束符
    2. 可以获得空白

```java
package com.kuang.scanner;

import java.util.Scanner;

public class case2 {
    public static void main(String[] args) {
        //创建一个扫描器对象，用于接受键盘数据
        Scanner scanner = new Scanner(System.in);

        System.out.println("使用nextLine方式接收:");

        if(scanner.hasNextLine()){
            String str = scanner.nextLine();
            System.out.println("输出的内容为："+str);
        }
        scanner.close();
    }
}
```

## 2.顺序结构

Java的基本结构是顺序结构，除非特别指明，否则就按照顺序一句一句执行

## 3.选择结构

### if语局

```java
//if单选择结构
if(布尔表达式){
    
}
```

```java
//if双选择结构
if(布尔表达式){
    
}else{
    
}
```

```java
//if多选择结构
if(布尔表达式1){
    
}else if(布尔表达式2){
    
}else if(布尔表达式3){
    
}else{
    
}
```

```java
//嵌套的if结构
if(布尔表达式1){
    
    if(布尔表达式2){
        
    }
}
```

### switch多选择结构

- switch语句中的变量类型可以是：

  - byte、short、int、或者char。

  - 从Java SE7开始switch支持字符串String类型了

  - case标签必须为字符串常量或字面量

 ```java
switch(experssion){
    case value:
        //语句
        break;	//可选
    case value:
        //语句
        break;	//可选
    default：	//可选
        //语句
}    
 ```

​    

## 4.循环结构

- while循环

```java
  while(布尔表达式){
      //循环内容
  }
```

- do...while循环

```java
do{
    //代码语句
}while(布尔表达式);
```

- for循环

```java
for(初始化;布尔表达式;更新){
    //代码语句
}
```

- Java5中引入主要用于数组的的增强型for循环

```java
for(声明语句:表达式){
    //代码句子
}
```

```java
package com.kuang.struct;

public class Case2 {
    public static void main(String[] args) {
        int numbers[] = {10,20,30,40,50};

        //遍历数组元素
        for(int x:numbers){
            System.out.println(x);
        }
    }
}
```

## 5.break&continue

- break用于强行退出循环
- continue用于终止某次循环



