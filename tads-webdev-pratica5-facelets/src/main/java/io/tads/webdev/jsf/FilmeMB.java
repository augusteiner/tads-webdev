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
package io.tads.webdev.jsf;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import io.tads.webdev.Filme;
import io.tads.webdev.dao.ConnectionFactory;
import io.tads.webdev.dao.FilmeDAO;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
@ManagedBean
@RequestScoped
public class FilmeMB {

    private Filme filme;

    private Connection connection;

    public FilmeMB() {

        this.filme = new Filme();

    }

    public String cadastrar() {

        FilmeDAO dao;

        dao = this.getDAO();

        try {

            dao.salvar(this.filme);

        } catch (SQLException e) {

            e.printStackTrace();

            throw new RuntimeException(e.getMessage(), e);

        } finally {

            this.close();
        }

        this.filme = new Filme();

        return "busca";

    }

    @PreDestroy
    public void close() {

        Connection connection = this.connection;
        this.connection = null;

        try {

            if (connection != null)
                connection.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    private Connection getConnection() {

        if (this.connection == null)
            this.connection = ConnectionFactory.openConnection();

        return this.connection;

    }

    private FilmeDAO getDAO() {

        return new FilmeDAO(this.getConnection());
    }

    public Filme getFilme() {

        return this.filme;
    }

}
