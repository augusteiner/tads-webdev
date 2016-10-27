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
package tads.webdev.chat;

import java.util.UUID;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class MensagemChat {

    private long id;
    private String mensagem;

    private long salaId;
    private UUID usuarioId;

    public MensagemChat(long salaId, UUID usuarioId, String mensagem) {

        this.mensagem = mensagem;

        this.salaId = salaId;
        this.usuarioId = usuarioId;

    }

    public long getId() {

        return this.id;
    }

    public String getTexto() {

        return this.mensagem;
    }

    public long getSalaId() {

        return this.salaId;
    }

    public UUID getUsuarioId() {

        return this.usuarioId;
    }

}
