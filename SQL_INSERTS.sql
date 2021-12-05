SELECT * FROM bananas_premium.helado;
use bananas_premium;
insert into helado(nombre, sabor,imagen,precio,existencia)values
("Classic premium Lemon ice cream","Lemon","https://cdn1.cocina-familiar.com/recetas/helado-de-limon-casero-en-30-minutos.JPG",4.99,7),
("Classic premium Strawberry ice cream","Strawberry","https://misrecetascocina.es/wp-content/uploads/2018/07/helado-fresa-thermomix-800x485.jpg",4.99,10),
("Classic premium Oreo ice cream","OREO","https://i0.wp.com/www.lemonylimon.es/wp-content/uploads/2014/06/DSC_0046.jpeg?fit=1280%2C848&ssl=1",4.99,8),
("Classic premium Chocolate ice cream","Chocolate","http://www.recetasya.com/wp-content/uploads/2012/07/helado-de-chocolate-casero.2jpg.jpg",4.99,3);

insert into usuario(nombre,contraseña,rol)values
("banana-premium","4152","owner"),
("banana-admin","1234","admin"),
("banana-worker","4321","worker"),
("banan-worker-2","6789","worker"),
("banana-manager","9876","admin")
;
select * from detalle_sucursal;
insert into sucursal(nombre, ubicacion,imagen)values
("Vancouber shop","vancouber","http://3.bp.blogspot.com/-hCK4AEopfNM/U3ofb5Hk6NI/AAAAAAAAkJ4/YLEWfcFP_o0/s1600/01+The+Ice+Cream+Shop+@+Simpang+Bedok+[Singapore]+(Large).JPG"),
("Dallas Center","Dallas", "https://d2j8c2rj2f9b78.cloudfront.net/uploads/10-charlotte-ice-cream-shops/content/Jenis-Ice-Cream-4.JPG");
insert into detalle_sucursal(id_usuario, id_sucursal)values
(6,1),
(7,1),
(8,1);
insert into compra(monto_total)values(20.25),(9.99);
insert into detalle_compra(id_sucursal,id_compra,id_helado,cantidad)values
(1,1,4,2),
(1,1,5,2),
(1,2,6,1),
(1,2,5,1);