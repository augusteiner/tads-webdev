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
package tads.webdev.pratica2;

import java.math.BigDecimal;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Usuario {

    private String login;
    private String senha;

    private int qteAcoes;
    private BigDecimal saldo;

    public Usuario(String login, String senha) {

        this.login = login;
        this.senha = senha;

        this.qteAcoes = 0;
        this.saldo = BigDecimal.ZERO;

    }

    public String getLogin() {

        return this.login;
    }

    public int getQteAcoes() {

        return this.qteAcoes;
    }

    public BigDecimal getSaldo() {

        return this.saldo;
    }

    public String getSenha() {

        return this.senha;
    }

    public void setQteAcoes(int qteAcoes) {

        this.qteAcoes = qteAcoes;
    }

    public void setSaldo(BigDecimal saldo) {

        this.saldo = saldo;
    }

}
