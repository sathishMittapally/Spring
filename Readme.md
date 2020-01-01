# Restful CRUD API for a simple User-CRUD application using Spring Boot, Mysql, JPA and Hibernate and swagger 2.

Create Restful CRUD API for a simple User-CRUD application using Spring Boot, Mysql, JPA and Hibernate and swagger 2.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/santoshhiremani/spring-boot-rest-user-crud-tutorial-1.git
```

**2. Create Mysql database**
```bash
create database spring_crud_app
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/spring-boot-rest-user-crud-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/users
    
    POST /api/users
    
    GET /api/users/{userId}
    
    PUT /api/users/{userId}
    
    DELETE /api/users/{userId}
    
Swagger2 UI will run at <http://localhost:8080/swagger-ui.html>.

You can test them using swagger-ui or any other rest client.

