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
package io.tads.webdev.pratica4;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
@ManagedBean
@RequestScoped
public class ProdutoMB {

    private Collection<Produto> produtos;
    private Produto produto;

    private Connection connection;

    public ProdutoMB() {

        this.produto = new Produto();

    }

    @PreDestroy
    public void close() {

        Connection connection = this.connection;
        this.connection = null;

        if (connection != null) {

            try {

                connection.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }

        }

    }

    public String editar(int produtoId) {

        try {

            this.produto = this.getDAO().buscarPorId(produtoId);

            this.close();

        } catch (SQLException e) {

            e.printStackTrace();

            throw new RuntimeException(e.getMessage(), e);

        }

        return "editar";

    }

    protected Connection getConnection() {

        if (this.connection == null) {

            try {

                this.connection = ConnectionFactory.openConnection();

            } catch (SQLException e) {

                e.printStackTrace();

                throw new RuntimeException(e.getMessage(), e);

            }
        }

        return this.connection;

    }

    protected ProdutoDAO getDAO() {

        ProdutoDAO dao;

        dao = new ProdutoDAO(this.getConnection());

        return dao;

    }

    public Produto getProduto() {

        return this.produto;

    }

    public Collection<Produto> getProdutos() {

        if (this.produtos == null) {

            this.produtos = new ArrayList<Produto>();

            try {

                this.produtos.addAll(this.getDAO().listar());

                this.close();

            } catch (SQLException e) {

                e.printStackTrace();

                throw new RuntimeException(e.getMessage(), e);

            }

        }

        return this.produtos;

    }

    public String remover(int produtoId) {

        try {

            this.getDAO().removerPorId(produtoId);

            this.close();

        } catch (SQLException e) {

            e.printStackTrace();

            throw new RuntimeException(e.getMessage(), e);

        }

        this.produtos = null;

        return null;

    }

    public String salvar() {

        try {

            this.getDAO().salvar(this.produto);

            this.close();

        } catch (SQLException e) {

            e.printStackTrace();

            throw new RuntimeException(e.getMessage(), e);

        }

        return "index";

    }

}
