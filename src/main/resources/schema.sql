DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS authors;

CREATE TABLE if not exists authors
(
    id         int          NOT NULL AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
    last_name  varchar(255) NOT NULL,
    email      varchar(255) NOT NULL,
    username   varchar(255) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE if not exists posts
(
    id           int          NOT NULL AUTO_INCREMENT,
    title        varchar(255) NOT NULL,
    content      TEXT         NOT NULL,
    published_on timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on   timestamp    NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    author    int          NOT NULL,
    FOREIGN KEY (author) REFERENCES authors (id),
    PRIMARY KEY (id)
);

