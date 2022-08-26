# Broker-Insights


This Project was created for the Broker Insights coding challenge.

The purpose of the project was to create a web interface that would allow the client to display their customers policies over the internet.
To accomplish this 3 items were created.
    A database to hold the policy data. This was created using MySQL.
    A backend to provide access to the database and act as an intermediatary between the frontend and the database. THis was created using Java Spring Boot.
    A web frontend that would act as the interface to access the policies. This was created using a combination of Java Spring Web and HTML.
    
Source code
    The database is contained in the database folder. The v2 folder contains the correct, up to date version of the database.
    The backend was created in the Eclipse IDE using Java 11. It is located in the /source code/Broker-Insights-Backend/ file.
    The frontend was created in the Eclipse IDE using Java 11. It is located in the /source code/Broker-Insights-Frontend/ file.
        The HTML part of the frontend is part of the Java project, and by running the java project will be displayed.
        
Access requirements.
    The database if set up locally will require that the backend be given the correct connection details and password/username.
        This can be done in the /src/main/resources/application.properties file.
            Set spring.datasource.url to the url of the Database. Format: jdbc:mysql://{url}:{port}/{database}
            Set spring.datasource.username to the username of the connection.
            Set spring.datasource.password to the password of the connection.
            
    The Backend can be accessed on the port 8090. If run locally throught eclipse, then use http://localhost:8090/ to access the api.
        This can be changed in the /src/main/resources/application.properties file.
            Set server.port= to the required port number.
            
        Any changes to the backend IP address and port number will have to be mirrored in the frontend in the src/main/java/com.br.in.service/PolicyServiceImpl.java file. Each instance of the restTemplate will require that "http://localhost:8090" be updated for the new location of the backend.
            
    The Frontend can be accessed on the port 8091. If run locally throught eclipse, then use http://localhost:8091/ to access the website.
        This can be changed in the /src/main/resources/application.properties file.
            Set server.port= to the required port number.
            
Incomplete Functionality:
    Error handling: Due to time constraints, try-catch statements and custom exceptions were not implemented.  
    Testing: While manual testing was done, J-unit testing was not yet implemented.  

Known bugs:
    Creating a filter that leads to 0 results, causes filter screen to dissapear.
    

