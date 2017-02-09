
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

USE pweb;

DROP TABLE IF EXISTS filme;

CREATE TABLE filme (
  id INT AUTO_INCREMENT,

  titulo VARCHAR(100) NOT NULL,
  genero VARCHAR(100) NOT NULL,
  categoria VARCHAR(100) NOT NULL,

  preco DECIMAL(14,4) NOT NULL,
  duracao DECIMAL(14,4) NOT NULL,

  PRIMARY KEY (id)

);

INSERT INTO filme (titulo, genero, categoria, preco, duracao)
VALUES
  ('A volta dos que não foram', 'Drama', 'Top 10', 7.50, 2.5),
  ('Titanic', 'Comédia Romântica', 'Lançamento', 10.50, 2.5),
  ('O regresso', 'Terror', 'Clássicos', 20.50, 2.5),
  ('A ilha', 'Romance', 'Top 10', 20.00, 2.5),
  ('Guerra dos Mundos', 'Ficção', 'Lançamento', 11.50, 2.5)
;
