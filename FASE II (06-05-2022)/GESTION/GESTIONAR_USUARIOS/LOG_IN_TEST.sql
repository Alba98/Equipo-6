-- LOG_IN_TEST
/* 
 Fecha: 17/05/2022
 Descripcion: test funcion para hacer login y conseguir el rol del usuario
*/

--usuario
SELECT log_in('alba@gmail.com', 'Hola') FROM dual;

--admin
SELECT log_in('admin@gmail.com', 'admin') FROM dual;

--error
SELECT log_in('admin@gmail.com', 'Hola') FROM dual;