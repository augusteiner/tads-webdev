/*
 * MIT License
 *
 * Copyright (c) 2016 José Augusto
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
package io.tads.webdev.exercicios;

import io.tads.webdev.AgendaEletronica;
import io.tads.webdev.Contato;
import io.tads.webdev.Endereco;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Exercicio_14_09_Agenda_Eletronica {

    private AgendaEletronica controlador;

    public Exercicio_14_09_Agenda_Eletronica() {

        controlador = new AgendaEletronica();

    }

    public void exibirContatos() {

        for (Contato contato : this.controlador.getContatos()) {

            this.exibirContato(contato);

        }

    }

    public void exibirContato(Contato contato) {

        System.out.println(String.format(
            "~ %s\n  %s",

            contato,
            contato.getEndereco()));

    }

    private void run() {

        Endereco enderecoJose = new Endereco("R. dos Programadores", "30", "Candelária");
        Contato jose = new Contato("José", "Nascimento", 30, enderecoJose);

        this.controlador.adicionar(jose);

        this.exibirContatos();

    }

    public static void main(String[] args) {

        new Exercicio_14_09_Agenda_Eletronica().run();

    }

}
