# XP-practice-project

*** Приложение-mobile: жизнь перед дедлайном***

**Требования**

1. Для добавления нужно добавить дату и время дедлайна и время на выполнение задачи.

2. При пересечении времени выполнения задач об этом пишется пользователю. Об этом будет написано пользователю и предложено подходящее время для оповещения

3. При операции добавления дедлайна информация об этом сохраняется на устройстве пользователя. Все вычисления происходят у пользователя.

4. Оповещения о дедлайнах работает без интернета и авторизации.

5. Есть регистрация/авторизация 

6. Если у пользователя есть интернет и он авторизован, то происходит синхронизация с сервером.

**Детали реализации**

1. Java. Причины: наличие популярных фреймворков для мобильной разработки, имеется опыт использования.

2. Для хранения данных используется PostgreSQL. Причины: имеется опыт использования со Spring и Hibernate.

3. AndroidX - фреймворк для мобильной разработки, самое популярное решение, имеется опыт использования. 

4. Spring - популярный фреймворк, подходит для разработки серверов.

*API:*

GET `/sync/{userId}` - получить текущие дедлайны

POST '/sync/{userId}' - внести новые дедлайны

**Планированеи**

*Первый этап*
0. Настроить CI с базой данных и тестами
1. Сервер с ручками для синхронизации с базой данных
2. Алгоритм проверки пересечений дедлайнов
3. Клиент с отображением названия, даты и требуемого времени на выполнение дедлайна, модель окна для добавления дедлайнов
