<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Gerência de Produtos</title>
  <style>
    table {
      border-collapse: collapse;
      width: 100%;
    }
    table, th, td {
      border: 1px solid black;
    }
  </style>
</head>
<body>
  <h3>Produtos Cadastrados</h3>
  <form method="post" action="">
    <div>
      Filtrar por Nome: <input type="text" name="nome" placeholder="Filtro vazio lista todos" value="${param.nome}">
      <button type="submit">Filtrar</button>
    </div>
  </form>
  <table>
    <thead>
      <tr>
        <td>
          ID
        </td>
        <td>
          NOME
        </td>
        <td>
          PRECO UNIT.
        </td>
        <td>
          UNIDADE
        </td>
        <td>
          QTE. ESTOQUE
        </td>
        <td>
          AÇÕES
        </td>
      </tr>
    </thead>
    <tfoot>
    </tfoot>
    <tbody>
      <c:forEach var="produto" items="${lista}">
        <tr>
          <td>
            ${produto.id}
          </td>
          <td>
            ${produto.nome}
          </td>
          <td>
            ${produto.preco}
          </td>
          <td>
            ${produto.unidade}
          </td>
          <td>
            ${produto.quantidade}
          </td>
          <td>
            <a href="remover?id=${produto.id}">Remover</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
