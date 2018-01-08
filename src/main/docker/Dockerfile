# From the openjdk 8 alpine in dockerhub
FROM openjdk:8-jre-alpine

# Add our project specific scripts, configs and deployment files
ADD dccf-reconciler-1.0.0-SNAPSHOT.jar  /dccf-reconciler-1.0.0-SNAPSHOT.jar

MAINTAINER pputta "pramod.putta@centurylink.com"

EXPOSE 20003

CMD ["java","-jar", "/dccf-reconciler-1.0.0-SNAPSHOT.jar"]
