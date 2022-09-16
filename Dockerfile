FROM maven:3.8-openjdk-11

RUN apt update && apt install -y build-essential