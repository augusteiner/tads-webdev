<%@ page import="tads.webdev.chat.MemoriaChat" %>
<%@ page import="tads.webdev.chat.SalaChat" %>

<%! MemoriaChat memoria = MemoriaChat.instance(); %>
<%! long salaId; %>
<%  this.salaId = Integer.valueOf(request.getParameter("salaId")); %>
<%! SalaChat sala = memoria.getSala(this.salaId); %>
<% out.print(this.sala); %>
