# Xakaton.ui

Это приложение предназначено для UI отоброжения формы на которой можно задать сообщения для категоризации, приоритезации и назначения сотрудника


## Deploying using Docker

Для билда использовать команды ниже

```
mvn clean package -P prod
docker build -t javaui .
```

Для деплоя использовать команды ниже
```
docker run -p 8080:8080 javaui:latest
```
