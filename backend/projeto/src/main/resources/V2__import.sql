CREATE SEQUENCE modelo_sequence START WITH 1 INCREMENT BY 1;

INSERT INTO Modelo (id, name, email, cargo, ativo) 
VALUES (nextval('modelo_sequence'), 'Nome1', 'email1@example.com', 'Cargo1', true);

INSERT INTO Modelo (id, name, email, cargo, ativo) 
VALUES (nextval('modelo_sequence'), 'Nome2', 'email2@example.com', 'Cargo2', false);

INSERT INTO Modelo (id, name, email, cargo, ativo) 
VALUES (nextval('modelo_sequence'), 'Nome3', 'email3@example.com', 'Cargo3', true);
