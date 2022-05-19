FROM openjdk
LABEL maintainer = "praveenmaha13@gmail.com"
WORKDIR /app
COPY out/artifacts/CTSE_ORDERSERVICE_jar/CTSE-ORDERSERVICE.jar .
COPY startup.sh .
RUN chmod +x startup.sh
CMD ["./startup.sh"]