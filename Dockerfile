#estagio da compilação
FROM ubuntu:lastest as build

#instale o OpneJDK 17
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
RUN apt-get install mavn -y

#copie o codigo-fonte para o container
COPY . .

#Compile o projeto com maven
RUN mvn clean install

#estagio de execução
FROM openjdk:17-jdk-slim

#exponha a porta 8000
EXPOSE 8000

#Copie o arquivo JAR da etapa de compilação para o container de execução
COPY --from=build /target/Deploy_Anthony.jar app.jar

#defina o comando de inicialização da aplicação
ENTRYPOINT [ "java", "-jar", "app-jar" ]