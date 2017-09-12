<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des Clients</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/styles/bootstrap.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/styles/style.css"
	media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath }js/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }styles/font-awesome.css">
<script>
	$(function() {
		$("#accordion").accordion();
	})
</script>
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
			<div id="accordion">
				<h3 class="ajout">Ajouter un Client</h3>
				<div>
					<div>
						<p>
							<s:form action="/insertClient" name="clientForm" method="post"
								theme="css_xhtml">
								<s:textfield name="client.nom" label="Nom" labelposition="left" />
								<s:textfield name="client.prenom" label="Prénom" labelposition="left" />
								<s:textfield name="client.adresse" label="Adresse" labelposition="left" />
								<s:textfield name="client.fixe" label="Fixe" labelposition="left" />
								<s:textfield name="client.mobile" label="Mobile" labelposition="left" />
								<s:textfield name="client.email" label="Email" labelposition="left" />
								<s:textfield name="client.remarque" label="Remarques" labelposition="left" />
								<s:radio label="Carte de fidelité" labelposition="left" name="client.carteFidelite"
									list="#{'false':'Non','true':'Oui'}" />
								<s:submit class="btn btn-primary" value="Valider"></s:submit>
							</s:form>
						</p>
					</div>
				</div>
				<h3 class="ajout">Liste des Clients</h3>
				<div>
					<table class="table-center">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Prénom</th>
								<th>Adresse</th>
								<th>Fixe</th>
								<th>Mobile</th>
								<th>Email</th>
								<th>Remarques</th>
								<th>Carte de fidélité</th>
								<th>Date d'inscription</th>
								<th>Modifier</th>
								<th>Supprimer</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lesClients}" var="unClient">
								<tr>
									<td>${unClient.nom}</td>
									<td>${unClient.prenom}</td>
									<td>${unClient.adresse}</td>
									<td>${unClient.fixe}</td>
									<td>${unClient.mobile}</td>
									<td>${unClient.email}</td>
									<td>${unClient.remarque}</td>
									<td>${unClient.carteFidelite}</td>
									<td>${unClient.dateCreation}</td>
									<td><s:a action="/updateClient">
											<s:param name="idClient">${unClient.id}</s:param><span
												class="fa fa-pencil"></span></s:a></td>
									<td><s:a action="/supprimerClient">
											<s:param name="idClient">${unClient.id}</s:param><span
												class="fa fa-trash"></span></s:a></td>
							</c:forEach>
						</tbody>

					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>