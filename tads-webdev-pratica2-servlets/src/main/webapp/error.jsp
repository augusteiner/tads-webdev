<%@page import="java.io.PrintWriter"%>
<%@ page isErrorPage="true" %>
<h1>Erro!</h1>

<h2><%= exception.getMessage() %></h2>

<pre>

<% exception.printStackTrace(new PrintWriter(out)); %>

</pre>