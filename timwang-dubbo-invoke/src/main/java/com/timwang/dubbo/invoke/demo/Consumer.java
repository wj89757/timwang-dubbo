package com.timwang.dubbo.invoke.demo;

import com.timwang.dubbo.provider.demo.DemoService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangjun
 * @date 2020-09-03
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/dubbo-demo-consumer.xml");
        applicationContext.start();
        DemoService demoService = (DemoService) applicationContext.getBean("demoService");
        String world = demoService.sayHello("world");
        System.out.println(world);


        ApplicationConfig application = new ApplicationConfig();
        application.setName("api-generic-consumer");

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");

        application.setRegistry(registry);

        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        // 弱类型接口名
        reference.setInterface("com.alibaba.dubbo.samples.generic.api.IUserService");
        // 声明为泛化接口
        reference.setGeneric(true);

        reference.setApplication(application);
        // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();
        String name = (String) genericService.$invoke("delete", new String[]{int.class.getName()}, new Object[]{1});
        System.out.println(name);
    }
}
