# To Do List

A small to-do list webapp for studying purposes. In this app I am using:
* Spring boot (MVC + Security)
* JPA
* Thymeleaf

------
## Running the app

It's necessary to create a file named "application.properties" in the src/main/resources/ folder with your database information, as follows:

```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost/todolist?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC
spring.datasource.username= **INSERT USERNAME HERE**
spring.datasource.password= **INSERT PASSWORD HERE**
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
```