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
package tads.webdev.pratica2.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tads.webdev.pratica2.FachadaAcoes;
import tads.webdev.pratica2.FachadaLogin;
import tads.webdev.pratica2.TransacaoException;
import tads.webdev.pratica2.Usuario;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        if (!FachadaLogin.isUsuarioAutenticado(req)) {

            resp.sendRedirect("login");

            return;

        }

        super.service(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        req.setAttribute("usuario", FachadaLogin.getUsuarioLogado(req));

        req.getRequestDispatcher("main.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String pOperacao = req.getParameter("operacao");
        String pQte = req.getParameter("qte");

        if (pOperacao == null || pQte == null) {

            resp.sendRedirect("main?erro=1");

            return;

        }

        int qte = Integer.valueOf(pQte);
        Usuario usuario = FachadaLogin.getUsuarioLogado(req);

        try {

            realizarTransacao(pOperacao, qte, usuario);

        } catch (TransacaoException e) {

            e.printStackTrace();

            throw new ServletException(e.getMessage(), e);

        }

        resp.sendRedirect("main");

    }

    private void realizarTransacao(String pOperacao, int qte, Usuario usuario)
            throws TransacaoException {

        if (pOperacao.equals("comprar")) {

            FachadaAcoes.comprarAcoes(usuario, qte);

        } else if (pOperacao.equals("vender")) {

            FachadaAcoes.venderAcoes(usuario, qte);

        } else {

            throw new TransacaoException(
                    "Tipo de transação solicitada não suportada");
        }

    }

}
