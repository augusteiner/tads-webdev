<%@ page import="tads.webdev.chat.MemoriaChat"  %>
<%@ page import="tads.webdev.chat.SalaChat"  %>

<%! MemoriaChat memoria = MemoriaChat.instance(); %>

<fieldset>
  <legend>Escolha a sala de bate-papo</legend>
<% for (SalaChat sala : memoria.getSalas()) { %>

  <div>
    <a href="chat-sala.jsp?salaId=<%= sala.getId() %>">
      <%= sala.getNome() %></a>
  </div>

<% } %>
</fieldset>