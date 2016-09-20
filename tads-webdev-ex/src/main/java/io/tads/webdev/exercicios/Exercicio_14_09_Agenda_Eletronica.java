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

import java.util.Scanner;

import io.tads.webdev.AgendaEletronica;
import io.tads.webdev.Contato;
import io.tads.webdev.ContatoBuilder;
import io.tads.webdev.EnderecoBuilder;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Exercicio_14_09_Agenda_Eletronica {

    private AgendaEletronica controlador;
    private Scanner scanner;

    public Exercicio_14_09_Agenda_Eletronica(Scanner scanner) {

        this.controlador = new AgendaEletronica();
        this.scanner = scanner;

    }

    public void exibirContato(Contato contato) {

        System.out.println(String.format(
            "> %s\n  %s",

            contato,
            contato.getEndereco()));

    }

    public void exibirContatos() {

        exibirContatos(this.controlador.getAgenda());

    }

    public void exibirContatos(Iterable<Contato> contatos) {

        for (Contato contato : contatos) {

            this.exibirContato(contato);

        }

    }

    private ContatoBuilder lerContato(ContatoBuilder builder) {

        System.out.println("~ Novo Contato ~");

        System.out.print(" Infome o nome: ");
        builder.setNome(lerString());

        System.out.print(" Infome o sobrenome: ");
        builder.setSobrenome(lerString());

        builder.setIdade(30);

        return builder;
    }

    private EnderecoBuilder lerEndereco(EnderecoBuilder builder) {

        builder.setLogradouro("R. dos Programadores");

        builder.setNumero("30");

        builder.setBairro("Candelária");

        return builder;

    }

    private String lerString() {

        return lerString(this.scanner);

    }

    private String lerString(Scanner scanner) {

        return scanner.nextLine();

    }

    private void run() {

        ContatoBuilder contato = lerContato(this.controlador.contatoBuilder());
        EnderecoBuilder endereco = lerEndereco(this.controlador.enderecoBuilder());

        contato.setEndereco(endereco.build());

        this.controlador.adicionar(contato.build());

        this.exibirContatos(this.controlador.buscar("J"));

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        new Exercicio_14_09_Agenda_Eletronica(scanner).run();

        scanner.close();

    }

}
