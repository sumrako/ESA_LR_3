# Лабораторная работа 3 (REST)
## SpringREST vs JAX-RS
 JAX-RS нацелен на разработку веб-сервисов (в отличие от веб-приложений на HTML), в то время как Spring MVC уходит своими корнями в разработку веб-приложений. 
 Spring MVC - это полноценный фреймворк с возможностями REST. Как и JAX-RS, он также предоставляет нам полезные аннотации для абстрагирования от низкоуровневых деталей. 
 Его главное преимущество заключается в том, что он является частью экосистемы Spring Framework. Таким образом, он позволяет нам использовать внедрение зависимостей, 
 как любой другой модуль Spring.  Кроме того, он легко интегрируется с другими компонентами, такими как Spring AOP, Spring Data REST и Spring Security.

## Ход работы
 > Для разработки было выбрано приложение лабораторной работы 2, в котором интегрирован фреймворк Spring.

В ходе лабораторной работы было реализовано REST API для модели, описанной в предыдущих лабораторных,
была реализована имплементация API, его интеграция в существующее приложение, а также его расширяемость до типов JSON и XML. Была реализована XSL трансформация, и добавлены XSLT файлы для всех
XML ресурсов.

## Демонстрация работоспособности
### http://localhost:8081/rest/tickets


XML
```bash
<html>
    <body>
        <h1>Tickets</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Seat</th>
                    <th>Cost</th>
                    <th>Timetable</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>952</td>
                    <td>
                                    Seat : 1 | Row 1</td>
                    <td>310.0</td>
                    <td>Bogemian rapsody | 2024-01-10 03:03 | hall(2)
                                </td>
                </tr>
                <tr>
                    <td>953</td>
                    <td>
                                    Seat : 1 | Row 1</td>
                    <td>310.0</td>
                    <td>Black lake | 2024-01-12 03:03 | hall(2)
                                </td>
                </tr>
                <tr>
                    <td>955</td>
                    <td>
                                    Seat : 3 | Row 1</td>
                    <td>200.0</td>
                    <td>Black lake | 2024-01-12 03:03 | hall(2)
                                </td>
                </tr>
                <tr>
                    <td>954</td>
                    <td>
                                    Seat : 2 | Row 1</td>
                    <td>200.0</td>
                    <td>Black lake | 2024-01-12 03:03 | hall(2)
                                </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
```

JSON
```bash
[
    {
        "id": 952,
        "seatDto": {
            "seat": 1,
            "row": 1
        },
        "cost": 310.0,
        "benefits": false,
        "timetable": {
            "id": 653,
            "performance": {
                "id": 252,
                "name": "Bogemian rapsody",
                "genre": "comedy",
                "country": "Russia"
            },
            "hall": 2,
            "date": "2024-01-10T03:03:00"
        }
    },
    {
        "id": 953,
        "seatDto": {
            "seat": 1,
            "row": 1
        },
        "cost": 310.0,
        "benefits": false,
        "timetable": {
            "id": 654,
            "performance": {
                "id": 202,
                "name": "Black lake",
                "genre": "drama",
                "country": "Britain"
            },
            "hall": 2,
            "date": "2024-01-12T03:03:00"
        }
    },
    {
        "id": 955,
        "seatDto": {
            "seat": 3,
            "row": 1
        },
        "cost": 200.0,
        "benefits": true,
        "timetable": {
            "id": 654,
            "performance": {
                "id": 202,
                "name": "Black lake",
                "genre": "drama",
                "country": "Britain"
            },
            "hall": 2,
            "date": "2024-01-12T03:03:00"
        }
    },
    {
        "id": 954,
        "seatDto": {
            "seat": 2,
            "row": 1
        },
        "cost": 200.0,
        "benefits": true,
        "timetable": {
            "id": 654,
            "performance": {
                "id": 202,
                "name": "Black lake",
                "genre": "drama",
                "country": "Britain"
            },
            "hall": 2,
            "date": "2024-01-12T03:03:00"
        }
    }
]
```

### http://localhost:8081/rest/performances

XML
```bash
<html>
    <body>
        <h1>Performances</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Genre</th>
                    <th>Country</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>252</td>
                    <td>Bogemian rapsody/&gt;
                                </td>
                    <td>comedy</td>
                    <td>Russia</td>
                </tr>
                <tr>
                    <td>253</td>
                    <td>Sad Andrei/&gt;
                                </td>
                    <td>drama</td>
                    <td>Russia</td>
                </tr>
                <tr>
                    <td>202</td>
                    <td>Black lake/&gt;
                                </td>
                    <td>drama</td>
                    <td>Britain</td>
                </tr>
                <tr>
                    <td>302</td>
                    <td>Pups and Vups/&gt;
                                </td>
                    <td>comedy</td>
                    <td>India</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
```

JSON
```bash
[
    {
        "id": 252,
        "name": "Bogemian rapsody",
        "genre": "comedy",
        "country": "Russia"
    },
    {
        "id": 253,
        "name": "Sad Andrei",
        "genre": "drama",
        "country": "Russia"
    },
    {
        "id": 202,
        "name": "Black lake",
        "genre": "drama",
        "country": "Britain"
    },
    {
        "id": 302,
        "name": "Pups and Vups",
        "genre": "comedy",
        "country": "India"
    }
]
```

### http://localhost:8081/rest/timetable

XML
```bash
<html>
    <body>
        <h1>Timetable</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th><th>Performance</th><th>Hall</th><th>Date</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>653</td><td>Bogemian rapsody | comedy | Russia</td><td>2</td><td>2024-01-10 03:03</td>
                </tr>
                <tr>
                    <td>655</td><td>Bogemian rapsody | comedy | Russia</td><td>3</td><td>2024-01-09 08:08</td>
                </tr>
                <tr>
                    <td>654</td><td>Black lake | drama | Britain</td><td>2</td><td>2024-01-12 03:03</td>
                </tr>
                <tr>
                    <td>652</td><td>Sad Andrei | drama | Russia</td><td>2</td><td>2024-01-09 06:06</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
```

JSON
```bash
[
    {
        "id": 653,
        "performance": {
            "id": 252,
            "name": "Bogemian rapsody",
            "genre": "comedy",
            "country": "Russia"
        },
        "hall": 2,
        "date": "2024-01-10T03:03:00"
    },
    {
        "id": 655,
        "performance": {
            "id": 252,
            "name": "Bogemian rapsody",
            "genre": "comedy",
            "country": "Russia"
        },
        "hall": 3,
        "date": "2024-01-09T08:08:00"
    },
    {
        "id": 654,
        "performance": {
            "id": 202,
            "name": "Black lake",
            "genre": "drama",
            "country": "Britain"
        },
        "hall": 2,
        "date": "2024-01-12T03:03:00"
    },
    {
        "id": 652,
        "performance": {
            "id": 253,
            "name": "Pups and Vups",
            "genre": "comedy",
            "country": "India"
        },
        "hall": 2,
        "date": "2024-01-09T06:06:00"
    }
]
```