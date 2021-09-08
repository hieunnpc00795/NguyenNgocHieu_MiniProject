create database MiniStore;
use ministore;

create table accounts(
 Username varchar(20) NOT NULL PRIMARY KEY,
 Password varchar(120) not null,
 Fullname nvarchar(50) not null,
 Email varchar(50) not null
);

create table roles(
 Id varchar(10) NOT NULL PRIMARY KEY,
 Name varchar(20) not null
);

create table Authorities(
	Id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	Username varchar(20),
	Roleid varchar(10),
	Foreign key(Username) references accounts(Username),
	Foreign key(Roleid) references Roles(Id)
);

CREATE TABLE Categories(
	Id char(4) not null PRIMARY KEY,
	Name nvarchar(50) not null
);

CREATE TABLE Products(
	Id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	Name nvarchar(100) not null,
	Image nvarchar(100) not null,
	Price float not null,
	Active bit not null,
	Createdate date not null,
	CategoryId char(4) not null,
	Foreign key(CategoryId) references Categories(Id)
);

CREATE TABLE Orders(
	Id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	Username varchar(20) not null,
	Createdate date not null,
	Address nvarchar(200) not null,
	Foreign key(Username) references Accounts(Username)
);

CREATE TABLE OrderDetails(
	Id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	OrderId int(11) not null,
	ProductId int(11) not null,
	Price float not null,
	Quantity int not null,
	Foreign key(OrderId) references Orders(Id),
	Foreign key(ProductId) references Products(Id)
);