# Модуль уведомлений (демонстрационная версия)

> Модуль используется для получения данных о регистрации и верификации сервиса
> InviteMe (https://github.com/tanernifas/InviteMePublic)

[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-ED8B00?style=flat-square&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Kafka](https://img.shields.io/badge/Spring%20Kafka-6DB33F?style=flat-square&)](https://spring.io/projects/spring-kafka)
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white)](https://www.docker.com/)

---

## Оглавление

- [О проекте](#о-проекте)
- [Технологии](#технологии)
- [Требования](#требования)
- [Быстрый старт через Docker](#быстрый-старт-через-docker)
    - [Windows](#windows)
    - [Linux](#linux)
    - [Проверка запуска](#проверка-запуска)
- [API Документация](#api-документация)

---

## О проекте

Модуль использует брокера сообщений Kafka для получения данных о регистрации и
верификации пользователей сервиса InviteMe и дальнейшего оповещения пользователей.

---

## Технологии

| Компонент    | Версия | Примечание        |
|--------------|--------|-------------------|
| Java         | 17+    | LTS               |
| Spring Boot  | 4.0.3  | Web               |
| Spring Kafka |        | Data exchange     |
| Docker       | 20.10+ | Multi-stage build |
| Maven        | 3.9+   | Build             |

---

## Требования

Перед запуском убедитесь, что установлены:

- [Docker](https://docs.docker.com/get-docker/) **20.10+**
- [Docker Compose](https://docs.docker.com/compose/install/) **v2.0+** (встроен в новые версии Docker Desktop)
- (Опционально) [Git](https://git-scm.com/) **2.30+**
- (Опционально) [Maven](https://maven.apache.org/download.cgi) **3.9+**
- (Опционально для Maven) [Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) **17+**

> **Проверка:**
> ```bash
> docker --version
> docker compose version
> git --version
> mvn -version
> java -version
> ```

---

## Быстрый старт через Docker

Проект полностью контейнеризирован. Запуск одинаков для всех ОС, но есть нюансы в путях и правах.

### Windows

#### PowerShell (рекомендуется)

```powershell
# 1. Клонируйте репозиторий
git clone https://github.com/tanernifas/NotificationSenderPublic.git
cd NotificationSenderPublic

(При желании можно пересобрать проект)
mvn clean package

# 2. Запустите через Docker Compose
docker compose up --build -d
```

или

1. На GitHub нажмите зелёную кнопку "Code" ? "Download ZIP"
2. Разархивировать скаченный файл

```powershell
3. Перейдите в соответствующую папку, куда был разархиврован файл
cd NotificationSenderPublic

(При желании можно пересобрать проект)
mvn clean package

4. Запустите через Docker Compose
docker compose up --build -d
```

### Linux

```
# 1. Клонируйте репозиторий
git clone https://github.com/tanernifas/NotificationSenderPublic.git
cd NotificationSenderPublic

(При желании можно пересобрать проект)
mvn clean package

# 2. Запустите через Docker Compose
docker compose up --build -d
```

### Проверка запуска

Зайдите на [демонстрационный сайт сервиса](http://localhost:9091/). Заполните необходимые данные и нажмите кнопку "Отправить".
После этого зайти на указанную электронную почту и проверьте полученное письмо.

## Тесты

### Отправить email с оповещением через curl

> **Указать необходимую почту вместо test@mail.ru**

#### Windows

```powershell
curl.exe --% -X POST http://localhost:9091/api/demo/send -H "Content-Type: application/json" -d "{\"to\":\"test@mail.ru\",\"subject\":\"test subject\",\"message\":\"test message\",\"html\":false}"
```

#### Linux

```
curl --% -X POST http://localhost:9091/api/demo/send -H "Content-Type: application/json" -d "{\"to\":\"test@mail.ru\",\"subject\":\"test subject\",\"message\":\"test message\",\"html\":false}"
```