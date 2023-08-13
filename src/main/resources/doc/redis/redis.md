# redis

## 安装

### liunx
> 官网直接上强度
- 注意里面的`gcc` 编译处理
  - `yum install gcc-c++ `
- `make & make install` 操作
    -  有一个操作需要前提执行 meke Marrc=libs 之类的
- 然后就可以执行一些可以执行文件
    - serve 启动服务
    - cli 访问服务
    - redis-conf 配置信息
### mac
> 类似`liunx`上面的处理
- 进入 下载的文件包
    - `sudo make distclean`
    - `make`
    - `make test`
    - `make install`
###  window
> 一般下载的安装包 都能直接运行


## 使用 redis
> java中

### jedis 
> 传统的使用方法 他会通过类的方式去操作 我的 `redis` 服务器

### starter 
> spring-boot-starter-data-redis (pom)