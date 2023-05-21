# 1. CSS常用选择器

| 名称         | 语法           | 示例             |
| ------------ | -------------- | ---------------- |
| 元素选择器   | 标签名{}       | p{},div{},span{} |
| class选择器  | .class属性值{} | .A{},.B{}        |
| id选择器     | #id属性值{}    | #A{},#B{}        |
| 通配符选择器 | *{}            | *{} 选择所有标签 |

# 2. Vue基础

```html
<body>
	<div id="app">
		{{message}}
		<h2>{{school.name}} {{school.mobile}}</h2>
		<ul>
			<li>{{ campus[0] }}</li>
			<li>{{ campus[3] }}</li>
		</ul>
	</div>
	<!-- 开发环境版本，包含了有帮助的命令行警告 -->
	<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
	<script>
		var app = new Vue({
			el:"#app",
			data:{
				message:"你好",
				school:{
					name:"axc",
					mobile:"188"
				},
				campus:["bj","sh","gz","sz"]
			}
		})
	</script>
</body>
```

# 3. 常用指令

## v-text

```html
<div id="app">
    <h2 v-text="message + '字符'"></h2>
    <h2 v-text="info"></h2>
    <h2>{{ message + '字符'}}深圳</h2>
</div>
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<script>
    var app = new Vue({
        el:"#app",
        data:{
            message:"Hello!!!",
            info:"Word!"
        }
    })
</script>
```

## v-html

可以解析html标签

```html
<div id="app">
    <p v-html="content"></p>
    <p v-text="content"></p>
</div>
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<script>
    var app = new Vue({
        el:"#app",
        data:{
            // content:"Hello"
            content:"<a href='https://www.baidu.com'>百度</a>"
        }
    })
</script>
```

## v-on事件绑定和数据更新

```html
<div id="app">
    <input type="button" value="事件绑定"v-on:click="dolt">
    <input type="button" value="事件绑定"v-on:mouseenter="dolt">
    <input type="button" value="事件绑定"v-on:dblclick="dolt">
    <input type="button" value="事件绑定"@dblclick="dolt">
    <h2 @mouseenter="changeFood"> {{ food }} </h2>
</div>
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<script>
    var app = new Vue({
        el:"#app",
        data:{
            food:"西兰花炒蛋"
        },
        methods:{
            dolt:function(){
                console.log("事件触发了");
            },
            changeFood:function(){
                this.food = this.food + "真好吃";
            }
        }
    })
</script>
```

## v-on补充 传递自定义参数，事件修饰符

