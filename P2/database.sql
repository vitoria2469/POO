CREATE DATABASE cadastrodb;

USE cadastrodb;

CREATE TABLE funcionario ( 
    id INT AUTO_INCREMENT,
    nome VARCHAR(100),
    cpf VARCHAR(11),
    email VARCHAR(100),
    telefone CHAR(30),
    sexo CHAR(2),
    endereco VARCHAR(200),
    cargo VARCHAR(100),
    setor VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE medico ( 
    id INT AUTO_INCREMENT,
    nome VARCHAR(100),
    cpf VARCHAR(11),
    email VARCHAR(100),
    telefone CHAR(30),
    sexo CHAR(2),
    endereco VARCHAR(200),
    especialidade VARCHAR(100),
    setor VARCHAR(50),
    crm VARCHAR(22),
    PRIMARY KEY (id)
);

INSERT INTO funcionario (nome, cpf, email, telefone, sexo, endereco, cargo, setor) 
 VALUES ('Joao Silva', '555.333.777-13', 'joao@teste.com', '(11) 1111-1111', 'M', 'Rua ABC', 'Segurança', 'Pediatria');

INSERT INTO funcionario (nome, cpf, email, telefone, sexo, endereco, especialidade, setor, crm) 
 VALUES ('maria Silva', '111.666.444-26', 'maria@teste.com', '(11) 2222-2222', 'F', 'Rua Dominica', 'Psiquiatria da Infância e Adolescência',  'Psiquiatria', '3711');