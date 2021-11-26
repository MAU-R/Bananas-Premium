create database if not exists bananas_premium;
use bananas_premium;

create table if not exists Usuario(
id int not null auto_increment primary key,
nombre nvarchar(250) not null,
contraseña nvarchar(250) not null,
rol nvarchar(20) not null
);

create table if not exists Sucursal(
id int not null auto_increment primary key,
nombre nvarchar(250) not null,
ubicacion nvarchar(250) not null,
imagen nvarchar(50) not null
);

create table if not exists Helado(
id int not null auto_increment primary key,
nombre nvarchar(50) not null,
sabor nvarchar(50) not null,
imagen nvarchar(50) not null,
precio double not null,
existencia int not null default(0)
);

create table if not exists Compra(
id int not null auto_increment primary key,
fecha date not null,
monto_total double not null
);

create table if not exists Detalle_Sucursal(
id int not null auto_increment primary key,
id_usuario int not null ,
id_sucursal int not null ,
constraint foreign key (id_usuario) references Usuario(id),
constraint foreign key (id_sucursal) references Sucursal(id)
);

create table if not exists Detalle_Compra(
id int not null auto_increment primary key,
id_usuario int not null ,
id_sucursal int not null ,
id_compra int not null ,
id_helado int not null ,
cantidad int not null ,
foreign key (id_usuario) references Usuario(id),
foreign key (id_sucursal) references Sucursal(id),
foreign key (id_compra) references Compra(id),
foreign key (id_helado) references Helado(id)
);

insert into Usuario values(1,"banana-premium","4152","Admin");
select * from usuario;

insert into helado values(1,"Helado de limon","limon","https://www.heladosrevuelta.es/wp-content/uploads/2019/04/sjxhry1gqxy.jpg",25.00,1);

