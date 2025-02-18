-- drop the database if exists
DROP DATABASE IF EXISTS project;

-- create the database
-- create database if not exists project; -- already have drop database if exists
CREATE DATABASE project;

-- select the database
USE project;

-- create one or more tables
-- select "Creating users table..." as msg; // cmdline
SELECT "CREATING USERS...";
CREATE TABLE users (
    id INT AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL, -- this is the PK
    password VARCHAR(255) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    role ENUM('USER', 'ADMIN') DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

    constraint pk_id primary key(id)
);

-- Grant fred access to the DB
SELECT "GRANTING ALL PRIVILEGES TO FRED..";
GRANT ALL PRIVILEGES ON project.* TO 'fred'@'%';

-- Apply changes to privileges
FLUSH PRIVILEGES;





