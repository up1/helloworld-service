# helloworld-service

### Tasks
* Create project with Spring Boot
* Database woth PostgreSQL
  * Create database
  * Create table
  * Initial data
* Deploy project with Docker compose

### Step to run ?
```
$mvnw clean package -DskipTests
$cd docker
$docker-compose up -d

$docker-compose ps
      Name                     Command               State           Ports
-----------------------------------------------------------------------------------
docker_hello_1      /bin/sh -c java -Xmx400m - ...   Up      0.0.0.0:8080->8080/tcp
docker_postgres_1   docker-entrypoint.sh postgres    Up      5432/tcp
```
Open url = http://localhost:8080/hi in browser

