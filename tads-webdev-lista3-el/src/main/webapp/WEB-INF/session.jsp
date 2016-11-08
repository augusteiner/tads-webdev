<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Exibindo Cookie</title>
  </head>
  <body>

    <form action="session" method="post">

      <fieldset>
        <legend>Cadastro de Pessoas</legend>

        <div>
          <label>
            Nome
          </label>
          <input name="nome" type="text">
        </div>

        <div>
          <label>
            Sobrenome
          </label>
          <input name="sobrenome" type="text">
        </div>

        <fieldset>
          <legend>Endereço</legend>

          <div>
            <label>
              Rua
            </label>
            <input name="endereco[rua]" type="text">
          </div>

          <div>
          </div>
        </fieldset>

        <div>
          <button type="submit">
            Salvar</button>
        </div>

      </fieldset>

    </form>

  </body>
</html>
