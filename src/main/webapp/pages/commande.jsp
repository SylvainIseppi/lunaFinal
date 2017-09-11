<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des commandes</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/styles/bootstrap.css"
	media="all" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/styles/style.css" media="all" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/styles/font-awesome.css">
<script>
	$(function() {
		$("#accordion").accordion();
	});
</script>
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
			<div id="accordion">
				<h3 class="ajout">Ajouter une Commande</h3>
				<div>
					<div class="row">
						<div class="col-sm-6">
							<s:form action="/insertCommande" name="commandeForm"
								method="post" theme="css_xhtml">
								<s:select list="lesClients" listValue="nom" listKey="id"
									name="id"></s:select>
								<select name="modepaiement">
									<option value="carte">Carte Bleue</option>
									<option value="cheque">Chèque</option>
									<option value="paypal">PayPal</option>
								</select>
								<s:submit value="Ajouter" />
							</s:form>
						</div>
						<div class="col-sm-6">
							test
							<form action="ajoutArticleCommande">
								<s:select list="lesArticles" listValue="designation"
									listKey="id" name="id"/><br />
								<s:textfield name="commande.quantite" placeholder="Quantité" />
								<s:submit value="Ajouter" />
							</form>
						</div>

					</div>
				</div>
				<h3 class="ajout">Liste des Commandes</h3>
				<div>
					<table class="table-center">
						<thead>
							<tr>
								<th>Désignation Article</th>
								<th>Quantité</th>
								<th>Prix</th>
								<th>Supprimer</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lesCommandes}" var="uneCommande">
								<td>${uneCommande.libelle }</td>
								<td>${uneCommande.quantite }</td>
								<td>${uneCommande.prixUnitaire }</td>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>