echo "********************************************************"
echo "Starting config-service with Configuration Service with profile: $PROFILE";
echo "********************************************************"
#java -Dspring.cloud.config.uri=$CONFIGSERVER_URI -Dspring.profiles.active=$PROFILE -jar /app/app.jar
java -jar /app/app.jar