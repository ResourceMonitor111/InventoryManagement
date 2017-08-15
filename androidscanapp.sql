DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS Bill_Of_Materials;
DROP TABLE IF EXISTS ShopTransaction;
DROP TABLE IF EXISTS Clerk;
DROP TABLE IF EXISTS ProductTransaction;
CREATE TABLE Product (
  product_id          INTEGER NOT NULL PRIMARY KEY, 
  barcode             char(13) NOT NULL,
  name                varchar(100) NOT NULL, 
  product_type        integer(10), 
  amount              integer(10) NOT NULL, 
  image               blob, 
  datetime_modified   timestamp NOT NULL, 
  Bill_Of_Materialsid integer(10) NOT NULL, 
  price               numeric(7, 2));
CREATE TABLE Bill_Of_Materials (
  id             INTEGER NOT NULL PRIMARY KEY, 
  amount_arrived integer(10) NOT NULL, 
  datetime_added timestamp NOT NULL, 
  delivered_by   varchar(255) NOT NULL, 
  contact_number integer(20) NOT NULL, 
  product_id     integer(10) NOT NULL, 
  FOREIGN KEY(product_id) REFERENCES Product(product_id));
CREATE TABLE ShopTransaction (
  _transaction_id  INTEGER NOT NULL PRIMARY KEY, 
  datetime_created timestamp NOT NULL, 
  Clerk_id         integer(10) NOT NULL, 
  FOREIGN KEY(Clerk_id) REFERENCES Clerk(Clerk_id));
CREATE TABLE Clerk (
  Clerk_id       INTEGER NOT NULL PRIMARY KEY, 
  firstname      varchar(255) NOT NULL, 
  lastname       varchar(50) NOT NULL, 
  contact_number integer(15), 
  email          varchar(150));
CREATE TABLE ProductTransaction (
  sold_amount    integer(10), 
  product_id     integer(10) NOT NULL, 
  transaction_id integer(10) NOT NULL, 
  PRIMARY KEY (product_id, 
  transaction_id), 
  FOREIGN KEY(product_id) REFERENCES Product(product_id), 
  FOREIGN KEY(transaction_id) REFERENCES ShopTransaction(_transaction_id));
CREATE INDEX Product_product_id 
  ON Product (product_id);
