FROM selenium/standalone-chrome:latest

USER root

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY . .

RUN mvn dependency:resolve

CMD ["mvn", "test"]