# Prueba Java Spring Boot Senior

## Ejercicio 1

1. Cree un proyecto Spring Boot (sin importar la versión ni el nombre del proyecto) desde cero que utilice Java 8 o superior.
2. Añada al proyecto una base de datos (en memoria, no importa cuál elija) que contenga una tabla (no importa el nombre de la base de datos ni del esquema). La tabla debe llamarse "Users" y debe contener 3 columnas: Fullname, Phone y Address.
3. La tabla "Users" debe inicializarse con los siguientes datos:

   | Fullname            | Phone      | Address                    |
   | ------------------- | ---------- | --------------------------- |
   | Thomson, Elias      | 555-8596   | Diamond St. 4G3 NY         |
   | Simond, Ella         | 415-9687   | Fleet st. 45 B, 56 BR-NY   |
   | Clifford, Thomas    | 416-69883  | Meet town, 45 - FL         |

4. El proyecto debe contener un endpoint (en un controlador) "/api/users" con el método GET y sin parámetros de entrada. Este endpoint debe devolver un archivo que contenga los datos de la tabla "Users". El formato del archivo no es relevante; lo importante es que contenga todos los datos de la tabla "Users".

## Ejercicio 2

En el proyecto creado en el Ejercicio 1, cree un endpoint (puede ser en el mismo controlador que el ejercicio anterior o en otro) con la ruta "/api/copy" y el método POST. Este endpoint debe recibir un archivo (sin importar el formato) como entrada y copiarlo localmente con las siguientes condiciones:

- La copia del archivo debe realizarse en el directorio local del proyecto utilizando rutas relativas.
- La copia del archivo debe realizarse de forma asíncrona utilizando hilos independientes para la lectura y escritura. Debe haber un hilo de lectura y otro hilo de escritura.
- Cuando se reciba la solicitud en el endpoint "/api/copy", este debe devolver una respuesta 200 inmediatamente y la copia del archivo se realizará en segundo plano sin bloquear la respuesta.

**NOTA:**
- Se evaluará la implementación de los ejercicios en términos de eficiencia y uso de recursos.
- Se evaluará el uso de Streams y expresiones Lambda (programación fluida).
- Se evaluará el uso de patrones de diseño.
- Se evaluará el uso de JPA (Java Persistence API).
