# Job Search Portal

## Frameworks and Languages used:
* `Java 17`
* `Maven 4.0.0`
* `Spring Boot 3.0.5(Framwork)`
* `IntelliJ IDEA 2023.1 (Community Edition)`


## Data Flow:
 1. ### Model: 
    Created Job class along with properties like id, title, description, location, salary, companyName, employerName, jobType, appliedDate and create a constructor, and getters and setters.Using some validation with properties like @Id, @Not Blank, @Pattern etc.
 1. ### Controller: 
    * Created JobController class in which having annotation like @GetMapping,
    @PostMapping,@PutMapping,@DeleteMapping.Created a object of JobService class through dependency injection using @Autowired annotation.

    #### API Reference:
    * Get all Jobs:

      ```http://localhost:8080/jobs/all```

    * Get Job By Id:

      ```http://localhost:8080/job/{id}```  

    * Get Job By Title:

      ```http://localhost:8080/jobs/title/{title}```  

    * Get Job Based On Title Or Description :

      ```http://localhost:8080/jobs/title/{title}```  

    * Add Job:

      ```http://localhost:8080/job/add```

    * Add Jobs:

      ```http://localhost:8080/jobs/add```

    * Delete Job By Title:

      ```http://localhost:8080/jobs/{title}```

    * Update JobType By id:

      ```http://localhost:8080/job/update/{id}/{job type}```




 1. ### Service: 
    * It consist JobService class in which having some buisness logic.
    * @Service annotation is used to make the class as a service layer.

 1. ### Repository:
    * Created JobDao Inteface that extents CrudRepository interface so we can use inbuilt crudRepo method and we create some cusom finder method and writting some query method to perform crud operation like create ,read, update and delete.

## Project Summary
In this spring boot application I had created API's mapping for CRUD operations like create(save), read(find), update and delete Job. Aim of this project to using some validation, using the crudRepository method and createing and using custom finder method and custom query method in this project.Through this project  we can filter jobs and easily finds the jobs thats we want.