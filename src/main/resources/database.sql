CREATE DATABASE sugar_rush;
USE sugar_rush;
DROP TABLE article;
CREATE TABLE article (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    is_main BOOLEAN NOT NULL,
    title VARCHAR(500),
    slug VARCHAR(500),
    publication_date datetime,
    modification_date datetime,
    lead_ VARCHAR(500),
    content VARCHAR(8000),
    publication_image VARCHAR(500),
    author VARCHAR(500),
    categories VARCHAR(500)
);