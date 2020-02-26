## Dolphin社区
  
  
  
## 资料
[Spring 文档](https://spring.io/guides/)  
[Spring Web](https://spring.io/guides/gs/serving-web-content/)  
[bootstrap 文档](https://v3.bootcss.com/getting-started/)  
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)  
[Spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)  
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)  
[Spring Web文档](https://docs.spring.io/spring/docs/5.0.3.RELEASE/spring-framework-reference/web.html)  


## 工具
[Visual Paradigm](https://www.visual-paradigm.com/cn/download/community.jsp?platform=macosx&arch=jre)  
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)  


## 脚本
```sql
CREATE TABLE USER
(
    ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN VARCHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
);
```
```bash
mvn flyway:migrate  
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate  
```