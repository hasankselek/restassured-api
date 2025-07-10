# REST Assured API Testing Project

This project demonstrates automated API testing using REST Assured framework for testing TMDB APIs. The project is built with Java and uses TestNG for test execution.

## Project Structure

```
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   │   └── BaseTest.java
│   │   │   ├── payloads
│   │   │   │   ├── addFavorite.json
│   │   │   │   ├── addToWatchlist.json
│   │   │   │   └── rating.json
│   │   │   └── utils
│   │   │       ├── API_Methods.java
│   │   │       ├── ConfigurationReader.java
│   │   │       ├── ReusableMethods.java
│   │   │       └── TestListener.java
│   │   └── resources
│   │       └── logback.xml
│   └── test
│       ├── java
│       │   └── tests
│       │       ├── Account.java
│       │       ├── Genres.java
│       │       ├── Movie.java
│       │       ├── MovieList.java
│       │       └── Search.java
│       └── resources
│           └── config
│               └── configuration.properties
```

## Features

The project includes API tests for various endpoints:

- Account-related operations
- Movie-related operations
- Genre-related operations
- Search functionality
- Movie list operations

## Technologies Used

- Java
- REST Assured
- TestNG
- Logback (for logging)
- Maven (for dependency management)

## Prerequisites

- Java JDK 8 or higher
- Maven
- IDE (IntelliJ IDEA recommended)

## Project Setup

1. Clone the repository
2. Open the project in your IDE
3. Install Maven dependencies:
```bash
mvn clean install
```

## Running Tests

You can run the tests using the following methods:

1. Using Maven:
```bash
mvn test
```

2. Using TestNG XML:
Run the `allApiTests.xml` file in your IDE

## Test Structure

- `BaseTest.java`: Contains common test setup and configurations
- `API_Methods.java`: Contains reusable API methods for making requests and assertions
- `ConfigurationReader.java`: Handles configuration properties
- `ReusableMethods.java`: Contains utility methods
- `TestListener.java`: Implements test execution listeners

## Configuration

The project uses a configuration.properties file located in `src/test/resources/config/` for managing test configurations.

## Test Files

- `Account.java`: Tests for account-related endpoints
- `Genres.java`: Tests for genre-related endpoints
- `Movie.java`: Tests for movie-related endpoints
- `MovieList.java`: Tests for movie list operations
- `Search.java`: Tests for search functionality

## Payload Files

The project includes JSON payload files for various operations:
- `addFavorite.json`
- `addToWatchlist.json`
- `rating.json`

## Logging

The project uses Logback for logging, configured via `logback.xml` in the resources directory.

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

## License

This project is licensed under the MIT License.
