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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class ProdutoIterator implements Iterator<Produto> {

    private ResultSet rs;
    private boolean isInitialized;
    private boolean hasNext;

    public ProdutoIterator(ResultSet rs) {

        this.hasNext = false;
        this.isInitialized = false;

        this.rs = rs;

    }

    @Override
    public boolean hasNext() {

        if (!this.isInitialized) {

            this.isInitialized = true;

            try {

                this.hasNext = this.rs.next();

            } catch (SQLException e) {

                e.printStackTrace();

                throw new RuntimeException(e.getMessage(), e);

            }

        }

        return this.hasNext;

    }

    @Override
    public Produto next() {

        try {

            Produto produto = this.doFetch();

            this.hasNext = this.rs.next();

            return produto;

        } catch (SQLException e) {

            e.printStackTrace();

            throw new RuntimeException(e.getMessage(), e);

        }

    }

    private Produto doFetch()
        throws SQLException {

        Produto produto = new Produto();

        produto.setId(this.rs.getInt("ID"));
        produto.setNome(this.rs.getString("NOME"));
        produto.setPreco(this.rs.getDouble("PRECO"));
        produto.setUnidade(this.rs.getString("UNIDADE"));
        produto.setQuantidade(this.rs.getInt("QUANTIDADE"));

        return produto;

    }

}
