# Project-x

End to end project development

## Install local multi node kafka cluster
https://www.baeldung.com/ops/kafka-docker-setup

cd projectx-infra  
docker-compose up -d

### command line tools
Link: https://downloads.apache.org/kafka/3.6.0/kafka_2.12-3.6.0.tgz

1. Link contains the command line tools
2. extract it to "C:\devtools\kafka\bin\windows", otherwise path too long exception will occur 
3. 
kafka-console-producer.bat --bootstrap-server localhost:29092 --topic topic-test
kafka-console-consumer.bat --bootstrap-server localhost:29092 --topic topic-test

### Create topic
kafka-topics.bat --create --bootstrap-server localhost:29092 --replication-factor 1 --partitions 1 --topic mytopic

## Install elasticsearch with 3 node setup locally
Install elasticsearch   

cd projectx-infra\es   
docker-compose up -d

## config server setup

`java -Dserver.port=8888 -jar .\target\config-server-1.0-SNAPSHOT.jar`  
run config server with port 8888

## eureka registry setup

1. http://localhost:8761/eureka/apps/order-service to get location details of order microservice
