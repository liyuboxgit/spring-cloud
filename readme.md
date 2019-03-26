spring cloud

ribbon是客户端的负载均衡器，他去注册中心查询服务列表，以轮询或者随机的方式去调用服务。
feign是在ribbon的基础，实现声明式的服务调用，或者称接口形式的服务调用。
hystrix是断路器，失败返回默认的一种实现。
zuul是个前置，或者叫代理。
trace是日志跟踪。
config是配置服务器。