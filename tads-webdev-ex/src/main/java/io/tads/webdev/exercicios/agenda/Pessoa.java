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
package io.tads.webdev.exercicios.agenda;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public abstract class Pessoa {

    private String nome;

	private String sobrenome;
    private int idade;

    private final ETipoPessoa tipo;
    private Endereco endereco;

    protected Pessoa(ETipoPessoa tipo) {

        this.tipo = tipo;

    }


    protected Pessoa(ETipoPessoa tipo, String nome, String sobrenome, int idade) {

    	this(tipo);

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;

    }

    protected Pessoa(ETipoPessoa tipo, String nome, String sobrenome, int idade, Endereco endereco) {

        this(tipo, nome, sobrenome, idade);

        this.endereco = endereco;

    }

    public Endereco getEndereco() {

        return this.endereco;
    }

	public int getIdade() {

        return this.idade;
    }

    public String getNome() {

        return this.nome;
    }

    public String getSobrenome() {

        return this.sobrenome;
    }

    public ETipoPessoa getTipo() {

		return this.tipo;
	}

	public boolean matches(String termo) {

        return this.getNome().contains(termo) ||
            this.getSobrenome().contains(termo) ||
            this.getEndereco().matches(termo);

    }

    public void setEndereco(Endereco endereco) {

        this.endereco = endereco;
    }

    public void setIdade(int idade) {

        this.idade = idade;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {

        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {

        return String.format(
            "%s %s",

            this.getNome(),
            this.getSobrenome());

    }

}
