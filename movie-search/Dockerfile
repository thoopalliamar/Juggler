# pull image of jdk
FROM java:8-jre

# copy jar file to docker file system
ADD ./target/movie-search-1.0.0.jar /usr/app/movie-search-1.0.0.jar

# java -jar <jar fileName>
WORKDIR usr/app
ENTRYPOINT ["java","-jar", "movie-search-1.0.0.jar"]
EXPOSE 9077
