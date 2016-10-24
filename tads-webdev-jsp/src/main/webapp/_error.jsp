<%@ page import="java.io.PrintWriter" %>
<%@ page isErrorPage="true" %>

<h1>Erro na aplicação!</h1>

<div>
  <strong>Mensagem</strong>: <%= exception.getMessage() %>
</div>

<div>
  <strong>Trace:</strong>
  <pre>
    <% exception.printStackTrace(new PrintWriter(out)); %>
  </pre>
</div>