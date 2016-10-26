<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
</head>
<body>

  <form method="post" action="livro.do">
    <fieldset>
      <legend>Cadastro de Livros</legend>

      <div>
        <label>
          Título
        </label>
        <input type="text" name="titulo" autofocus required>
      </div>

      <div>
        <label>
          Autor
        </label>
        <input type="text" name="autor" required>
      </div>

      <div>
        <label>
          ISBN
        </label>
        <input type="text" name="isbn" required>
      </div>

      <div>
      
        <button type="submit">
          Enviar
        </button>
      
      </div>

    </fieldset>
  </form>

</body>
</html>
