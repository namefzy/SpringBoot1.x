package com.example.demo.mybatis.controller;

import com.example.demo.mybatis.MybatisUser;
import com.example.demo.mybatis.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/mybatis")
public class MybatisController {

    /**
     * Resource与Autowired
     * Resource并不是spring的注解，单spring支持
     *      Autowired:默认按照类型装配，默认要求依赖对象必须存在，如果允许null值，可以设置它的required属性为false
     *   如果我们想使用按照名称（byName）来装配，可以结合@Qualifier注解一起使用
     *      Resource默认按照ByName自动注入，Spring将@Resource注解的name属性解析为bean的名字;而type属性则解析为bean的类型
 *      @Resource 默认按名称进行装配，通过name属性进行指定
     *      @Resource装配顺序：
     *          ①如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常。
     *          ②如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常。
     *          ③如果指定了type，则从上下文中找到类似匹配的唯一bean进行装配，找不到或是找到多个，都会抛出异常。
     *          ④如果既没有指定name，又没有指定type，则自动按照byName方式进行装配；如果没有匹配，则回退为一个原始类型进行匹配，如果匹配则自动装配。??????
     *          @Resource的作用相当于@Autowired，只不过@Autowired按照byType自动注入。
     */
//    @Autowired
//    @Qualifier
    @Resource
    UserMapper userMapper;

    /**
     * @RequestParam=request.getParam()
     * 1、默认名称，传入参数必须与变量一致
     * 2、别名@RequestParam(value="name1")
     *注意：
     *如果要@RequestParam为一个int型的数据传值，假如前端并未输入，那么将会为int型的数据赋值为null。显然，这是不允许的，直接报错。
     * 可以通过required=false或者true来要求@RequestParam配置的前端参数是否一定要传
     * @param age
     * @param name
     */
    @RequestMapping("/findByName")
    public void findByName(@RequestParam int age,@RequestParam String name){
        MybatisUser user = userMapper.findByName(name);
        System.out.println(user.getAge());
    }
    @RequestMapping("/result")
    public void select(){
        List<MybatisUser> all = userMapper.findAll();
        System.out.println(all);

    }
}
