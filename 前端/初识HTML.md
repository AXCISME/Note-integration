# <center>  1. 什么是HTML</center>

- HTML:Hyper Text Markup Language(超文本标记语言)

## W3C标准

- W3C:
  - World Wide Web Consortium(万维网联盟)
  - 成立于1994年，Web技术领域最权威和最具影响力的国际中立性技术标准机构
  - http://www.w3.org/
  - http://www.chinaw3c.org/

- W3C标准包括：
  - 结构化标准语言（HTML、XML）
  - 表现标准语言（CSS）
  - 行为标准（DOM、ECMAScript）

# 2. 网页基本信息

```html
<!--DOCTYPE：告诉浏览器，我们要使用什么规范-->

<!DOCTYPE html>
<html lang="en">

<!--head标签代表网页头部-->
<head>
    <!--mata描述性标签，它用来描述我们网站的一些信息-->
    <!--一般用来做SEO-->
    <meta charset="UTF-8">
    <meta name="keyworlds" content="狂神说Java">
    <meta name="description" content="来这个地方可以学习Java">

    <!--title网页标题-->
    <title>我的第一个网页</title>
</head>

<!--head标签代表网页主体-->
<body>
Hello,World!
</body>
</html>
```

# 3. 网页基本标签

```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>基本标签学习</title>
</head>
<body>
<!--标题标签-->
<h1>一级标签</h1>
<h2>二级标签</h2>
<h3>三级标签</h3>
<h4>四级标签</h4>

<!--段落标签-->
<p>两只老虎爱跳舞，小 兔子乖乖拔萝卜，</p>
<p>我和小鸭子学走路，童年是最美的礼物。</p>
<p>小螺号呀嘀嘀地吹，我学海鸥展翅飞，</p>
<p>不怕风雨不怕累，快快把本领都学会。</p>

<!--水平线标签-->
<hr/>

<!--换行标签-->
两只老虎爱跳舞，小兔子乖乖拔萝卜，<br/>
我和小鸭子学走路，童年是最美的礼物。<br/>
小螺号呀嘀嘀地吹，我学海鸥展翅飞，<br/>
不怕风雨不怕累，快快把本领都学会。<br/>

<!--粗体，斜体-->
<h1>字体样式标签</h1>

粗体：<strong>i love you</strong>
斜体：<em>i love you</em>

<br/>
<!--特殊符号-->

空 格：
空&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格

<br/>
<!--大于-->
&gt;
<br/>
<!--小于-->
&lt;
<br>
<!--版权符号-->
&copy;版权所有AXC
</body>
</html>
```

# 4. 图像标签

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图像标签学习</title>
</head>
<body>
<!--img学习
src:图片地址(必填)
    相对地址，绝对地址
    ../   上一级目录

alt:图片名字（必填）
-->
<img src="../resources/image/1.jpg" alt="红色眼睛短发动漫美女" title="悬停文字" width="496" height="701">
</body>
</html>
```

# 5. 链接标签

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>链接标签学习</title>
</head>
<body>

<!--使用name做标记-->
<a name="top">顶部</a>
<!--a标签
href:必填，表示要跳转到那个页面
target:表示窗口再哪里打开
  _blank  在新标签中打开
  _self  在自己的网页中打开
-->
<a href="1. 我的第一个网页.html" target="_blank">点击我跳转到页面</a>
<a href="https://www.baidu.com" target="_self">点击我跳转到百度</a>
<br>
<a href="https://www.baidu.com">
  <img src="../resources/image/1.jpg" alt="红色眼睛短发动漫美女" title="悬停文字" width="496" height="701">
</a>
<p>
    <a href="https://www.baidu.com">
        <img src="../resources/image/1.jpg" alt="红色眼睛短发动漫美女" title="悬停文字" width="496" height="701">
    </a>
</p>
<p>
    <a href="https://www.baidu.com">
        <img src="../resources/image/1.jpg" alt="红色眼睛短发动漫美女" title="悬停文字" width="496" height="701">
    </a>
</p>
<p>
    <a href="https://www.baidu.com">
        <img src="../resources/image/1.jpg" alt="红色眼睛短发动漫美女" title="悬停文字" width="496" height="701">
    </a>
</p>
<p>
    <a href="https://www.baidu.com">
        <img src="../resources/image/1.jpg" alt="红色眼睛短发动漫美女" title="悬停文字" width="496" height="701">
    </a>
</p>
<p>
    <a href="https://www.baidu.com">
        <img src="../resources/image/1.jpg" alt="红色眼睛短发动漫美女" title="悬停文字" width="496" height="701">
    </a>
</p>

<!--锚链接
1.需要一个标记
2.跳转到标记
-->
<a href="#top">回到顶部</a>

<!--功能性链接
邮件链接：mailto:
QQ链接
-->

<a href="mailto:2234906940@qq.com">点击联系我</a>
<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=&site=qq&menu=yes">
    <img border="0" src="../resources/image/img.png" alt="你好，加我领取小电影" title="你好，加我领取小电影"/>
</a>
</body>
</html>
```

