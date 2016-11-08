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
package tads.webdev.lista3.el;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tads.webdev.lista3.Endereco;
import tads.webdev.lista3.Pessoa;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
@WebServlet("/session")
public class PessoaSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/session.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        Pessoa pessoa = this.pessoaFromRequest(req);

        req.getSession(true).setAttribute("pessoa", pessoa);

        resp.sendRedirect("pessoa");

    }

    private Endereco enderecoFromRequest(HttpServletRequest req) {

        Endereco endereco = new Endereco();

        String pEnderecoRua = req.getParameter("endereco[rua]");

        endereco.setRua(pEnderecoRua);

        return endereco;

    }

    private Pessoa pessoaFromRequest(HttpServletRequest req) {

        Pessoa pessoa = new Pessoa();

        String pNome = req.getParameter("nome");
        String pSobrenome = req.getParameter("sobrenome");

        pessoa.setNome(pNome);
        pessoa.setSobrenome(pSobrenome);

        pessoa.setEndereco(this.enderecoFromRequest(req));

        return pessoa;

    }

}
