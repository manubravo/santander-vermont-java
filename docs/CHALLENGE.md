# Java Spring Boot Senior Challenge

## Exercise 1

1. Create a Spring Boot project (version and project name don't matter) from scratch using Java 8 or higher.
2. Add an in-memory database to the project (the specific database and schema names don't matter) containing a table named "Users" with 3 columns: Fullname, Phone, and Address.
3. Initialize the "Users" table with the following data:

   | Fullname            | Phone      | Address                    |
   | ------------------- | ---------- | --------------------------- |
   | Thomson, Elias      | 555-8596   | Diamond St. 4G3 NY         |
   | Simond, Ella         | 415-9687   | Fleet st. 45 B, 56 BR-NY   |
   | Clifford, Thomas    | 416-69883  | Meet town, 45 - FL         |

4. The project should include an endpoint (in a controller) with the path "/api/users," using the GET method and no input parameters. This endpoint should return a file containing the data from the "Users" table. The format of the file is not relevant; the important thing is that it contains all the data from the "Users" table.

## Exercise 2

In the project created in Exercise 1, create an endpoint (it can be in the same controller as the previous exercise or a different one) with the path "/api/copy" and the POST method. This endpoint should receive a file (format doesn't matter) as input and copy it locally with the following conditions:

- The file copy should be placed in the local directory of the project using relative paths.
- The file copy should be performed asynchronously using separate threads for reading and writing. There should be one thread for reading and another for writing.
- When a request is received at the "/api/copy" endpoint, it should immediately return a 200 response, and the file copy will be carried out in the background without blocking the response.

**NOTE:**
- The implementation of the exercises will be evaluated in terms of efficiency and resource usage.
- Usage of Streams and Lambda expressions (fluid programming) will be evaluated.
- Usage of design patterns will be evaluated.
- Usage of Java Persistence API (JPA) will be evaluated.
