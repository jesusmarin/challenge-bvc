# CHALLENGE BVC
Aplicación Spring Boot con persistencia en PostgreSQL desarrollada como reto para la Bolsa de Valores de Colombia
## Ruta servidor Heroku
App desplagada en Heroku [Link](https://challenge-bvc.herokuapp.com/)
## Documentacion OpenApi 3.0
[Documentación](https://challenge-bvc.herokuapp.com/swagger-ui/index.html) 
referencia en swagger de cada uno de los endpoint disponibles version OpenApi 3.0
## referencia descriptiva de los endpoints
### Eventos
https://challenge-bvc.herokuapp.com/api/events

- GET findAll https://challenge-bvc.herokuapp.com/api/events
- GET findById https://challenge-bvc.herokuapp.com/api/events/{id}
- POST saveEvent https://challenge-bvc.herokuapp.com/api/events/

ejemplo de event
```
{
"id": 4,
"idEvent": "F004",
"description": "Custodia de título valor",
"cost": 100.00
}
```

### Plataforma
https://challenge-bvc.herokuapp.com/api/platform
- GET findAll https://challenge-bvc.herokuapp.com/api/platform
- GET findById https://challenge-bvc.herokuapp.com/api/platform/{id}
- POST saveEvent https://challenge-bvc.herokuapp.com/api/platform/
  ejemplo de platform
```
{
        "id": 2,
        "name": "DEPO",
        "decription": "Plataforma de bóveda de valores"
}
```
## Registro de Eventos
https://challenge-bvc.herokuapp.com/api/event-register
- GET findAll https://challenge-bvc.herokuapp.com/api/event-register
- GET findById https://challenge-bvc.herokuapp.com/api/event-register/{id}
- POST saveEvent https://challenge-bvc.herokuapp.com/api/event-register/

ejemplo de platform- 
```
{
        "id": 5,
        "date": 1661033244000,
        "amount": 2,
        "cost": 41.00,
        "platform": {
            "id": 2,
            "name": "DEPO",
            "decription": "Plataforma de bóveda de valores"
        },
        "event": {
            "id": 1,
            "idEvent": "F001",
            "description": "Consulta de información bursátil",
            "cost": 20.50
        }
    }
```
Filtros por fechas, eventos y plataforma
- GET  https://challenge-bvc.herokuapp.com/api/event-register/date

body del request  (devuelve registro de eventos entre esas fechas)
 ```
 {
   "start":"1661033170000",
   "end":"1661033257000"
 }
```
- GET  https://challenge-bvc.herokuapp.com/api/event-register/date-event

body del request (devuelve registro de eventos entre esas fechas y con ese tipo de evento)
 ```
 {
   "start":"1661033170000",
   "end":"1661033257000",
   "event": {
            "id": 1,
            "idEvent": "F001",
            "description": "Consulta de información bursátil",
            "cost": 20.50
        }
 }
```

- GET  https://challenge-bvc.herokuapp.com/api/event-register/date-plat

body del request (devuelve registro de eventos entre esas fechas y con ese tipo de plataforma)
 ```
 {
   "start":"1661033170000",
   "end":"1661033257000",
   "platform": {
            "id": 2,
            "name": "DEPO",
            "decription": "Plataforma de bóveda de valores"
        }
 }
```
- GET  https://challenge-bvc.herokuapp.com/api/event-register/date-event-plat

body del request (devuelve registro de eventos entre esas fechas y con ese tipo de evento y plataforma)
 ```
 {
   "start":"1661033170000",
   "end":"1661033257000",
   "platform": {
            "id": 2,
            "name": "DEPO",
            "decription": "Plataforma de bóveda de valores"
        },
   "event": {
            "id": 1,
            "idEvent": "F001",
            "description": "Consulta de información bursátil",
            "cost": 20.50
        }
 }
```
para cada caso hay un enpoint count, devuelve el número de coincidencias
(integer) los parametros del body en el request coinciden a la endpoint anteriores
- GET  https://challenge-bvc.herokuapp.com/api/event-register/count
- GET  https://challenge-bvc.herokuapp.com/api/event-register/count-event
- GET  https://challenge-bvc.herokuapp.com/api/event-register/count-plat
- GET  https://challenge-bvc.herokuapp.com/api/event-register/count-event-plat

# Modelo
