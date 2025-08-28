# 1. 베이스 이미지 선택 (Java 21)
FROM openjdk:21-jdk-slim

# 2. JAR 파일이 복사될 경로를 변수로 지정
ARG JAR_FILE=build/libs/*.jar

# 3. 빌드된 JAR 파일을 컨테이너 내부로 복사하고 이름을 app.jar로 변경
COPY ${JAR_FILE} app.jar

# 4. 애플리케이션 실행
# docker-compose.yml에서 환경 변수로 프로필과 Jasypt 비밀키 등을 주입할 예정입니다.
ENTRYPOINT ["java","-jar","/app.jar"]