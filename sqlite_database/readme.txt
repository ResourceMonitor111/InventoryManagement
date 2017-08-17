Added brackets to table name due to reserved words, 
all fields are NOT NULL, 
'datetime' fields are CURRENT_TIMESTAMP by default, 
removed unnecessary field from 'product' table, 
improved naming convention,
enabled foreign key support, 
added ON DELETE CASCADE so that each row in the child table 
that was associated with the deleted parent row is also deleted