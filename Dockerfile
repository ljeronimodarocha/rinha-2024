# Etapa de build usando a imagem oficial do Maven
FROM gradle:jdk21-alpine AS build
# Copia o código fonte do projeto para o container
COPY . /home/gradle/

# Define o diretório de trabalho dentro do container
WORKDIR /home/gradle

# Compila o projeto e empacota a aplicação
RUN gradle build
#RUN gradle build --no-daemon

# Etapa de execução usando a imagem oficial do OpenJDK
FROM openjdk:21

# Copia o artefato gerado na etapa de build para o diretório de trabalho
#COPY --from=build /usr/src/app/build/quarkus-app /usr/app/
COPY --from=build /home/gradle/build/quarkus-app/. /usr/app/

# Define o diretório de trabalho
WORKDIR /usr/app/

# Comando para executar a aplicação
CMD ["java", "-jar", "quarkus-run.jar"]


