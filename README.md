# lets-learn-together

Repository for Let's Learn Together Work

### Structure

Melbourne City Library

- abstractions
  - Rentable.java
- domainObjects
  - Book.java
  - Transaction.java
  - User.java
  - DVD.java
- services
  - LibraryService.java
  - ResourcesService.java
- tests
  - LibraryServiceTest.java
  - ResourcesServiceTest.java
- userInterface
  - Operations.java
  - UserOperations.java
  - ResourceOperations.java
  - DisplayUtility.java
- utilities
  - Utility.java
- Application.java

## To be done:

- Read books from Datasource(file)
- Read Users from Datasource(file)
- Handle exceptions


Under the userInterface, have a separate folder for user response to define the structure.
use a separate object at service and interface levels


The services need their own interfaces. 

Multiple copies of a single Resource

id - auto generated - uuid