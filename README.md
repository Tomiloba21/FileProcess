 <h1>FileProcess</h1>

## Table of Contents

- [Requirements](#requirements)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Building and Running](#building-and-running)
    - [Running the Application](#running-the-application)
    - [Using Docker](#using-docker)
- [API Endpoints](#api-endpoints)
- [Testing the API](#testing-the-api)
- [Environment Configuration](#environment-configuration)
- [Troubleshooting](#troubleshooting)
- [License](#license)

## Requirements

- Java 17 (e.g., OpenJDK 17)
- Maven 3.x
- Docker (Optional, if you want to use Docker)
- A text file for testing


## Installation

### Clone the Repository

 ```bash
  git clone https://github.com/Tomiloba21/FileProcess
  cd FileProcess 
   
 ```

Building and Running

Running the Application


After building the project, you can run the application using the following command:


```shell
  mvn clean package
 java -jar target/fileUpload-0.0.1-SNAPSHOT.jar

```

The application will start on http://localhost:8080.

Using Docker
If you prefer to run the application inside a Docker container, follow these steps:

Build the Docker Image:

```shell
docker build -t file-upload-app .

```
Run the Docker Container:
```shell
docker run -p 8080:8080 file-upload-app
```
The application will be accessible at http://localhost:8080.

API Endpoints

POST /process-file

GET /

Upload a text file for processing.

URL: /process-file
Method: POST
Content-Type: multipart/form-data
File Parameter: file
Success Response:
Code: 200 OK
Content: Processed text with the most frequent word surrounded by foo and bar.
Error Responses:
Code: 400 BAD REQUEST
Content: Error message (e.g., "File is empty" or "File is missing").



