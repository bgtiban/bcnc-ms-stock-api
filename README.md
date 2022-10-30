# bcnc-ms-stock-api.

bcnc-ms-stock-api es un microservicio API rest que permite consultas sobre el stock de diversas tiendas.
Este proyecto está basado en una arquitectura hexagonal, OpenApi 3.0 y aproximación Api First.
Para su arranque se ha configurado una BD embebida H2 con una carga inicial. Las distintas URLS de las que dispone el servicio se detallan en el apartado URLS

## Tecnologías, patrones y metodologías usadas

- Lenguaje: Java 17 sobre un marco SpringBoot 2.5.10
- Maven: maven versión 3.8.1
- OpenApi: OpenApi versión 3.0.2
- Distribución de carpetas: se ha optado por un proyecto maven multimódulo con [arquitectura hexagonal](https://medium.com/@edusalguero/arquitectura-hexagonal-59834bb44b7f).
    - bcnc-ms-stock-api-api-specs/: definición del contrato OpenApi.yaml
    - bcnc-ms-stock-api-application/: actores primarios que hacen que se ejecute la lógica de negocio, es decir, un API rest, un consumidor de colas, interfaz gráfica, etc...
    - bcnc-ms-stock-api-boot/: Contiene la clase que permite ejecutar nuestro proyecto SpringBoot
    - bcnc-ms-stock-api-domain/: contiene toda la lógica de negocio y está totalmente aislado del resto de módulos, expone sus funcionalidades mediante interfaces de servicio que serán usadas por la capa de aplicación y expone puertos que deberán ser "adaptados" por la capa de infraestructura. Es completamente agnóstico del resto de capas.
    - bcnc-ms-stock-api-infrastructure/: actores secundarios, sistemas de persistencia, conectividad con APIS externas, publicación de mensajes en servicios de colas, etc... Implementa los puertos de la capa dominio.
- Aproximaxión [Api First](https://medium.com/@emilianozublena/api-first-development-c202a61cf3b2): Se trabaja primero en la generación del contrato OpenApi y se desarrolla en base al código autogenerado de dicho contrato.
- [SpringDoc](https://springdoc.org/): plugin de maven que permite la generación de las clases necesarias a partir de un contrato OpenApi 3.0
- swaggger-ui: Permite visualizar e interactuar con la API.

## Montaje del entorno de desarrollo.

Para la instalación en local del proyecto primero nos aseguraremos de cumplir con los siguientes requisitos:

- Java 17 o superior
- Lombok 1.18.24
- Maven 3.8.1 o superior
- SpringBoot 2.5.10
- IDE de libre elección
- puerto 8080 libre

Imprte el proyecto en su IDE preferido e inicie la aplicación springboot, esta lo hará en el puerto 8080.

## Ejemplo de uso

Podemos arrancar la aplicación sólo con java y maven instalados mediante los siguiente pasos:

1. descargar el proyecto desde este repositorio.
2. Ubicarse en la raíz del proyecto bcnc-ms-stock-api 
3. Ejecutar `mvn clean validate install` para compilar el proyecto
4. Comprobar que el puerto 8080 está libre.
5. Ejecutar `java -jar bcnc-ms-stock-api-boot/target/bcnc-ms-stock-api-boot.jar`
6. Acceder a la UI de Swagger: (http://localhost:8080/api-docs/swagger-ui/index.html)
7. Probar el endpoint, por ejemplo: 2020-06-14-21.00.00, 35455, 1.


## URLS

- Swagger-ui: (http://localhost:8080/api-docs/swagger-ui/index.html)
- H2-console: (http://localhost:8080/h2-console)

## Autores y menciones
- Creador: Bryan Tibán
- A petición de: BCNC



