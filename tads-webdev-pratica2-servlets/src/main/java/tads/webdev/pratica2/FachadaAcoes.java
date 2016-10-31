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
package tads.webdev.pratica2;

import java.math.BigDecimal;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class FachadaAcoes {

    public static final int QTE_ACOES_LOTE = 1000;
    private static int qteAcoesAtual = QTE_ACOES_LOTE;

    public static final BigDecimal VALOR_POR_ACAO = BigDecimal.valueOf(102.00);

    public static synchronized void comprarAcoes(Usuario usuario, int qte)
        throws TransacaoException {

        if (qte > qteAcoesAtual) {

            throw new TransacaoException(String.format(
                "Usuario não pode comprar mais ações que o máximo (%d)",
                qteAcoesAtual));

        }

        usuario.setQteAcoes(usuario.getQteAcoes() + qte);

        usuario.setSaldo(VALOR_POR_ACAO.multiply(BigDecimal.valueOf(usuario.getQteAcoes())));

        qteAcoesAtual -= qte;

    }

    public static synchronized void venderAcoes(Usuario usuario, int qte)
        throws TransacaoException {

        if (qte > usuario.getQteAcoes()) {

            throw new TransacaoException(String.format(
                "Usuario não pode vender mais ações que o máximo (%d)",
                usuario.getQteAcoes()));

        }

        usuario.setQteAcoes(usuario.getQteAcoes() - qte);

        usuario.setSaldo(VALOR_POR_ACAO.multiply(BigDecimal.valueOf(usuario.getQteAcoes())));

        qteAcoesAtual += qte;

    }

    public static int getQteAcoesAtual() {

        return qteAcoesAtual;
    }

}
