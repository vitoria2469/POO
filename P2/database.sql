CREATE DATABASE cadastrodb;

USE cadastrodb;

CREATE TABLE funcionario ( 
    registro INT AUTO_INCREMENT,
    nome VARCHAR(40) NOT NULL,
    email VARCHAR(40) NOT NULL UNIQUE,
    senha VARCHAR(20) NOT NULL,
    telefone CHAR(11) NOT NULL,
    setor VARCHAR(50),
    PRIMARY KEY (registro)
);

CREATE TABLE medico (
	id INT AUTO_INCREMENT,
	crm VARCHAR(20) UNIQUE,
    nome VARCHAR(40) NOT NULL,
    email VARCHAR(40) NOT NULL UNIQUE,
    telefone CHAR(11) NOT NULL ,
    especialidade VARCHAR(100) NOT NULL,
    
    PRIMARY KEY (id)
);

INSERT INTO funcionario (nome, email, telefone, senha, setor) 
 VALUES ('Joao Silva', 'joao@teste.com', '1111111111', '123', 'Agendamento');

INSERT INTO medico (crm, nome, email, telefone,  especialidade) 
 VALUES ('3711', 'maria Silva', 'maria@teste.com', '1122222222', 'Psiquiatria da Infância e Adolescência');
 