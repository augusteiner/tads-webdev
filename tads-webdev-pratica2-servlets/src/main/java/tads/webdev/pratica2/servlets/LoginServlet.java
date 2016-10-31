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

import tads.webdev.pratica2.AcessoNaoPermitidoException;
import tads.webdev.pratica2.FachadaLogin;
import tads.webdev.pratica2.Usuario;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        if (FachadaLogin.isUsuarioAutenticado(req)) {

            resp.sendRedirect("/main");

            return;

        }

        super.service(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String pLogin = null;
        String pSenha = null;

        pLogin = req.getParameter("login");
        pSenha = req.getParameter("senha");

        if (pLogin == null ||
            pSenha == null ||
            FachadaLogin.isUsuarioAutenticado(req)) {

            resp.sendRedirect("/login");

            return;

        }

        Usuario usuario = new Usuario(pLogin, pSenha);

        try {

            FachadaLogin.logar(usuario, req);

        } catch (AcessoNaoPermitidoException e) {

            e.printStackTrace();

            throw new ServletException(e.getMessage(), e);

        }

        resp.sendRedirect("/main");

    }

}
