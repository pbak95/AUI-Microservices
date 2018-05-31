FROM maven:alpine
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ADD . /usr/src/app
RUN cd DateAndTime
RUN ls -al
RUN mvn install