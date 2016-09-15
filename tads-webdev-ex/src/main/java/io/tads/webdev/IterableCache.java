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
package io.tads.webdev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class IterableCache<E> implements Iterable<E> {

    private Collection<E> cache;
    private Iterator<E> iter;

    public IterableCache() {

        this(Collections.emptyList());

    }

    public IterableCache(Iterable<E> iterable) {

        this.iter = iterable.iterator();
        this.cache = null;

    }

    @Override
    public Iterator<E> iterator() {

        if (this.cache == null) {

            this.cache = new ArrayList<E>();

            return new Iterator<E>() {

                private final IterableCache<E> self = IterableCache.this;

                @Override
                public boolean hasNext() {

                    return self.iter.hasNext();

                }

                @Override
                public E next() {

                    E next = self.iter.next();

                    self.cache.add(next);

                    return next;

                }

            };

        } else {

            return this.cache.iterator();

        }

    }

}
