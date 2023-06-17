# java-exam

Для запуска стоит нажать download ZIP, открыть в Intellij IDEA и нажать RUN

- GET /rates - возвращает все пары валют и их курсы
- GET /rates/{id} - возвращает пару по id
- POST /rates - добавляет пару (rate), проверяет не была ли она уже добавлена
- DELETE /rates/{id} - удаляет пару по id
- POST /exchange - (отправляем модель exchange) возвращает сумму в валюте
