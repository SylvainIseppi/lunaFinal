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
			<s:a href="accueil.jsp"><h2 style="color: white">Accueil</h2></s:a>
			</br>
			<s:a action="accueilCategorie"><h2 style="color: white">Catégorie</h2></s:a>
			</br>
			<s:a action="accueilClient"><h2 style="color: white">Client</h2></s:a>
			</br>
			<s:a action="accueilArticle"><h2 style="color: white">Article</h2></s:a>
			</br>
			<s:a action="accueilCommande"><h2 style="color: white">Commande</h2></s:a>
		</div>
		<div class="col-sm-10 corp">
			<h2>Bienvenue sur l'application Luna, </br> parcourez le menu à gauche pour découvrir les différentes fonctionnalités de l'application.</h2>
		</div>
	</div>
</body>
</html>