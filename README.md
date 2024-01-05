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



## SCREENSHOTS OF THE API RESULT

#### SIGN UP API
[![Screenshot-1459.png](https://i.postimg.cc/y6TM0gd7/Screenshot-1459.png)](https://postimg.cc/pypcHdzS)

#### LOGIN API
[![Screenshot-1460.png](https://i.postimg.cc/Wz2grf46/Screenshot-1460.png)](https://postimg.cc/Hchr1zXV)

#### CREATING A NEW NOTE
[![Screenshot-1461.png](https://i.postimg.cc/8c9kDjxJ/Screenshot-1461.png)](https://postimg.cc/PvbnQrXT)

#### GETTING LIST OF ALL THE NOTES
[![Screenshot-1462.png](https://i.postimg.cc/GpmpFwPp/Screenshot-1462.png)](https://postimg.cc/qNW0rF5f)

#### GETTING A NOTE BY ID
[![Screenshot-1463.png](https://i.postimg.cc/0Nj86GxM/Screenshot-1463.png)](https://postimg.cc/kVrrzb2q)

#### UPDATING A NOTE
[![Screenshot-1464.png](https://i.postimg.cc/BZTGn7D7/Screenshot-1464.png)](https://postimg.cc/pyLS0ZsK)

#### SEARCHING OF NOTES
[![Screenshot-1465.png](https://i.postimg.cc/y8JQkWt6/Screenshot-1465.png)](https://postimg.cc/3kTCqr3z)

#### SHARING OF A NOTE
[![Screenshot-1466.png](https://i.postimg.cc/bY33gQjN/Screenshot-1466.png)](https://postimg.cc/fkScTSL6)
