# 1. 什么是CSS

如何学习

	1. CSS是什么
	2. CSS怎么用（快速入门）
	3. **CSS选择器（重点+难点）**
	4. 美化网页（文字，阴影，超链接，列表，渐变...）
	5. 盒子模型
	6. 浮动
	7. 定位
	8. 网页动画（特效效果）

## 1.1  什么是CSS

Cascadiing Style Sheet 层叠级联样式表

CSS：表现（美化网页）

字体，颜色，边距，高度，宽度，背景图片，网页定位，网页浮动..

## 1.2 发展史

CSS1.0

CSS2.0    DIV（块）+ CSS，HTML与CSS结构分离的思想，网页变得简单，SEO

CSS2.1    浮动，定位

CSS3.0    圆角，阴影，动画...浏览器兼容性~

## 1.3 快速入门

style

**基本入门**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

<!--    规范,<style>可以编写CSS代码，每一个声明最好使用分号结尾
    语法：
        选择器{
            声明1;
            声明2;
            声明3;
        }
-->
    <style>
        h1{
            color: red;
        }
    </style>
</head>
<body>
<h1>我是标题</h1>
</body>
</html>
```

推荐：

![image-20210518102711003](C:\Users\AXC\Desktop\java study\CSS\image-20210518102711003.png)

css的优势：

1. 内容和表现分离
2. 网页结构表现统一，可以实现复用
3. 样式十分的丰富
4. 建议使用独立于html的css文件
5. 利于SEO，容易被搜索引擎收录！

## 1.4 CSS的3种导入方式

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

<!--    内部样式-->
    <style>
        h1{
            color: green;
        }
    </style>

<!--    外部样式-->
    <link rel="stylesheet" href="css/style.css">

</head>
<body>

<!--优先级：就近原则-->
<!--行内样式：在标签元素中，编写一个style属性，编写样式即可-->
<h1 style="color: red">我是标题</h1>

</body>
</html>
```

扩展：外部样式两种写法

- 连接式：

  html

  ```html
  <!--    外部样式-->
      <link rel="stylesheet" href="css/style.css">
  ```

- 导入式：

  CSS2.1

  ```html
  <!--    导入式-->
      <style>
          @import url(css/style.css);
      </style>
  ```

# 2. 选择器

作用：选择页面上的某一个或者某一类元素

## 2.1 基本选择器

1. 标签选择器：选择一类标签 标签{}

   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <title>Title</title>
   
       <style>
            /*标签选择器，会选择到页面上所有的这个标签的元素*/
           h1{
             color: red;
           }
            p{
              font-size: 80px;
            }
       </style>
   </head>
   <body>
   
   <h1>学Java</h1>
   <h1>学Java</h1>
   <p>听狂神说</p>
   
   </body>
   </html>
   ```

2. 类 选择器 class：选择所有class属性一致的标签，跨标签 .类名{}

   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <title>Title</title>
   
       <style>
           /*类选择器的格式  .class的名称{}
           好处，可以多个标签归类，是同一个class,可以复用
           */
           .axc{
               color: #0600ff;
           }
           .kuangshen{
               color: #a100ff;
           }
       </style>
   
   </head>
   <body>
   
   <h1 class="axc">标题1</h1>
   <h1 class="kuangshen">标题2</h1>
   <h1 class="axc">标题3</h1>
   
   <p class="axc">P标签</p>
   </body>
   </html>
   ```

3. Id 选择器：全局唯一！#id名{}

```html
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Title</title>

	<style>
		/*id选择器：id必须保证全局唯一
		#id名称{}
		优先级：
		不遵循就近原则
		id选择器>类选择题>标签选择器
		 */
		#axc{
			color: #ff0015;
		}
		.style1{
			color: #00ff35;
		}
		h1{
            color: #001eff;
		}
	</style>

</head>
<body>

<h1 class="style1" id="axc">标题1</h1>
<h1 class="style1">标题2</h1>
<h1 class="style1">标题3</h1>
<h1>标题4</h1>
<h1>标题5</h1>
</body>
</html>
```

优先级：id>class>标签

## 2.2 层次选择器

1. 后代选择器：在某个元素的后面  

   ```css
   /* 后代选择器*/
   body p {
   	background: red;
   }
   ```

