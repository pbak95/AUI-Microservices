FROM maven:alpine
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ADD . /usr/src/app
WORKDIR /usr/src/app/DateAndTime
RUN mvn install