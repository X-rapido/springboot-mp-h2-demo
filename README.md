# Spring Boot 2.x 整合 Mybatis-plus 实现 H2 数据库 CRUD（完整示例）


## 使用

| 分支 | 说明 |
|---|---|
| code-generator | 代码生成 |
| quickstart-h2 | H2基础CURD |
| quickstart-tableLogic | H2基础CURD，逻辑删除 |
| quickstart-tableLogic-p6spy | H2基础CURD，逻辑删除，SQL性能分析 |
| quickstart-tableLogic-p6spy-enum | H2基础CURD，逻辑删除，SQL性能分析，枚举配置 |
| quickstart-tableLogic-p6spy-enum-version | H2基础CURD，逻辑删除，SQL性能分析，枚举配置，乐观锁配置 |


### 快速上手

教程：https://mp.baomidou.com/guide/optimistic-locker-plugin.html

#### （1）依赖包
```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.3.0</version>
</dependency>

<!--开发环境使用，线上不推荐-->
<dependency>
    <groupId>p6spy</groupId>
    <artifactId>p6spy</artifactId>
    <version>3.8.7</version>
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
    driver-class-name: com.p6spy.engine.spy.P6SpyDriver
    schema: classpath:db/schema-h2.sql
    data: classpath:db/data-h2.sql
    url: jdbc:p6spy:h2:mem:test
    username: root
    password: test
```
