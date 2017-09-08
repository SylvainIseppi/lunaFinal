<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/styles/bootstrap.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/styles/style.css"
	media="all" />
</head>
<body>
	<div class="row first-row">
		<div class="col-sm-2 menu">
			<s:a href="pages/accueil.jsp">accueil</s:a>
			<s:a action="accueilCategorie">Categorie </s:a>
			<s:a action="accueilClient">Client </s:a>
			<s:a action="accueilArticle">Article </s:a>
			<s:a action="accueilCommande">Commande </s:a>
		</div>

		<div class="col-sm-10 corp">
			<h3>Update Article ${article2.designation }</h3>
			<s:form action="/valideUpdateArticle" theme="css_xhtml">
				<s:textfield type="hidden" name="article2.id" labelposition="left">
					<s:param>${article2.id }</s:param>
				</s:textfield>
				<s:textfield name="article2.designation" label="designation"
					labelposition="left">
					<s:param>${article2.designation } </s:param>
				</s:textfield>
				<s:textfield name="article2.quantiteStock" label="quantite stock"
					labelposition="left">
					<s:param>${article2.quantiteStock } </s:param>
				</s:textfield>
				<s:textfield name="article2.prixUnitaire" label="prix unitaire"
					labelposition="left">
					<s:param>${article2.prixUnitaire } </s:param>
				</s:textfield>
				<s:select list="lesCategories" label="categories"
					labelposition="left" listValue="libelle" listKey="id"
					name="idCateg"></s:select>
				<s:submit value="valider Update" class="btn btn-primary"></s:submit>
			</s:form>
		</div>
	</div>
</body>
</html>