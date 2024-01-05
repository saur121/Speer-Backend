##               STEPS TO SETUP AND RUN THE PROJECT

#### STEP - 1 
     Clone the Project From my Github Repository using the following command.
      git clone https://github.com/saur121/Speer-Backend

#### STEP - 2
     Open the Project in Spring Tool Suite - 4.

#### STEP - 3
    In MySQL create your database

#### STEP - 4
     Open the "application.properties" file and do the following setup

     spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     spring.datasource.username= your_db_user_name
     spring.datasource.password=your_db_password
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql = true


     security.jwt.secretKey =  //your secret key
     security.jwt.tokenDuration =  1D 

#### STEP - 5
     Run the application and test the API’s.



## SCREENSHOTS OF THE TESTED API

#### SIGN UP API
    [![Screenshot-1459.png](https://i.postimg.cc/y6TM0gd7/Screenshot-1459.png)](https://postimg.cc/pypcHdzS)
