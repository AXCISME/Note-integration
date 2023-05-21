# JavaDoc

- javadoc命令是用来生成自己API文档的
- 参数信息
  - @author 作者名
  - @version 版本号
  - @since 指明需要最早使用的jdk版本
  - @param 参数名
  - @return 返回值情况
  - @throws 异常抛出情况

- DOS命令生成JavaDoc文档

```
javadoc -encoding UTF-8 -charset UTF-8 name.java
```

- IDEA生成JavaDoc文档
  1. 打开 idea，点击 Tools-> Generate JavaDoc，这样会打开生成 javadoc 文档的配置页面。
  2. 进行配置：

![image-20210216102033885](picture\image-20210216102033885.png)