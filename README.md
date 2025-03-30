Este es un Proyecto de una Calculadora-Spring Boot que implementa operaciones básicas y pruebas unitarias utilizando **JUnit y Mockito**.

#Requisitos previos
tener instalado:
- Java 17
- Maven
- Git 

Para ejecutar las pruebas unitarias y de integración, usamos **./mvnw test** en la terminal 

Qué validan las pruebas?
Las pruebas verifican que los métodos de la calculadora funcionan correctamente:

Operaciones básicas: suma, resta, multiplicación y división.
Manejo de errores: Se prueba que la división por cero lanza una excepción.
Mockito: Se usa para simular el comportamiento del repositorio en pruebas unitarias.

Integración con acciones de GitHub
El proyecto incluye un Pipeline CI/CD en GitHub Actions para ejecutar pruebas automáticamente en cada pusho pull request.
