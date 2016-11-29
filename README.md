# Rest-Authentication
Proyecto hecho en java - jersey que muestra como realizar autentificación de la forma basica y con token.

### Login
Para el caso del login se debe realizar a travez de POST y las credenciales deben ser enviadas en el body del request de la sigueinte forma:
```sh
{ "usuario": ejemplo, "clave": ejemplo }
```
En este ejemplo las credenciales para un login exitoso son:

```sh
{ "usuario": admin, "clave": admin }
```
Si se realiza con éxito te devolvera un token.

### Validacion
#### Basic
En la forma básica se debe descomentar el codigo en la clase "SecurityFiler". En este caso se debe de enviar en el Header:
```sh
Authorization : Basic CREDENCIALES_ENCODE
```
#### Token
En el caso de querer utilizar una token en el Header se debe de enviar lo siguiente:
```sh
Authorization : Bearer VALOR_DEL_TOKEN
```
