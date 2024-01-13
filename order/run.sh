echo "********************************************************"
echo "Starting order-service with Configuration Service : $CONFIGSERVER_URI with profile: $PROFILE";
echo "********************************************************"
java -Dspring.cloud.config.uri=$CONFIGSERVER_URI -Dspring.profiles.active=$PROFILE -jar /app/app.jar