2. 子选择器，一代，儿子

   ```css
   /*子选择器*/
   body>p{
   	background: #3cbda6;
   }
   ```

3. 相邻兄弟选择器   同辈

   ```css
   /*相邻兄弟选择器，只有一个，相邻（上下）*/
   .active + p{
       background: #ff6f09;
   }
   ```

4. 通用选择器

   ```css
   /*通用兄弟选择器：当前选中元素的向下所有兄弟元素*/
   .active~p{
       background: #00ff35;
   }
   ```

## 2.3 结构伪类选择器

伪类：条件

```css
/*ul的第一个子元素*/
ul li:first-child{
    background: #ff0015;
}

/*ul的最后一个子元素*/
ul li:last-child{
    background: #00ff35;
}

/*选中p1：定位到父元素，选择当前的第一个元素
选择当前p元素的父级元素，选中父级元素的第一个，并且是当前元素才生效！
*/
p:nth-child(2){
    background: #d21fff;
}

/*选中父元素下的p元素的第二个*/
p:nth-of-type(2){
    background: #fffc5c;
}
```

## 2.4 属性选择器（常用）

```html
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Title</title>

	<style>
		.demo a{
			float: left;
			display: block;
			height: 50px;
			width: 50px;
			border-radius: 10px;
			background: #2700ff;
			text-align: center;
			color: gainsboro;
			text-decoration: none;
			margin-right: 5px;
			font: bold 20px/50px Arial;
		}

		/*属性名， 属性名=属性值（正则）
		= 绝对等于
		*= 包含包含这个元素
		^= 以这个开头
		$= 以这个结尾
		*/

		/*存在id属性的元素    a[]{}*/
		/*a[id]{*/
		/*	background: yellow;*/
		/*}*/

		/*a[id=first]{*/
		/*	background: yellow;*/
		/*}*/

		/*a[class*=links]{*/
		/*	background: yellow;*/
		/*}*/

		/*选中href中以https开头的元素*/
		/*a[href^=https]{*/
		/*	background: yellow;*/
		/*}*/

		/**/
		a[href$=pdf]{
			background: yellow;
		}
	</style>

</head>
<body>

<p class="demo">
	<a href="https://www.baidu.com" class="links item first" id="first">1</a>
	<a href="" class="links item active" target="_blank" title="test">2</a>
	<a href="images/123.html" class="links item">3</a>
	<a href="images/123.png" class="links item">4</a>
	<a href="images/123.jpg" class="links item">5</a>
	<a href="abc" class="links item">6</a>
	<a href="/a.pdf" class="links item">7</a>
	<a href="/abc.pdf" class="links item">8</a>
	<a href="abc.doc" class="links item">9</a>
	<a href="abcd.doc" class="links item last">10</a>
</p>

</body>
</html>
```

```
= 绝对等于
*= 包含包含这个元素
^= 以这个开头
$= 以这个结尾
```

# 3. 美化网页元素

## 3.1 为什么要美化

1. 有效的传递页面信息
2. 美化网页，页面漂亮，才能吸引用户
3. 凸显页面的主题
4. 提高用户的体验

span标签：重点要突出的字，使用span套起来

```html
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Title</title>

	<style>
		#title1{
			font-size: 50px;
		}
	</style>

</head>
<body>

欢迎学习 <span id="title1">Java</span>

</body>
</html>
```

## 3.2 字体样式

```html
<!--
font-family: 字体
font-size: 字体大小
font-weight: 字体粗细
color: 字体颜色
-->
<style>
    body{
        font-family: "Arial Black","楷体";
        color: #a13d30;
    }
    h1{
        font-size: 50px;
    }
    .p1{
        font-weight: lighter;
    }
    p {
        font: oblique 100 16px 楷体;
    }
</style>
```

## 3.3 文本样式

1. 颜色 color rgb rgba
2. 文本对其的方式 text-align = center
3. 首行缩进 text-indent:2em
4. 行高 line-height:
5. 装饰 text-decoration:
6. 文本图片水平对齐 vertical-align: middle;

