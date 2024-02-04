# opentelemetry-order-service-2023

![Diagram](./gif/diagram.gif)

We're using Google Jib to create a Docker Image `order-service:0.0.5-SNAPSHOT` that you see in `docker-compose.yml` file. 

1. To create `order-service:0.0.5-SNAPSHOT` by using `gradlew` with `Java 17`
```shell
./gradlew clean build jibDockerBuild -x test
```

2. Then, to spin up all the `docker-compose.yml`
```
docker compose up -d
```

3. Send sample requests to `Order Service`
```http request
GET http://localhost:8080/orders/1
GET http://localhost:8080/orders/2
GET http://localhost:8080/orders/3
```

4. Access Grafana to observe metrics, traces, logs at
```
http://localhost:3000
```

---

#### Be aware at step 1, the `docker image` is created for ARM architecture (MAC M1) 
#### If you're in linux, please change the following line in `build.gradle` file
```yaml
platforms {
    platform {
        architecture = 'arm64'
        os = 'linux'
    }
}
```
to
```yaml
platforms {
    platform {
        architecture = 'amd64'
        os = 'linux'
    }
}
```
then run
```shell
./gradlew clean build jibDockerBuild -x test
```

---

### OpenTelemetry with Spring Boot 3: 
https://www.youtube.com/playlist?list=PLLMxXO6kMiNg6EcNCx6C6pydmgUlDDcZY