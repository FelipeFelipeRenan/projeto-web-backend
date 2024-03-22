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
    nome VARCHAR(255)
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
    available BOOLEAN NOT NULL,
    completed BOOLEAN NOT NULL,
    description VARCHAR(255),
    dueDate DATE,
    title VARCHAR(255),
    daily_id BIGINT,
    CONSTRAINT fk_task_daily FOREIGN KEY (daily_id) REFERENCES Daily(id)
);

CREATE TABLE IF NOT EXISTS daily_participante (
    participante_id BIGINT NOT NULL,
    daily_id BIGINT NOT NULL,
    CONSTRAINT fk_daily_participante_participante FOREIGN KEY (participante_id) REFERENCES Participante(id),
    CONSTRAINT fk_daily_participante_daily FOREIGN KEY (daily_id) REFERENCES Daily(id)
);

CREATE TABLE IF NOT EXISTS participante_task (
    participante_id BIGINT NOT NULL,
    task_id BIGINT NOT NULL,
    CONSTRAINT fk_participante_task_participante FOREIGN KEY (participante_id) REFERENCES Participante(id),
    CONSTRAINT fk_participante_task_task FOREIGN KEY (task_id) REFERENCES Task(id)
);

CREATE TABLE IF NOT EXISTS sprint_participante (
    sprint_id BIGINT NOT NULL,
    participante_id BIGINT NOT NULL,
    CONSTRAINT fk_sprint_participante_sprint FOREIGN KEY (sprint_id) REFERENCES Sprint(id),
    CONSTRAINT fk_sprint_participante_participante FOREIGN KEY (participante_id) REFERENCES Participante(id)
);

CREATE TABLE IF NOT EXISTS squad_participante (
    squad_id BIGINT NOT NULL,
    participante_id BIGINT NOT NULL,
    CONSTRAINT fk_squad_participante_squad FOREIGN KEY (squad_id) REFERENCES Squad(id),
    CONSTRAINT fk_squad_participante_participante FOREIGN KEY (participante_id) REFERENCES Participante(id)
);

-- Inserção de dados fictícios (apenas se as tabelas estiverem criadas)
INSERT INTO Participante (nome, email, cargo, ativo) VALUES
    ('Maria Silva', 'maria.silva@email.com', 'Engenheira de Software', true),
    ('João Oliveira', 'joao.oliveira@email.com', 'Analista de Qualidade', true),
    ('Carla Pereira', 'carla.pereira@email.com', 'Gerente de Projetos', true),
    ('Ricardo Souza', 'ricardo.souza@email.com', 'Desenvolvedor Frontend', true),
    ('Fernanda Santos', 'fernanda.santos@email.com', 'Product Owner', true);

INSERT INTO Sprint (name, startDate, endDate, goal) VALUES
    ('Sprint 1', '2023-01-01', '2023-01-14', 'Concluir Desenvolvimento de Recursos Principais'),
    ('Sprint 2', '2023-01-15', '2023-01-28', 'Implementar Funcionalidades Adicionais'),
    ('Sprint 3', '2023-02-01', '2023-02-14', 'Realizar Testes e Correções'),
    ('Sprint 4', '2023-02-15', '2023-02-28', 'Preparar para Lançamento');

INSERT INTO Squad (sprint_id) VALUES
    (1),
    (2),
    (3),
    (4);

INSERT INTO Daily (date, description) VALUES
    ('2023-01-01', 'Reunião de planejamento da Sprint 1'),
    ('2023-01-02', 'Desenvolvimento da interface de usuário'),
    ('2023-01-03', 'Revisão de código e resolução de bugs'),
    ('2023-01-04', 'Testes de integração e aceitação de usuário');

INSERT INTO Task (title, description, dueDate, completed, available, daily_id) VALUES
    ('Implementar Login', 'Implementar página de login com autenticação', '2023-01-01', true, true, 1),
    ('Desenvolver API REST', 'Construir endpoints RESTful para interação com o frontend', '2023-01-02', true, true, 2),
    ('Testar Funcionalidades', 'Realizar testes de unidade e integração', '2023-01-03', false, true, 3),
    ('Corrigir Bugs', 'Identificar e corrigir problemas no código', '2023-01-04', false, true, 4);

-- Fim da migration
