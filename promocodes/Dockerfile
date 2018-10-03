# pull image of jdk
FROM java:8-jre

# copy jar file to docker file system
ADD ./target/promocodes-1.0.0.jar /usr/app/promocodes-1.0.0.jar

# java -jar <jar fileName>
WORKDIR usr/app
ENTRYPOINT ["java","-jar", "promocodes-1.0.0.jar"]
EXPOSE 9080