```html
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Title</title>

	<!--
	颜色：
		单词
		RGB 0~F
		RGBA A:0~1

	text-align:排版，居中
	text-indent: 2em; 段落首行缩进
	height: 300px;
	line-height: 50px;
	行高和块的高度一致，就可以上下居中
	-->
	<style>
        h1 {
            color: rgba(0, 255, 255, 0.9);
            text-align: center;
        }

        .p1 {
            text-indent: 2em;
        }

        .p3 {
            background: #a400ff;
            height: 50px;
            line-height: 50px;
        }

        /*下划线*/
        .l1 {
            text-decoration: underline;
        }

        /*中划线*/
        .l2 {
            text-decoration: line-through;
        }

        /*上划线*/
        .l3 {
            text-decoration: overline;
        }

        img, span {
            vertical-align: middle;
        }
	</style>

</head>
<body>

<p class="l1">1321231</p>
<p class="l2">1321231</p>
<p class="l3">1321231</p>

<h1>故事介绍</h1>
<p class="p1">
	平静安详的元泱境界，每隔333年，总会有一个神秘而恐怖的异常生物重生，它就是魁拔！魁拔的每一次出现，都会给元泱境界带来巨大的灾难！即便是天界的神族，也在劫难逃。在天地两界各种力量的全力打击下，魁拔一次次被消灭，但又总是按333年的周期重新出现。魁拔纪元1664年，天神经过精确测算后，在魁拔苏醒前一刻对其进行毁灭性打击。但谁都没有想到，由于一个差错导致新一代魁拔成功地逃脱了致命一击。很快，天界魁拔司和地界神圣联盟均探测到了魁拔依然生还的迹象。因此，找到魁拔，彻底消灭魁拔，再一次成了各地热血勇士的终极目标。
</p>
<p>
	在偏远的兽国窝窝乡，蛮大人和蛮吉每天为取得象征成功和光荣的妖侠纹耀而刻苦修炼，却把他们生活的村庄搅得鸡犬不宁。村民们绞尽脑汁把他们赶走。一天，消灭魁拔的征兵令突然传到窝窝乡，村长趁机怂恿蛮大人和蛮吉从军参战。然而，在这个一切都凭纹耀说话的世界，仅凭蛮大人现有的一块冒牌纹耀，不要说参军，就连住店的资格都没有。受尽歧视的蛮吉和蛮大人决定，混上那艘即将启程去消灭魁拔的巨型战舰，直接挑战魁拔，用热血换取至高的荣誉。
</p>
<p class="p3">
	Since there’s no help, come let us kiss and part;Nay, I have done, you get no more of me,And I am glad, yea glad
	with all my heartThat thus so cleanly I myself can free;Shake hands forever, cancel all our vows,And when we meet at
	any time again,Be it not seen in either of our browsThat we one jot of former love retain.Now at the last gasp of
	Love’s latest breath,When, his pulse failing, Passion speechless lies,When Faith is kneeling by his bed of death,And
	Innocence is closing up his eyes,Now if thou wouldst, when all have given him over,From death to life thou mightst
	him yet recover.
</p>

<p>
	<img src="images/a.png" alt="">
	<span>fdgsgsdgsd</span>
</p>

</body>
</html>
```

## 3.4 阴影

```css
/*text-shadow: 阴影颜色，水平偏移，阴影半径*/
#price{
    text-shadow: #71eeff 5px 5px 3px;
}
```

## 3.5 超链接伪类

正常情况下，a,a:hover

```css
/*默认的颜色*/
a{
    text-decoration: none;
    color: #000000;
}
/*鼠标悬浮的状态*/
a:hover{
    color: #c7870c;
    font-size: 20px;
}
```

## 3.6 列表

```css
/*ul li*/
/*
list-style:
none 去掉圆点
circle 空心圆
decimal 数字
square 正方形
*/
ul{
    background: #a0a0a0;
}
ul li {
    height: 30px;
    list-style: none;
    text-indent: 1em;
}
```

## 3.7 背景

背景颜色

背景图片

```css
<style>
div {
    width: 1000px;
    height: 700px;
    border: 1px solid red;
    background-image: url("images/a.jpg");
    /*默认是全部平铺的*/
}
.div1{
    background-repeat: repeat-x;
}
.div2{
    background-repeat: repeat-y;
}
.div3{
    background-repeat: no-repeat;
}
</style>
```

渐变

https://www.garbient.com

# 4. 盒子模型

## 4.1 什么是盒子模型

margin:外边距

padding:内边距

border:边框

## 4.2 边框

