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

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class DbChat {

    private Map<SalaChat, RegistroChat> registro;

    private Collection<UsuarioChat> usuarios;

    public DbChat(
        Map<SalaChat, RegistroChat> registro,
        Collection<UsuarioChat> usuarios) {

        this.registro = registro;
        this.usuarios = usuarios;

    }

    public void addMensagem(MensagemChat mensagem) {

        SalaChat sala = this.getSala(mensagem.getSalaId());

        RegistroChat registro = this.registro.get(sala);

        registro.addMensagem(mensagem);

    }

    public void addUsuario(UsuarioChat usuario) {

        this.usuarios.add(usuario);

    }

    public Iterable<MensagemChat> getMensagens(long salaId) {

        SalaChat sala = this.getSala(salaId);

        return this.registro.get(sala).getMensagens();

    }

    public SalaChat getSala(long id) {

        for (SalaChat sala : this.getSalas()) {

            if (sala.getId() == id) {

                return sala;

            }

        }

        return null;

    }

    public Iterable<SalaChat> getSalas() {

        return Collections.unmodifiableSet(registro.keySet());

    }

    public UsuarioChat getUsuario(UUID usuarioId) {

        String id = usuarioId.toString();

        for (UsuarioChat autor : this.getUsuarios()) {

            if (autor.getId() == id) {

                return autor;

            }

        }

        return null;

    }

    public Iterable<UsuarioChat> getUsuarios() {

        return Collections.unmodifiableCollection(this.usuarios);

    }

}
