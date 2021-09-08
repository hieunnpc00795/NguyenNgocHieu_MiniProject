use ministore;

INSERT INTO Categories VALUES('NATT', N'GIÀY THỂ THAO NAM');
INSERT INTO Categories VALUES('NASL', N'GIÀY SLIP ON');
INSERT INTO Categories VALUES('NAMO', N'GIÀY MỌI NAM');
INSERT INTO Categories VALUES('NABO', N'GIÀY BOOT NAM');
INSERT INTO Categories VALUES('NASD', N'SANDAL NAM');
INSERT INTO Categories VALUES('NADE', N'DÉP NAM');

INSERT INTO Products(Name,Image,Price,Active,Createdate,CategoryId) VALUES (N'Giày Thể Thao Nam MWC NATT - 5311','NATT-5311.jpg', 270000, 1, '2021-06-09', 'NATT');
INSERT INTO Products(Name,Image,Price,Active,Createdate,CategoryId) VALUES (N'Giày Thể Thao Nam MWC NATT - 5312','NATT-5312.jpg', 295000, 1, '2021-06-09', 'NATT');
INSERT INTO Products(Name,Image,Price,Active,Createdate,CategoryId) VALUES (N'Giày Thể Thao Nam MWC NATT - 5314','NATT-5314.jpg', 295000, 1, '2021-06-09', 'NATT');
INSERT INTO Products(Name,Image,Price,Active,Createdate,CategoryId) VALUES (N'Giày Thể Thao Nam MWC NATT - 5315','NATT-5315.jpg', 295000, 1, '2021-06-09', 'NATT');

INSERT INTO roles(id, name) VALUES('US', 'ROLE_USER');
INSERT INTO roles(id, name) VALUES('MOD', 'ROLE_MODERATOR');
INSERT INTO roles(id, name) VALUES('AD', 'ROLE_ADMIN');

INSERT INTO accounts VALUES('admin','1234',N'Nguyễn Văn A', 'hieunnpc00795@fpt.edu.vn');
INSERT INTO accounts VALUES('moderator','1234',N'Nguyễn Văn B', 'hieunnpc00795@fpt.edu.vn');
INSERT INTO accounts VALUES('NguyenNgocHieu','1234',N'Nguyễn Ngọc Hiếu', 'hieunnpc00795@fpt.edu.vn');

INSERT INTO Authorities(username, Roleid) VALUES('admin', 'AD');
INSERT INTO Authorities(username, Roleid) VALUES('moderator', 'MOD');
INSERT INTO Authorities(username, Roleid) VALUES('NguyenNgocHieu', 'US');