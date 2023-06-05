## 1. jQuery的使用

直接引入

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
	</body>
	<script src="js/jquery-3.7.0.js" type="text/javascript" charset="utf-8"></script>
</html>
```

## 2. Dom对象与jQuery包装集对象

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<div id="mydiv">文本</div>
	</body>
	<script src="js/jquery-3.7.0.js"></script>
	<script>
		var divDom = document.getElementById("mydiv");
		console.log(divDom);
		var divsDom = document.getElementsByTagName("div");
		console.log(divsDom);
		
		// Jquery对象
		var divJquery = $("#mydiv");
		console.log(divJquery);
		
		// js获取不存在的元素
		var spanDom = document.getElementsByTagName("span");
		console.log(spanDom);
		var spanDom2 = document.getElementById("myspan");
		console.log(spanDom2);
		console.log("=======");
		// jquery获取不存在的元素
		var spanJquery = $("#myspan");
		console.log(spanJquery);
		
		console.log("======");
		
		// dom对象转jQuery对象
		var divDomToJquery = $(divDom);
		console.log(divDomToJquery);
		
		// jQuery对象转Dom对象
		// 获取包装集对象中指定下标的元素，将jquery对象转换成dom对象
		var divJqueryToDom = divJquery[0];
		console.log(divJqueryToDom);
		
	</script>
</html>
```

## 3. 基础选择器

|  id选择器  |      #id属性值      |      $("#id属性值")      |
| :--------: | :-----------------: | :----------------------: |
|  类选择器  |    .class属性值     |    $(".class属性值")     |
| 元素选择器 |    标签名/元素名    |    $("标签名/元素名")    |
| 通用选择器 |          *          |          $("*")          |
| 组合选择器 | 选择器1,选择器2,... | $("选择器1,选择器2,...") |

```javascript
// id选择器		#id属性值
var mydiv = $("#mydiv");
console.log(mydiv);

// 类选择器		.class属性值
var clas = $(".blue");
console.log(clas);

// 元素选择器	标签名/元素名
var spans = $("span");
console.log(spans);

// 通用选择器
var all = $("*");
console.log(all);

// 组合选择器
var group = $("#mydiv1,div,.blue");
console.log(group);
```

## 4. 层次选择器

```html
<!-- 
  层次选择器
    后代选择器
      格式： 父元素 指定元素 (空格隔开)
      示例： $("父元素 指定元素")
      选择父元素的所有指定元素(包括第一代、第二代等)
    子代选择器
      格式： 父元素 > 指定元素 (大于号隔开)
      示例： $("父元素 > 指定元素")
      选择父元素的所有第一代指定元素
    相邻选择器
      格式： 元素 + 指定元素 (大于号隔开)
      示例： $("父元素 + 指定元素")
      选择元素的下一个指定元素(只会查找下一个选择，如果元素不存在)，则获取不到)
    同辈选择器
      格式： 元素 ~ 指定元素 (~号隔开)
      示例： $("父元素 ~ 指定元素")
      选择元素的下面的所有指定元素
 -->
<body>
  <div id="parent">层次选择器
    <div id="child" class="testColor">父选择器
      <div class="gray">子选择器</div>
      <img src="http://www.baidu.com/img/bd_logo1.png"
        width="270" height="129" />
      <img src="http://www.baidu.com/img/bd_logo1.png"
        width="270" height="129"/>
    </div>
    <div>
      选择器2<div>选择器2中的div</div>
    </div>
  </div>
</body>
<script src="js/jquery-3.7.0.js"></script>
<script type="text/javascript">
  // 后代选择器
  var hd = $("#parent div");
  console.log(hd);

  // 子代选择器
  var zd = $("#parent > div");
  console.log(zd);

  // 相邻选择器
  var x1 = $("#child + div");
  console.log(x1);

  // 同辈选择器
  var imgs = $(".gray ~ img");
  console.log(imgs);
</script>
```

## 5. 表单选择器

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>表单选择器</title>
	</head>
	<!-- 
		表单选择器
			表单选择器		:input		查找所有的input元素：$(":input")；
									注意：会匹配所有的input、textarea、select和button元素
			文本框选择器		:text
			密码框选择器		:password
			单选按钮选择器	:radio
			多选按钮选择器	:checkbox
			提交按钮选择器	:submit
			图像按钮选择器	:image
			重置按钮选择器	:reset
			文件域选择器		:file
			按钮选择器		:button
	 -->
	<body>
		<form id="myform" name="myform" method="post">
			<input type="hidden" name="uno" value="9999" disabled="disabled" />
			姓名：<input type="text" id="uname" name="uname"/><br />
			密码：<input type="password" id="upwd" name="upwd" value="123456"/><br />
			年龄：<input type="radio" name="uage" value="0" checked="checked"/>小屁孩
				<input type="radio" name="uage" value="1"/>你懂得 <br />
			爱好：<input type="checkbox" name="ufav" value="篮球"/>篮球
				<input type="checkbox" name="ufav" value="爬床"/>爬床
				<input type="checkbox" name="ufav" value="代码"/>代码<br />
			来自：<select id="ufrom" name="ufrom">
					<option value="-1" selected="selected">请选择</option>
					<option value="0">北京</option>
					<option value="1">上海</option>
				</select><br />
			简介：<textarea rows="10" cols="30" name="uintro"></textarea><br />
			头像：<input type="file"/><br />
			<input type="image" src="http://www.baidu.com/img/bd_logo1.png"
				width="20" height="20"/>
			<button type="submit" onclick="return checkForm();">提交</button>
			<button type="reset">重置</button>
		</form>
	</body>
	<script src="js/jquery-3.7.0.js"></script>
	<script>
		var inputs = $(":input");
		console.log(inputs);
		var inputs2 = $("input");
		console.log(inputs2);
	</script>
