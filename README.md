# servlet-spring-boot-example

This project has an example of a servlet and it connects to MariaDb and fetchs data from the table 'books'.

## steps to set up MariaDB locally

Instructions are for MAC users. Please refer the official site of MariaDB if you are using another OS.

1. `brew install mariadb`
2. `mysql.server start`
3. `brew services start mariadb`
4. `sudo mysql -u root`
5. To check the DB's available by default `Show databases;`
6. To create a new DB 'CREATE DATABASE `database_name`;`
7. To create a new user `CREATE USER 'user_name' IDENTIFIED BY 'a_secure_password';`
8. To Grant all privileges on new DB   `database_name.* to ‘user_name’@‘localhost' identified by ‘a_secure_password’;`
9. To flush privileges `FLUSH PRIVILEGES;`
10. Now you can exit out and login without being super user. `mysql -u user_name -p`

11. To switch to your db `use testdb;`
12. To create a new table. 

    `CREATE TABLE books(book_id Integer NOT NULL, book_name VARCHAR(100) NOT NULL);`
13. To show all the tables in the DB 
   
    `show tables;`
14. Inserting data 

    `INSERT INTO books(book_id, book_name) VALUES (1, "shoe dog");
     INSERT INTO books(book_id, book_name) VALUES (2, “War on normal people”);`

## Steps to run the project 

1. Clone the repo.
2. Execute the below command from the project directory 
   
   `mvn sprong-boot:run`
3. Invoke the below GET service from your browser or any other client. The response should display the row count and data in the books table. 

   `http://localhost:8080/fetch`