文档：[API — Vue.js (vuejs.org)](https://v2.cn.vuejs.org/v2/api/#v-on)

```html
<body>
	<div id="app">
		<input type="button" value="点击" @click="doIt(666)">
		<input type="text" @keyup.enter="sayHi">
	</div>
	<!-- 开发环境版本，包含了有帮助的命令行警告 -->
	<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
	<script>
		var app = new Vue({
			el:"#app",
			methods:{
				doIt:(p1) => {
					console.log("做it");
					console.log(p1);
				},
				sayHi:() => {
					alert("吃了没");
				}
			},
			
		})
	</script>
</body>
```

.prevent 阻止默认行为

.stop 阻止事件冒泡

## v-show

根据表达式的真假，切换元素的显示和隐藏

```html
<body>
	<div id="app">
		<img src="https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png" v-show="true"><br>
		<button @click="changeIsShow">切换显示状态</button><br>
		<img src="https://www.baidu.com/img/flexible/logo/pc/peak-result.png" v-show="isShow">
		<img src="https://www.baidu.com/img/flexible/logo/pc/peak-result.png" v-show="age>=18">
	</div>
	<!-- 开发环境版本，包含了有帮助的命令行警告 -->
	<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
	<script>
		var app = new Vue({
			el:"#app",
			data:{
				isShow:true,
				age:16
			},
			methods:{
				changeIsShow:function(){
					this.isShow = !this.isShow;
				}
			},
		})
	</script>
</body>
```

## v-if

修改dom树，存在或删除

```html
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<div id="app">
    <input type="button" value="切换显示" @click="toggleIsShow">
    <p v-if="true">我是一个p标签</p>
    <p v-if="isShow">我是一个p标签</p>
</div>
<script>
    var app = new Vue({
        el:"#app",
        data:{
            isShow:false
        },
        methods:{
            toggleIsShow:function(){
                this.isShow = !this.isShow;
            }
        }
    })
</script>
```

配套指令：

```javascript
<div v-if="type === 'A'">优秀</div>
<div v-else-if="type === 'B'">良好</div>
<div v-else-if="type === 'C'">一般</div>
<div v-else>差</div>
```



## v-bind

作用：为元素绑定属性

完整写法：v-bind:属性名

简写可以直接省略v-bind,只保留:属性名

```html
<body>
	<div id="app">
		<img v-bind:src="imgSrc" alt="">
		<br>
		<img :src="imgSrc" alt="" :title="imgTitle + '!!!'" :class="isActive?'active':''" @click="toggleActive">
		<br>
		<img :src="imgSrc" alt="" :title="imgTitle + '!!!'" :class="{active:isActive}" @click="toggleActive">
	</div>
	<!-- 开发环境版本，包含了有帮助的命令行警告 -->
	<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
	<script>
		var app = new Vue({
			el:"#app",
			data:{
				imgSrc:"https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png",
				imgTitle:"百度",
				isActive:false
			},
			methods:{
				toggleActive:function(){
					this.isActive = !this.isActive;
				}
			}
		})
	</script>
</body>
```

图片切换显示：

```javascript
<body>
	<div id="app">
		<img :src="imgArr[index]"><br>
		<a href="#" @click="prev" v-show="index>0">上一张</a>
		<a href="#" @click="next" v-show="index<imgArr.length-1">下一张</a>
	</div>
	<!-- 开发环境版本，包含了有帮助的命令行警告 -->
	<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
	<script>
		var app = new Vue({
			el:"#app",
			data:{
				imgArr:['./src/IMG_20230120_093955.jpg','./src/IMG_20230120_115416.jpg','./src/IMG_20230203_214323.jpg','./src/IMG_20230205_081140.jpg','./src/IMG_20230220_114827.jpg'],
				index:0
			},
			methods:{
				prev:function(){
					this.index--;
					console.log(this.index);
				},
				next:function(){
					this.index++;
				}
			}
		})
	</script>
</body>
```

## v-for和数组长度更新删除

删除：

```javascript
this.objArr.splice(index,1);	//索引和删除数量
```

官方建议：只要用到v-for指令，那么一定要绑定一个:key属性

而且尽量把id作为key的值

```html
<body>
	<div id="app">
		<input type="button" value="添加数据" @click="add">
		<input type="button" value="移除数据" @click="remove">
		<ul>
			<li v-for="(item,index) in arr" :key="item.id">{{ item }} {{ index }}</li>
			<li v-for="(item,index) in objArr">{{item.name}}</li>
		</ul>
	</div>
	<!-- 开发环境版本，包含了有帮助的命令行警告 -->
	<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
	<script>
		const app = new Vue({
			el:"#app",
			data:{
				arr:[1,2,3,4,5],
				objArr:[
				{name:"jack"},
				{name:"rose"}
				]
			},
			methods:{
				add:function(){
					this.objArr.push({name:"西兰花炒鸡蛋"})
				},
				remove:function(){
					this.objArr.shift();
				}
			}
		})
	</script>
</body>
```

## v-model双向数据绑定

```html
<body>
	<div id="app">
		<input type="text" v-model="message">
		<h2>{{ message }}</h2>
	</div>
	<!-- 开发环境版本，包含了有帮助的命令行警告 -->
	<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
	<script>
		var app = new Vue({
			el:"#app",
			data:{
				message:""
			}
		})
	</script>
</body>
```

修饰符：

| 修饰符  | 作用                           | 示例                           |
| ------- | ------------------------------ | ------------------------------ |
| .number | 自动将用户的输入值转为数值类型 | <input v-model.number="age" /> |
| .trim   | 自动过滤用户输入的首位空白字符 | <input v-model.trim="msg" />   |
| .lazy   | 在”change“时而非"input"时更新  | <input v-model.lazy="msg" />   |



# 4. axios 专注于网络请求的库

[axios/axios: Promise based HTTP client for the browser and node.js (github.com)](https://github.com/axios/axios)

[axios中文文档|axios中文网 | axios (axios-js.com)](http://www.axios-js.com/zh-cn/docs/)

基本使用：

```javascript
const result = axios({
    method: 'GET',
    url: 'xxx.xxx.xxx',
    //url参数
    params: {
        id: 1
    },
    //请求体参数
    data: {}
})

result.then(function(value){
    
})
```

结合async和await调用axios和解构赋值:

```javascript
getJoke: async function(){
    //如果调用某个方法的返回值是Promise，则前面可以添加await
    const {data} = await axios({
        method: 'GET',
        url: 'https://autumnfish.cn/api/joke'
    })
    this.joke = data
}
```



```html
<body>
	<div id="app">
		<input type="button" value="获取笑话" @click="getJoke">
		<p>{{ joke }}</p>
	</div>
	<!-- axios -->
	<script src="https://unpkg.com/axios@1.3.4/dist/axios.min.js"></script>
	<!-- 开发环境版本，包含了有帮助的命令行警告 -->
	<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
	<script>
		/*
		 接口：随机获取一条笑话
		 请求地址：https://autumnfish.cn/api/joke
		 请求方法：get
		 请求参数：无
		 */
		var app = new Vue({
			el:"#app",
			data:{
				joke:"很好笑的笑话"
			},
			methods:{
				getJoke: () =>{
					var that = this.app;
					axios.get("https://autumnfish.cn/api/joke").then
					((response) => {
						console.log(response.data)
						that.joke = response.data;
					}, (err) => {
						
					})
				}
			},
		})
	</script>
</body>
```

# 5. webpack 前端工程化

前端模块化开发支持，代码混淆，处理JS的兼容性，性能优化等功能

1. 新建项目空白目录，并运行npm init -y命令，初始化包管理配置文件package.json
2. 新建src源代码目录
3. 新建src->index.html首页和src->index.js脚本文件
4. 初始化首页基本的结构
5. 运行npm install jquery -S命令，安装jQuery
6. 通过ES6模块化的方式导入jQuery,实现列表隔行变色效果

## 安装 配置 和使用

1. 安装：npm install webpack@5.42.1 webpack-cli@4.7.2 --save-dev

2. 配置：

   根目录创建webpack配置文件 webpack.config.js，初始化配置

```javascript
//使用Node.js中的导出语法，向外导出一个webpack的配置对象
module.exports = {
    //代表webpack运行的模式，可选development和production
    mode:'development'
}
```

​		在package.json的scripts节点下，新增dev脚本：

```javascript
"scripts": {
	"dev": "webpack"
}
```

3. 打包构建

   npm run dev

## 指定webpack的entry和output

在webpack4.x和5.x中，有如下默认约定

1. 默认的打包入口文件为src->index.js
2. 默认的输出文件路径为dist->main.js

自定义打包入口与出口：

```javascript
const path = require('path')    //导入node.js中专门操作路径的模块
//使用Node.js中的导出语法，向外导出一个webpack的配置对象
module.exports = {
    //代表webpack运行的模式，可选development和production
    mode: 'production',
    entry: path.join(__dirname, './src/index.js'),   //打包入口文件的路径
    output: {
        path: path.join(__dirname, './dist'), //输出文件的存放路径
        filename: 'bundle.js'   //输出文件的名称
    }
}
```

## webpack-dev-server  自动打包

1. 安装：npm install webpack-dev-server@3.11.2 -D

2. 配置: 修改package.json

   ```json
   "scripts": {
       "dev": "webpack serve"
   },
   ```

## html-webpack-plugin

1. 安装：npm install html-webpack-plugin -D

2. 配置：

   ```javascript
   const HtmlPlugin = require('html-webpack-plugin')
   const htmlPlugin = new HtmlPlugin({
       //指定要复制哪个页面
       template: './src/index.html',
       filename: './index.html'
   })
   //使用Node.js中的导出语法，向外导出一个webpack的配置对象
   module.exports = {
       //插件的数组
       plugins: [htmlPlugin]
   }
   ```

## 自动打开浏览器

webpack.config.js中添加：

```javascript
devServer: {
    // open: true,  //初次打包完成后，自动打开浏览器
    open: 'C:/Program Files/Google/Chrome/Application/chrome.exe',
    host: '127.0.0.1', //实时打包所使用的主机地址
    port: 8080,   //实时打包所使用的端口号
}
```

# 6. Webpack中的loader(加载器)

## 打包处理CSS文件

```javascript
//导入样式(在webpack中，一切皆模块，都可以通过ES6导入语法导入)
import './css/index.css'
```



安装：npm i style-loader css-loader -D

配置：webpack.config.js中添加：

```javascript
module: {
    rules: [
        //定义了不同模块对应的loader
        { test: /\.css$/, use: ['style-loader', 'css-loader'] }
    ]
}
```

## 打包处理less文件

```javascript
import './css/index.less'
```

安装：npm i less-loader less -D

配置：同css { test: /\.less$/, use: ['style-loader', 'css-loader','less-loader'] }

## 打包处理url路径相关的文件

导入：

```javascript
//1.导入图片，得到图片文件
import logo from './images/123.jpg'
//2.动态赋值
$('.box').attr('src', logo)
```

安装：npm i url-loader file-loader -D

配置：{ test: /\.jpg|png|gif$/, use: ['url-loader?limit=22229'] }

## babel-loader打包处理js高级语法

1. 安装：npm i babel-loader @babel/core @babel/plugin-proposal-decorators -D

2. 配置webpack.config.js:{ test: /\.js$/, use: 'babel-loader', exclude: /node_modules/ }

3. 配置babel.confog.js:

   ```javascript
   module.exports = {
       //声明babel可用的插件
       plugins: [['@babel/plugin-proposal-decorators', {legacy: true}]]
   }
   ```

   [@babel/plugin-proposal-class-properties · Babel (babeljs.io)](https://babeljs.io/docs/babel-plugin-proposal-class-properties)

## 自动删除dist

1. 安装 npm install --save-dev clean-webpack-plugin

2. 配置：

   ```javascript
   const { CleanWebpackPlugin } = require('clean-webpack-plugin')
   plugins: [htmlPlugin, new CleanWebpackPlugin()],
   { 
       test: /\.jpg|png|gif$/, 
       use: {
           loader: 'url-loader',
           options: {
               limit: 22228,
               outputPath: 'image',
           }
       }
   },
   ```

   

## 只暴露行号不暴露源码

定位行号：eval-source-map

webpack.config.js添加： 

```javascript
devtool: 'nosources-source-map',
```



# 7. 过滤器

基本用法：

```html
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<div id="app">
    <p>message的值是 {{ message | capi }}</p>
</div>
<script>
    const vm = new Vue({
        el: '#app',
        data: {
            message: 'hello'
        },
        //过滤器函数
        filters: {
            capi(val) {
                const first = val.charAt(0).toUpperCase()
                const other = val.slice(1)
                //过滤器中一定有返回值
                return first+other
            }
        }
    })
</script>
```

全局过滤器一定要定义在前面：

```html
<script>
    Vue.filter('capitalize', (str) => {
        const first = str.charAt(0).toUpperCase()
        const other = str.slice(1)
        //过滤器中一定有返回值
        return first+other
    })
</script>
```

# 8. 侦听器

基本使用：

```javascript
const vm = new Vue({
    el: '#app',
    data: {
        username: ''
    },
    //定义侦听器
    watch: {
        //新值在前，旧值在后
        username(newVal, oldVal) {
            console.log(newVal, oldVal);
        }
    }
})
```

## 侦听器的格式

1. 方法格式的侦听器
   - 缺点1：无法在刚进入页面的时候，自动触发。
   - 缺点2： 如果侦听的是一个对象，如果对象中的属性发生了变化，不会触发侦听器。

2. 对象格式的侦听器
   - 好处1：可以通过immediate选项，让侦听器自动触发
   - 好处2：可以通过deep选项，让侦听器侦听对象中每个属性的变化

```javascript
//定义对象格式的侦听器
username: {
    handler: function(newVal, oldVal) {
        console.log(newVal, oldVal, '触发了');
    },
    //自动触发
    immediate: true,
    //开启深度监听
    deep: true
}
```

# 9. 计算属性

基本使用：

```html
<script>
    var vm = new Vue({
        el: '#app',
        data:{
            r: 0,
            g: 0,
            b: 0
        },
        // 定义计算属性，要定义成方法格式
        computed: {
            rgb() {
                return `rgb(${this.r}, ${this.g}, ${this.b})`
            }
        }
    })
</script>
```

# 10. vue-cli的使用

1. 在终端下运行如下命令，创建指定名称的项目

   vue create 项目名称

2. vue项目中src目录构成

   assets: 存放项目中用到的静态资源文件，例如CSS样式表、图片资源

   components: 程序员封装的、可复用的组件

   main.js: 是项目的入口文件

   App.js: 是项目的根组件

## 定义组件

新建文件：xxx.vue

```vue
<template>
    <div class="test-box">
        <h3>用户自定义的Test.vue---{{ username }}</h3>
        <button @click="changeName">修改用户名</button>
    </div>
</template>

<script>
//默认导出
export default {
    //vue组件中的data不能指向对象，必须是一个函数
    data(){
        //定义数据
        return {
            username: 'admin'
        }
    },
    methods: {
        changeName(){
            //在组件中，this表示当前组件的实例对象
            this.username = "哇哈哈"
        }
    },
    watch: {},  //监听器
    computed: {},    //计算属性
    filters: {} //过滤器
}
</script>

<!-- 启用less语法 -->
<style lang="less">
.test-box {
    background-color: pink;
}
h3 {
    color: red;
}
</style>
```

## 使用组件

导入、注册、使用

```vue
<template>
  <div id="app">
    <div>
      <h1>App根组件</h1>
    </div>
    <div class="box">
      <!-- 渲染Left组件和Rignt组件 -->
      <!-- 3. 使用组件 -->
      <Left></Left>
    </div>
  </div>
  
</template>

<script>
// 1. 导入需要使用的 .vue 组件
import Left from '@/components/Left.vue'
export default {
  data() {
    return {}
  },
  methods: {},
  components: {
    // 2. 注册组件
    Left
  }
}
</script>

<style lang="less">
.app {
  padding: 1px, 20px, 20px;
  background-color: #efefef;
}
</style>
```

## 注册全局组件

在main.js中

```javascript
import Count from '@/components/Count.vue'
Vue.component("Count", Count)
```

## 自定义属性 props

```javascript
export default {
    props: ['自定义属性A', '自定义属性B']
}
```

自定义默认值

```javascript
props: {
    init: {
        default: 0
    }
}
```

指定类型

```javascript
props: {
    init: {
        default: 0,
        typeof: Number
    }
}
```

必填校验

```javascript
props: {
    init: {
        default: 0,
        typeof: Number,
        //必填项校验
        required: true
    }
}
```

## scoped解决组件间样式冲突

```html
<style scoped>
...
</style>
```

同时修改子组件样式：

```less
/deep/ h5 {
    color: pink;
}
```

# 11. 生命周期

创建

beforeCreate->created->beforeMount->mounted

运行

beforeUpdate->updated

销毁

beforeDestroy->destroyed

created生命周期函数非常常用，经常用它调用methods中的方法，请求服务器数据。

mounted函数可以最早的操作DOM元素

# 12. 组件之间数据共享

## 父->子：自定义属性

## 子->父：自定义事件

子组件：

```javascript
methods: {
    add() {
        this.count += 1
        //修改数据时，通过$emit触发自定义事件
        this.$emit('numchange',this.count)
    }
}
```

父组件：

```vue
<Left @numchange="getNewCount"></Left>

data() {
    return {
      countFromSon: 0
    }
},
methods: {
    getNewCount(val) {
      this.countFromSon = val
    }
}
```

## 兄弟之间数据共享 EventBus

数据发送方：

```javascript
import bus from './eventBus.js'

export default {
    data() {
       return {
           msg: 'hello vue.js'
       } 
    },
    methods: {
        sendMsg() {
            bus.$emit('share', this.msg)
        }
	}
}
```

eventBus.js

```javascript
import Vue from 'vue'

//向外共享Vue实例
export default new Vue()
```

数据接收方：

```javascript
import bus from './eventBus.js'

export default {
    data() {
       return {
           msgFromLeft: ''
       } 
    },
    created() {
        bus.$on('share', val => {
            this.msgFromLeft = val
        })
    }
}
```

# 13. ref

引用dom元素

```
<h1 ref="myh1">App根组件-- {{ countFromSon }}</h1>

console.log(this.$refs.myh1)
```

引用组件

```html
<my-counter ref="counterRef"></my-counter>

//通过this.$refs.引用名称 可以引用组件的实例
this.$refs.counterRef
//引用到组件的实例之后，可以调用组件上的methods方法
this.$refs.counterRef.add()
```

延迟到dom重新渲染完毕之后执行

```javascript
this.$nextTick(() => {
	this.$refs.iptRef.focus()
})
```

# 14. 数组中的方法

数组中查找某一项：some方法

```javascript
arr.some((item, index) => {
    if (item === "苏大强") {
        return true
    }
})
```

判断每一项是否满足需求：every方法

```javascript
const result = arr.every(item => item.state)
```

reduce方法：累加器

```javascript
//语法：
arr.filter(item => state).reduce((累加的结果, 当前循环项) =>{  },初始值)

let amt = 0
const result = arr.filter(item => state).reduce((amt, item) =>{ 
	return amt += item.price * item.count
}, 0)

//简写：
const result = arr.filter(item => state).reduce((amt, item) => amt += item.price * item.count, 0)
```

# 15. 动态组件

## 基本使用

component标签是vue内置的，作用：组件的占位符

is属性的值，表示要渲染组件的名字

```vue
<components :is="comName"></components>
```

## keep-alive

可以把内部的组件进行缓存，而不是销毁组件

include:指定哪些组件需要被缓存，exclude:指定哪些不被缓存，不能同时使用

```vue
<keep-alive include="Left, Right">
	<components :is="comName"></components>
</keep-alive>
```

生命周期：

当组件被缓存时，会自动触发组件的deactivated生命周期函数。

当组件被激活时，会自动触发组件的activated生命周期函数。

# 16. 插槽

## 基本使用

声明：

```vue
<!-- Left组件声明一个插槽 -->
<slot></slot>
```

使用：

```vue
<Left>
	<p>这是Left内容区声明的P标签</p>
</Left>
```

## v-slot

声明：

```vue
<slot name="default"></slot>
```

使用：

```vue
<template v-slot:default>
  <p>这是Left内容区声明的P标签</p>
</template>
```

简写：

```vue
<template #:default>
  <p>这是Left内容区声明的P标签</p>
</template>
```

提供默认内容：

```vue
<slot name="default">默认内容</slot>
```

## 作用域插槽

声明：

```vue
<slot name="content" msg="hello vue.js"></slot>
```

使用：

```vue
<template #content="scope">
	<p>
        {{ scope.msg }}
    </p>
</template>
```

可以使用解构赋值

# 17. 自定义指令

## 私有自定义指令

基本用法：

```vue
// 私有自定义指令的节点
directives: {
// 定义名为color的指令，指向一个配置对象
        color: {
            // 当指令第一次被绑定到元素上的时候，会立即触发bind指令
            // el表示当前被绑定的DOM对象
            bind(el) {
            el.style.color = 'red'
        }
    }
}
```

自定义值：

```vue
// 私有自定义指令的节点
directives: {
// 定义名为color的指令，指向一个配置对象
        color: {
            // 当指令第一次被绑定到元素上的时候，会立即触发bind指令
            // el表示当前被绑定的DOM对象
            bind(el, binding) {
            el.style.color = 'red'
        }
    }
}

<h1 v-color="'red'">App根组件</h1>
```



## update函数

和bind同时使用，第一次生效，改变时也生效

```vue
color: {
  bind(el, binding) {
    console.log('触发了bind函数')
    el.style.color = binding.value
  },
  update(el, binding) {
    console.log('触发了update函数')
    el.style.color = binding.value
  }
}
```

简写：

```vue
color(el, binding) {
	el.style.color = binding.value
}
```

## 全局自定义指令

```vue
Vue.directive('color', function(el, binding) {
  el.style.color = binding.value
})
```

# ESLint

# axios

全局配置

```vue
import axios from 'axios'

axios.defaults.baseURL = 'https://api.apiopen.top/api'
Vue.prototype.$http = axios
```

基本使用：

```vue
export default {
  methods: {
    async getInfo() {
      const { data: res } = await this.$http.get('sentences')
      console.log(res.result)
    }
  }
}
```

# 18. 前端路由

## 基本原理：锚点链接

```html
<body>
  <div class="side-bar">
    <a href="#b1">b1</a>
    <a href="#b2">b2</a>
    <a href="#b3">b3</a>
    <a href="#b4">b4</a>
  </div>

  <div class="box" id="b1"></div>
  <div class="box" id="b2"></div>
  <div class="box" id="b3"></div>
  <div class="box" id="b4"></div>
</body>
```

## vue-router

安装：npm i vue-router@3.5.2 -S

新建路由模块：src/index.js

```javascript
import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const router = new VueRouter()

export default router
```

main.js导入和挂载路由模块

```javascript
// 在模块化导入的时候，如果给定的是文件夹，则默认导入名字叫做index.js的文件
import router from './router'

new Vue({
  render: h => h(App),
  // router: router
  router	// 简写
}).$mount('#app')
```

定义路由规则

```javascript
import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/components/Home.vue'
import Movie from '@/components/Movie.vue'
import About from '@/components/About.vue'

Vue.use(VueRouter)

const router = new VueRouter({
  // 定义hash地址和组件之间对应关系
  routes: [
    {path: '/home', component: Home},
    {path: '/movie', component: Movie},
    {path: '/about', component: About},
  ]
})

export default router
```

使用：

```vue
<template>
  <div id="app">
    <h1>App 组件</h1>

    <a href="#/home">首页 </a>
    <a href="#/movie">电影 </a>
    <a href="#/about">关于</a>
    <hr>
    
    <!-- 只要在项目中安装和配置了vue-router就可以使用了 -->
    <router-view></router-view>
  </div>
</template>
```

router-link可以替代a链接

```vue
<router-link to="/home">首页 </router-link>
<router-link to="/movie">电影 </router-link>
<router-link to="/about">关于</router-link>
```

## 路由重定向

```vue
{path: '/', redirect: '/home'},
```

## 嵌套路由

创建子路由规则：

```js
const router = new VueRouter({
  // 定义hash地址和组件之间对应关系
  routes: [
    { path: '/', redirect: '/home' },
    { path: '/home', component: Home },
    { path: '/movie', component: Movie },
    {
      path: '/about',
      component: About,
      children: [
        // 子路由规则
        // 默认子路由：如果children数组中每个路由规则的path值为空，则这条路由是默认子路由
        { path: '', component: Tab1 },
        { path: 'tab1', component: Tab1 },
        { path: 'tab2', component: Tab2 }
      ]
    }
  ]
})
```

使用：

```html
  <!-- 子级路由链接 -->
  <router-link to="/about/tab1">tab1</router-link>
  <router-link to="/about/tab2">tab2</router-link>
  <hr />

  <!-- 子级路由占位符 -->
  <router-view></router-view>
```

## 动态路由匹配

链接：

```vue
<router-link to="/movie/1">洛基 </router-link>
<router-link to="/movie/2">雷神 </router-link>
<router-link to="/movie/3">复联 </router-link>
```

定义路由：

```javascript
{ path: '/movie/:id', component: Movie }
```

获取动态参数：

```js
{{ this.$route.params.id }}
```

props传参：

```
{ path: '/movie/:id', component: Movie, props: true }

export default {
  //接收props数据
  props: ['id']
}

{{ id }}
```

## query和fullPath

在路由“参数对象”中，需要使用this.$route.query来访问路径参数

在this.$route中，path只是路径部分，fullPath是完整的地址

## 编程式导航

```vue
export default {
  methods: {
    gotoLk() {
      //编程式导航
      this.$router.push('/movie/1')
    }
  }
}
```

this.$router.push(hash地址): 跳转并且增加一条历史记录

this.$router.replace(hash地址): 跳转并且替换当前历史记录

this.$router.go(n): 在浏览历史中前进和后退

this.$router.back()

this.$router.forward()

## 导航守卫

全局前置守卫：

```javascript
// 为router实例对象声明全局前置导航守卫
// 只要发生路由跳转，必然触发
router.beforeEach(function (to, from, next) {
  // to 是将要访问的路由信息对象
  // from 是将要离开的路由的信息对象
  // next 是一个函数， 调用next() 表示放行，允许这次路由导航
  if (to.path === '/main') {
    const token = localStorage.getItem('token')
    if (token) {
      next()
    } else {
      next('/login')
    }
  } else {
    next()
  }
})
```

