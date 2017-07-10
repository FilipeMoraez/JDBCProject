
-- Criar banco de dados jdbcexample
create database jdbcexample;

-- Usar o jdbcexample para executar os comandos
use jdbcexample;

-- criar tabela usuarios com os campos
-- ID (que incrementa 1 por 1, chave primaria) 
-- name (ate 30 letras, nao pode ser nulo)
-- senha (com ate 30 letras, nao pode ser nulo)

create table usuarios(
  id  int primary key auto_increment,
  name varchar(30) not null,
  password varchar(30) not null  
);

-- insere uma linha na tabela usuarios, com name de Filipe e senha 123 	
insert into usuarios(name, password) values( 'Filipe', '123' );
insert into usuarios(name, password) values( 'Matheus', '321' );

— Criando procedure para listar usuarios
DELIMITER $$

CREATE PROCEDURE Listar()
BEGIN
	SELECT * from usuarios;	
END $$
DELIMITER ;
