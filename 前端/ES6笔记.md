# 1. let声明变量

```javascript
let a;
let b,c,d;
let e = 100;
let f = 512; g = 'idsafd', h = [];
```

1. 变量不能重复声明。

2. 块级作用域 全局，函数，eval

   ```javascript
   {
       let girl = 'sdfsa';
   }
   console.log(girl);	//报错
   ```

3. 不存在变量提升

   ```javascript
   console.log(song);	//报错
   let song = 'sdfas';
   ```

4. 不影响作用域链

   ```javascript
   {
       let school = 'sdfa';
       function fn(){
           console.log(school);
       }
       fn();
   }
   ```

   

# 2. 声明常量

```javascript
const SCHOOL = 'fsads';
```

1. 一定要赋初始值

2. 一般常量使用大写

3. 常量的值不能修改

4. 块级作用域

   ```javascript
   {
       const PLAYER = 'UZI';
   }
   console.log(PLAYER);	//报错
   ```

5. 对于数组和对象的元素修改，不算做对常量的修改，不会报错。

   ```javascript
   const TEAM = ['dsf','ewr','ewrq'];
   TEAM.push('ew');	//不报错
   ```

   

# 3. 变量的解构赋值

ES6允许按照一定模式从数组和对象中提取值，对变量进行赋值，这被称为解构赋值。

1. 数组的解构

   ```javascript
   const F4 = ['小沈阳','刘能','赵四','宋小宝']；
   let [xiao,liu,zhao,song] = F4;
   console.log(xiao);
   ```

2. 对象的解构

   ```javascript
   const zhao = {
       name: '赵本山',
       age: '不详',
       xiaopin: function(){
           console.log("我可以演小品");
       }
   };
   
   let {name, age, xiaopin} = zhao;
   let {xiaopin} = zhao;
   ```



# 4. 模板字符串

1. 声明

   ```javascript
   let str = `我也是一个字符串哦！`;
   console.log(str, typeof str);
   ```

2. 内容中可以直接出现换行符

   ```javascript
   let str = `<ul>
   			<li></li>
   			<li></li>
   		</ul>`;
   ```

3. 变量拼接

   ```javascript
   let lovest = `魏翔`;
   let out = `${lovest}是我心目中最搞笑的演员！！`;
   ```

   

# 5. 对象的简化写法

ES6允许在大括号里面，直接写入变量和函数，作为对象的属性和方法。

```javascript
let name = 'zxcv';
let change = function(){
    console.log('我们可以改变你！！');
}
const school = {
    name,
    change,
    improve(){
        console.log("我们可以提高你的技能");
    }
}
```

# 6. 箭头函数

ES6允许使用箭头 (=>) 定义函数。

声明一个函数：

```javascript
let fn = function(a,b){
    return a + b;
}
let fn = (a,b) => {
    return a + b;
}
```

1. this是静态的，this始终指向函数声明时所在作用域下的this的值

   ```javascript
   function getName(){
       console.log(this.name);
   }
   let getName2 = () => {
       console.log(this.name);
   }
   //设置window对象的name属性
   window.name = 'xvc';
   const school = {
       name: "dvf"
   }
   //直接调用
   getName();	//this指向window
   getName2();	//this指向window
   //call 方法调用
   getName.call(school);	//this指向school
   getname2.call(school);	//this指向window
   ```

2. 不能作为构造实例化对象

   ```javascript
   let Person = (name, age) => {
       this.name = name;
       this.age = age;
   }
   let me = new Person('xiao',30);	//报错
   ```

   

3. 不能使用arguments变量

4. 箭头函数的简写

   ```javascript
   //1.省略小括号，当形参有且只有一个
   let add = n => {
       return n + n;
   }
   //2.省略花括号，当代码体只有一条语句时，return必须省略。
   let pow = n => n*n;
   ```

   

# 7. 函数参数的默认值设置

ES6允许给函数参数赋值初始值

