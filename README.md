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
 ### Реализация получения,добавления и отправки данных из нашей БД
 Созданы 2 интерфейса конвертера `Converter` и `ConverterService`. Интерфейс `Converter` нужен для создания конвертеров и их поиска. Разработчику остается просто реализовать интерфейс и создать бины `ConvertorsConfig`, а `ConvertorsService` автоматически подтянет новый конвертор и использует его. Это позволяет сохранять данные в БД, **без необходимости дополнительного преобразования кода сервиса**.

 Созданы контроллеры для маппинга файлов или тела запроса соответствующего формата и их дальнейшего сохранения через сервисы - `CsvController`,`JsonController`,`XMLController`.
 
 Создан контроллер `PetrolController` для маппинга на получение данных из БД.

 Создан сервис `PetrolStationServiceImpl` для сохранения данных в БД и получения данных из БД.

 Созданы конверторы `CsvConverter`,`JsonConverter`,`XmlConverter` имплементирующие от `ConverterImpl`, преобразующие файлы соответствующих форматов в коллекцию `PetrolStationDtoList` состоящую из объектов `PetrolStationDto` с её записью в БД через сервис `PetrolStationServiceImpl`.


---
## Вывод

Нами был создан гибкий,быстрый сервис для работы с данными о заправках.

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

Не допускается хранение пустых полей(если поле не имеет значения, тогда поле должно содержать "-" ,если поле текстовое или "0",если поле числовое ).

Не допускается многоуровневое вложение(ограничение - данное в условии задания).


