
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-------------------------
--  BORRADO DE TABLAS  --
-------------------------
DROP TABLE IF EXISTS HISTORICO_PETICIONES;
DROP TABLE IF EXISTS HISTORICO_PETICIONES_REL_REDES;
DROP TABLE IF EXISTS PETICIONES_REL_CUENTAS;
DROP TABLE IF EXISTS PETICIONES;
DROP TABLE IF EXISTS CATEGORIAS;
DROP TABLE IF EXISTS CUENTAS;
DROP TABLE IF EXISTS ESTADOS;
DROP TABLE IF EXISTS REDES;
DROP TABLE IF EXISTS UBICACIONES;


-------------------------
--   TABLAS MAESTRAS  --
-------------------------

-- redes
CREATE TABLE redes(
	id SERIAL NOT NULL,
	nick VARCHAR(50) NOT NULL,
	red_social VARCHAR(20) UNIQUE NOT NULL , 
	descripcion VARCHAR(200) NOT NULL,
	CONSTRAINT pk_redes PRIMARY KEY (id)
);
COMMENT ON TABLE redes IS 'Redes sociales que usa Malsin para hacer las publicaciones';
COMMENT ON COLUMN redes.nick IS 'Nombre de usuario en la red social';
COMMENT ON COLUMN redes.red_social IS 'Nombre de la red social';
COMMENT ON COLUMN redes.descripcion IS 'Descripción de la red social';

INSERT INTO redes (nick, red_social, descripcion) VALUES('malsin', 'twitter', 'Esta red social es usada por organismos públicos, presidentes y mediante este medio se realizan comunicaciones oficiales.');


-- estados
CREATE TABLE estados(
	id SERIAL NOT NULL,
	nombre VARCHAR(10) NOT NULL,
	CONSTRAINT pk_estados PRIMARY KEY (id)
);
COMMENT ON TABLE estados IS 'Estados por los que puede pasar una petición.';
COMMENT ON COLUMN estados.id IS 'Identificador único';
COMMENT ON COLUMN estados.nombre IS 'Nombre descriptivo del estado';

INSERT INTO estados (nombre) VALUES('Recibida');
INSERT INTO estados (nombre) VALUES('Enviada');
INSERT INTO estados (nombre) VALUES('Procesando');
INSERT INTO estados (nombre) VALUES('Rechazada');
INSERT INTO estados (nombre) VALUES('Procesada');


-- categorias
CREATE TABLE categorias(
	id SERIAL NOT NULL,
	descripcion VARCHAR(200) NOT NULL,
	CONSTRAINT pk_categorias PRIMARY KEY (id)
);
COMMENT ON TABLE categorias IS 'Categorías clasificatorias de las incidencias reportadas';
COMMENT ON COLUMN categorias.id IS 'Identificador único';

INSERT INTO categorias (descripcion) VALUES ('General');

-------------------------
--       TABLAS       --
-------------------------

-- peticiones
CREATE TABLE peticiones(
	id SERIAL NOT NULL,
	descripcion VARCHAR(280),
	fecha_peticion TIMESTAMP NOT NULL,
	multimedia VARCHAR(100) NOT NULL,
	ubicacion INTEGER NOT NULL,
	categoria INTEGER NOT NULL,
	CONSTRAINT pk_peticions PRIMARY KEY (id)
);
COMMENT ON TABLE peticiones IS 'Listado de peticiones recibidas';
COMMENT ON COLUMN peticiones.id IS 'Identificador único';
COMMENT ON COLUMN peticiones.descripcion IS 'Descripción de la petición reportada';
COMMENT ON COLUMN peticiones.fecha_peticion IS 'Fecha de registro de petición';
COMMENT ON COLUMN peticiones.multimedia IS 'Identificador del contenido multimedia asociado a la petición';
COMMENT ON COLUMN peticiones.ubicacion IS 'Identificador de los datos de ubicación de la incidencia reportada';
COMMENT ON COLUMN peticiones.categoria IS 'Categoría a la que pertenece la incidencia';

-- historico_peticiones
CREATE TABLE historico_peticiones(
	id SERIAL NOT NULL,
	id_peticion INTEGER NOT NULL,
	id_estado INTEGER NOT NULL,
	CONSTRAINT pk_historico_peticiones PRIMARY KEY (id)
);
COMMENT ON TABLE historico_peticiones IS 'Histórico por el que pasa una petición';
COMMENT ON COLUMN historico_peticiones.id_peticion IS 'Id petición';
COMMENT ON COLUMN historico_peticiones.id_estado IS 'Id estado';

