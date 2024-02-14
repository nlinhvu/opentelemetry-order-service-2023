# opentelemetry-order-service-2023

---

### New feature added for video 12
* Add `POST http://localhost:8080/orders` to send a `OrderPlacedEvent` to Kafka
```yaml
  kafka:
    bootstrap-servers: kafka:9092
    producer:
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
```

---
### To build `order-service:0.0.6-SNAPSHOT` docker image:
* #### If you're in linux, please change the following line in `build.gradle` file
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

* #### Then, to create `order-service:0.0.6-SNAPSHOT` by using `gradlew` with `Java 17`
```shell
./gradlew clean build jibDockerBuild -x test
```
---

### OpenTelemetry with Spring Boot 3: 
https://www.youtube.com/playlist?list=PLLMxXO6kMiNg6EcNCx6C6pydmgUlDDcZY