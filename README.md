# MALSIN
Malsin es una aplicación que permite a los usuarios reportar incidencias encontradas en su ciudad.
Está basada en arquitectura de microservicios y eventos mediante:
- Backend desarrollado en SpringBoot Java 17 y RabbitMq.
- Frontend desarrollado en Flutter.

Documentación al completo en:
- Documentación: [malsin-confluence](https://bgtiban.atlassian.net/wiki/spaces/GM/pages/917517/Modelo+C4+MALSIN)
- Repositorio de Documentación: [malsin-documentation](https://github.com/bgtiban/malsin-documentation)
- Repositorio Frontend: [malsin-front](https://github.com/bgtiban/malsin-front)


# Preparación del entorno de desarrollo 

1. Instalar STS (Spring Tool Suite) en su versión 4.15 como mínimo. Puedes ver todas las versiones aquí --> [Versiones STS](https://github.com/spring-projects/sts4/wiki/Previous-Versions)
2. Instalar java en la versión que se indique en la propiedad `<java.version>` del fichero `malsin-back/pom.xml`.
3. Instalar maven en la versión que se indique en la propiedad `<maven-required.version>` del fichero `malsin-back/pom.xml`
4. Importar el proyecto en tu IDE e instalar Lombok. La versión debe ser la descrita en la propiedad `<lombok.version>` del fichero `malsin-back/pom.xml`.
5. Instalar docker engine en tu equipo. Para ello puedes seguir la guía oficial --> [Guía oficial Docker](https://docs.docker.com/engine/install/)
6. Instalar editorconfig en tu IDE. Editorconfig es un plugin que mediante un fichero de configuración llamado `.editorconfig` permite mantener un formato unificado independientemente del IDE utilizado.
7. Añadir fichero `.env` en la raíz del proyecto con las variables
	  ```
      POSTGRES_HOST=172.168.0.10
	  POSTGRES_USER=postgres
	  POSTGRES_PASSWORD=****
	  ```
   Esto es imprescindible para la posterior puesta a punto de la infraestructura con  docker compose.

# Arrancar entorno de desarrollo

1. Añadir estos tags en el fichero `malsin-back-infrastructure/pom.xml` para poder ejecutar los comandos de flyway. Flyway es una herramienta que nos permite versionar nuestra BD.
   ```
    <build>
		<plugins>
			<plugin>
				<groupId>org.flywaydb</groupId>
				<artifactId>flyway-maven-plugin</artifactId>
				<configuration>
					<driver>org.postgresql.Driver</driver>
					<url>jdbc:postgresql://172.168.0.10:5432/malsin</url>
					<user>postgres</user>
					<password>****</password>
					<baselineOnMigrate>true</baselineOnMigrate>
					<schemas>malsin</schemas>
					<locations>
						<location>
							classpath:scripts/migration
						</location>
					</locations>
				</configuration>
			</plugin>
		</plugins>
	</build>
   ```
   Los comandos que más usaremos serán
   ```
   mvn flyway:clean
   mvn flyway:migrate
   ```
2. Una vez instalado STS, Lombok, editorconfig, haber añadido el fichero `.env` y haber instalado Docker procedemos a arrancar la infraestructura configurada en el fichero `docker-compose.yaml` con el comando 
   - Windows: ejecutar CMD como admin y ejecutar comando `docker compose up` 
   - Linux: `sudo docker compose up`
   Con esto levantamos la infraestructura necesaria para el desarrollo en local:
    - Postgres
    - Adminer
    - rabbitmq
    - netdata
3. Lo único que queda es arrancar la aplicación springboot de Malsin.

# URLS
Una vez levantada la infraestructura podemos acceder a las siguientes URLS:
- BD postgres: (172.168.0.10)
- Cliente BD Adminer: (http://localhost:8087/)
- Broker RabbitMq: (http://172.168.0.12:15672/)
- Dashboard NetData: (http://172.168.0.13:19999/) 

