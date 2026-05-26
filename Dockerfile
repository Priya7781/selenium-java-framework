FROM maven:3.9.6-eclipse-temurin-21

WORKDIR /app

# Copy pom first
COPY pom.xml .

# Cache dependencies
RUN mvn dependency:go-offline

# Copy remaining project
COPY . .

CMD ["mvn", "test"]