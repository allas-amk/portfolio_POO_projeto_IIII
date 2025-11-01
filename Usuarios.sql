-- Criação do Banco de Dados (se necessário)
CREATE DATABASE IF NOT EXISTS meu_projeto_db;

-- Seleciona o Banco de Dados
USE meu_projeto_db;

-- Criação da Tabela de Exemplo
CREATE TABLE IF NOT EXISTS Usuarios (
    ID INT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL
);

-- Inserção dos Dados (Requisitos do Resultado)
INSERT INTO Usuarios (ID, Nome, Email) VALUES
(1, 'João Silva', 'joao@example.com'),
(2, 'Maria Oliveira', 'maria@example.com'),
(3, 'Carlos Souza', 'carlos@example.com');
