echo "********************************************************"
echo "Starting registry-service with Configuration Service : $CONFIGSERVER_URI Configuration Port: $CONFIGSERVER_PORT with profile: $PROFILE";
echo "********************************************************"
java -Dspring.cloud.config.uri=$CONFIGSERVER_URI -Dspring.profiles.active=$PROFILE -jar /app/app.jar