1. 形参初始值

   ```javascript
   function add(a,b,c=10){
       return a + b + c;
   }
   let result = add(1,2,3);
   ```

   

2. 与解构赋值结合

   ```javascript
   function connect({host="127.0.0.1", username, password, port}){
       console.log(host);
       console.log(username);
       console.log(password);
       console.log(port);
   }
   connect({
       host: 'localhost',
       username: 'root',
       password: 'root',
       port: 3306
   })
   ```

   

# 8. rest参数

ES6引入rest参数，用于获取函数的实参，用来代替arguments

```javascript
function date(){
    console.log(arguments);	//对象
}
date('asf','sfda','werq')
//ES6:
function date(...args){	//数组
    console.log(args);
}
```

rest参数必须要放到参数最后

```javascript
function fn(a,b,...args){
    console.log(a);
    console.log(b);
    console.log(args);
}
fn(1,2,3,4,5,6);
```

# 9. 扩展运算符...

扩展运算符能将数组转换为逗号分隔的参数序列

```javascript
//声明一个数组
const rubbish = ['少年大佐','赛博顶针','鸡哥','时间管理大师'];
//声明一个函数
function chunwan(){
    console.log(argumemts);
}
chunwan(rubbish);	//参数是一个数组
chunwan(...rubbish);	//参数是四个
```

1. 数组的合并

   ```javascript
   const kuaizi = ['王太利'，'肖央'];
   const fenghuang = ['曾毅','玲花'];
   const zuixuanxiaopingguo = kuaizi.concat(fenghuang);	//合并
   const zuixuanxiaopingguo = [...kuaizi, ...fenghuang];	//合并
   ```

2. 数组的克隆

   ```javascript
   const sanzhihua = ['E','G','M'];
   const sanyecao = [...sanzhihua];
   console.log(sanyecao);
   ```

3. 将伪数组转换为真正的数组

   ```javascript
   const divs = documents.querySelectorAll('div');
   const divsArr = [...divs];	//变成了真正的数组
   ```

   

# 10. Symbol基本使用

ES6引入了一种新的原始数据类型Symbol，表示独一无二的值。它是JavaScript语言的第七种数据类型，是一种类似于字符串的数据类型。

## Symbol特点：

1. Symbol的值是为一个，用来解决命名冲突的问题

2. Symbol值不能与其他数据进行运算

3. Symbol定义的对象属性不能使用for...in循环遍历，单实可以使用Reflect.ownKeys来获取对象的所有键名

   ```javascript
   //创建Symbol
   let s = Symbol();
   let s2 = Symbol('手动阀');
   let s3 = Symbol('手动阀');
   //Symbol.for创建
   let s4 = Symbol.for('手动阀');
   let s5 = Symbol.for('手动阀'); 
   console.log(s2 === s3);	//false
   console.log(s4 === s5);	//true
   ```

   

## 对象添加Symbol类型的属性

```javascript
let game = {
    
}
//声明一个对象
let methods = {
    up: Symbol(),
    down: Symbol()
};
game[methods.up] = function(){
    console.log("我可以改变形状");
}
game[methods.down] = function(){
    console.log("我可以快速下降");
}
console.log(game);
```

```javascript
let youxi = {
    name:"狼人杀",
    [Symbol('say')]: function(){
        console.log("我可以发言")；
    }
    [Symbol('zibao')]: function(){
        console.log("我可以自爆")；
    }
}
```

## Symbol的内置属性

```javascript
class Person{
    static [Symbol.hasInstance](param){
        console.log("我被用来检测类型了");
        return false;
    }
}
let o = {};
console.log(o instanceof Person);
```

# 11. 迭代器

迭代器(Iterator)是一种接口，为各种不同的数据解构提供统一的访问机制。任何数据结构只要部署Iterator接口，就可以完成遍历操作。

```javascript
const xiyou = ['唐僧','孙悟空','猪八戒','沙僧'];
for(let v of xiyou){
    console.log(v);
}
```

## 自定义遍历对象

