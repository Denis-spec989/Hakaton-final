# Cup of Java ![cup](https://raw.githubusercontent.com/Denis-spec989/DifferentPhotos/master/Hakaton/cupofjava1.png)
## **Финал BEST Hack '22**
## Направление **Java Backend**
## Участники:
+ ### Борисовская Алена Алексеевна ([Alienstemple](https://github.com/Alienstemple)) (капитан)
+ ### Игнатов Денис Сергеевич ([Denis-spec989](https://github.com/Denis-spec989))
+ ### Циндяйкин Вадим Денисович ([Vadim-Burns](https://github.com/Vadim-Burns))
+ ### Чихутова Дарья Денисовна ([dashachickutova](https://github.com/dashachickutova))

---
 ## Постановка задачи
 Создать сервис, работающий с данными о заправках, который получает в форматах: **".csv"**,**".json"**,**".xml"** и отправляет их в формате **.json**.

---
 ## Решение задачи
 ### Реализация получения, добавления и отправки данных из нашей БД
 Созданы 2 интерфейса конвертера `Converter` и `ConverterService`. Интерфейс `Converter` нужен для создания конвертеров и их поиска. Разработчику остается просто реализовать интерфейс и создать бины `ConvertorsConfig`, а `ConvertorsService` автоматически подтянет новый конвертор и использует его. Это позволяет сохранять данные в БД, **без необходимости дополнительного преобразования кода сервиса**.

 Созданы контроллеры для маппинга файлов или тела запроса соответствующего формата и их дальнейшего сохранения через сервисы - `CsvController`,`JsonController`,`XMLController`.
 
 Создан контроллер `PetrolController` для маппинга на получение данных из БД.

 Создан сервис `PetrolStationServiceImpl` для сохранения данных в БД и получения данных из БД.

 Созданы конверторы `CsvConverter`,`JsonConverter`,`XmlConverter` имплементирующие от `ConverterImpl`, преобразующие файлы соответствующих форматов в коллекцию `PetrolStationDtoList` состоящую из объектов `PetrolStationDto` с её записью в БД через сервис `PetrolStationServiceImpl`.

 Для получения данных из БД на репозиторном слое была добавлена фильтрация - посредством двух методов. Метод `findAllByFilterPaginated` дает возможность пагинации, в метод `findAllByFilter` можно указать любое поле petrolstation для поиска записей, если какое-то поле не указано оно просто игнорируется

Пару слов о Docker - для обработки https трафика мы развернули через docker-compose + ngingx.

---
## Вывод

Нами был создан гибкий,быстрый сервис для работы с данными о заправках.

**Потестировать можно через сваггер - https://api.inagent.site/swagger-ui/#/**

---
## Ограничения

В связи с сжатыми сроками создания продукта, есть ограничения на вид получаемой  информации в файле формата **.xml**.

Данные должны храниться примерно в таком виде:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<PetrolStationList>
    <PetrolStation>
        <address>Denisaddress</address>
      <latitude>44.62423</latitude> 
      <longtitude>40.05552</longtitude>  
        <name>01023</name>
        <country>RU</country>
        <phone>(8772) 531.50</phone>
        <region>Республика Адыгея</region>
    </PetrolStation>
    <PetrolStation>
        <address>г.Майкоп, Батарейная, 385 А</address>
        <latitude>44.57913</latitude> 
        <longtitude>0</longtitude> 
        <name>01024</name>
        <country>RU</country>
        <phone>(8772) 56-38-20</phone>
        <region>-</region>
    </PetrolStation>
</PetrolStationList>
```
Не допускается замена порядка полей.

Не допускается хранение пустых полей(палка о двух концах, не хватает четкого ТЗ. Мы можем легко проверить на отсутствие значения переменной, и вместо нее записать либо 0 либо "". Но допустим, если мы знаем , что обязательно все поля должны быть заполнены в xml - тогда краш программы- лишняя проверка :shipit: ).

Не допускается многоуровневое вложение(ограничение - данное в условии задания).


