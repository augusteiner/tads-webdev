/*
 * MIT License
 *
 * Copyright (c) 2016 José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.tads.webdev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Iterator;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection conn) {

        this.connection = conn;

    }

    public void remove(int id)
        throws SQLException {

        PreparedStatement stmt = this.connection.prepareStatement(
            "DELETE FROM PRODUTO " +
            "WHERE ID = ? ");

        stmt.setLong(1, id);
        int affectedRows = stmt.executeUpdate();

        if (affectedRows != 1) {

            throw new ObjetoNaoEncontradoException(String.format(
                "Produto de ID #%d não existe",
                id));

        }

    }

    public Iterable<Produto> findByNome(String nome)
        throws SQLException {

        ResultSet rs;
        PreparedStatement stmt = this.connection.prepareStatement(
            "SELECT ID, NOME, PRECO, UNIDADE, QUANTIDADE " +
            "FROM PRODUTO " +
            "WHERE LOCATE(?, NOME) > 0 ");

        stmt.setString(1, nome);

        rs = stmt.executeQuery();

        return this.iterable(rs);

    }

    protected Iterable<Produto> iterable(final ResultSet rs) {

        return new Iterable<Produto>() {

            @Override
            public Iterator<Produto> iterator() {

                return new ProdutoIterator(rs);
            }

        };

    }

    public Iterable<Produto> list()
        throws SQLException {

        ResultSet rs;
        Statement stmt = this.connection.createStatement();

        rs = stmt.executeQuery(
            "SELECT ID, NOME, PRECO, UNIDADE, QUANTIDADE " +
            "FROM PRODUTO ");

        return this.iterable(rs);

    }

}
