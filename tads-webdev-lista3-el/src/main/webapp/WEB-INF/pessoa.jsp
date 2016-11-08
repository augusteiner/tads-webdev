<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Exibindo Cookie</title>
  </head>
  <body>

    <fieldset>
      <legend>Informações da Pessoa</legend>

      <div>
        <label>
          Nome
        </label>
        ${sessionScope.pessoa.nome}
      </div>

      <div>
        <label>
          Sobrenome
        </label>
        ${sessionScope.pessoa.sobrenome}
      </div>

      <fieldset>
        <legend>Endereço</legend>

        <div>
          <label>
            Rua
          </label>
          ${sessionScope.pessoa.endereco.rua}
        </div>

        <div>
        </div>
      </fieldset>

    </fieldset>

  </body>
</html>
