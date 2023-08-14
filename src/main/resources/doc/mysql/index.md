# mysql

> 一些mysql 笔记

## 优化操作

### mysql 主从复制

> 需要两台以上服务器进行操作

#### 主库操作

- 更改配置

```cnf
# vim etc/my.cof
log-bin=mysql-bin #启动二进制文件
server-id=100  #服务器唯一ID
```

- 重新`mysql`服务

```sh
systemctl restart mysqld
```

- 创建一个新的 mysql 用户

```mysql
GRANT REPLICATION SLAVE ON *.* to 'xjh'@'%' identified by 'xjh@1234'
```

- 查看主库状态

```mysql
show master status; 
```

#### 从库操作

- 同样的添加服务器id
- 重启服务器
- 执行这段sql代码

```mysql
change master to
    master_host ='0.0.0', 
    master_user ='xjh', 
    master_password ='xjh@1234',
    master_log_file ='mysql-bin.000001', 
    master_log_pos =439;

start slave;
```
- 查看从库状态
```mysql
show slave status;
```

### Sharding-JDBC
> mysql 主从复制解决方案

#### 使用步骤
- 导入maven
- 配置读写分离规则
- 允许bean定义覆盖配置项
- 引入特定的 `DataSource` 操作就哦了