### Patron de diseño utilizado : Repository
### Recomendaciones
-al ejecutar el proyecto se recomeinda antes correr Redis en local Ya que el conteo de movimientos por cuenta se guarda en una BD cache
### Orden de consumo de API
- POST persona: Añade un registro de la persona
- POST cliente: Crea una persona como cliente
- POST cuenta: le crea una cuenta al cliente
- POST movimientos: Crea un movimiento y registra en cache el numero de movimientos diarios


### Redis@EnableScheduling
Tiene el servicio configurado para que la BD Redis se reinicie diario y el conteo empiece de nuevo desde 0
