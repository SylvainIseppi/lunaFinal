<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action="/valideUpdateClient">
		<s:textfield type="hidden" name="client.id"><s:param>${client.id }</s:param></s:textfield>
		<s:textfield name="client.nom"><s:param>${client.nom }</s:param></s:textfield>
		<s:textfield name="client.prenom"><s:param>${client.prenom }</s:param></s:textfield>
		<s:textfield name="client.adresse"><s:param>${client.adresse }</s:param></s:textfield>
		<s:textfield name="client.fixe"><s:param>${client.fixe }</s:param></s:textfield>
		<s:textfield name="client.mobile"><s:param>${client.mobile }</s:param></s:textfield>
		<s:textfield name="client.email"><s:param>${client.email }</s:param></s:textfield>
		<s:textfield name="client.remarque"><s:param>${client.remarque }</s:param></s:textfield>
		<s:textfield name="client.carteFidelite"><s:param>${client.carteFidelite }</s:param></s:textfield>
		<s:submit value="valider Update"></s:submit>
	</s:form>
</body>
</html>