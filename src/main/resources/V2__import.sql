-- Criação da tabela Participante
CREATE TABLE participante (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    cargo VARCHAR(255) NOT NULL,
    ativo BOOLEAN NOT NULL
);

-- Criação da tabela Sprint
CREATE TABLE sprint (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL
);

-- Criação da tabela Daily
CREATE TABLE daily (
    id SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    observacao TEXT,
    participante_id INTEGER REFERENCES participante(id),
    sprint_id INTEGER REFERENCES sprint(id)
);

-- Criação da tabela Task
CREATE TABLE task (
    id SERIAL PRIMARY KEY,
    descricao TEXT NOT NULL
);

-- Criação da tabela de relacionamento muitos-para-muitos entre Participante e Sprint
CREATE TABLE participante_sprint (
    participante_id INTEGER REFERENCES participante(id),
    sprint_id INTEGER REFERENCES sprint(id),
    PRIMARY KEY (participante_id, sprint_id)
);

-- Criação da tabela de relacionamento muitos-para-muitos entre Participante e Task
CREATE TABLE participante_task (
    participante_id INTEGER REFERENCES participante(id),
    task_id INTEGER REFERENCES task(id),
    PRIMARY KEY (participante_id, task_id)
);

-- Inserção de dados fictícios

-- Participantes fictícios
INSERT INTO participante (nome, email, cargo, ativo) VALUES
    ('João', 'joao@email.com', 'Desenvolvedor', true),
    ('Maria', 'maria@email.com', 'Testador', true),
    ('Carlos', 'carlos@email.com', 'Gerente de Projeto', true);

-- Sprints fictícias
INSERT INTO sprint (nome, data_inicio, data_fim) VALUES
    ('Sprint 1', '2023-01-01', '2023-01-15'),
    ('Sprint 2', '2023-01-16', '2023-01-31'),
    ('Sprint 3', '2023-02-01', '2023-02-15');

-- Dailys fictícias
INSERT INTO daily (data, observacao, participante_id, sprint_id) VALUES
    ('2023-01-02', 'Trabalhando em feature X', 1, 1),
    ('2023-01-03', 'Corrigindo bugs', 2, 1),
    ('2023-01-16', 'Revisão de código', 1, 2);

-- Tasks fictícias
INSERT INTO task (descricao) VALUES
    ('Implementar autenticação'),
    ('Criar interface de usuário'),
    ('Testar funcionalidades');

-- Relacionamento entre participantes e sprints
INSERT INTO participante_sprint (participante_id, sprint_id) VALUES
    (1, 1),
    (2, 1),
    (1, 2),
    (3, 3);

-- Relacionamento entre participantes e tasks
INSERT INTO participante_task (participante_id, task_id) VALUES
    (1, 1),
    (2, 2),
    (3, 3);
