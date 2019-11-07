# Start with a base image containing Java runtime
#FROM openjdk:8-jdk-alpine
FROM registry.cn-beijing.aliyuncs.com/lwkelelw/jdk8

# Add Maintainer Info
MAINTAINER Wayne <liuweirr@aliyun.com>

# Set Env
ENV TZ Asia/Shanghai

# The application's jar file
ARG JAR_FILE=C:\Users\WEILIU\.jenkins\workspace\iiht-fsd-sba\backend\registry\target\registry-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]