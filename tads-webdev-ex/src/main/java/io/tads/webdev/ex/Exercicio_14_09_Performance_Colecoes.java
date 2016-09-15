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
package io.tads.webdev.ex;

import static io.tads.webdev.TesteBuscaElementosEmColecao.novoTeste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import io.tads.webdev.InteirosAleatoriosEmIntervalo;
import io.tads.webdev.IterableCache;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Exercicio_14_09_Performance_Colecoes {

    private static final int LENGTH = 20000;

    public static void main(String[] args) {

        Collection<Integer> lista;
        Collection<Integer> set;
        Iterable<Integer> numeros = numeros(LENGTH);

        // XXX Teste com ArrayList
        System.out.println("Teste com ArrayList");

        lista = new ArrayList<Integer>(LENGTH);

        preencherColecao(lista, numeros);

        novoTeste(lista, numeros).executar();

        //exibirColecao(lista);

        // XXX Teste com Set
        System.out.println();
        System.out.println("Teste com HashSet");

        set = new HashSet<Integer>(LENGTH);

        preencherColecao(set, numeros);

        novoTeste(set, numeros).executar();

        //exibirColecao(set);

    }

    public static void preencherColecao(
        Collection<Integer> collection,
        Iterable<Integer> numeros) {

        long t0 = System.currentTimeMillis();

        for (Integer number : numeros) {

            collection.add(number);

        }

        long tf = System.currentTimeMillis();

        System.out.println(String.format(
            "Tempo gasto no preenchimento: %d (ms)",

            tf - t0));

    }

    public static void printIterable(Iterable<?> iterable) {

        for (Object obj : iterable) {

            System.out.print(obj + " ");

        }

        System.out.println();

    }

    private static Iterable<Integer> numeros(int length) {

        Iterable<Integer> numeros = new InteirosAleatoriosEmIntervalo(
            length,
            length * 2,
            0);

        return new IterableCache<Integer>(numeros);

    }

}
