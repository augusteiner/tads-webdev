<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <style type="text/css">
      input, textarea {
        width: 100%;
        display: inline;
      }
      textarea {
        min-height: 80px;
      }
    </style>
  </head>
  <body>
    <form action="email.do" method="post">
      <fieldset>
        <legend>Enviar e-mail</legend>

        <div>
          <label>
            Destinatário(s)
            <br>
            <input type="text" name="destinatarios" placeholder="Lista de destinatários separados por virgula">
          </label>
        </div>

        <div>
          <label>
            Assunto
            <br>
            <input type="text" name="assunto" placeholder="Assunto do e-mail">
          </label>
        </div>

        <div>
          <label>
            Mensagem
            <br>
            <textarea name="mensagem" placeholder="Mensagem a ser enviada"></textarea>
          </label>
        </div>

        <div style="margin: 10px 0;">
            <div style="float: right;">
                <button type="submit">Enviar</button>
            </div>
            <div style="clear: both;"></div>
        </div>

      </fieldset>
    </form>
  </body>
</html>