# swagger
## 安装
- pom.xml
```xml
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-spring-boot-starter</artifactId>
    <version>3.0.2</version>
</dependency>
```
- webMvcConfig 
    - 引入 `knife4j` 的配置文件
    - 增加文件映射
    - 关闭 login check

## 常用注解
> 添加到各个类上面, 进行更加详细的文档说明
- @api
- @ApiModel
- @ApiModelProperty