FROM eclipse-temurin:21

# Install required packages
RUN apt-get update && apt-get install -y \
    maven \
    wget \
    unzip \
    gnupg \
    curl

# Add Google Chrome repository
RUN curl -fsSL https://dl.google.com/linux/linux_signing_key.pub | \
    gpg --dearmor -o /usr/share/keyrings/google-chrome.gpg

RUN echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-chrome.gpg] http://dl.google.com/linux/chrome/deb/ stable main" \
    > /etc/apt/sources.list.d/google-chrome.list

# Install Chrome
RUN apt-get update && apt-get install -y google-chrome-stable

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Download Maven dependencies
RUN mvn dependency:resolve

# Run tests
CMD ["mvn", "test"]