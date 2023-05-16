drop database supplyStore;

CREATE DATABASE supplyStore;
use supplyStore;


CREATE TABLE clientes (
  nome_cli VARCHAR(100) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  endereco VARCHAR(200) NOT NULL,
  telefone INT(9) NOT NULL,
  email VARCHAR(100) NOT NULL ,
  data_nascimento INT NOT NULL,
  estado_civil VARCHAR(20 ) NOT NULL,
  sexo VARCHAR(20) NOT NULL,
  PRIMARY KEY (cpf, email)
);


CREATE TABLE produtos (
  id_produto INT NOT NULL AUTO_INCREMENT,
  nome_produto VARCHAR(100) NOT NULL,
  quantidade INT NOT NULL,
  valor DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id_produto)
);


CREATE TABLE vendas (
  id_venda INT NOT NULL AUTO_INCREMENT,
  id_cliente VARCHAR(11) NOT NULL,
  id_produto INT NOT NULL,
  quantidade INT NOT NULL,
  data_venda datetime,
  PRIMARY KEY (id_venda),
  FOREIGN KEY (id_cliente) REFERENCES clientes(cpf),
  FOREIGN KEY (id_produto) REFERENCES produtos(id_produto)
  
);

