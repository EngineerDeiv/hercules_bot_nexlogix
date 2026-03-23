FROM gradle:8.5-jdk17

RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    xvfb \
    gnupg \
    libx11-xcb1 \
    libxcb1 \
    libxcomposite1 \
    libxcursor1 \
    libxdamage1 \
    libxi6 \
    libxtst6 \
    libnss3 \
    libxrandr2 \
    libasound2 \
    libatk-bridge2.0-0 \
    libgtk-3-0 \
    libgbm1 \
    libxshmfence1 \
    && rm -rf /var/lib/apt/lists/*

RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google.list \
    && apt-get update \
    && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# 🔥 CLAVE: copiar TODO el proyecto
COPY . .

RUN chmod +x gradlew || true

RUN ./gradlew dependencies --no-daemon || true
RUN ./gradlew compileJava compileTestJava --no-daemon || true

ENTRYPOINT ["xvfb-run", "--auto-servernum", "--server-args=-screen 0 1920x1080x24", "./gradlew", "test", "aggregate"]