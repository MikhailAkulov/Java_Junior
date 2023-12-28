# Урок 5. Клиент/Сервер своими руками

## Описание лекции:

- Понятие сетей и сокетов
- Создание сокетов и подключение к серверу
- Создание серверного сокета и прослушивание входящих соединений
- Отправка и получение данных через сокеты
- Многопоточность и сокеты: обработка нескольких клиентов
- Обработка исключений в работе с сокетами
- Работа с UDP сокетами
- Безопасность сетевого взаимодействия: использование SSL сокетов

[Код лекции](https://github.com/MikhailAkulov/Java_Junior/tree/main/src/main/java/ru/gb/examples/Example_5/Lecture)

## На семинаре:

- Создание простого сервера и клиента с использованием ServerSocket и Socket.
- Отправка и прием сообщений между сервером и клиентом.
- Расширение клиента и сервера для поддержки множества клиентов одновременно.

[Код семинара](https://github.com/MikhailAkulov/Java_Junior/tree/main/src/main/java/ru/gb/examples/Example_5/Seminar)

## Задания:

0. Разобраться с написанным кодом семинара в классах Server и Client.
1. Если в начале сообщения есть '@4' - то значит отсылаем сообщеине клиенту с идентификатором 4.
2. Если в начале сообщения нет '@' - значит, это сообщение нужно послать остальным клиентам. 
3. (*) Добавить админское подключение, которое может кикать других клиентов. 

    3.1 При подключении оно посылает спец. сообщение, подтверждающее, что это - админ. 

    3.2 Теперь, если админ посылает сообщение kick 4 - то отключаем клиента с идентификатором 4. 
4. (**) Подумать, как лучше структурировать программу (раскидать код по классам).