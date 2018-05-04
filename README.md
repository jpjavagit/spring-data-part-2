# Spring Data (Useful methods)

The proposal of this project is to show some useful methods and the capabilities to build methods with no SQL line or JPA implementations like
HQL, Criteria and etc.

This project was based in the Spring documentation.

### Configurations

 1º Step: Clone the project via Git 
 
 ```sh
$ git clone https://github.com/jpjavagit/spring-data-part-2.git
```
 
 2º Step: You must install the project dependencies, you should access the project folder and execute the code below

```sh
$ mvn install
```

 3º Step: Running the project
```sh
$ mvn spring-boot:run
```

 4º Step: Open your browser and run the URL below

<http://localhost:8080/>

### users.json

There's a json file called users.json that you can use to persist using the endpoint /saveUsers

### H2 Database

The datas are persisted at H2 database.

Remember that H2 is a memory database and to running queries in the terminal the application must being running.

### To access 

<http://localhost:8080/h2>

