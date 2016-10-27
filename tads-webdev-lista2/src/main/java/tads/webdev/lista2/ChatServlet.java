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
package tads.webdev.lista2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tads.webdev.chat.MemoriaChat;
import tads.webdev.chat.MensagemChat;
import tads.webdev.chat.UsuarioChat;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
@WebServlet("/chat.do")
public class ChatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String pSalaId = req.getParameter("salaId");

        if (pSalaId == null) {

            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);

            return;

        }

        int salaId = Integer.valueOf(pSalaId);

        Iterable<MensagemChat> mensagens = this.getMemoria().recuperarMensagens(salaId);

        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        String separador = "";

        writer.print("[");

        for (MensagemChat mensagem : mensagens) {

            UsuarioChat usuario = this.getMemoria().getUsuario(mensagem.getUsuarioId());

            writer.print(String.format(
                "%s\n"
                + "{ "
                + " \"usuario\": { \"id\": \"%s\", \"nome\": \"%s\" } "
                + " \"mensagem\": \"%s\" "
                + "} ",
                separador,
                usuario.getId(),
                usuario.getNome(),
                mensagem.getTexto()));

            separador = ",";

        }

        writer.print("]");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String pSalaId = req.getParameter("salaId");
        String pUsuarioId = req.getParameter("usuarioId");
        String pMensagem = req.getParameter("mensagem");

        if (pSalaId == null || pUsuarioId == null) {

            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);

            return;

        }

        int salaId = Integer.valueOf(pSalaId);
        UUID usuarioId = UUID.fromString(pUsuarioId);

        MensagemChat mensagem = new MensagemChat(salaId, usuarioId, pMensagem);

        this.getMemoria().enviarMensagem(mensagem);

    }

    private MemoriaChat getMemoria() {

        return MemoriaChat.instance();

    }

}
