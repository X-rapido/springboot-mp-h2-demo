# Spring Boot 2.x 整合 Mybatis-plus 实现 H2 数据库 CRUD

| 分支 | 说明 |
|---|---|
| code-generator | 代码生成 |
| quickstart-h2 | H2基础CURD |
| quickstart-tableLogic | H2基础CURD，逻辑删除 |
| quickstart-tableLogic-p6spy | H2基础CURD，逻辑删除，SQL性能分析 |
| quickstart-tableLogic-p6spy-enum | H2基础CURD，逻辑删除，SQL性能分析，枚举配置 |
| quickstart-tableLogic-p6spy-enum-version | H2基础CURD，逻辑删除，SQL性能分析，枚举配置，乐观锁配置 |

## 使用
### 1、代码生成

教程：https://mp.baomidou.com/guide/logic-delete.html

### 2、快速上手
#### （1）依赖包
```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.3.0</version>
</dependency>

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

#### （2）配置
```yaml
# DataSource Config
spring:
  datasource:
    driver-class-name: org.h2.Driver
    schema: classpath:db/schema-h2.sql
    data: classpath:db/data-h2.sql
    url: jdbc:h2:mem:test
    username: root
    password: test
```


### 注解说明
@TableLogic
- 描述：表字段逻辑处理注解（逻辑删除）

| 属性	| 类型	| 必须指定	| 默认值	| 描述 | 
|---|---|---|---|---|
| value	|  String	| 否	| ""	| 逻辑未删除值 | 
| delval | 	String	| 否	| ""	| 逻辑删除值 |


```java
@TableLogic
private Integer deleted;


@TableLogic(delval = "null", value = "1")
private Integer deleted;


@TableLogic(delval = "now()", value = "null")
private LocalDateTime delTime;
```