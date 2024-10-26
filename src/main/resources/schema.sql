CREATE TABLE if not exists posts (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    content TEXT NOT NULL,
    published_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);
