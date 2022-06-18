FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_PASSWORD=root
ENV MYSQL_DATABASE=countries

COPY initial-script.sql /docker-entrypoint-initdb.d/