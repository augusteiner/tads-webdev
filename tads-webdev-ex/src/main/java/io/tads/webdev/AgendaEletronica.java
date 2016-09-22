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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class AgendaEletronica implements Iterable<Pessoa> {

    private Agenda agenda;

    public AgendaEletronica() {

        this.agenda = new Agenda(new ArrayList<Pessoa>());

    }

    public Agenda getAgenda() {

        return this.agenda;
    }

    public void adicionar(Pessoa contato) {

        this.getAgenda().adicionar(contato);

    }

    public Iterable<Pessoa> buscar(String termo) {

        return this.getAgenda().buscar(termo);

    }

    public Iterable<Pessoa> getContatos() {

        return this.getAgenda();

    }

    @Override
    public Iterator<Pessoa> iterator() {

        return this.getAgenda().iterator();
    }

    public PessoaBuilder contatoBuilder() {

        return new PessoaBuilder();

    }

    public EnderecoBuilder enderecoBuilder() {

        return new EnderecoBuilder();
    }

}
