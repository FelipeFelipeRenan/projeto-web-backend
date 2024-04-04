-- Criação das tabelas (apenas se não existirem)
CREATE TABLE IF NOT EXISTS Daily (
    id BIGSERIAL PRIMARY KEY,
    date DATE,
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Participante (
    id BIGSERIAL PRIMARY KEY,
    ativo BOOLEAN NOT NULL,
    cargo VARCHAR(255),
    email VARCHAR(255),
    nome VARCHAR(255),
    pwd VARCHAR(255) -- Adicionei o campo senha para o Participante
);

CREATE TABLE IF NOT EXISTS Sprint (
    id BIGSERIAL PRIMARY KEY,
    endDate DATE,
    goal VARCHAR(255),
    name VARCHAR(255),
    startDate DATE -- Adicionei a coluna startDate
);

CREATE TABLE IF NOT EXISTS Squad (
    id BIGSERIAL PRIMARY KEY,
    sprint_id BIGINT,
    CONSTRAINT fk_squad_sprint FOREIGN KEY (sprint_id) REFERENCES Sprint(id)
);

CREATE TABLE IF NOT EXISTS Task (
    id BIGSERIAL PRIMARY KEY,
    availability VARCHAR(255) NOT NULL, -- Alterado para representar os estados Aberto, Disponível e Fechado
    completed BOOLEAN NOT NULL,
    description VARCHAR(255),
    dueDate DATE,
    title VARCHAR(255),
    priority VARCHAR(255), -- Adicionei o campo priority para Task
    daily_id BIGINT,
    CONSTRAINT fk_task_daily FOREIGN KEY (daily_id) REFERENCES Daily(id) ON DELETE CASCADE -- Adicionado ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS squad_participante (
    squad_id BIGINT NOT NULL,
    participante_id BIGINT NOT NULL,
    CONSTRAINT fk_squad_participante_squad FOREIGN KEY (squad_id) REFERENCES Squad(id) ON DELETE CASCADE, -- Adicionado ON DELETE CASCADE
    CONSTRAINT fk_squad_participante_participante FOREIGN KEY (participante_id) REFERENCES Participante(id) ON DELETE CASCADE -- Adicionado ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS participante_task (
    participante_id BIGINT NOT NULL,
    task_id BIGINT NOT NULL,
    CONSTRAINT fk_participante_task_participante FOREIGN KEY (participante_id) REFERENCES Participante(id) ON DELETE CASCADE, -- Adicionado ON DELETE CASCADE
    CONSTRAINT fk_participante_task_task FOREIGN KEY (task_id) REFERENCES Task(id) ON DELETE CASCADE -- Adicionado ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS sprint_squad (
    sprint_id BIGINT NOT NULL,
    squad_id BIGINT NOT NULL,
    CONSTRAINT fk_sprint_squad_sprint FOREIGN KEY (sprint_id) REFERENCES Sprint(id) ON DELETE CASCADE, -- Adicionado ON DELETE CASCADE
    CONSTRAINT fk_sprint_squad_squad FOREIGN KEY (squad_id) REFERENCES Squad(id) ON DELETE CASCADE -- Adicionado ON DELETE CASCADE
);

-- Inserção de dados fictícios (apenas se as tabelas estiverem criadas)
INSERT INTO Sprint (name, startDate, endDate, goal) VALUES
    ('Sprint 1', '2023-01-01', '2023-01-14', 'Concluir Desenvolvimento de Recursos Principais'),
    ('Sprint 2', '2023-01-15', '2023-01-28', 'Implementar Funcionalidades Adicionais'),
    ('Sprint 3', '2023-02-01', '2023-02-14', 'Realizar Testes e Correções'),
    ('Sprint 4', '2023-02-15', '2023-02-28', 'Preparar para Lançamento');

INSERT INTO Squad (sprint_id) VALUES
    (1),
    (1),
    (2),
    (3),
    (3),
    (4);

INSERT INTO Daily (date, description) VALUES
    ('2023-01-01', 'Reunião de planejamento da Sprint 1'),
    ('2023-01-02', 'Desenvolvimento da interface de usuário'),
    ('2023-01-03', 'Revisão de código e resolução de bugs'),
    ('2023-01-04', 'Testes de integração e aceitação de usuário');

-- Associação de participantes a squads
INSERT INTO Participante (nome, email, cargo, ativo, pwd) VALUES
    ('Maria Silva', 'maria.silva@email.com', 'Engenheira de Software', true, 'senha123'),
    ('João Oliveira', 'joao.oliveira@email.com', 'Analista de Qualidade', true, 'senha456'),
    ('Carla Pereira', 'carla.pereira@email.com', 'Gerente de Projetos', true, 'senha789'),
    ('Ricardo Souza', 'ricardo.souza@email.com', 'Desenvolvedor Frontend', true, 'senhaabc'),
    ('Fernanda Santos', 'fernanda.santos@email.com', 'Product Owner', true, 'senhaxyz'),
    ('Paulo Mendes', 'paulo.mendes@email.com', 'Desenvolvedor Backend', true, 'senha1234'),
    ('Juliana Costa', 'juliana.costa@email.com', 'Scrum Master', true, 'senha5678');

INSERT INTO squad_participante (squad_id, participante_id) VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (3, 4),
    (3, 5),
    (4, 6);

-- Associação de tasks a participantes
INSERT INTO Task (title, description, dueDate, completed, availability, daily_id, priority) VALUES
    ('Implementar Login', 'Implementar página de login com autenticação', '2023-01-01', true, 'Aberto', 1, 'Alta'),
    ('Desenvolver API REST', 'Construir endpoints RESTful para interação com o frontend', '2023-01-02', true, 'Disponível', 2, 'Média'),
    ('Testar Funcionalidades', 'Realizar testes de unidade e integração', '2023-01-03', false, 'Aberto', 3, 'Baixa'),
    ('Corrigir Bugs', 'Identificar e corrigir problemas no código', '2023-01-04', false, 'Disponível', 4, 'Alta');

INSERT INTO participante_task (participante_id, task_id) VALUES
    (1, 1), 
    (2, 2),
    (3, 3),
    (4, 4);

-- Alterações para adicionar cláusulas ON DELETE CASCADE nas chaves estrangeiras
ALTER TABLE squad_participante DROP CONSTRAINT IF EXISTS fk_squad_participante_participante;
ALTER TABLE squad_participante ADD CONSTRAINT fk_squad_participante_participante FOREIGN KEY (participante_id) REFERENCES Participante(id) ON DELETE CASCADE;

ALTER TABLE participante_task DROP CONSTRAINT IF EXISTS fk_participante_task_participante;
ALTER TABLE participante_task ADD CONSTRAINT fk_participante_task_participante FOREIGN KEY (participante_id) REFERENCES Participante(id) ON DELETE CASCADE;

ALTER TABLE participante_task DROP CONSTRAINT IF EXISTS fk_participante_task_task;
ALTER TABLE participante_task ADD CONSTRAINT fk_participante_task_task FOREIGN KEY (task_id) REFERENCES Task(id) ON DELETE CASCADE;
