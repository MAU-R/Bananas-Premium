SELECT * FROM bananas_premium.usuario;
use bananas_premium;
select empleador.nombre, det.id from usuario empleador inner join detalle_sucursal det on det.id_usuario=empleador.id where empleador.id=6;
select empleador.nombre, emp.nombre from usuario emp inner join detalle_sucursal det on det.id_usuario = emp.id  inner join usuario empleador on emp.id = det.id_usuario where emp.rol = "worker" and empleador.id = 6;
select empleador.nombre, emp.nombre from usuario empleador inner join detalle_sucursal det on det.id_usuario = empleador.id inner join usuario emp on emp.id= det.id_usuario and emp.rol = "worker" where det.id_sucursal=1;