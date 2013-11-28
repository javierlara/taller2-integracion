taller2-integracion
===================

Configuración Axis2
--------------------

Ver http://sourceforge.net/p/redsocialeducativataller22013/code-0/HEAD/tree/Grupos/Persistencia/Integracion/ hasta paso 4 inclusive.


Compilación proyectos
--------------------

- **rsedatos** (*WS de la capa DATOS*)

Para la compilación de este proyecto, importarlo en eclipse y exportarlo como war o ver:

http://sourceforge.net/p/redsocialeducativataller22013/code-0/HEAD/tree/Grupos/Persistencia/Datos/trunk/

También con ant en el root del proyecto: `ant war`


- **taller-webapp** (*Capa Presentación*)

En el root de la carpeta, se compila con `mvn package`
Se genera el war en el directior `target`

- **Taller-integrado**

*Este proyecto tiene los WS de la capa Integración y de la Capa Seguridad y Sesión ya empaquetados en archivos axis2 .aar en la carpeta `WebContent / WEB-INF / services`*

En Eclipse:

File -> Import... -> General -> Existing Projects into Workspace

Una vez importado el proyecto, se debe exportarlo como war:

File -> Export... -> Web -> WAR File

Ant:

En el root del proyecto: `ant war`

- **fiuba.taller2.elprimero** (*Capa Usuario*)

Instalar node

`sudo apt-get install nodejs`

Para correr la app 

Primero correr (por unica vez) para obtener las dependencias

`npm install`

Para levantar el server (lo hace en el puerto 5000)

`node web.js`

Deploy en Tomcat
----------------------

Una vez que se tengan todos los war, copiarlos en `tomcat7/webapps/`
Y correr tomcat y el proyecto de fiuba.taller2.elprimero


**Probar integración en http://localhost:5000**

