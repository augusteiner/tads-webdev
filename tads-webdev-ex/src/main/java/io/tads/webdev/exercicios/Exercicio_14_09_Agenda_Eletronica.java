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
package io.tads.webdev.exercicios;

import java.util.Scanner;

import io.tads.webdev.AgendaEletronica;
import io.tads.webdev.Pessoa;
import io.tads.webdev.PessoaBuilder;
import io.tads.webdev.EnderecoBuilder;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Exercicio_14_09_Agenda_Eletronica {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        new Exercicio_14_09_Agenda_Eletronica(scanner).run();

        scanner.close();

    }
    private static void print(String format, Object... args) {

        System.out.println(String.format(
            format,
            args));

    }

    private static void println(String format, Object... args) {

        print(format, args);

        System.out.println();

    }

    private AgendaEletronica ctrlr;

    private Scanner scanner;

    public Exercicio_14_09_Agenda_Eletronica(Scanner scanner) {

        this.ctrlr = new AgendaEletronica();
        this.scanner = scanner;

    }

    public void exibirContato(Pessoa contato) {

        println(String.format(
            "> %s\n  %s",

            contato,
            contato.getEndereco()));

    }

    public void exibirContatos() {

        exibirContatos(this.ctrlr.getAgenda());

    }

    public void exibirContatos(Iterable<Pessoa> contatos) {

        for (Pessoa contato : contatos) {

            this.exibirContato(contato);

        }

    }

    private PessoaBuilder lerContato(PessoaBuilder builder) {

        println("~ Novo Contato ~");

        print(" Infome o nome: ");
        builder.setNome(lerString());

        print(" Infome o sobrenome: ");
        builder.setSobrenome(lerString());

        builder.setIdade(30);

        return builder;
    }

    private EnderecoBuilder lerEndereco(EnderecoBuilder builder) {

        print("Informe o logradouro: ");
        builder.setLogradouro(lerString());

        print("Informe o número: ");
        builder.setNumero(lerString());

        print("Informe o bairro: ");
        builder.setBairro(lerString());

        return builder;

    }

    private String lerString() {

        return lerString(this.scanner);

    }

    private String lerString(Scanner scanner) {

        return scanner.nextLine();

    }

    private void run() {

        final AgendaEletronica ctrlr = this.ctrlr;

        PessoaBuilder contato = lerContato(ctrlr.contatoBuilder());
        EnderecoBuilder endereco = lerEndereco(ctrlr.enderecoBuilder());

        contato.setEndereco(endereco.build());

        ctrlr.adicionar(contato.build());

        this.exibirContatos(ctrlr.buscar("J"));

    }

}
