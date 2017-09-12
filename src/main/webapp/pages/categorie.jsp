<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des Catégories</title>
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
				<h3 class="ajout">Ajouter une Catégorie</h3>
				<div>
					<div>
						<s:form action="insertCategorie" theme="css_xhtml">
							<s:textfield name="categorie.libelle" label="libelle Categorie" labelposition="left"></s:textfield>
							<s:submit class="btn btn-primary" value="Ajouter"></s:submit>
						</s:form>
					</div>
				</div>
				<h3 class="ajout">Liste des Catégories</h3>
				<div>
					<table class="table-center">
						<thead>
							<tr>
								<th>Id</th>
								<th>Libelle</th>
								<th>Modifier</th>
								<th>Supprimer</th>

							</tr>

						</thead>
						<tbody>
							<c:forEach items="${lesCategories}" var="uneCat">
								<tr>
									<td>${uneCat.id}</td>
									<td>${uneCat.libelle}</td>
									<td><s:a action="/updateCategorie">
											<s:param name="idCategorie">${uneCat.id}</s:param><span
												class="fa fa-pencil"></span></s:a></td>
									<td><s:a action="/supprimerCategorie">
											<s:param name="idCategorie">${uneCat.id}</s:param><span
												class="fa fa-trash"></span></s:a></td>
								</tr>

							</c:forEach>
						</tbody>

					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>