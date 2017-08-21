* SQLite database file scanerist_db must be copied into assets folder

* Change DataBaseHelper DB_PATH String to /data/data/YOUR.PACKAGE.NAME/

* Before invoking insertProduct(), getAllProducts() or database query methods,
  call the openDataBase() method! When done - close()