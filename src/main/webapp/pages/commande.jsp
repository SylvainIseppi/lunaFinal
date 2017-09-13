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
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/styles/font-awesome.css">
<script type="text/javascript" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script>
	$(function() {
		$("#accordion").accordion();
	});
	$(document).ready(function(){
	    $('#myTable').DataTable();
	});
</script>
</head>
<body>
	<div class="row first-row">
		<div class="col-sm-2 menu">
			<s:a href="accueil.jsp">
				<h2 style="color: white">Accueil</h2>
			</s:a>
			</br>
			<s:a action="accueilCategorie">
				<h2 style="color: white">Catégorie</h2>
			</s:a>
			</br>
			<s:a action="accueilClient">
				<h2 style="color: white">Client</h2>
			</s:a>
			</br>
			<s:a action="accueilArticle">
				<h2 style="color: white">Article</h2>
			</s:a>
			</br>
			<s:a action="accueilCommande">
				<h2 style="color: white">Commande</h2>
			</s:a>
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
									name="idClient"></s:select>
								<s:textfield type="hidden" value="listeCommande" />
								<select name="modepaiement">
									<option value="carte">Carte Bleue</option>
									<option value="cheque">Chèque</option>
									<option value="paypal">PayPal</option>
								</select>
								<s:submit value="Ajouter" />
							</s:form>
							<c:if test="${!empty detailCommandecopie }">
							<table class="table-center">
								<thead>
									<tr>
										<th>Article</th>
										<th>Quantité</th>
										<th>Prix Unitaire</th>
										<th>Prix Total</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${detailCommandecopie}" var="unArt">
										<tr>
											<td>${unArt.key.designation}</td>
											<td>${unArt.value}</td>
											<td>${unArt.key.prixUnitaire}</td>
											<c:set var="totalLigne"
												value="${unArt.key.prixUnitaire * unArt.value}"></c:set>
											<td>${totalLigne }</td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
							</c:if>
						</div>
						<div class="col-sm-6">
							<form action="ajoutArticleCommande">
								<s:select list="lesArticles" listValue="designation"
									listKey="id" name="idArticle" />
								<br />
								<s:textfield name="quantiteArt" placeholder="Quantité" />
								<s:submit value="Ajouter" />
							</form>
						</div>

					</div>
				</div>
				<h3 class="ajout">Liste des Commandes</h3>
				<div>
					<c:if test="${!empty lesCommandes }">
					<table class="table-center" id="myTable">
						<thead>
							<tr>
								<th>Client</th>
								<th>Adresse</th>
								<th>Prix</th>
								<th>Mode de Paiement</th>
								<th>Supprimer</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lesCommandes}" var="uneCommande">
								<tr>
									<td>${uneCommande.client.nom }  ${uneCommande.client.prenom }</td>
									<td>${uneCommande.client.adresse }</td>

									<c:set var="total" value="${0 }"></c:set>
									<c:forEach items="${uneCommande.articles }" var="unArticleCommande">

										<c:set var="total"
											value="${total + unArticleCommande.prixUnitaire }" />
									</c:forEach>
									<td>${total }</td>
									<td>${uneCommande.modePayement }
									<td> <s:a action="/deleteCommande">
											<s:param name="idCommande">${uneCommande.id}</s:param><span
												class="fa fa-trash"></span></s:a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>