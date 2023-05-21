# Java方法

- 设计方法的原则：方法的本意是模块，就是实现某个功能的语句块的集合。我们设计方法的时候，最好保持方法的原子性，就是一个方法只完成一个功能，这样利于我们后期的扩展。

```java
package com.kuang.method;

public class Case1 {
    //main方法
    public static void main(String[] args) {
        System.out.println(add(1,2));

        test();
    }

    //加法
    public static int add(int a,int b){
        return a+b;
    }

    public static void test(){
        for (int i = 0; i <= 1000; i++) {
            if(i%5==0){
                System.out.print(i+"\t");
            }
            if(i%(5*3)==0){
                System.out.println();
            }
        }
    }
}
```

## 方法的定义

Java的方法类似于其它语言的函数

```java
修饰符 返回值类型 方法名(参数类型 参数名){
    ...
    方法体
    ...
    return 返回值;
}
```

## 方法的重载

- 重载就是在一个类中，由相同的函数名称，但形参不同的函数
- 方法重载的规则：
  - 方法名必须相同。
  - 参数列表必须不同（个数不同，或类型不同、参数排列顺序不同等）。
  - 方法的返回类型可以相同也可以不相同。
  - 仅仅返回类型不同不足以成为方法的重载。

- 实现理论：
  - 方法名称相同时，编译器会根据调用方法的参数个数、参数类型等去逐个匹配，以选择对应的方法，如果匹配失败，则编译器报错。

## 命令行传参(了解)

```java
public class Case3 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("arge["+i+"]:"+args[i]);
        }
    }
}
```

## 可变参数

```java
public class Case4 {
    public static void main(String[] args) {
        Case4 case4 = new Case4();
        case4.test(1,2,3,4,5,6);
    }
    public void test(int x,int... i){
        System.out.println(i[0]);
        System.out.println(i[1]);
        System.out.println(i[2]);
        System.out.println(i[3]);
        System.out.println(i[4]);
        System.out.println(i[5]);
    }
}
```

## 递归

- 递归结构包括两个部分：
  - 递归头：什么时候不调用自身方法。如果没有头，将陷入死循环。
  - 递归体：什么时候需要调用自身方法。

```java
public class Case5 {
    public static void main(String[] args) {
        System.out.println(f(3));
    }
    public static int f(int n){
        if(n==1){
            return n;
        }else{
            return n*f(n-1);
        }
    }
}
```

