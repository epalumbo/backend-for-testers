# Backend for testers

### Prerequisites
- JDK 11 installed and configured in the system.
- Optional: Docker.

### Build and run the service locally
Build the application first, then run the executable JAR file.

e.g.
```shell
./mvnw clean install
java -jar target/backend-for-testers.jar
```

You can also load the Maven project in your IDE of choice and build/start the service from there.

### Build and run as Docker container
Build the Docker image using the provided multi-stage Dockerfile.

e.g.
```shell
docker build -t backend-for-testers . 
```

Then you can run the container from the previously built image.

e.g. 
```shell
docker run -p 8081:8081 backend-for-testers 
```
