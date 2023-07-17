FROM openjdk:8

ENV ALLURECTL_DOWNLOAD_URL https://github.com/allure-framework/allurectl/releases/latest/download

RUN wget ${ALLURECTL_DOWNLOAD_URL}/allurectl_linux_386 -O /usr/bin/allurectl && \
    chmod +x /usr/bin/allurectl
