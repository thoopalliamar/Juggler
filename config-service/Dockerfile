FROM java:8

RUN mkdir /src

WORKDIR /src

ADD target/config-service-1.0.0.jar /src/centralizedconfig.jar

EXPOSE 9084

RUN sh -c 'touch /src/centralizedconfig.jar'

ENTRYPOINT ["java", "-jar","/src/centralizedconfig.jar"]
