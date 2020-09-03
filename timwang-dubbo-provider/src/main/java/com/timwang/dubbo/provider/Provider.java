package com.timwang.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangjun
 * @date 2020-09-03
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
"META-INF/spring/provider.xml"
        );
        applicationContext.start();
        int read = System.in.read();

    }
}