-- ubicaciones
CREATE TABLE ubicaciones(
	id SERIAL NOT NULL,
	latitud VARCHAR(100) NOT NULL,
	longitud VARCHAR(100) NOT NULL,
	altitud VARCHAR(100) NOT NULL,
	tipo_via VARCHAR(30) NOT NULL,
	numero VARCHAR(10),
	piso VARCHAR(10),
	puerta VARCHAR(10),
	CONSTRAINT pk_ubicaciones PRIMARY KEY (id)
);
COMMENT ON TABLE ubicaciones IS 'Listado de ubicaciones donde se encuentran las incidencias reportadas';
COMMENT ON COLUMN ubicaciones.id IS 'Id único';
COMMENT ON COLUMN ubicaciones.latitud IS 'Eje del Ecuador';
COMMENT ON COLUMN ubicaciones.longitud IS 'Eje de Grenwich';
COMMENT ON COLUMN ubicaciones.altitud IS 'Altura sobre el nivel del mar';
COMMENT ON COLUMN ubicaciones.tipo_via IS 'Tipo de vía';
COMMENT ON COLUMN ubicaciones.numero IS 'Número, portal del lugar de la incidencia';
COMMENT ON COLUMN ubicaciones.piso IS 'Piso en el que sucede la incidencia';
COMMENT ON COLUMN ubicaciones.puerta IS 'Puerta en la que sucede la incidencia';

-- cuentas
CREATE TABLE cuentas(
	id VARCHAR(50) NOT NULL DEFAULT uuid_generate_v4(),
	fecha_alta TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT pk_cuentas PRIMARY KEY (id)
);
COMMENT ON TABLE cuentas IS 'Cuentas de usuarios';
COMMENT ON COLUMN cuentas.id IS 'Id único';
COMMENT ON COLUMN cuentas.fecha_alta IS 'Fecha de alta registro';

-------------------------
-- TABLAS DE RELACIÓN  --
-------------------------

-- historico_peticiones_rel_redes
CREATE TABLE historico_peticiones_rel_redes(
	id_historico_peticion INTEGER NOT NULL,
	id_red INTEGER NOT NULL,
	fecha_peticion TIMESTAMP,
	CONSTRAINT pk_historico_peticiones_rel_redes PRIMARY KEY (id_historico_peticion, id_red)
);
COMMENT ON TABLE historico_peticiones_rel_redes IS 'Listado de peticiones y redes sociales en las que se publican dicjas peticiones';
COMMENT ON COLUMN historico_peticiones_rel_redes.id_historico_peticion IS 'Id del histórico de petición';
COMMENT ON COLUMN historico_peticiones_rel_redes.id_red IS 'Id de la red';
COMMENT ON COLUMN historico_peticiones_rel_redes.fecha_peticion IS 'Fecha en la que se realiza la petición';

-- peticiones_rel_cuentas
CREATE TABLE peticiones_rel_cuentas(
	id_peticion INTEGER NOT NULL,
	id_cuenta VARCHAR(50) NOT NULL,
	fecha_peticion TIMESTAMP NOT NULL,
	CONSTRAINT pk_peticiones_rel_cuentas PRIMARY KEY (id_peticion, id_cuenta)
);
COMMENT ON TABLE peticiones_rel_cuentas IS 'Listado de peticiones y cuentas en desde las que se hja reportado dicha peticion';
COMMENT ON COLUMN peticiones_rel_cuentas.id_peticion IS 'Id de petición';
COMMENT ON COLUMN peticiones_rel_cuentas.id_cuenta IS 'Cuenta desde la que se ha reportado la petición';
COMMENT ON COLUMN peticiones_rel_cuentas.fecha_peticion IS 'Fecha en la que se realizó el alta del registro';


-------------------------
-- RELACION DE TABLAS  --
-------------------------

-- peticiones
ALTER TABLE peticiones 
	ADD CONSTRAINT fk_peticiones_ubicaciones FOREIGN KEY (ubicacion) REFERENCES ubicaciones (id);


-- historico_peticiones
ALTER TABLE historico_peticiones
	ADD CONSTRAINT fk_histotico_peticiones_estados FOREIGN KEY (id_estado) REFERENCES estados (id),
	ADD CONSTRAINT fk_histotico_peticiones_peticiones FOREIGN KEY (id_peticion) REFERENCES peticiones (id);


-- peticiones_rel_cuentas
ALTER TABLE peticiones_rel_cuentas 
	ADD CONSTRAINT fk_peticiones_rel_cuentas_cuentas FOREIGN KEY (id_cuenta) REFERENCES cuentas (id),
	ADD CONSTRAINT fk_peticiones_rel_cuentas_peticiones FOREIGN KEY (id_peticion) REFERENCES peticiones (id);


-- historico_peticiones_rel_cuentas
ALTER TABLE historico_peticiones_rel_redes
	ADD CONSTRAINT fk_historico_peticiones_rel_redes_historico_peticiones FOREIGN KEY (id_historico_peticion) REFERENCES peticiones (id),
	ADD CONSTRAINT fk_historico_peticiones_rel_redes_redes FOREIGN KEY (id_red) REFERENCES redes (id);

