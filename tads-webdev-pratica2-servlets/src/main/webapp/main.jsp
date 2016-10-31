<%@ page errorPage="error.jsp" %>

<%@ page import="tads.webdev.pratica2.FachadaAcoes"%>
<%@ page import="tads.webdev.pratica2.Usuario" %>

<% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>

<fieldset>
  <legend>Resumo das ações</legend>

  <label>
  </label>

  <form method="post" action="main">
    <fieldset>
      <legend>Operações com ações</legend>

        <div>
          Ações disponíveis: <%= FachadaAcoes.getQteAcoesAtual() %> * <%= FachadaAcoes.VALOR_POR_ACAO %>
        </div>

        <div>
          Saldo de ações: <%= usuario.getQteAcoes() %> * R$ <%= FachadaAcoes.VALOR_POR_ACAO %> = R$ <%= usuario.getSaldo() %>
        </div> 

        <input type="number" name="qte" value="1" placeholder="Quantidade a vender/comprar">

        <div>
          <button type="submit" name="operacao" value="comprar">
            Comprar Ações
          </button>
        </div> 

        <div>
          <button type="submit" name="operacao" value="vender">
            Vender Ações
          </button>
        </div>

    </fieldset>
  </form>

</fieldset>