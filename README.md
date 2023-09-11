# Italia Indexer (italian-cities-elasticserach)

Italia Indexer is a versatile tool that allows users to search for cities based on their "Denominazione in italiano". The application comes in two flavors: a Spring Boot web service and a CLI (Command-Line Interface) version.

It was specifically designed to demonstrate how to integrate Elasticsearch, from loading JSON data to conducting searches.
## Features:

### 1. **Spring Boot Version**:
- RESTful API that provides city search functionality.
- Endpoints for querying cities based on names.

### 2. **CLI Version**:
- Search for cities directly from the command line.
- Efficient Elasticsearch client for faster lookups.

## Prerequisites:

- Java 8 or later
- Maven (for building the project)
- Docker and Docker Compose (for running Elasticsearch and Kibana)

## Setting up:

### 1. **Clone the repository**:

   ```
   git clone https://github.com/Demigod21/italian-cities-elasticsearch.git
   ```

### 2. **Navigate to the project directory**:
   ```
cd italian-cities-elasticserach
   ```

### 3. Using Docker to start Elasticsearch and Kibana:
a. Navigate to the resources directory:

```
cd src/main/resources
   ```

b. Run the Docker Compose file:

   ```
docker-compose up
   ```

This will start Elasticsearch and Kibana. You can access Kibana at http://localhost:5601.

### 4. Build the project:

```
mvn clean install
```
## How to use:
### 1. Spring Boot Version:
**a. Start the application**:

```
java -jar target/italian-cities-elasticserach-0.0.1-SNAPSHOT.jar
```
#### b. Open your browser or a tool like Postman and navigate to:

```
http://localhost:8080/api/cities/search?name=[CITY_NAME]
```
Replace [CITY_NAME] with the name or partial name of the city.

### 2. CLI Version:
```
java -cp target/italian-cities-elasticserach-0.0.1-SNAPSHOT.jar cliversion.CliApplication [KEYWORD]
```
Replace [KEYWORD] with the name or partial name of the city you're searching for.

### Contribution:
If you'd like to contribute, please fork the repository and make changes as you'd like. Pull requests are warmly welcome.

### License:
See LICENSE for more information.

### Contact:
Davide Falcone - davide@davidefalcone.com

Project Link: https://github.com/Demigod21/italian-cities-elasticsearch