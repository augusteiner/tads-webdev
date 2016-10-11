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
package tads.web.pratica.servlets.q1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Questao_01_HttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        processarRequisicao(req, resp, Operacao.SOMA);

    }

    private void processarRequisicao(
        HttpServletRequest req,
        HttpServletResponse resp,
        Operacao operacao)

        throws IOException, ServletException {

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        String n1 = req.getParameter("n1");
        String n2 = req.getParameter("n2");

        if (n1 != null && n2 != null) {

            double d1, d2;

            try {

                d1 = Double.valueOf(n1);
                d2 = Double.valueOf(n2);

            } catch (NumberFormatException e) {

                writer.println(String.format(
                        "<span>Erro ao converter entradas: %s</span>",
                        e.getMessage()));

                return;
            }

            writer.println(String.format(
                "%f %s %f = %f",
                d1,
                operacao.comoString(),
                d2,
                realizarOperacao(d1, d2, operacao)));

        } else {

            writer.println("<span>forneça a url no formato ?n1=?&n2=?</span>");

        }
    }

    private double realizarOperacao(double d1, double d2, Operacao operacao)
        throws ServletException {

        switch (operacao)
        {
            case SOMA:
                return d1 + d2;
            case SUBTRACAO:
                return d1 - d2;
            default:
                throw new ServletException("");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        processarRequisicao(req, resp, Operacao.SUBTRACAO);

    }

}