```javascript
const banji = {
    name: "终极一班",
    stus: [
        'xiaoming',
        'xiaoning',
        'xiaotian',
        'knight'
    ]
    [Symbol.iterator](){
    	//索引变量
    	let index = 0;
    	let _this = this;
    	return {
    		next: function(){
                if(index < this.stus.length){
                    const result = {value: _this.stus[index], done: false};
                    index++;
                    return result;
                }else{
                    return {value: undefined, done: true}
                }
            }
		};
	}
}
//遍历这个对象
for (let v of banji){
    console.log(v);
}
```

# 12. 生成器

生成器函数是ES6提供的一种异步编程解决方案，语法行为与传统函数完全不同

```javascript
function* gen(){
	console.log(111);
    yield '一只没有耳朵';
    console.log(222);
    yield '一只没有尾巴';
    console.log(333);
    yield '真奇怪';
    console.log(444);
}
let iterator = gen();
for(let v of gen()){
    console.log(v);
}
```

## 生成器函数参数

```javascript
function* gen(arg){
    console.log(arg);
    let one = yield 111;
    console.log(one);
    let two = yield 222;
    console.log(two);
    yield 333;
}
//执行获取迭代器对象
let iterator = gen('AAA');
console.log(iterator.next());
console.log(iterator.next('BBB'));
console.log(iterator.next('CCC'));
```

## 生成器函数实例

```javascript
//回调地狱
setTimeout(() => {
    console.log(111);
    setTimeout(() => {
        console.log(222);
            setTimeout(() => {
                console.log(333);
            }, 1000);
    }, 1000);
}, 1000);
```

```javascript
function one(){
    setTimeout(() => {
        console.log(111);
        iterator.next();
    }, 1000);
}
function two(){
    setTimeout(() => {
        console.log(222);
        iterator.next();
    }, 1000);
}
function three(){
    setTimeout(() => {
        console.log(333);
        iterator.next();
    }, 1000);
}
function* gen(){
    yield one();
    yield two();
    yield three();
}
let iterator = gen();
iterator.next();
```

```javascript
function getUsers(){
    setTimeout(() => {
        let data = '用户数据';
        iterator.next(data);
    }, 1000);
}
function getOrders(){
    setTimeout(() => {
        let data = '订单数据';
        iterator.next(data);
    }, 1000);
}
function getGoods(){
    setTimeout(() => {
        let data = '商品数据';
        iterator.next(data);
    }, 1000);
}
function * gen(){
    let users = yield getUsers();
    console.log(users);
    let orders = yield getOrders();
    console.log(orders);
    let goods = yield getGoods();
    console.log(goods);
}
let iterator = gen();
iterator.next();
```

# 13.Promise

## 基本使用

```javascript
//实例化Promise对象
    const p = new Promise(function(resolve, reject){
        setTimeout(() => {
            // let data = '数据库中的用户数据';
            // resolve(data);  //p变成功
            let err = '数据读取失败';
            reject(err);
        }, 1000);
    });

    p.then(function(value){	//成功调用此方法
        console.log(value);
    },function(reason){	//失败调用此方法
        console.log(reason);
    });
```

## Promose封装读取文件

```javascript
/* fs.writeFile('./files/test.txt', 'Hello Node.js!!', function(err){
    if(err){
        console.log('写入失败');
    }else{
        console.log('写入成功');
    }
}); */

const p = new Promise(function(resolve, reject){
    fs.readFile("./files/test.txt", "utf-8",(err, data) => {
        if(err) reject(err);
        resolve(data);
    });
});
p.then(function(value){
    console.log(value);
}, function(reason){
    console.log("读取失败！！");
});
```

## Promise封装AJAX请求

ajax请求：

```javascript
// 1.创建对象
const xhr = new XMLHttpRequest();
// 2.初始化
xhr.open("GET", "https://api.apiopen.top/api/getTime");
// 3.发送
xhr.send();
// 4.绑定时间，处理响应结果
xhr.onreadystatechange = function(){
    //判断
    if(xhr.readyState === 4){
        //判断响应状态码 200-299
        if(xhr.status >= 200 && xhr.status < 300){
            //表示成功
            console.log(xhr.response);
        }else{
            //如果失败
            console.error(xhr.status);
        }
    }
}
```

