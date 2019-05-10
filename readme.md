spring cloud

ribbon是客户端的负载均衡器，他去注册中心查询服务列表，以轮询或者随机的方式去调用服务。
feign是在ribbon的基础，实现声明式的服务调用，或者称接口形式的服务调用。
hystrix是断路器，失败返回默认的一种实现。
zuul是个前置，或者叫代理。
trace是日志跟踪。
config是配置服务器。

https://github.com/babylikebird/Micro-Service-Skeleton.git
https://github.com/babylikebird/Micro-Service-Skeleton/tree/v2.0
先 git clone 整个仓库，然后 git checkout tag_name 就可以取得 tag 对应的代码了。
但是这时候 git 可能会提示你当前处于一个“detached HEAD" 状态，因为 tag 相当于是一个快照，是不能更改它的代码的，如果要在 tag 代码的基础上做修改，你需要一个分支：
git checkout -b branch_name tag_name
这样会从 tag 创建一个分支，然后就和普通的 git 操作一样了。


http://localhost:9030/uaa/oauth/token?username=webApp&password=123456&grant_type=client_credentials
http://localhost:9030/uaa/oauth/token?grant_type=password&username=admin&password=123456

http://localhost:9030/uaa/user?access_token=md
