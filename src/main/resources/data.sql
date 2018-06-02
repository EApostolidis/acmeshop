insert into users (username, password, email, role) values ('paris', 'paris', 'parisk85@gmail.com', 'ADMIN');
insert into users (username, password, email, role) values ('vagelis', 'vagelis', 'vagelis@gmail.com', 'USER');
insert into users (username, password, email, role) values ('panos', 'panos', 'panos@gmail.com', 'USER');

insert into categories (name, description) values ('Motherboard', 'motherboards category');
insert into categories (name, description) values ('CPU', 'cpu category');
insert into categories (name, description) values ('HDD/SSD', 'HDD/SSD category');
insert into categories (name, description) values ('RAM', 'RAM category');
insert into categories (name, description) values ('GPU', 'GPU category');
insert into categories (name, description) values ('Cases', 'cases category');
insert into categories (name, description) values ('PSU', 'PSU category');

insert into products (name,quantity,category_id) values ('Intel i5 8600K',2, 2);
insert into products (name,quantity, category_id) values ('Intel i5 8400',1, 2);
insert into products (name,quantity, category_id) values ('Asus GTX 1080Ti',3, 5);

insert into stocks  (prod_id, quantity) values (1, 5);
insert into stocks  (prod_id, quantity) values (2, 3);
insert into stocks  (prod_id, quantity) values (3, 2);