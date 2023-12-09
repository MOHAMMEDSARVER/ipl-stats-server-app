FROM maven:3.8.1-openjdk-21-slim AS build
RUN mkdir /home/iplstats
COPY . /home/iplstats
RUN cd /home/iplstats && mvn clean package
RUN cp /home/iplstats/target/*.jar iplstats.jar
ENTRYPOINT [ "java","-jar","currency.jar" ]
EXPOSE 8080