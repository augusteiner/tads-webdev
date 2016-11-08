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
package tads.webdev.lista3;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Endereco {

    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

    public String getBairro() {

        return this.bairro;
    }

    public String getCep() {

        return this.cep;
    }

    public String getCidade() {

        return this.cidade;
    }

    public String getEstado() {

        return this.estado;
    }

    public String getRua() {

        return this.rua;
    }

    public void setBairro(String bairro) {

        this.bairro = bairro;
    }

    public void setCep(String cep) {

        this.cep = cep;
    }

    public void setCidade(String cidade) {

        this.cidade = cidade;
    }

    public void setEstado(String estado) {

        this.estado = estado;
    }

    public void setRua(String rua) {

        this.rua = rua;
    }

}