# 6. 行内元素和块元素

- 块元素
  - 无论内容多少，该元素独占一行
  - （p、h1-h6...）

- 行内元素
  - 内容撑开宽度，左右都是行内元素的可以排在一行
  - （a . strong . em ...）

# 7. 列表

- 什么是列表
  - 列表就是信息资源的一种展现形式。它可以使信息结构化和条理化，并以列表的样式展示出来，以便浏览者能更快捷地获得相应的信息。

- 列表地分类
  - 无序列表
  - 有序列表
  - 定义列表

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>列表学习</title>
</head>
<body>
<!--有序列表-->
<ol>
  <li>Java</li>
  <li>Python</li>
  <li>运维</li>
  <li>前端</li>
  <li>C/c++</li>
</ol>

<hr/>

<!--无序列表-->
<ul>
  <li>Java</li>
  <li>Python</li>
  <li>运维</li>
  <li>前端</li>
  <li>C/c++</li>
</ul>
<!--自定义列表
dl:标签
dt:列表名称
dd:列表选项
-->
<dl>
  <dt>学科</dt>

  <dd>Java</dd>
  <dd>Python</dd>
  <dd>Linux</dd>
  <dd>C</dd>

  <dt>位置</dt>

  <dd>西安</dd>
  <dd>上海</dd>
  <dd>承德</dd>
  <dd>北戴河</dd>
</dl>
</body>
</html>
```

# 8. 表格

- 为什么使用表格
  - 简单通用
  - 结构稳定

- 基本结构
  - 单元格
  - 行
  - 列
  - 跨行
  - 跨列

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表格学习</title>
</head>
<body>
<!--表格table
行 tr
列 td
-->
<!--
align="center"  居中
style="text-align: center  文字居中
-->
<table border="1px" align="center" style="text-align: center">
    <tr>
        <!--colspan 跨列-->
        <td colspan="4">1-1</td>
    </tr>
    <tr>
        <!--rowspan 跨列-->
        <td rowspan="2">2-1</td>
        <td>2-2</td>
        <td>2-3</td>
        <td>2-4</td>
    </tr>
    <tr>
        <td>3-2</td>
        <td>3-3</td>
        <td>3-4</td>
    </tr>
</table>
</body>
</html>
```

# 9. 视频和音频

- 视频元素
  - video

- 音频元素
  - audio

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>媒体元素学习</title>
</head>
<body>
<!--音频和视频
src  资源路径
controls  控制条
autoplay  自动播放
-->

<video src="../resources/video/VID_20210408_053839.mp4" controls autoplay></video>
<audio src="../resources/audio/roy_sax - 我心永恒（高音萨克斯）（Cover：Kenny G）.mp3" controls></audio>
</body>
</html>
```

# 10. 页面结构分析

| 元素名  |                        描述                        |
| :-----: | :------------------------------------------------: |
| header  |  标题头部区域的内容（用于页面或页面中的一块区域）  |
| footer  | 标记脚部区域的内容（用于整个页面或页面的一块区域） |
| section |              Web页面中的一块独立区域               |
| article |                   独立的文章内容                   |
|  aside  |           相关内容或应用（常用于侧边栏）           |
|   nav   |                   导航类辅助内容                   |

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>页面结构分析</title>
</head>
<body>
<header>
  <h2>网页头部</h2>
</header>

<section>
  <h2>网页主体</h2>
</section>

<footer>
  <h2>网页脚部</h2>
</footer>
</body>
</html>
```

