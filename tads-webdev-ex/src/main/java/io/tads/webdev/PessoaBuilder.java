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

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class PessoaBuilder {

    private String nome;
    private String sobrenome;
    private int idade;
    private Endereco endereco;
    private ETipoPessoa tipo;


    public void setNome(String nome) {

        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {

        this.sobrenome = sobrenome;
    }

    public void setIdade(int idade) {

        this.idade = idade;
    }

    public void setEndereco(Endereco endereco) {

        this.endereco = endereco;

    }

    public Pessoa build() {

    	switch (this.tipo) {

	    	case FISICA:
	    		return new PessoaFisica(nome, sobrenome, idade, endereco);

	    	case JURIDICA:
	    		return new PessoaJuridica(nome, sobrenome, idade, endereco);

    		default:
    			throw new IllegalStateException();

    	}

    }

}
