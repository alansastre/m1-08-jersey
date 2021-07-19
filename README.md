

Proyecto:

1. Crear proyecto Jersey
2. POO: creando clases y aplicando herencia
3. Practicar patrones: Factory y Fachada: SmartDeviceFacade, SmartDeviceFactory
4. Practicar CRUD y lógica de negocio: interfaces y clases servicio




Funcionalidades de los frameworks:

* Enrutado HTTP
* Seguridad
* Logging
* Persistencia
* Inyección de dependencias / Control de inversión

## Proyecto API REST Spring - Jersey

0. Instalar extensión Spring Tools 4
1. Crear proyecto Spring Starter Project con las dependencias:
	* Jersey
	* Spring Boot Dev Tools
2. Crear estructura de paquetes: config, domain, rest, service
3. Crear clase de configuración jersey: JerseyConfig
4. Crear clases para paquete domain: 
	* Clase abstracta Vehicle
	* Clases hijas
	* Clases para asociaciones: piezas vehículos
5. Crear clases controlador:
	* HelloController para verificar que todo funciona correctamente desde POSTMAN
	* VehicleController para probar los patrones de diseño
	* Una clase controlador por cada tipo de vehículo: definir métodos CRUD
6. Patrones de diseño: Factory y Fachada
7. Interfaces servicio:
	* Una interfaz por cada tipo de vehículo, definiendo los métodos CRUD:
		* findOne
		* findAll
		* create / update (se pueden combinar en un mismo método save)
		* deleteOne
		* deleteAll
		* filtros
8. Implementación de interfaces servicio:
	* Crear una clase implementación por cada interfaz servicio
	* Emular base de datos utilizando una estructura de datos en Java (HashMap)
9. Crear colección de peticiones POSTMAN con las que probar los controladores
	* Exportar la colección e importarla en el proyecto
	
	
## Apache JMeter:

Herramienta para testing de rendimiento

(Ejecutar con Java 8)

https://jmeter.apache.org/download_jmeter.cgi

Dentro de la carpeta bin de apache jmeter:

C:\Users\alanj\.jdks\adopt-openjdk-1.8.0_292\bin\java -jar ApacheJMeter.jar

Pasos: 
		
1. Click derecho sobre el plan de pruebas --> agregamos Nuevo grupo de hilos
2. Click derecho sobre grupo hilos --> agregamos Muestreador --> Petición HTTP
3. Click drecho sobre Petición HTTP --> agregamos Receptor --> Árbol de resultados

En grupo de hilos poner 100 o 1000
Añadir URL a elemento Petición HTTP

	
## Katalon Studio

Testing de interfaz de usuario. Grabación de las navegaciones para ejecutarlas 
como casos de test.
		
		
		
		
		
		
