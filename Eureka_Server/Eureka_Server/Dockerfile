FROM openjdk:17
VOLUME /tmp
EXPOSE 8761
ADD classes/artifacts/Eureka_Server_jar/Eureka_Server.jar Eureka_Server.jar
ENTRYPOINT ["java","-jar","/Eureka_Server.jar"]