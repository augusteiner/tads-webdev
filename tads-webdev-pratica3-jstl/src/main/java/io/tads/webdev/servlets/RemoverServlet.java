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
package io.tads.webdev.servlets;

import static javax.servlet.http.HttpServletResponse.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.tads.webdev.ConnectionFactory;
import io.tads.webdev.ProdutoDAO;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
@WebServlet("/remover")
public class RemoverServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String pId = req.getParameter("id");

        if (pId == null) {

            resp.setStatus(SC_BAD_REQUEST);

        } else {

            int id = Integer.valueOf(pId);

            try {

                Connection conn = ConnectionFactory.openConnection();
                ProdutoDAO dao = new ProdutoDAO(conn);

                dao.remove(id);

                conn.close();

            } catch (SQLException e) {

                e.printStackTrace();

                throw new ServletException("Falha de comunicação com a base de dados", e);

            }

        }

        resp.sendRedirect(this.getServletContext().getContextPath() + "/");

    }

}
