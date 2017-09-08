<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/styles/bootstrap.css"
	"
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
			<s:a href="pages/accueil.jsp">accueil</s:a>
			<s:a action="accueilCategorie">Catégorie</s:a>
			<s:a action="accueilClient">Client</s:a>
			<s:a action="accueilArticle">Article</s:a>
			<s:a action="accueilCommande">Commande</s:a>
		</div>
		<div class="col-sm-10 corp">
			<div id="accordion">
				<h3 class="ajout">Ajouter un Article</h3>
				<div>
					<div>
						<p>
						<h1>ajouter une Categorie</h1>
						<s:form action="insertCategorie" theme="css_xhtml">
							<s:textfield name="categorie.libelle" label="libelle Categorie :" labelposition="left"></s:textfield>
							<s:submit value="Ajouter"></s:submit>
						</s:form>
					</div>
				</div>
				<h3 class="ajout">Liste des Articles</h3>
				<div>
					<table class="table-center">
						<thead>
							<tr>
								<th>id</th>
								<th>libelle</th>
								<th>update</th>
								<th>supprimer</th>

							</tr>

						</thead>
						<tbody>
							<c:forEach items="${lesCategories}" var="uneCat">
								<tr>
									<td>${uneCat.id}</td>
									<td>${uneCat.libelle}</td>
									<td><s:a action="/updateCategorie">
											<s:param name="idCategorie">${uneCat.id}</s:param>update</s:a></td>
									<td><s:a action="/supprimerCategorie">
											<s:param name="idCategorie">${uneCat.id}</s:param>supprimer</s:a></td>
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