<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification Catégorie</title>
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
			<h3>Modification Catégorie ${categorie2.libelle }</h3>
			<s:form action="/valideUpdateCategorie" theme="css_xhtml">
				<s:textfield type="hidden" name="categorie2.id"><s:param>${categorie2.id }</s:param> </s:textfield>
				<s:textfield name="categorie2.libelle" label="Désignation" labelposition="left"><s:param>${article2.libelle } </s:param> </s:textfield>
				<s:submit class="btn btn-primary" value="Valider"></s:submit>
			</s:form>
		</div>
	</div>
</body>
</html>