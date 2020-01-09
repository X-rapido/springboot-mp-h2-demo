# Spring Boot 2.x 整合 Mybatis-plus 实现 H2 数据库 CRUD

| 分支 | 说明 |
|---|---|
| code-generator | 代码生成 |
| quickstart-tableLogic | H2基础CURD，逻辑删除 |
| quickstart-tableLogic-p6spy | H2基础CURD，逻辑删除，SQL性能分析 |
| quickstart-tableLogic-p6spy-enum | H2基础CURD，逻辑删除，SQL性能分析，枚举配置 |
| quickstart-tableLogic-p6spy-enum-version | H2基础CURD，逻辑删除，SQL性能分析，枚举配置，乐观锁配置 |

## 使用
### 1、代码生成

教程：https://mp.baomidou.com/guide/generator.html

#### （1）依赖包
```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.3.0</version>
</dependency>
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-engine-core</artifactId>
    <version>2.1</version>
</dependency>
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.29</version>
</dependency>
<dependency>
    <groupId>com.ibeetl</groupId>
    <artifactId>beetl</artifactId>
    <version>3.0.16.RELEASE</version>
</dependency>
```




