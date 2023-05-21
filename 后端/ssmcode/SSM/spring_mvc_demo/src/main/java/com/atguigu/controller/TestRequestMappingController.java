package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 1.@RequestMapping注解标识的位置
 * @RequestMapping标识一个类：设置映请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求路径的具体信息
 * 2.@RequestMapping注解的value属性
 * 作用：通过请求的请求路径来匹配请求
 * value属性是数组类型，即当前浏览器所发送请求的请求路径匹配value属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 * 在@RequestMapping的基础上，结合请求方式的一些派生注解：
 * @GetMapping,PostMapping,@DeleteMapping,@PutMapping
 * 4.@RequestMapping注解的params属性
 * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求参数必须满足params属性的设置
 * params可以使用四种表达式：
 * “params”:表示当前请求的请求参数中必须携带param参数
 * “!params”表示当前请求的请求参数中一定不能携带param参数
 * “params=value”
 * “params!=value”
 * 6.SpringMVC支持ant风格的路径
 * 在@RequestMapping注解的value属性中设置一些特殊字符
 * ?:任意的单个字符，不包括?本身
 * *:任意个数的任意字符，不包括/和?
 * **:任意层数的目录，注意使用方式只能**写在双斜线中，前后不能有任何其它字符
 * 7.@RequestMapping注解使用路径的占位符
 * 传统：/deleteUser?id=1
 * rest：/user/delete/1
 * 需要在@RequestMapping注解value属性中所设置的路径中，使用{xxx}的方式表示路径中的数据
 * 再通过@PathVariable注解，将占位符所表示的值和控制器方法的形参进行绑定
 */

@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {

    @RequestMapping(
            value = {"/hello", "/abc"},
            method = {RequestMethod.POST,RequestMethod.GET},
            params = {"username"}
    )
    public String hello(){
        return "success";
    }

    @RequestMapping("/**/test/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id,@PathVariable("username") String username){
        System.out.println("username:"+username);
        System.out.println("id:"+id);
        return "success";
    }
}
