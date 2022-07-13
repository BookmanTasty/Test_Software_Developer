# Test_Software_Developer
Prueba técnica del candidato Cesar Adrian Leyva Luna
## _Sistema REST utilizando Spring Boot y la base de datos H2_

## Funciones

- Visualizar, eliminar y crear elementos en la tabla usuarios
- Visualizar y crear elementos en la tabla facturas

## Endpoints

Para visualizar todas las personas
```sh
curl --location --request GET 'http://localhost:8080/directorio/personas'
```
Para visualizar una persona por su identificación
```sh
curl --location --request GET 'http://localhost:8080/directorio/persona?identificacion=22222'
 ```
Para eliminar una persona por su identificación
```sh
curl --location --request DELETE 'http://localhost:8080/directorio/persona?identificacion=11111'
 ```
Para crear una persona(identificación tiene id único y los campos: nombre y apellido paterno no pueden ser nulos o vacíos)
```sh
curl --location --request POST 'http://localhost:8080/directorio/persona' \
--header 'Content-Type: application/json' \
--data-raw '    {
        "nombre": "Cesar",
        "apellidoPaterno": "Leyva",
        "apellidoMaterno": "Luna",
        "identificacion": "123456"
    }'
```
Para visualizar las facturas por la identificación de la persona 
```sh  
 curl --location --request GET 'http://localhost:8080/ventas/facturas?personaIdentificacion=11111'
  ```
Para crear una factura(la fecha se obtiene automáticamente del sistema)
 ```sh   
 curl --location --request POST 'http://localhost:8080/ventas/factura' \
--header 'Content-Type: application/json' \
--data-raw '    {
        "monto": 905.23,
        "personaId": "11111"
    }'
    ```
