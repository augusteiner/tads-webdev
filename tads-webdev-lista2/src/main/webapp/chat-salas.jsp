<%@ page import="java.util.Collection"  %>
<%@ page import="tads.webdev.chat.SalaChat"  %>

<% Collection<SalaChat> salas = (Collection<SalaChat>) request.getAttribute("salas"); %>

<fieldset>
  <legend>Escolha a sala de bate-papo</legend>
<% for (SalaChat sala : salas) { %>

  <div>
    <a href="chat-sala.do?salaId=<%= sala.getId() %>">
      <%= sala.getNome() %></a>
  </div>

<% } %>
</fieldset>