</html>
```

## 7. 操作元素的属性

- 属性的分类
  - 固有属性：元素本身就有的属性
  - 返回值是boolean的属性：checked、selected、didsabled
  - 自定义属性：用户自己定义的属性
- attr()和prop()的区别：
  1. 如果是固有属性，attr和prop方法均可获取和操作
  2. 如果是自定义属性，attr可获取prop不可获取和操作
  3. 如果是返回值是Boolean类型的属性，若设置了属性，attr返回具体的值，prop返回true。若未设置属性，attr返回undefined，prop返回false

1. 获取属性
   - attr("属性名")
   - prop("属性名")
2. 设置属性
   - attr("属性名","属性值")
   - prop("属性名","属性值")
3. 移除属性
   - removeAttr("属性名");

总结：如果属性的类型是boolean (checked、selected、disabled)，则使用prop()方法，否则使用attr()方法。

```html
<input type="checkbox" name="ch" checked="checked" id="aa" abc="aabbcc"/> aa
<input type="checkbox" name="ch" id="bb"/> bb

<script type="text/javascript">
		// 获取属性
		// 固有属性
		var name = $("#aa").attr("name");
		console.log(name);
		var name2 = $("#aa").prop("name");
		console.log(name2);
		// 返回值是boolean的属性(元素设置了属性的)
		var ck1 = $("#aa").attr("checked");	// checked
		var ck2 = $("#aa").prop("checked");	// true
		console.log(ck1);
		console.log(ck2);
		// 返回值是boolean的属性(元素未设置属性)
		var ck3 = $("#bb").attr("checked");	// undefined
		var ck4 = $("#bb").prop("checked");	// false
		console.log(ck3);
		console.log(ck4);
		// 自定义属性
		var abc1 = $("#aa").attr("abc");	// aabbcc
		var abc2 = $("#aa").prop("abc");	// undefined
		console.log(abc1);
		console.log(abc2);
		
		// 设置属性
		// 固有属性
		$("#aa").attr("value", "1");
		$("#bb").prop("value", "2");
		// 返回值是boolean的属性
		$("#bb").attr("checked", "checked");
		$("#bb").prop("checked", true);
		//自定义属性
		$("#aa").attr("uname","admin");
		$("#aa").prop("uage","18");	//失败
		
		// 移除属性
		$("#aa").removeAttr("checked");
	</script>
```

## 8. 操作元素的样式

| 方法                   |             说明              |
| :-------------------: | :---------------------------: |
| attr("class")          | 获取class属性的值，即样式名称 |
| attr("class","样式名") |  设置元素的样式，原本的样式会被覆盖  |
| addClass("样式名")     |         添加样式，原本样式会保留。相同样式则以后定义的为准         |
| css()                  |        添加具体的样式(行内样式)css("具体样式名","样式值")；设置单个样式；css({"具体样式名",样式值,具体样式名,样式值});	设置多个        |
| removeClass(class)     |         移除样式名称          |

```html
<h3>css()方法设置元素样式</h3>
<div id="conBlue" class="blue larger">天蓝色</div>
<div id="conRed">大红色</div>
<div id="remove" class="blue larger">天蓝色</div>

<script type="text/javascript">
  // attr("class")	获取元素的样式名
  var cla = $("#conBlue").attr("class");
  console.log(cla);

  // attr("class","属性值")	设置元素的样式
  $("#conBlue").attr("class","green");

  // addClass("样式名")		添加样式
  $("#conBlue").addClass("larger");
  $("#conBlue").addClass("pink");

  // css()	添加具体的样式
  $("#conRed").css("font-size","40px");
  $("#conRed").css({"font-family":"楷体","color":"green"})

  // removeClass("样式名")	移除样式	
  $("#remove").removeClass("larger");
