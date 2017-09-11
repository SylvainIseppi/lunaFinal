<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/styles/bootstrap.css" media="all" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/styles/style.css" media="all" />
</head>
<body>
	<div class="row first-row">
		<div class="col-sm-2 menu">
			<s:a href="accueil.jsp">accueil</s:a>
			<s:a action="accueilCategorie">Categorie </s:a>
			<s:a action="accueilClient">Client </s:a>
			<s:a action="accueilArticle">Article </s:a>
			<s:a action="accueilCommande">Commande </s:a>
		</div>
	</div>
</body>
</html>