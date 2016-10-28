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

import java.util.*;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public final class MemoriaChat {

    private static final class Nested {

        private static final MemoriaChat INSTANCE = Nested.createInstance();

        private static MemoriaChat createInstance() {

            return new MemoriaChat();

        }

    }

    public static final MemoriaChat instance() {

        return Nested.INSTANCE;

    }

    private final DbChat db;

    private MemoriaChat() {

        this.db = this.initDb();

    }

    public UsuarioChat cadastrarUsuario(String nome) {

        UUID uuid = UUID.randomUUID();

        UsuarioChat usuario = new UsuarioChat(
            uuid.toString(), nome);

        this.db.addUsuario(usuario);

        return usuario;
    }

    public void enviarMensagem(MensagemChat mensagem) {

        this.db.addMensagem(mensagem);

    }

    private Iterable<SalaChat> gerarSalasPadrao() {

        Collection<SalaChat> lista = new ArrayList<SalaChat>();

        lista.add(new SalaChat(1, "Música"));
        lista.add(new SalaChat(2, "Filmes"));
        lista.add(new SalaChat(3, "Gastronomia"));

        return lista;

    }

    public SalaChat getSala(long salaId) {

        return this.db.getSala(salaId);

    }

    public Iterable<SalaChat> getSalas() {

        return this.db.getSalas();

    }

    public UsuarioChat getUsuario(UUID usuarioId) {

        return this.db.getUsuario(usuarioId);

    }

    public Iterable<UsuarioChat> getUsuarios() {

        return this.db.getUsuarios();

    }

    private DbChat initDb() {

        Collection<UsuarioChat> usuarios = Collections.synchronizedCollection(
            new LinkedList<UsuarioChat>());
        Map<SalaChat, RegistroChat> registro = Collections.synchronizedMap(
            new Hashtable<SalaChat, RegistroChat>());

        for (SalaChat sala : this.gerarSalasPadrao()) {

            Collection<MensagemChat> mensagens = Collections.synchronizedCollection(
                new LinkedList<MensagemChat>());

            RegistroChat r = new RegistroChat(sala, mensagens);

            registro.put(sala, r);

        }

        return new DbChat(registro, usuarios);

    }

    public Iterable<MensagemChat> recuperarMensagens(long salaId) {

        return this.db.getMensagens(salaId);

    }

    public Iterable<MensagemChat> getMensagens(long salaId) {

        return this.db.getMensagens(salaId);

    }

}