Promise封装AJAX请求:

```javascript
const p = new Promise((resolve, reject) => {
    // 1.创建对象
    const xhr = new XMLHttpRequest();
    // 2.初始化
    xhr.open("GET", "https://api.apiopen.top/api/getTime");
    // 3.发送
    xhr.send();
    // 4.绑定时间，处理响应结果
    xhr.onreadystatechange = function(){
        //判断
        if(xhr.readyState === 4){
            //判断响应状态码 200-299
            if(xhr.status >= 200 && xhr.status < 300){
                //表示成功
                resolve(xhr.response);
            }else{
                //如果失败
                reject(xhr.status);
            }
        }
    }
});
p.then(function(value){
    console.log(value);
},function(reason){
    console.error(reason);
})
```

## then方法解决回调地狱

```javascript
//then方法
const p = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve('用户数据');
        // reject('出错啦');
    }, 1000);
});

//then方法的返回结果是Promise对象，对象状态由回调函数的执行结果决定
//1. 如果回调函数中返回结果是 非Promise 类型的属性， 状态为成功，返回值为对象的成功值。
const result = p.then(value => {
    // console.log(value);
    return value;
}, reason => {
    console.warn(reason);
    return reason;
})
//链式调用
p.then(value => p)
.then(value => {
    console.log(value);
});
```

文件读取

```javascript
/* fs.readFile('./files/1.txt', 'utf-8', (err, data1) => {
    fs.readFile('./files/2.txt', 'utf-8', (err, data2) => {
        fs.readFile('./files/3.txt', 'utf-8', (err, data3) => {
            let result = data1 + data2 + data3;
            console.log(result);
        })
    })
}) */
//使用promise实现
const p = new Promise((res, reject) => {
    fs.readFile("./files/1.txt", 'utf-8', (err, data) => {
        res(data);
    });
});
p.then(value => {
    return new Promise((res, reject) => {
        fs.readFile("./files/2.txt", 'utf-8', (err, data) => {
            res([value, data]);
        });
    })
}).then(value => {
    return new Promise((res, reject) => {
        fs.readFile("./files/3.txt", 'utf-8', (err, data) => {
            value.push(data);
            res(value);
        });
    })
}).then(value => {
    console.log(value);
})
```

## catch

```javascript
const p = new Promise((resolve, reject) => {
    setTimeout(() => {
        //设置p对象的状态为失败，并设置失败的值
        reject("出错啦！");
    }, 1000);
});

/* p.then(function(value){}, function(reason){
    console.error(reason);
}) */
p.catch(function(reason){
    console.warn(reason);
})
```

# 14. Set集合

## 基本使用

```javascript
//声明一个set
let s = new Set();
let s2 = new Set(['大事儿','小事儿','好事儿','坏事儿','小事儿']);
//元素个数
console.log(s2.size);
//添加元素
s2.add('喜事儿');
//删除元素
s2.delete('坏事儿');
//检测
console.log(s2.has('好事儿'));
console.log(s2, typeof s);
//清空
// s2.clear();
console.log(s2);
for(let v of s2){
    console.log(v);
}
```

## 数组处理

```javascript
let arr = [1,2,3,4,5,4,3,2,1];
// 1. 数组去重
let result = [...new Set(arr)];
console.log(result);
// 2. 交集
let arr2 = [4,5,6,5,6];
/* let result1 = [...new Set(arr)].filter(item => {
    let s2 = new Set(arr2);
    if(s2.has(item)){
        return true;
    }else{
        return false;
    }
}) */
let result1 = [...new Set(arr)].filter(item => new Set(arr2).has(item));
console.log(result1);
// 3. 并集
let union = [...new Set([...arr, ...arr2])];
console.log(union);
// 4. 差集
let result2 = [...new Set(arr)].filter(item => !new Set(arr2).has(item));
console.log(result2);
```

