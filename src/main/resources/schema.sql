CREATE table user(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(20) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    pseudo VARCHAR(50) NOT NULL,
    login VARCHAR (100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    sexe CHAR(1),
    type_compte VARCHAR(10),
    photo VARCHAR(255),
    date_naissance DATE,
    token VARCHAR(255),
    profile VARCHAR (20)
);
