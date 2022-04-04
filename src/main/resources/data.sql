CREATE TABLE users (
    user_id INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    login varchar(50) not null,
    password varchar(50) not null,
    role varchar(15) not null
);

INSERT INTO users (login, password, role) VALUES ('seller', 'seller123', 'Selller');
INSERT INTO users (login, password, role) VALUES ('manager', 'manager123', 'Manager');