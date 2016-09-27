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
package tads.webdev.impl.mvc.util;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class MvcServlet extends HttpServlet {

    private static final int NOT_FOUND = HttpServletResponse.SC_NOT_FOUND;
    private static final String PATH_SEPARATOR = "/";
    private String pkg;

    @Override
    public void init() throws ServletException {

        super.init();

        this.pkg = this.getInitParameter("package");

        if (this.pkg == null) {

            throw new ServletException("Parametro 'package' deve ser configurado");

        }

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String path = req.getPathInfo();
        String ctrlrName = "Index";
        String actionName = "Index";

        if (path != PATH_SEPARATOR) {

            String[] pathInfo = path.split(PATH_SEPARATOR);

            if (pathInfo.length != 3) {

                resp.setStatus(NOT_FOUND);
                resp.getOutputStream().print(
                    "Path deve ser <Controller>/<Action>");

                return;

            }

            ctrlrName = pathInfo[1];
            actionName = pathInfo[2];
        }

        Class<?> ctrlrCls;

        try {

            ctrlrCls = Class.forName(String.format(
                "%s.%s",

                this.pkg,
                String.format("%sController", ctrlrName)));

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

            resp.setStatus(NOT_FOUND);
            resp.getOutputStream().print(String.format(
                "Controller '%s' não encontrado",
                ctrlrName));

            return;

            //throw new ServletException(
            //    String.format(
            //        "Controller '%s' não encontrado",
            //        ctrlrName),
            //    e);

        }

        Method action;

        try {

            action = ctrlrCls.getMethod(
                actionName,
                (Class<?>[]) null);

        } catch (Exception e) {

            e.printStackTrace();

            resp.setStatus(NOT_FOUND);
            resp.getOutputStream().print(String.format(
                "Action '%s' não encontrada",
                actionName));

            return;

            //throw new ServletException(
            //    String.format(
            //        "Action '%s' não encontrada",
            //        actionName),
            //    e);

        }

        String content;

        try {

            content = (String) action.invoke(ctrlrCls.newInstance());

        } catch (Exception e) {

            throw new ServletException(
                String.format(
                    "Erro ao executar action '%s'",
                    actionName),
                e);

        }

        resp.setContentType("text/html");
        resp.getOutputStream().print(content);

    }

}
