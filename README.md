# odateam-task

## Instructions

Build a microservice which exposes a REST API for:
- Return three EU countries with the highest standard VAT rate
- Return three EU countries with the lowest reduced VAT rates

Input: https://euvatrates.com/rates.json

Guidelines: Keep it clean and simple (with some design for future extensions).
Implement as a Maven project using Spring Boot or Quarkus.
Provide source code, a way to run it and some kind documentation for the API.

## Solution

The solution is a Spring Boot application that exposes three endpoints:
- GET ... */api/rates/* ... for retrieving all EU countries from the input JSON file
- GET ... */api/rates/highest* ... for retrieving the three EU countries with the highest standard VAT rate
- GET ... */api/rates/lowest* ... for retrieving the three EU countries with the lowest reduced VAT rate.

In the *RatesService* class, the method *getRates()* is used to retrieve all EU countries from the input JSON file.
Those are stored in a List of Country objects to prevent loading the data from the file every time the endpoints are called.

The method *getHighestRates()* is used to retrieve the three EU countries with the highest standard VAT rate.
First of all we remove the duplicates from the list of countries(GB and UK are the same country so the data is repeated).
From the dataset we can see that the standard VAT rate is always of type double, so we can
use the method *Collections.sort()* to sort the list of countries by the standard VAT rate. Because the
list is sorted in ascending order, we can use the method Collections.reverse() to reverse the order.
Then we can use the method *subList()* to get the first three elements from the list.

The method *getLowestRates()* is used to retrieve the three EU countries with the lowest reduced VAT rate.
Again we remove the duplicates from the list of countries. From the data, we can see that the reduced VAT rate
can be of type double or false, so we need to filter the list. After that we can again sort the list by the reduced VAT rate,
and since it is sorted in ascending order, we can use the method *subList()* to get the first three elements from the list.

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

