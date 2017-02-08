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

import java.util.Date;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Produto {

    private int id;

    private String descricao;

    private Date validade;

    private double preco;

    public String getDescricao() {

        return this.descricao;
    }

    public int getId() {

        return this.id;
    }

    public double getPreco() {

        return this.preco;
    }

    public Date getValidade() {

        return this.validade;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setPreco(double preco) {

        this.preco = preco;
    }

    public void setValidade(Date validade) {

        this.validade = validade;
    }

}
