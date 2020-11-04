CREATE TABLE abaco.USERS (
id_user INT auto_increment PRIMARY KEY,
name VARCHAR(100) NULL,
surname VARCHAR(100) NULL,
email VARCHAR(100) NOT NULL,
password VARCHAR(255) NOT NULL,
porcent_payment_personal INT NULL,
porcent_payment_permanent INT NULL,
porcent_saving INT NULL,
UNIQUE INDEX `id_user_UNIQUE` (id_user ASC));

CREATE TABLE abaco.CATEGORY (
id_category INT auto_increment PRIMARY KEY,
description VARCHAR(100) NULL,
type INT NULL,
nature INT NULL,
porcent_saving INT NULL,
id_user INT NOT NULL,
FOREIGN KEY (id_user) REFERENCES USERS(id_user),
UNIQUE INDEX `id_category_UNIQUE` (id_category ASC));

CREATE TABLE abaco.PAYMENT (
id_payment INT auto_increment PRIMARY KEY,
description VARCHAR(100) NULL,
period VARCHAR(6) NULL,
quantity decimal(2) NULL,
id_category INT NOT NULL,
id_user INT NOT NULL,
FOREIGN KEY (id_category) REFERENCES CATEGORY(id_category),
FOREIGN KEY (id_user) REFERENCES USERS(id_user),
UNIQUE INDEX `id_payment` (id_payment ASC));