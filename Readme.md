mvn clean package
# Spring build
java -Dmongodb.host="54.254.2.174" -jar MongoDB-1.0-SNAPSHOT-spring-boot.jar

# Shade build
java -Dmongodb.host="54.254.2.174" -jar MongoDB-1.0-SNAPSHOT.jar

# Others way to build executatble jar
https://www.baeldung.com/executable-jar-with-maven

# Shade plugin
http://maven.apache.org/plugins/maven-shade-plugin/index.html
