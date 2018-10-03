

# pull image of jdk
FROM java:8-jre

# copy jar file to docker file system
ADD ./target/login-authentication-0.0.1-SNAPSHOT.jar /usr/app/login-authentication-0.0.1-SNAPSHOT.jar

# java -jar <jar fileName>
WORKDIR usr/app
ENTRYPOINT ["java","-jar", "login-authentication-0.0.1-SNAPSHOT.jar"]
EXPOSE 9074