# 15. Map基本使用

```javascript
let m = new Map();
m.set('name', '鸡哥');
m.set('favorite', function(){
    console.log("我喜欢CTRL");
});
let key = {
    team: '美国校队'
};
m.set(key,['队长','队员','观众']);
console.log(m.size);
//删除
m.delete('name');
//获取
console.log(m.get('favorite'));
//清空
// m.clear();
//遍历
for(let v of m){
    console.log(v);
}
console.log(m);
```

# 16. Class类

```javascript
class Phone{
    //构造方法
    constructor(brand, price){
        this.brand = brand;
        this.price = price;
    }
    //方法不能使用ES5语法
    call(){
        console.log("我可以打电话！！");
    }
}
let onePlus = new Phone("1+", 1999);
console.log(onePlus);
```

## 静态成员

```javascript
class Phone{
    //静态属性
    static name = '手机';
    static change(){
        console.log("我可以改变世界");
    }
}
let nokia = new Phone();
console.log(nokia.name);    //undefined
console.log(Phone.name);    //手机
```

## 继承

ES5继承：

```javascript
//手机
function Phone(brand, price){
    this.brand = brand;
    this.price = price;
}
Phone.prototype.call = function(){
    console.log("我可以打电话");
}
//智能手机
function SmartPhone(brand, price, color, size){
    Phone.call(this, brand, price);
    this.color = color;
    this.size = size;
}
//设置子级构造函数的原型
SmartPhone.prototype = new Phone;
SmartPhone.prototype.constructor = SmartPhone;

//声明子类方法
SmartPhone.prototype.photo = function(){
    console.log("拍照");
}
SmartPhone.prototype.playGame = function(){
    console.log("玩游戏");
}

const chuizi = new SmartPhone('锤子', 2499, '黑色', '5.5');
console.log(chuizi);
```

class继承：

```javascript
class Phone{
    //构造方法
    constructor(brand, price){
        this.brand = brand;
        this.price = price;
    }

    //父类的成员属性
    call(){
        console.log("我可以打电话！！");
    }
}

class SmartPhone extends Phone {
    //构造方法
    constructor(brand, price, color, size){
        super(brand, price);
        this.color = color;
        this.size = size;
    }

    photo(){
        console.log("拍照");
    }

    playGame(){
        console.log("玩游戏");
    }
}

const xiaomi = new SmartPhone('小米', 799, '黑色', '4.7');
console.log(xiaomi);
xiaomi.call();
```

## 重写

```javascript
class Phone{
//构造方法
constructor(brand, price){
    this.brand = brand;
    this.price = price;
}

//父类的成员属性
call(){
    console.log("我可以打电话！！");
}
}

class SmartPhone extends Phone {
//构造方法
constructor(brand, price, color, size){
    super(brand, price);
    this.color = color;
    this.size = size;
}

photo(){
    console.log("拍照");
}

playGame(){
    console.log("玩游戏");
}

call(){
    console.log("我可以进行视频通话");
}
}

const xiaomi = new SmartPhone('小米', 799, '黑色', '4.7');
console.log(xiaomi);
xiaomi.call();
```

# 17. 数值扩展

## 最小精度Number.EPSILON

```javascript
function equal(a, b){
    if(Math.abs(a-b) < Number.EPSILON){
        return true;
    }else{
        return false;
    }
}
console.log(0.1 + 0.2 === 0.3);	//false
console.log(equal(0.1 + 0.2, 0.3));	//true
```

## 二进制和八进制

```javascript
let b = 0b1010;	//二进制 10
let o = 0o777;	//八进制 511
let x = 0xff;   //十六进制 255
```

## 检测

