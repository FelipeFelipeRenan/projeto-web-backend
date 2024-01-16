CREATE SEQUENCE modelo_sequence START WITH 1 INCREMENT BY 1;

INSERT INTO Modelo (id, name, email, cargo, ativo) 
VALUES (nextval('modelo_sequence'), 'Alice Silva', 'alice.silva@example.com', 'Gerente', true);

INSERT INTO Modelo (id, name, email, cargo, ativo) 
VALUES (nextval('modelo_sequence'), 'Bob Santos', 'bob.santos@example.com', 'Analista', false);

INSERT INTO Modelo (id, name, email, cargo, ativo) 
VALUES (nextval('modelo_sequence'), 'Carla Oliveira', 'carla.oliveira@example.com', 'Desenvolvedor', true);

INSERT INTO Modelo (id, name, email, cargo, ativo) 
VALUES (nextval('modelo_sequence'), 'David Lima', 'david.lima@example.com', 'Coordenador', false);

INSERT INTO Modelo (id, name, email, cargo, ativo) 
VALUES (nextval('modelo_sequence'), 'Eva Pereira', 'eva.pereira@example.com', 'Analista Sênior', true);

INSERT INTO Modelo (id, name, email, cargo, ativo) 
VALUES (nextval('modelo_sequence'), 'Fábio Rocha', 'fabio.rocha@example.com', 'Engenheiro de Software', false);

INSERT INTO Modelo (id, name, email, cargo, ativo) 
VALUES (nextval('modelo_sequence'), 'Gabriela Souza', 'gabriela.souza@example.com', 'Designer', true);

INSERT INTO Modelo (id, name, email, cargo, ativo) 
VALUES (nextval('modelo_sequence'), 'Hugo Costa', 'hugo.costa@example.com', 'Analista de Dados', false);

INSERT INTO Modelo (id, name, email, cargo, ativo) 
VALUES (nextval('modelo_sequence'), 'Isabela Martins', 'isabela.martins@example.com', 'Arquiteto de Software', true);

INSERT INTO Modelo (id, name, email, cargo, ativo) 
VALUES (nextval('modelo_sequence'), 'João Oliveira', 'joao.oliveira@example.com', 'Analista de Qualidade', false);
