/**
 *
 * @author Peteris Caurs
 */
CREATE TABLE [product] (
    product_id INTEGER PRIMARY KEY,
    barcode TEXT NOT NULL,
    product_name TEXT NOT NULL,
    product_type INTEGER NOT NULL,
    amount INTEGER NOT NULL,
    image BLOB NOT NULL,
    datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    price DECIMAL NOT NULL,
    description TEXT NOT NULL
);

CREATE TABLE [bill_of_materials] (
    bill_of_materials_id INTEGER PRIMARY KEY,
    amount_arrived INTEGER NOT NULL,
    datetime_added TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delivered_by TEXT NOT NULL,
    contact_number INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    FOREIGN KEY(product_id) REFERENCES [product](product_id)
    ON DELETE CASCADE
);

CREATE TABLE [clerk] (
    clerk_id INTEGER NOT NULL PRIMARY KEY,
    firstname TEXT NOT NULL,
    lastname TEXT NOT NULL,
    contact_number INTEGER NOT NULL,
    email TEXT NOT NULL
);

CREATE TABLE [transaction] (
    transaction_id INTEGER NOT NULL PRIMARY KEY,
    datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    clerk_id INTEGER NOT NULL,
    FOREIGN KEY(clerk_id) REFERENCES [clerk](clerk_id)
    ON DELETE CASCADE
);

CREATE TABLE [product_transaction] (
    sold_amount INTEGER NOT NULL PRIMARY KEY,
    product_id INTEGER NOT NULL,
    transaction_id INTEGER NOT NULL,
    FOREIGN KEY(product_id) REFERENCES [product](product_id)
    FOREIGN KEY(transaction_id) REFERENCES [transaction](transaction_id)
    ON DELETE CASCADE
);