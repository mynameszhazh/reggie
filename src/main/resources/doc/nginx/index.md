# nginx

## 下载和安装
- 安装依赖包
    - `yum -y install gcc pcre-devel zlib-devel openssl openssl-devel`
- 下载nginx安装包
    - `wget https://nginx.org/download/nginx-1.16.1.tar.gz` 
- 解压 
    - `tar -zxvf nginx-1.16.1.tar.gz`
- 其它运行步骤
```
cd nginx-1.16.1
./configure --prefix=/usr/local/nginx
make && make install
```

## nginx配置文件结构

- 全局块
  - 运行相关的全局配置 
- events块
  - 和网络相关的配置
- http块(代理 缓存 日志记录  虚拟主机配置)
  - http 全局
  - server块
    - server 全局块
    - location块

## 作用
- 静态资源部署
  - 相比 `tomcat` 处理资源更高效
- 方向代理 (proxy_pass)
- 负载均衡
```conf
// 设置
upstream targetserver {
  server ip1;
  server ip2;
}

// http location 块中使用
proxy_pass http://targetserver
```