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
package io.tads.webdev.pratica4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {

        this.connection = connection;

    }

    public Produto buscarPorId(int produtoId) throws SQLException {

        String sql = ""
            + "SELECT id, descricao, validade, preco "
            + "FROM produto "
            + "WHERE id = ?";

        PreparedStatement ps = this.getConnection().prepareStatement(sql);

        ps.setInt(1, produtoId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Produto produto = new Produto();

            produto.setId(rs.getInt("id"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setValidade(rs.getDate("validade"));
            produto.setPreco(rs.getDouble("preco"));

            ps.close();
            rs.close();

            return produto;

        } else {

            return null;

        }

    }

    public Connection getConnection() {

        return this.connection;

    }

    public Collection<Produto> listar() throws SQLException {

        String sql = "SELECT id, descricao, validade, preco FROM produto";

        PreparedStatement ps = this.getConnection().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        ArrayList<Produto> lista = new ArrayList<Produto>();

        while (rs.next()) {

            Produto produto = new Produto();

            produto.setId(rs.getInt("id"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setValidade(rs.getDate("validade"));
            produto.setPreco(rs.getDouble("preco"));

            lista.add(produto);

        }

        ps.close();
        rs.close();

        return lista;

    }

    public void removerPorId(int id) throws SQLException {

        String sql = "DELETE FROM produto WHERE id = ?";

        PreparedStatement ps = this.getConnection().prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();

        ps.close();

    }

    public void salvar(Produto produto) throws SQLException {

        String sql = ""
                + "INSERT INTO produto (id, descricao, validade, preco) "
                + "  VALUES (?, ?, ?, ?) "

                + "ON DUPLICATE KEY UPDATE "
                + "  descricao = VALUES(descricao), "
                + "  validade = VALUES(validade), "
                + "  preco = VALUES(preco) ";

        PreparedStatement ps = this.getConnection().prepareStatement(sql);

        ps.setInt(1, produto.getId());
        ps.setString(2, produto.getDescricao());
        ps.setDate(3, new java.sql.Date(produto.getValidade().getTime()));
        ps.setDouble(4, produto.getPreco());

        ps.executeUpdate();

        ps.close();

    }

}
