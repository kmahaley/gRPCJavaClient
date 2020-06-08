# Book
REST api for spring boot application. REST API internally calls gRPC Java client.

### Swagger
http://localhost:8080/swagger-ui.html#/book-controller

###Design
Controller -> BookService(with gRPC client) -> CRUD operations

###gRPC
gRPC server is running on port specified in configuration.
```
grpc:
  serverAddress: localhost
  serverPort: 50000
```