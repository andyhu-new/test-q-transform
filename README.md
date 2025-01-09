# Web Crawler Application

A Spring Boot application that crawls web pages and returns page metadata based on provided URLs.

## Prerequisites

- Java 8 (JDK 1.8)
- Maven 3.8+ (3.13.0 recommended)

### Installation

#### Linux
```bash
sudo apt-get install maven
```

#### Mac
```bash
brew install maven
```

## Running the Application

1. Clone the repository:
```bash
gh repo clone andyhu-new/test-q-transform
cd test-q-transform
```

2. Build the project:
```bash
mvn clean package
```

3. Run the application:
```bash
mvn spring-boot:run
```

The application will start on port 8080.

## Usage

To crawl a webpage, send a GET request to:
```
http://localhost:8080/crawl?url=YOUR_URL
```

Replace `YOUR_URL` with the webpage URL you want to crawl.

Example using curl:
```bash
curl "http://localhost:8080/crawl?url=https://example.com"
```

The response will include:
- Page title
- Meta description (if available)
- URL

## Testing

Run the tests using:
```bash
mvn test
```

## AWS Amazon Q Requirements
This project meets all AWS Amazon Q code transformation prerequisites:
- Built with Maven 3.8+ (using maven-compiler-plugin 3.13.0)
- Uses Java 8
- Builds in under 55 minutes (typical build time: ~8 seconds)
- No private network resources required
- No non-Java language plugins
- Proper JDK configuration
