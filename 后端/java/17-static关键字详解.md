1. 静态方法不能调用非静态方法，非静态方法能够调用静态方法
2. 非静态方法需要创建对象，静态不需要

```java
package com.oop.demo07;

//static
public class Student {
    private static  int age;//静态的变量 多线程！
    private double score; //非静态的变量

    public void run(){

    }

    public static void go(){

    }

    public static void main(String[] args) {
        Student s1 = new Student();

        System.out.println(Student.age);
        System.out.println(s1.age);
        System.out.println(s1.score);

        new Student().run();
        Student.go();
    }
}

```

3. 静态代码块

```java
package com.oop.demo07;

public class Person {

    //2：赋初始值
    {
        System.out.println("匿名代码块");
    }

    //1:只执行一次
    static {
        System.out.println("静态代码块");
    }

    //3
    public Person(){
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("===========================");
        Person person1 = new Person();
    }
}
```

4. 静态导入包

```java
package com.oop.demo07;

//静态导入包
import static java.lang.Math.PI;
import static java.lang.Math.random;

public class Test {
    public static void main(String[] args) {
        System.out.println(random());
        System.out.println(PI);
    }
}
```