```javascript
//检测一个数是否为有限数
console.log(Number.isFinite(100));
console.log(Number.isFinite(100/0));
console.log(Number.isFinite(Infinity));

//isNaN
console.log(Number.isNaN(123));

//字符串转数 Number.parseInt Number.parseFloat
console.log(Number.parseInt('234432love'));

//判断一个数是否为整数 Number.isInteger
console.log(Number.isInteger(5));

//将数字的小数部分抹掉 Math.trunc
console.log(Math.trunc(3.5));

//判断一个数是整数 复数 还是零
console.log(Math.sign(100));
```

# 18. 对象方法扩展

```javascript
//判断两个值是否完全相等 Object,is
console.log(Object.is(120, 120));   //true
console.log(Object.is(NaN, NaN));   //true
console.log(NaN === NaN);   //false

// 对象的合并
const config1 = {
    host: 'localhost',
    port: 3306,
    name: 'root',
    pass: 'root',
    test: 'test'
};
const config2 = {
    host: 'http',
    port: 33060,
    name: 'sf',
    pass: 'iloveyou'
}
console.log(Object.assign(config1, config2));

//设置原型对象 Object.setPrototypeOf
const school = {
    name: 'sd',
}
const cities = {
    xiaoqu: ['北京','上海','深圳']
}
Object.setPrototypeOf(school, cities);
console.log(Object.getPrototypeOf(school));
console.log(school);
```

# 19. 模块化

## 暴露

m1:

```javascript
//分别暴露
export let school = '尚硅谷';

export function teach(){
    console.log("4241412431234");
}
```

m2:

```javascript
//统一暴露
let school = 'vda';
function findJob(){
    console.log("我们什么也帮不了");
}

//
export {school, findJob}
```

m2:

```javascript
//默认暴露
export default{
    school: 'xczv',
    change: function(){
        console.log("我们什么也改变不了");
    }
}
```

## 导入

通用方式：

```javascript
//引入m1.js模块内容
import * as m1 from "./src/js/m1.js";
//引入m2.js
import * as m2 from "./src/js/m2.js";
import * as m3 from "./src/js/m3.js";
// console.log(m3);
m3.default.change();
```

解构赋值：

```javascript
import {school, teach} from "./src/js/m1.js";	//分别暴露
import {school as guigu, findJob} from "./src/js/m2.js";	//统一暴露
import {default as m3} from "./src/js/m3.js";	//默认暴露
console.log(school);
console.log(teach);
console.log(guigu, findJob);
console.log(m3);
```

简便形式 针对默认暴露

```javascript
import m3 from "./src/js/m3.js";
console.log(m3);
```

浏览去引入模块：

```javascript
//入口文件
//模块引入
import * as m1 from "./m1.js";
import * as m2 from "./m2.js";
import * as m3 from "./m3.js";

console.log(m1);
console.log(m2);
console.log(m3);
```

```html
//引入
<script src="./src/js/app.js" type="module"></script>
```

# 20. babel转换ES6

1.安装工具 babel-cli babel-preset-env browserify(webpack)

```
npm init --yes
npm i babel-cli babel-preset-env browserify -D
```

2.转换

```
npx babel src/js -d dist/js --presets=babel-preset-env
```

3.打包

```
npx browserify dist/js/app.js -o dist/bundle.js
```

# 21. 模块化引入NPM包

```javascript
import $ from 'jquery';
$('body').css('background','pink');
```

# 22. ES7

## 数组inlcudes

```javascript
const mingzhu = ['西游记','红楼梦','三国演义','水浒传'];
//判断
console.log(mingzhu.includes('西游记'));
```

## 幂运算

```javascript
console.log(2 ** 10);	//Math.pow(2, 10);
```

# 23. ES8

## 1. ansync

```javascript
//async 函数
async function fn(){
    //返回的结果不是一个Promise类型的对象，返回的结果就是成功Promise对象
    // return '尚硅谷';
    //抛出错误，返回的结果是一个失败的Promise
    // throw new Error('出错啦！');
    //返回的结果如果是一个Promise对象
    return new Promise((resolve, reject) => {
        resolve('成功的数据');
    });
}
const result = fn();
console.log(result);
```

