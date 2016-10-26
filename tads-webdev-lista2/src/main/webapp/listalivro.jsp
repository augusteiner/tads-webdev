<%@ page import="tads.webdev.Livro" %>
<%

  Livro livro;

  // livro = (Livro) request.getAttribute("livro");
  // livro = (Livro) application.getAttribute("livro");
  livro = (Livro) session.getAttribute("livro");

%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
</head>
<body>
  <fieldset>
    <legend><%= livro %></legend>
    <div>
      <strong>Título</strong>: <%= livro.getTitulo() %>
    </div>
    <div>
      <strong>Autor</strong>: <%= livro.getAutor() %>
    </div>
    <div>
      <strong>ISBN</strong>: <%= livro.getIsbn() %>
    </div>
  </fieldset>
</body>
</html>