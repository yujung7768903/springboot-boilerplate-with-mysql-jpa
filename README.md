# springboot-boilerplate-with-mysql-jpa
⭐️ Spring Boot boilerplate for initial setting with MySQL and Spring Data JPA

* Build Tool: Gradle    
* Language: Java 11   
* Database: MySQL


## Dependencies

- Spring Data JPA
- Thymeleaf
- Lombok
- MySQL Driver
- Spring Web
- Validation

## Usage
### Create project
```shell
mkdir new-project
cd new-project
git clone https://github.com/yujung7768903/springboot-boilerplate-with-mysql-jpa.git
```

### Datasource configuration
You should configure Datasource in `application.properties` file to connect the database.   
    
e.g. You can connect local database.
```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/mydb?&serverTimezone=UTC&autoReconnect=true
spring.datasource.username=user
spring.datasource.password=password

spring.jpa.database=mysql
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
```
If you want to connect to the Amazon RDS database, use `RDS endpoint` in the `hostname` instead of localhost.