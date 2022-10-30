# bcnc-ms-stock-api.

bcnc-ms-stock-api es un microservicio API rest que permite consultas sobre el stockd e diversas tiendas.
Este proyecto está basado en una arquitectura hexagonal, OpenApi 3.0 y aproximación Api First.
Para su arranque se ha configurado una BD embebida H2 con una carga inicial. Las distintas URLS de las que dispone el servicio se detallan en el apartado URLS

## Tecnologías, patrones y metodologías usadas

- Lenguaje: Java 17 sobre un marco SpringBoot 2.5.10
- Maven: maven versión 3.8.1
- OpenApi: OpenApi versión 3.0.2
- Distribución de carpetas: se ha optado por un proyecto maven multimódulo con arquitectura hexagonal.
- SpringDoc: plugin de maven que permite la generación de las clases necesarias a partir de un contrato OpenApi 3.0
- swaggger-ui: Permite visualizar e interactuar con la API.

## Montaje de entorno de desarrollo.

Para la instalación en local del proyecto primero nos aseguraremos de cumplir con los siguientes requisitos:

- Java 17
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
2. Ejecutar `mvn clean validate install` para compilar el proyecto
3. Ejecutar `java -jar bcnc-ms-stock-api-boot/target/bcnc-ms-stock-api-boot.jar`
5. Acceder a la UI de Swagger: (http://localhost:8080/api-docs/swagger-ui/index.html)

```

```

## URLS

- [Swagger-ui](http://localhost:8080/api-docs/swagger-ui/index.html)
- [H2-console](http://localhost:8080/h2-console)

## Autores y menciones
- Creador: Bryan Tibán
- A petición de: BCNC



