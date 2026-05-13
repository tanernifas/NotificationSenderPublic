# Используем официальный образ Eclipse Temurin (OpenJDK) с JRE
FROM eclipse-temurin:17-jre-alpine

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR-файл из директории target внутрь контейнера
COPY target/*.jar NotificationSender-0.4.1-demo.jar

# Открываем порты, которые будет слушать приложение (порты: сервер, отладка)
EXPOSE 9091
EXPOSE 5006

# Команда для запуска приложения
ENTRYPOINT ["sh", "-c", "java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5006 -jar NotificationSender-0.4.1-demo.jar"]