<!--
Vamos a desarrollar una red social de amantes de la fotografía. Nada más entrar en la web se 
mostrará un listado de miniaturas de las fotos que han subido todos los usuarios, junto al nombre 
del usuario autor y el número de likes que tiene cada una. Si quieres dar tu like a alguna foto o 
subir una foto a la web, debes iniciar sesión con un usuario registrado, para ello hay que incluir 
en la cabecera un enlace a una página de login donde podemos iniciar sesión con un usuario o 
registrar uno nuevo (solo el nombre, sin contraseña).  
Una vez iniciada la sesión con un usuario registrado, junto a cada imagen aparecerá un enlace 
para 'Dar like' a la misma, a no ser que el usuario ya lo haya hecho anteriormente, en cuyo caso, 
en vez del enlace debe aparecerá el texto 'Me gusta'. Al iniciar sesión también podemos pinchar 
en cualquier imagen del listado y se mostrará el detalle en otra página, con la imagen más grande 
(ancho de 400px) y listado de usuarios que le han dado like.  
En la cabecera de la página principal debe aparecer el nombre del usuario que ha iniciado sesión, 
y al pulsar sobre él, se abrirá una nueva página con las fotos que ha subido y un formulario para 
subir una nueva foto como autor, también debe haber un botón para poder cerrar sesión y otro 
para volver.  
Debemos tener 2 vistas asociadas al controlador de la página principal, una para usuarios 
registrados que han iniciado sesión y otra para usuarios no identificados, en la que no se puede 
interactuar con nada. 
 
Para poder desarrollar la aplicación se necesita una base de datos llamada 'fotografias' con 3 
tablas, 'usuarios' (id, nombre), 'fotos' (id, imagen, id_usuario) y 'likes'(id_foto, id_usuario). En la 
tabla fotos, el campo id_usuario corresponde a la clave del usuario autor de la misma. 
 
Servicio. 
Crear un servicio independiente sobre la base de datos fotografias que permita realizar las 
siguientes operaciones: 
- Consultar las fotos que tiene un determinado autor: la petición recibirá un parámetro con el 
nombre del autor y devolverá un JSON con objetos tipo ‘foto’, con las propiedades nombre 
(nombre del archivo sin la extensión), url (url absoluta de la imagen, http://...) y likes (numero 
de likes que tiene) 
- Modificar el autor de una imagen, para lo cual recibirá los parámetros ‘id_foto’ y ‘id_usuario’ 
en la cabecera de la petición, correspondientes al id de la imagen que se va a modificar y al id 
del nuevo usuario. 
 La cabecera de respuesta debe contener el código 200 si todo ha ido bien o un código de error 
(404 si alguno de los id no existe en la base de datos o no se encuentran fotos de un usuario y 
400 si no se envía el parámetro nombre), acompañado del mensaje descriptivo del error. 
Ubica el servicio dentro de una carpeta llamada ‘Servidor’ en la raíz del proyecto. No es necesario 
desarrollar un cliente para el servicio, se probará desde Postman. 
-->
<?php
// header('Location: Controller/redirect_controller.php');
header('Location: Controller/index_controller.php');
