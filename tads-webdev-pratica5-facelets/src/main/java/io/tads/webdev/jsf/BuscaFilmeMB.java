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

import java.sql.*;

import java.util.Collection;

import javax.annotation.PreDestroy;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;

import io.tads.webdev.*;
import io.tads.webdev.dao.*;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
@ManagedBean
@RequestScoped
public class BuscaFilmeMB {

    private String termo = "";

    private Collection<Filme> resultado;

    private Connection connection;

    public void viewCarregada(ComponentSystemEvent e) {

        this.buscar();

    }

    public void termoChanged(ValueChangeEvent e) {

        this.termo = e.getNewValue().toString();

        this.buscar();
    }

    public void buscar() {

        FilmeDAO dao;

        dao = this.getDAO();

        try {

            this.resultado = dao.buscar(this.termo);

        } catch (SQLException e) {

            e.printStackTrace();

            throw new RuntimeException(e.getMessage(), e);

        } finally {

            this.close();

        }

    }

    public String getTermo() {

        return this.termo;
    }

    public void setTermo(String termo) {

        this.termo = termo;
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

    private FilmeDAO getDAO() {

        return new FilmeDAO(this.getConnection());
    }

    private Connection getConnection() {

        if (this.connection == null)
            this.connection = ConnectionFactory.openConnection();

        return this.connection;

    }

    public Collection<Filme> getResultado() {

        return this.resultado;

    }

}
