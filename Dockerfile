FROM openjdk:8u222-jre-stretch
COPY target/hello.jar .
EXPOSE 8080
CMD java -Xmx400m -Xms400m  -XX:TieredStopAtLevel=1 -noverify -jar hello.jar