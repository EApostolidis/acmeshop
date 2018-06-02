insert into users (username, password, email, role) values ('paris', 'paris', 'parisk85@gmail.com', 'ADMIN');

insert into categories (name, description) values ('Motherboard', 'motherboards category');
insert into categories (name, description) values ('CPU', 'cpu category');
insert into categories (name, description) values ('HDD/SSD', 'HDD/SSD category');
insert into categories (name, description) values ('RAM', 'RAM category');
insert into categories (name, description) values ('GPU', 'GPU category');
insert into categories (name, description) values ('Cases', 'cases category');
insert into categories (name, description) values ('PSU', 'PSU category');

insert into products (name, category_id, quantity) values ('Intel i5 8600K', 2 ,1);
insert into products (name, category_id, quantity) values ('Intel i5 8400', 2 , 1);
insert into products (name, category_id, quantity) values ('Asus GTX 1080Ti', 5 , 1);

insert into stocks  (prod_id, quantity) values (1, 5);
insert into stocks  (prod_id, quantity) values (2, 3);
insert into stocks  (prod_id, quantity) values (3, 2);