1. 边框的粗细
2. 边框的样式
3. 边框的颜色

```css
<style>
/*body总有一个默认的外边距*/
/*body{*/
/*	margin:0;*/
/*}*/
/*border:粗细，样式，颜色*/
#box{
    width: 300px;
    border:1px solid red;

}
h2{
    font-size: 16px;
    background-color: #3cbda6;
    line-height: 30px;
    margin: 0;
    color: white;
}
form{
    background: #3cbda6;
}
div:nth-of-type(1) input{
    border: 3px solid black;
}
div:nth-of-type(2) input{
    border: 3px dashed #001eff;
}
div:nth-of-type(3) input{
    border: 3px dashed #046504;
}
</style>
```

## 4.3 内外边距

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>

        <!--外边距的妙用：居中元素
margin: 0 auto;
-->
        <style>
            #box {
                width: 300px;
                border: 1px solid red;
                margin: 0 auto;
            }

            h2 {
                font-size: 16px;
                background-color: #3cbda6;
                line-height: 30px;
                margin: 0;
                color: white;
            }

            form {
                background: #3cbda6;
            }
            input{
                border: 1px solid black;
            }

        </style>

    </head>
    <body>
        <div id="box">
            <h2>会员登录</h2>
            <form action="#">
                <div>
                    <span>用户名：</span>
                    <input type="text">
                </div>
                <div>
                    <span>密码：</span>
                    <input type="text">
                </div>
                <div>
                    <span>邮箱：</span>
                    <input type="text">
                </div>
            </form>
        </div>
    </body>
</html>
```

盒子的计算方式：你这个元素到底多大？

margin+border+padding+内容宽度

## 4.4 圆角边框

4个脚

```css
<style>
div {
    background-image: url("image/mi.jpeg");
    width: 100px;
    height: 100px;
    border: 10px solid red;
    border-radius: 40px;
}
</style>
```

## 4.5 盒子阴影

```css
<style>
div{
    width: 100px;
    height: 100px;
    margin: 0 auto;
}
img{
    /*width: 100px;*/
    /*height: 100px;*/
    border-radius: 50px;
    box-shadow: 10px 10px 20px yellow;
}
</style>
```

# 5 . 浮动

## 5.1 标准文档流

块级元素：独占一行

```
h1~h6  p  div  列表...
```

行内元素：不独占一行

```
span  a  img  strong...
```

行内元素可以被包含在块级元素中，反之，则不可以。

## 5.2 display

这个也是一种实现行内元素排列的方式，但是我们很多情况都是用float

```html
<!--
block 块元素
inline 行内元素
inline-block是块元素，但是可以内联，在一行！
none 消失
-->

<style>
    .div1{
        width: 100px;
        height: 100px;
        border: 1px solid red;
        display: inline-block;
    }

    span {
        width: 100px;
        height: 100px;
        border: 1px solid red;
        display: inline-block;
    }
```

## 5.3 float

1. 左右浮动

   ```css
   float:left;
   float:right;
   ```

## 5.4 父级边框塌陷的问题

clear

```css
clear:right;右侧不允许有浮动元素
clear:left;左侧不允许有浮动元素
clear:both;两侧不允许有浮动元素
clear:none;
```

解决方案：

1. 增加父级元素的高度

```css
#father{
	border:1px #000 solid;
	height:800px
}
```

2. 增加一个空的div标签，清除浮动

```html
<div class="clear"></div>
<style>
.clear{
	clear:both;
	margin:0;
	padding:0;
}
</style>
```

3. overflow

在父级元素中增加一个overflow:hidden;

4. 父类添加一个伪类：after

```css
#father:after{
    content:'';
    display:block;
    clear:both;
}
```

小结：

1. 浮动元素后面增加空div

   简单，代码中尽量避免空div

2. 设置父元素的高度

   简单，元素假设有了固定的高度，就会被限制

3. overflow

   简单，下拉的一些场景避免使用

4. 父类添加一个伪类：after(推荐)

   写法稍微复杂一点，但是没有副作用，推荐使用

##  5.5 对比

- display

  方向不可以控制

- float

  浮动起来会脱离标准文档流，所以要解决父级边框塌陷的问题

# 6. 定位

## 6.1 相对定位

## 6.2 绝对定位 

## 6.3 z-index

