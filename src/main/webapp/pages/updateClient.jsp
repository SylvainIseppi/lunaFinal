<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification Client</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/styles/bootstrap.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/styles/style.css"
	media="all" />
</head>
<body>
	<div class="row first-row">
		<div class="col-sm-2 menu">
			<s:a href="accueil.jsp">Accueil</s:a>
			<s:a action="accueilCategorie">Catégorie</s:a>
			<s:a action="accueilClient">Client</s:a>
			<s:a action="accueilArticle">Article</s:a>
			<s:a action="accueilCommande">Commande</s:a>
		</div>

		<div class="col-sm-10 corp">
			<h3>Modification Client ${client.nom }</h3>
			<s:form action="/valideUpdateClient" theme="css_xhtml">
				<s:textfield type="hidden" name="client.id"><s:param>${client.id }</s:param></s:textfield>
				<s:textfield name="client.nom" label="Nom" labelposition="left"><s:param>${client.nom }</s:param></s:textfield>
				<s:textfield name="client.prenom" label="Prénom" labelposition="left"><s:param>${client.prenom }</s:param></s:textfield>
				<s:textfield name="client.adresse" label="Adresse" labelposition="left"><s:param>${client.adresse }</s:param></s:textfield>
				<s:textfield name="client.fixe" label="Fixe" labelposition="left"><s:param>${client.fixe }</s:param></s:textfield>
				<s:textfield name="client.mobile" label="Mobile" labelposition="left"><s:param>${client.mobile }</s:param></s:textfield>
				<s:textfield name="client.email" label="Email" labelposition="left"><s:param>${client.email }</s:param></s:textfield>
				<s:textfield name="client.remarque" label="Remarques" labelposition="left"><s:param>${client.remarque }</s:param></s:textfield>
				<s:textfield name="client.carteFidelite" label="Carte de fidélité" labelposition="left"><s:param>${client.carteFidelite }</s:param></s:textfield>
				<s:submit class="btn btn-primary" value="Valider"></s:submit>
			</s:form>
		</div>
	</div>
</body>
</html>