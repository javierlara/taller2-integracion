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


- **taller-webapp** (*Capa Presentación*)

En el root de la carpeta, se compila con `mvn package`
Se genera el war en el directior `target`

- **Taller-integrado**

*Este proyecto tiene los WS de la capa Integración y de la Capa Seguridad y Sesión ya empaquetados en archivos axis2 .aar en la carpeta `WebContent / WEB-INF / services`*

En Eclipse:

File -> Import... -> General -> Existing Projects into Workspace

Una vez importado el proyecto, se debe exportarlo como war:

File -> Export... -> Web -> WAR File


Deploy en Tomcat
----------------------

Una vez que se tengan todos los war, copiarlos en `tomcat7/webapps/`
Y correr tomcat


**Probar integración en http://localhost:8080/taller-webapp/**