</script>
```

## 9. 操作元素的内容

| 方法              | 说明                             |
| ----------------- | -------------------------------- |
| html()            | 获取元素的html内容               |
| html("html,内容") | 设定元素的html内容               |
| text()            | 获取元素的文本内容就，不包含html |
| text("text 内容") | 设置元素的文本内容，不包含html   |
| val()             | 获取元素的value值                |
| val('值')         | 设置元素的value值                |

```html
<h3><span>html()和text()方法设置元素内容</span></h3>
<div id="html"></div>
<div id="html2"></div>
<div id="text"></div>
<div id="text2"></div>
<input type="text" name="uname" id="op" value="oop">

<script type="text/javascript">
  // html("内容")	设置元素的内容，包含html标签(非表单元素)
  $("#html").html("<h2>上海</h2>");
  $("#html2").html("上海");
  // html()		获取元素的内容
  var html = $("#html").html();
  var html2 = $("#html2").html();
  console.log(html);
  console.log(html2);

  // text("内容")	设置元素的纯文本内容，不识别HTML标签(非表单元素)
  $("#text").text("北京");
  $("#text2").text("<h2>好</h2>");
  var txt = $("#text").text();
  var txt2 = $("#text2").text();
  console.log(txt);
  console.log(txt2);

  // val()		获取元素的值(表单元素)
  var val = $("#op").val()
  console.log(val);
  // val("值")	设置元素的值(表单元素)
  $("#op").val("今天天气不错")
</script>
```

## 10. 创建元素和添加元素

|         方法         |                             说明                             |
| :------------------: | :----------------------------------------------------------: |
|   prepend(content)   | 在被选元素内部的开头插入元素或内容，被追加的content参数，可以是字符、HTML元素标记。 |
| $(content).prependTo |           把content元素或内容加入selector元素开头            |
|   append(content)    | 在被选元素内部的结尾插入元素或内容，被追加的content参数，可以是字符、HTML元素标记。 |
| $(content).appendTo  |     把content元素或内容插入selector元素内，默认是在尾部      |
|       before()       |   在元素前插入指定的元素或内容$(selector).before(content)    |
|       after()        |    在元素后插入指定的元素或内容$(selector).after(content)    |

注意：在添加元素时，如果元素本身不存在(新建的元素)，此时会将元素追加到指定位置；如果元素本身存在(已有元素)，会将原来元素直接剪切到指定位置

```html
<body>
  <span class="red">二次元</span>
  <span class="blue">胡桃</span>
  <div class="green">
    <span>神里绫华</span>
  </div>
</body>
<script src="js/jquery-3.7.0.js"></script>
<script>
  // 创建元素
  var p = "<p>这是一个p标签</p>"
  console.log(p);
  console.log($(p));

  var span = "<span>甘雨</span>";
  var span2 = "<span>心海</span>";
  var span3 = "<span>万叶</span>";
  var span4 = "<span>香菱</span>";
  var span5 = "<span class='pink'>派蒙</span>";
  var span6 = "<span class='gray'>雷电将军</span>";
  // 前追加子元素
  $(".green").prepend(span);
  $(span2).prependTo(".green")
  // 后追加子元素
  $(".green").append(span3);
  $(span4).appendTo(".green");
  // 将已存在内容追加到指定元素中
  $(".green").append($(".red"));
  // 前追加同级元素
  $(".blue").before(span5);
  // 后追加同级元素
  $(".blue").after(span6);
</script>
```

## 11. 删除元素和遍历元素

| 方法     | 说明                                                   |
| -------- | ------------------------------------------------------ |
| remove() | 删除所选元素或指定的子元素，包括整个标签和内容一起删。 |
| empty()  | 清空所选元素的内容                                     |

遍历元素each()

$(selector).each(function(index,element))

参数function为遍历时的回调函数，index为遍历元素的序列号，从0开始；element是当前的元素，此时是dom元素。

```js
$("span").each(function(index, elem) {
  console.log(index,elem);
  console.log(this);
  console.log($(this))
})
```

## 12. ready加载事件

预加载事件

当页面的dom结构加载完毕后执行

语法：

$(document).ready(function(){

});

简写：

$(function(){

});

## bind()绑定事件

语法：

```javascript
$(selector).bind(eventType [, eventData], handler(eventObject));
```

eventType:是一个字符串类型的事件类型，就是你所需要绑定的事件

[, eventData]: 传递的参数，格式：{名:值，名2:值2}

bind绑定单个事件

```javascript
$("元素").bind("事件类型",function(){
  
});
```

直接绑定

```javascript
$("元素").事件名(function(){
  
});
```

bind绑定多个事件

```javascript
// 1，
指定元素.bind("事件类型1 事件类型2 ..",function(){
  
});
// 2.
指定元素.bind("事件类型",function(){
  
}).bind("事件类型",function(){
  
});
// 3.
指定元素.bind({
  "事件类型":function(){
    
  },
  "事件类型":function(){
    
  }
});
```

直接绑定

```javascript
指定元素.事件名(function(){
  
}).事件名(function(){
  
});
```

