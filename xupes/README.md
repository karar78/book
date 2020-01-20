# Proof of Concept for accessing Penguin / Random House REST API

## Introduction
The purpose of this project is to provide a proof of concept for retrieving data from Penguin / Random House REST API.
The REST API is available at http://www.penguinrandomhouse.biz/webservices/rest/.
For testing purpose, the Random House books are listed in the Amazon book store: https://www.amazon.co.uk/Books-Random-House/s?page=1&rh=n%3A266239%2Cp_27%3ARandom%20House.

## The penguinrandomhouse-client Application
The application is provided as a SpringBoot service which can be used by other SpringBoot applications.
JUnit tests are provided in order to run and test the service.

### Running tests
For building the application and running the JUnit tests, type the following command in the console:
``` bash
mvn clean install test
```
Apache Maven should be available as command line tool. If not available yet, please proceed to the following page to install Apache Maven: https://maven.apache.org/install.html