## 2. await

```javascript
//创建 promise 对象
const p = new Promise((resolve, reject) => {
    // resolve("成功的值！");
    reject("失败啦！");
});
// await 要放在 async 函数中
async function main(){
    try{
        let result = await p;
        console.log(result);
    }catch (e) {
        console.log(e);
    }
}

//调用函数
main();
```

## 3. ansync与await结合读取文件

```javascript
//1. 引入fs模块
import fs from "fs";
//读取1.txt
function readOne(){
    return new Promise((resolve, reject) => {
        fs.readFile("./resources/1.txt", "utf-8", (err, data) => {
            if (err) reject(err);
            resolve(data);
        });
    });
}

function readTwo(){
    return new Promise((resolve, reject) => {
        fs.readFile("./resources/2.txt", "utf-8", (err, data) => {
            if (err) reject(err);
            resolve(data);
        });
    });
}

function readThree(){
    return new Promise((resolve, reject) => {
        fs.readFile("./resources/3.txt", "utf-8", (err, data) => {
            if (err) reject(err);
            resolve(data);
        });
    });
}

//声明一个async函数
async function main(){
    let one = await readOne();
    let two = await readTwo();
    let three = await readThree();
    console.log(one + two + three);
}

main();
```

## 4. ansync与await结合发送AJAX请求

```javascript
//发送AJAX请求，返回结果是Promise对象
function sendAJAX(url){
    return new Promise((resolve, reject) => {
        //1. 创建对象
    const x = new XMLHttpRequest();
    //2. 初始化
    x.open('GET', url);
    //3. 发送
    x.send();
    //4. 事件绑定
    x.onreadystatechange = function(){
        if(x.readyState === 4){
            if(x.status >= 200 && x.status < 300){
                //成功
                resolve(x.response);
            }else{
                //失败
                reject(x.status);
            }
        }
    }
    });
}
async function main(){
    let result = await sendAJAX("https://api.apiopen.top/api/sentences");
    let result2 = await sendAJAX("https://api.apiopen.top/api/sentences");
    console.log(result + ' ' + result2);
}
main();
```

## 5. 对象方法扩展

```javascript
//声明对象
const school = {
    name:"尚硅谷",
    cities:['北京','上海','深圳'],
    xueke:['前端','Java','大数据','运维']
};
//获取对象所有的键
console.log(Object.keys(school));
//获取对象所有的值
console.log(Object.values(school));
//创建MAP
const m = new Map(Object.entries(school));
console.log(m);
//对象属性的藐视对象
console.log(Object.getOwnPropertyDescriptors(school));
```

# 24. ES9扩展运算符与rest参数

Rest参数与spread扩展运算符在ES6中已经引入，不过ES6中只针对于数组，在ES9中为对象提供了向数组一样的rest参数和扩展运算符

对象的rest参数:

```javascript
function connect({host, port, ...user}){
    console.log(host);
    console.log(port);
    console.log(user);
}
connect({
    host: '127.0.0.1',
    port: 3306,
    username: 'root',
    password: 'root',
    type: 'master'
});
```

对象的合并：

```javascript
const skillOne = {
    q: '钟离'
}
const skillTwo = {
    w: '温迪'
}
const skillThree = {
    e: '雷电将军'
}
const skillFour = {
    r: '纳西妲'
}

const gods = {...skillOne, ...skillTwo, ...skillThree, ...skillFour};
console.log(gods);
```

# 25. ES9正则扩展

## 命名捕获分组

没有命名捕获：

```javascript
//声明一个字符串
let str = '<a href="http://www.baidu.com">百度</a>';
//提取url与标签文本
const reg = /<a href="(.*)">(.*)<\/a>/;
//执行
const result = reg.exec(str);
console.log(result[1]);
```

有命名捕获：

```javascript
let str = '<a href="http://www.baidu.com">百度</a>';
const reg = /<a href="(?<url>.*)">(?<text>.*)<\/a>/;
const result = reg.exec(str);
console.log(result.groups.url);
```

