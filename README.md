# MovieProject
Movie App


**1 - ¿Qué es el DataBinding?**  
Es una librería que nos permite enlazar los componentes de la interfaz de usuario con los layouts y de donde provienen los datos. De esta forma podemos mostrar la información en los layouts de forma declarativa.

**2 - ¿Qué son las corrutinas? ¿Y las funciones suspend?**  
Las corrutinas son un patrón de diseño que nos permite hacer llamadas asíncronas de forma más sencilla. Las funciones suspend son funciones que se pueden suspender o retomar siempre que se necesite sin bloqueos.

**3 - Tenemos una app que llama a varios servicios REST para obtener información de un usuario. El contrato de dicho servicio ha cambiado y ahora algunos parámetros nos llegan con un formato diferente. ¿Qué ventajas aporta la arquitectura de MVVM en este caso?**  
Dado que la capa de vista esta desacoplada de la capa de datos, esto hace que las aplicaciones con esta arquitectura sean más robustas frente a estos tipos de cambios. En este caso solo tendríamos que modificar el contrato en la capa de datos y ver si afecta a las entidades de la base de datos interna o a los objetos de dominio.

**4 - ¿Qué es un lateinit y en qué casos tiene sentido su uso?**  
Lateinit es un modificador que nos permite declarar una variable sin ser inicializada. Conviene usarla cuando se desea asignar el valor de dicha variable en otro momento y no se va a comprobar si es nula o no más tarde.
