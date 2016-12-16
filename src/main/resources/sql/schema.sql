CREATE TABLE Spittle
(
    id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    message VARCHAR(140) NOT NULL,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    latitude DOUBLE,
    longitude DOUBLE
);

CREATE TABLE Spitter
(
    id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL
);
CREATE UNIQUE INDEX username ON Spitter (username);