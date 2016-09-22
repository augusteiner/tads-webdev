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

import java.util.Iterator;
import java.util.Random;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class InteirosAleatorios implements Iterable<Integer> {

    private final int length;

    private int index;
    protected final Random random;

    public InteirosAleatorios(int length) {

        this.length = length;
        this.random = new Random();

    }

    @Override
    public Iterator<Integer> iterator() {

        final InteirosAleatorios self = this;

        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {

                return self.index < self.length;
            }

            @Override
            public Integer next() {

                self.index++;

                return self.nextInt();

            }

        };

    }

    protected int nextInt() {

        return this.random.nextInt();

    }

}
