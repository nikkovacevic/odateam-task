# odateam-task

The solution is a Spring Boot application that exposes a single endpoint:
- GET ... */api/rates/* ... for retrieving all the required data

The endpoint takes a request parameter query, which can have values ALL, HIGHEST and LOWEST. Based
on the value of the query parameter, the endpoint returns all the data, the three countries with 
the highest standard VAT rate or the three countries with the lowest reduced VAT rate. This was implemented 
using the Strategy pattern to follow the Open/Closed principle.


## Usage   

### Prerequisites

- Docker
- Maven

### Installation

1. Clone the repository with HTTPS `git clone https://github.com/nikkovacevic/odateam-task.git`
or SSH `git clone git@github.com:nikkovacevic/odateam-task.git` or download the zip file and extract it.
<br/><br/>
2. Build the project using the command `mvn clean install` in the root directory of the project.
<br/><br/>
3. Run `docker build -t odateam-task .` in the root directory of the project.
<br/><br/>
4. Run `docker run -p 8080:8080 odateam-task` to start the service.

Or open the project in your IDE and run the class *OdateamTaskApplication*.

When the service is running, you can access the API
documentation at http://localhost:8080/swagger-ui.html and
at http://localhost:8080/v3/api-docs

### Stoping the service

1. To stop the service, run `docker ps` to get the container ID.
<br/><br/>
2. Run `docker stop <container ID>` to stop the service.

