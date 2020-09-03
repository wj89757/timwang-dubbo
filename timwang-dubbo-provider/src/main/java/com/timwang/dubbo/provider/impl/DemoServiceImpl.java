package com.timwang.dubbo.provider.impl;

import com.timwang.dubbo.provider.demo.DemoService;

/**
 * @author wangjun
 * @date 2020-09-03
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
