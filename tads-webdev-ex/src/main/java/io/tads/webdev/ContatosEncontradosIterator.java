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

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class ContatosEncontradosIterator implements Iterator<Pessoa> {

    private String termo;
    private Iterator<Pessoa> iter;

    private Pessoa current;
    private boolean initialized;

    public ContatosEncontradosIterator(Iterator<Pessoa> iter, String termo) {

        this.iter = iter;
        this.termo = termo;

        this.current = null;
        this.initialized = false;

    }

    @Override
    public boolean hasNext() {

        if (!this.initialized) {

            this.initialized = true;

            this.findNext();

        }

        return this.current != null;

    }

    @Override
    public Pessoa next() {

        Pessoa current = this.current;

        this.findNext();

        return current;

    }

    protected void findNext() {

        this.current = null;

        while (this.iter.hasNext()) {

            Pessoa current = this.iter.next();

            if (current.matches(this.termo)) {

                this.current = current;

                break;

            }

        }

    }
}
