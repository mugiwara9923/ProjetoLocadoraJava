CREATE DATABASE locadora_filmes;

USE locadora_filmes;

CREATE TABLE Clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(15)
);

CREATE TABLE Filmes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    genero VARCHAR(50),
    ano INT,
    diretor VARCHAR(100)
);

CREATE TABLE Funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cargo VARCHAR(50),
    salario DECIMAL(10, 2)
);

-- Tabela de Aluguéis (Relaciona Clientes com Filmes)
CREATE TABLE Alugueis (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    filme_id INT,
    data_aluguel DATE,
    data_devolucao DATE,
    FOREIGN KEY (cliente_id) REFERENCES Clientes(id),
    FOREIGN KEY (filme_id) REFERENCES Filmes(id)
);

-- Tabela de Pagamentos (Relaciona Aluguéis com Funcionários)
CREATE TABLE Pagamentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    aluguel_id INT,
    funcionario_id INT,
    valor DECIMAL(10, 2),
    data_pagamento DATE,
    FOREIGN KEY (aluguel_id) REFERENCES Alugueis(id),
    FOREIGN KEY (funcionario_id) REFERENCES Funcionarios(id)
);
