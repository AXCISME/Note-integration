# 1. 请求的基本操作

```javascript
//获取button远胜于
const btn = document.getElementsByTagName('button')[0];
const result = document.getElementById("result");
btn.onclick = function(){
    //1. 创建对象
    const xhr = new XMLHttpRequest();
    //2. 初始化，设置请求方法和url
    xhr.open('GET', 'http://localhost:8888/server');
    //3. 发送
    xhr.send();
    //4. 事件绑定 处理服务端返回的结果
    //readystate 是 xhr 对象的属性，表示状态0 1 2 3 4
    xhr.onreadystatechange = function(){
        //判断
        if(xhr.readyState === 4){
            if(xhr.status >= 200 && xhr.status < 300){
                //处理结果 行 头 空行 体
                //1. 响应行
                // console.log(xhr.status);	//状态码
                // console.log(xhr.statusText);	//状字符串
                // console.log(xhr.getAllResponseHeaders());	//所有的响应头
                // console.log(xhr.response);	//响应体

                //设置result文本
                result.innerHTML = xhr.response;
            }else{

            }
        }
    }
}
```

## POST设置请求体请求头

```javascript
//获取元素对象
const result = document.getElementById("result");
//绑定事件
result.addEventListener("mouseover", function(){
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8888/server');
    //设置请求头
    xhr.setRequestHeader('Content-Type','application/x-www.form-urlencoded');
    xhr.setRequestHeader('name','atguigu');
    //设置请求体
    xhr.send('jkhkjhkjhkhkjhkj');
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status >= 200 && xhr.status < 300){
                result.innerHTML = xhr.response;
            }
        }
    }
});
```

# 2. 处理JSON数据

```javascript
const result = document.getElementById('result');
//绑定键盘按下事件
window.onkeydown = function(){
    //发送请求
    const xhr = new XMLHttpRequest();
    //设置响应体数据类型(自动转换)
    xhr.responseType = 'json';
    xhr.open('GET','http://localhost:8888/json-server');
    xhr.send();
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status >= 200 && xhr.status < 300){
                // console.log(xhr.response);
                // result.innerHTML = xhr.response;
                //手动对数据转化
                // let data = JSON.parse(xhr.response);
                // result.innerHTML = data.name;
                //自动转换
                result.innerHTML = xhr.response.name;
            }
        }

    }
}
```

# 3. IE缓存问题

```javascript
const btn = document.getElementsByTagName('button')[0];
const result = document.querySelector('#result');
btn.addEventListener('click', function(){
    console.log("点击了");
    const xhr = new XMLHttpRequest();
    //加时间戳
    xhr.open("GET",'http://localhost:8888/ie?t='+Date.now());
    xhr.send();
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status >= 200 && xhr.status < 300){
                console.log(xhr.response);
                result.innerHTML = xhr.response;
            }
        }
    }
})
```

# 4. 超时与网络异常

```javascript
const btn = document.getElementsByTagName('button')[0];
const result = document.querySelector('#result');
btn.addEventListener('click', function(){
    const xhr = new XMLHttpRequest();
    xhr.timeout = 2000;
    xhr.ontimeout = function(){
        alert("网络异常，请稍后重试！！");
    }
    xhr.onerror = function(){
        alert("你的网络似乎除了一些问题");
    }
    xhr.open("GET",'http://localhost:8888/delay');
    xhr.send();
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status >= 200 && xhr.status < 300){
                console.log(xhr.response);
                result.innerHTML = xhr.response;
            }
        }
    }
})
```

# 5. 取消请求

```javascript
//获取元素对象
const btns = document.querySelectorAll('button');
let x = null;
btns[0].onclick = function(){
    x = new XMLHttpRequest();
    x.open('GET', 'http://localhost:8888/delay');
    x.send();
}

//abort
btns[1].onclick = function(){
    x.abort();
}
```

# 6. 重复请求问题

```javascript
//获取元素对象
const btns = document.querySelectorAll('button');
let x = null;
//标识变量
let isSending = false;	//是否正在发送AJAX请求
btns[0].onclick = function(){
    if(isSending) x.abort();
    x = new XMLHttpRequest();
    isSending = true;
    x.open('GET', 'http://localhost:8888/delay');
    x.send();
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            isSending = false;
        }
    }
}
```

# 7. Axios发送AJAX请求

```javascript
const btns = document.querySelectorAll('button');
//配置baseURL
axios.defaults.baseURL = 'http://localhost:8888';
btns[0].onclick = function(){
    //GET
    axios.get('/json-server', {
        params:{
            id:100,
            vip:7
        },
        headers:{
            name:'atguigu',
            age:20
        }
    }).then(value => {
        console.log(value);
    });
}

btns[1].onclick = function(){
    axios.post('/json-server', {
        username:'admin',
        password:'admin'
    },{
        //url
        params:{
            id:200,
            vip:9
        },
        //请求头参数
        headers:{
            height:180,
            weight:180
        },
    })
}
```

通用方式：

```javascript
btns[2].onclick = function(){
    axios({
        //请求方法
        method:'POST',
        //url
        url: 'json-server',
        //url参数
        params:{
            vip:10,
            level:30
        },
        //头信息
        headers:{
            a:100,
            b:200
        },
        //请求体
        data:{
            username:'admin',
            password:'admin'
        }
    }).then(response => {
        console.log(response);
        //响应状态码
        console.log(response.status);
        //响应字符串
        console.log(response.statusText);
        //响应头信息
        console.log(response.headers);
        //响应体
        console.log(response.data);
    })
}
```

# 8. fetch发送AJAX请求

```javascript
const btn = document.querySelector('button');
btn.onclick = function(){
    fetch('http://localhost:8888/json-server', {
        method: 'POST',
        headers:{
            name:'atguigu'
        },
        body:'username=admin&password=admin'
    }).then(response => {
        return response.json();
    }).then(resonse => {
        console.log(resonse);
    })
}
```

# 9. JSONP

原生jspon实践：

```javascript
//获取input元素
const input = document.querySelector('input');
const p = document.querySelector('p');

//声明handle函数
function handle(data){
    input.style.border = "solid 1px #f00";
    //修改p标签的提示文本
    p.innerHTML = data.msg;
}
//绑定事件
input.onblur = function(){
    //获取用户的输入值
    let username = this.value;
    //向服务端发送请求，检测用户名是否存在
    //1. 创建script标签
    const script = document.createElement('script');
    //2. 设置src属性
    script.src = 'http://localhost:8888/check-username';
    //3. 将script插入文档中
    document.body.appendChild(script);
```

```java
//检测用户名是否存在
@ResponseBody
@RequestMapping("/check-username")
public String test5() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    Data1 data1 = new Data1();
    data1.setExist(1);
    data1.setMsg("用户名已经存在");
    //把对象转换为JSON格式字符串
    String str = objectMapper.writeValueAsString(data1);
    log.info(str);
    return "handle(" + str + ")";
}
```

