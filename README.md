# Zhang社区

## 资料
[Spring文档](https://spring.io/guides)
[Spring Web](https://spring.io/guides/gs/serving-web-content/)
[BootStrap文档](https://v3.bootcss.com/getting-started/)
[Github Oauth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
[Spring](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/html/spring-boot-features.html#boot-features-sql)
[Spring MVC](https://docs.spring.io/spring/docs/5.2.4.RELEASE/spring-framework-reference/web.html#spring-web)
## 工具
[Git](http://git-scm.com/download)
[Visual Paradigm](http://www.visual-paradigm.com)
[Flyway](https://flywaydb.org/)
[Lombok](https://projectlombok.org/)

##脚本
```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `token` char(100) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `new_column` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8
```
```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite = true mybatis-generator：generate
```