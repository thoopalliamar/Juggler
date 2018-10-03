# pull image of jdk
FROM java:8-jre

# copy jar file to docker file system
ADD ./target/distributor-0.0.1-SNAPSHOT.jar /usr/app/distributor-0.0.1-SNAPSHOT.jar
EXPOSE 9070

# java -jar <jar fileName> 
WORKDIR usr/app
ENTRYPOINT ["java","-jar", "distributor-0.0.1-SNAPSHOT.jar"]
