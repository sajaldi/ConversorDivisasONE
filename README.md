# Conversor de Divisas

Este proyecto de desafío del G6 de ONE (Oracle Next Education) de es una aplicación en Java que utiliza la API de ExchangeRate para consultar y 
convertir tasas de cambio entre diferentes divisas. Está diseñado con un menú interactivo que permite realizar diversas operaciones relacionadas con las conversiones de monedas.

## Características

- Consulta tasas de conversión para cualquier divisa base.
- Cambia la divisa base en cualquier momento.
- Obtén información general sobre la divisa base seleccionada.
- Consulta tasas específicas para varias divisas seleccionadas por el usuario.
- Diseño modular para facilitar la extensión y mantenimiento.

## Tecnologías Utilizadas

- **Java:** Lenguaje de programación principal.
- **Gson:** Biblioteca para manejar JSON.
- **HttpClient:** Para realizar solicitudes HTTP.
- **API de ExchangeRate:** Fuente de datos de tasas de cambio.

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/sajaldi/ConversorDivisasONE.git
   cd conversor-divisas
2. Crea un archivo config.properties en el directorio raíz con el siguiente contenido:
api.key=TU_API_KEY
3. Importa el proyecto en tu IDE favorito (como IntelliJ IDEA) y asegúrate de tener configurada la dependencia de Gson.

## Uso
Ejecuta la clase principal ConversorDeDivisas.

Introduce el código de la divisa base (por ejemplo, USD o EUR).

Navega por el menú interactivo para realizar operaciones:

Opción 1: Mostrar todas las tasas de conversión.
Opción 2: Cambiar la divisa base.
Opción 3: Mostrar información general de la divisa base.
Opción 4: Consultar conversiones específicas de varias divisas.
Opción 5: Salir de la aplicación.

## Ejemplo de Uso
Ingrese el código de la divisa base (por ejemplo, USD):
USD

=== Menú ===
1. Mostrar todas las tasas de conversión
2. Cambiar la divisa base
3. Información general de la divisa base
4. Mostrar conversiones específicas de varias divisas
5. Salir
Seleccione una opción: 4

Ingrese los códigos de las divisas a consultar (separados por comas):
EUR,JPY,GBP

Tasas específicas:
EUR: 0.91
JPY: 134.45
GBP: 0.78


## Seguridad
La clave API utilizada para acceder a los datos de ExchangeRate se almacena en un archivo config.properties, el cual está excluido del control de versiones mediante el archivo .gitignore.

Nota: Asegúrate de mantener tu clave API segura y no compartirla públicamente.

## Contribución
¡Se aceptan contribuciones! Si deseas mejorar este proyecto, por favor:

Realiza un fork del repositorio.
Crea una nueva rama para tu funcionalidad o corrección de errores.
Envía un pull request con una descripción detallada de tus cambios.
