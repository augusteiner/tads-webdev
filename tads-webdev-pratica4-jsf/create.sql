
DROP SCHEMA IF EXISTS pweb;

CREATE SCHEMA IF NOT EXISTS pweb;

/*!50706

-- XXX https://mariadb.com/kb/en/mariadb/comment-syntax/
CREATE USER IF NOT EXISTS
  'pweb'@'%',
  'pweb'@'127.0.0.1',
  'pweb'@'localhost'
*/;

/*!
GRANT USAGE
ON *.*
TO 'pweb'@'%', 'pweb'@'127.0.0.1', 'pweb'@'localhost'
*/;

/*!
GRANT SELECT, DELETE, INSERT, UPDATE
ON pweb.*
TO 'pweb'@'%', 'pweb'@'127.0.0.1', 'pweb'@'localhost'
*/;

/*! FLUSH PRIVILEGES */;

/*!
SET PASSWORD
FOR 'pweb'@'%' = PASSWORD('1234')
*/;

/*!
SET PASSWORD
FOR 'pweb'@'localhost' = PASSWORD('1234')
*/;

/*!
SET PASSWORD
FOR 'pweb'@'127.0.0.1' = PASSWORD('1234')
*/;

DROP TABLE IF EXISTS pweb.produto;

CREATE TABLE IF NOT EXISTS pweb.produto (

  id INT NOT NULL AUTO_INCREMENT,

  descricao VARCHAR(1024) NOT NULL,
  validade DATE NOT NULL,
  preco DECIMAL(14,4) NOT NULL,

  PRIMARY KEY (id)

)
;

INSERT INTO pweb.produto (descricao, validade, preco)
VALUES
  ('Sabão em pó', '2017-01-01', 2.55),
  ('Boneca Barbie', '2017-01-01', 201.99),
  ('PlayStation II', '2017-01-01', 1780.00),
  ('Feijão Carioca', '2017-01-01', 0.01),
  ('Arroz Urbano', '2017-01-01', 0.02)
ON DUPLICATE KEY UPDATE
  descricao = VALUES(descricao),
  validade = VALUES(validade),
  preco = VALUES(preco)
;

