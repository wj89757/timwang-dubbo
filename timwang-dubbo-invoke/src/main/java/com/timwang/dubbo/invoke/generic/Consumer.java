package com.timwang.dubbo.invoke.generic;

/**
 * 以下几种场景可以考虑使用泛化调用：
 *
 * - 服务测试平台
 * - API 服务网关
 *
 * 泛化调用主要用于消费端没有 API 接口的情况；不需要引入接口 jar 包，
 * 而是直接通过 GenericService 接口来发起服务调用，参数及返回值中的所有 POJO 均用 Map 表示。
 * 泛化调用对于服务端无需关注，按正常服务进行暴露即可。
 *
 * 下面来看看消费端如何使用泛化调用进行服务调用。
 * @author wangjun
 * @date 2020-09-03
 */
public class Consumer {
}
