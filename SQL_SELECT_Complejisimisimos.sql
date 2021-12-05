SELECT * FROM bananas_premium.usuario;
use bananas_premium;
select empleador.nombre, det.id from usuario empleador inner join detalle_sucursal det on det.id_usuario=empleador.id where empleador.id=6;
##consulta para obtener sucursales por manager ****Verificado***
select empleador.nombre manager, empleador.id id_manager, empleador.rol, sucursal.nombre sucursal, sucursal.id id_de_sucursal, sucursal.imagen, sucursal.ubicacion from usuario empleador inner join detalle_sucursal det on det.id_usuario = empleador.id inner join sucursal on sucursal.id=det.id_sucursal where empleador.id = 6;
#Consulta para obtener empleados por manager ****Verificado***
select emp.id, emp.nombre, emp.contraseña,emp.rol  from usuario emp inner join detalle_sucursal det on det.id_usuario = emp.id  inner join usuario empleador on emp.id = det.id_usuario where emp.rol = "worker" and empleador.id = 6;
#obtener todo, creo ****Prueba***
select * from usuario emp inner join detalle_sucursal det on det.id_usuario = emp.id  inner join usuario empleador on emp.id = det.id_usuario where emp.rol = "worker" and empleador.id = 6;
#consulta que posiblemente no sirva
select empleador.nombre, emp.nombre from usuario empleador inner join detalle_sucursal det on det.id_usuario = empleador.id inner join usuario emp on emp.id= det.id_usuario and emp.rol = "worker" where det.id_sucursal=1;
#Consulta para las compras
select helado.sabor ,compra.fecha, compra.monto_total from detalle_compra detalle inner join helado on helado.id=detalle.id_helado inner join compra on compra.id = detalle.id_compra where detalle.id_sucursal=1;