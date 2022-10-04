## springboot-rest-api-app

### A simple Spring Boot Rest Api app.

#### Requirements
For building and running the application you need:

* JDK 17
* Maven 3
* Couchbase

#### Build

```shell script
mvn package
```

#### Running the application locally
You can execute the main method in the com.spring.couchbase.SpringBootCouchbaseNonReactiveApplication class from your IDE, or you can use the Spring Boot Maven plugin like so:

```shell script
mvn spring-boot:run
```
#### Couchbase
couchbase is running on docker

* Install Docker
* Pull Couchbase:

```shell script
docker pull couchbase
```
* Run:

```shell script
docker run -d --name db -p 8091-8097:8091-8097 -p 11210:11210 -p 11207:11207 -p 18091-18095:18091-18095 -p 18096:18096 -p 18097:18097 couchbase
```

Couchbase is running on port 8091:
`http://localhost:8091`
* Install Couchbase Server ([docs](https://docs.couchbase.com/server/current/getting-started/do-a-quick-install.html#initialize-cluster-web-console))
* Add a bucket on your Couchbase server that Spring Boot will connect to and add the changes in your application.porperties file.
* Create an Index on travel-sample bucket:
  `CREATE PRIMARY INDEX 'name' ON 'bucket'`
* Set a configuration file called application.properties with :

```yaml
spring.couchbase.connection-string=couchbase://127.0.0.1
spring.couchbase.user.name=<USER_NAME>
spring.couchbase.password=<USER_PASSWORD>
spring.couchbase.bucket.name=travel-sample
```

#### Swagger
* `http://localhost:8081/swagger-ui.html`
* `http://localhost:8081/v2/api-docs`