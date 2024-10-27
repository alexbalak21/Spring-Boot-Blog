DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS comments;
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
    FOREIGN KEY (author) REFERENCES authors (id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);

CREATE TABLE if not exists comments
(
    id           int          NOT NULL AUTO_INCREMENT,
    content      TEXT         NOT NULL,
    published_on timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on   timestamp    NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    post         int          NOT NULL,
    author       int          NOT NULL,
    FOREIGN KEY (post) REFERENCES posts (id) ON DELETE CASCADE,
    FOREIGN KEY (author) REFERENCES authors (id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);