## 反向断言

```javascript
let str = '(JS345235你知道吗555啦啦啦)';
//正向断言
// const reg = /\d+(?=啦)/;
// const result = reg.exec(str);

//反向断言
const reg = /(?<=吗)\d+/;
const result = reg.exec(str);
console.log(result);
```

## dotAll模式

```javascript
//dot  .  元字符 除换行符以外的任意单个字符
let str = `
<ul>
    <li>
        <a>肖申克的救赎</a>
        <p>上映日期：1994-09-10</p>
    </li>
    <li>
        <a>阿甘正传</a>
        <p>上映日期：1994-07-06</p>
    </li>
</ul>`;
const reg = /<li>.*?<a>(.*?)<\/a>.*?<p>(.*?)<\/p>/gs;
let result;
while(result = reg.exec(str)){
    console.log(result);
}
// const result = reg.exec(str);
// console.log(result);
```

# ES10

## 对象方法扩展-Object.fromEntries

```javascript
//二维数组
const result = Object.fromEntries([
    ['name','尚硅谷'],
    ['xueke','Java,大数据,前端,云计算']
]);
console.log(result);
//Map
const m = new Map();
m.set('name', 'ATGUIGU');
const result2 = Object.fromEntries(m);
console.log(result);
//Object.entries ES8
const arr = Object.entries({
    name: "尚硅谷"
})
console.log(arr);
```

## 字符串方法扩展-trimStart-trimEnd 清除空白

```javascript
//trim
let str = '   iloveyou   ';
console.log(str);
console.log(str.trimStart());
console.log(str.trimEnd());
```

## 数组方法扩展 flat和flatMap

降维：

```javascript
//flat 平
//将多维数组转化为低维数组
const arr = [1,2,3,4,[5,6]];
const arr3 = [1,2,3,4,[5,6,[7,8,9]]];
//参数为深度 是一个数字
console.log(arr3.flat(2));
```

flatMap:

```javascript
//flatMap
const arr = [1,2,3,4];
const result = arr.flatMap(item => [item * 10]);
console.log(result);
```

## Symbol.prototype.description

```javascript
let s = Symbol('尚硅谷');
console.log(s.description);
```

# ES11

## 私有属性

```javascript
//flatMap
const arr = [1,2,3,4];
const result = arr.flatMap(item => [item * 10]);
console.log(result);
```

## Promose.allSettled

```javascript
//声明两个promise对象
const p1 = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve('商品数据 - 1');
    }, 1000);
});

const p2 = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve('商品数据 - 2');
    }, 1000);
});

//结果永远成功
const result = Promise.allSettled([p1, p2]);
//都成功才会成功
const res = Promise.all([p1, p2]);
console.log(result);
```

## String.prototype.machAll

```javascript
let str = `
<ul>
    <li>
        <a>肖申克的救赎</a>
        <p>上映日期：1994-09-10</p>
    </li>
    <li>
        <a>阿甘正传</a>
        <p>上映日期：1994-07-06</p>
    </li>
</ul>`;

//声明正则
const reg = /<li>.*?<a>(.*?)<\/a>.*?<p>(.*?)<\/p>/sg
//调用方法
const result = str.matchAll(reg);
/* for(let v of result){
    console.log(v);
} */
const arr = [...result];
console.log(arr);
```

## 可选链操作符

```javascript
function main(config){
    // const dbHost = config && config.db && config.db.host;
    const dbHost = config?.db?.host;
    console.log(dbHost);
}

main({
    db: {
        host:'192.168.1.100',
        username:'root'
    },
    cache: {
        host:'192.168.1.200',
        username:'admin'
    }
})
```

## 动态import

```javascript
btn.onclick = function(){
    import('./hello.js').then(
    	module.hello();
    );
}
```

## BigInt 大整形

```javascript
//大整形
let n = 521n;

//函数
let n = 123;
console.log(BigInt(n));
```

## globalThis

```javascript
全局指向window
```