# 11.iframe内联框架

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>内联框架iframe</title>
</head>
<body>

<!--iframe内联框架
src:地址
w-h:宽度高度
-->
<iframe src="https://www.baidu.com"  name="hello" frameborder="0" width="1200px" height="600px"></iframe>
<a href="1. 我的第一个网页.html" target="hello">点击跳转</a>
<!--<iframe-->
<!--        src="//player.bilibili.com/player.html?aid=55631961&bvid=BV1x4411V75C&cid=97257967&page=11"-->
<!--        scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true">-->
<!--</iframe>-->

</body>
</html>
```

# 12. 表单语法

## get and post

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆注册</title>
</head>
<body>
<h1 style="text-align: center">注册</h1>

<!--表单form
action : 表单提交的位置，可以是网站，也可以是请求处理地址
method : post,get 提交方式
  get方式提交：我们可以在url中看到我们提交的信息，不安全，高效
  post:比较安全，传输大文件
-->
<form action="1. 我的第一个网页.html" method="post">

  <!--文本输入框：input type="text"-->
  <p>名字：<input type="text" name="username"></p>

  <!--密码框：input type="password"-->
  <p>密码：<input type="password" name="psw"></p>

  <p>
    <input type="submit">
    <input type="reset">
  </p>
</form>
</body>
</html>
```

## 文本框和单选框

  value="初始值"      默认初始值
  maxlength="8"      最长能写几个字符
  size="30"              文本框长度

```html
  <!--单选框标签
  input type="radio"
  value="boy"   单选框的值
  name="sex"    表示组
  -->
  <p>性别：
    <input type="radio" value="boy" name="sex"/>男
    <input type="radio" value="girl" name="sex"/>女
  </p>
```

## 多选框和按钮

```html
  <!--多选框
  input type="checkbox"
  -->
  <p>爱好：
    <input type="checkbox" value="sleep" name="hobby">睡觉
    <input type="checkbox" value="code" name="hobby">敲代码
    <input type="checkbox" value="chat" name="hobby">聊天
    <input type="checkbox" value="game" name="hobby">游戏
  </p>
```

```html
  <!--按钮
  input type="button" 普通按钮
  input type="image"  图像按钮
  input type="submit" 提交按钮
  input type="reset"  重置按钮
  -->
  <p>按钮：
    <input type="button" name="btn1" value="点击变长">
    <input type="image" src="../resources/image/1.jpg" width="60px" height="30px">
  </p>
  
  <p>
    <input type="submit">
    <input type="reset" value="清空表单">
  </p>
```

## 列表框文本域和文件域

```html
  <!--下拉框，列表框
  -->
  <p>国家
    <select name="列表名称">
      <option value="china">中国</option>
      <option value="us">美国</option>
      <option value="eth" selected>瑞士</option>
      <option value="yindu">印度</option>
    </select>
  </p>
```

## 搜索框滑块和简单的验证

```html
 <!--邮件验证-->
  <p>邮箱：
    <input type="email" name="email">
  </p>
  <!--URL-->
  <p>URL：
    <input type="url" name="url">
  </p>
  <!--数字-->
  <p>数字：
    <input type="number" name="number" max="100" min="0" step="10">
  </p>
```

```html
 <!--滑块-->
  <p>音量：
    <input type="range" name="voice" min="0" max="100" step="2">
  </p>
```

```html
<!--搜索框-->
  <p>搜索
    <input type="search" name="search">
  </p>
```

```html
  <!--增强鼠标可用性-->
  <p>
    <label for="mark">你点我试试</label>
    <input type="text" id="mark">
  </p>
```

## 表单的应用

- 隐藏域 hidden
- 只读 readonly
- 禁用 disabled

## 表单的初级验证

placeholder="请输入用户名"  提示信息
required 非空判断
pattern 正则表达式

```html
  <!--正则表达式
  https://www.jb51.net/tools/regexsc.htm
  -->
  <p>自定义邮箱：
    <input type="text" name="diymail" pattern="/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/">
  </p>
```

