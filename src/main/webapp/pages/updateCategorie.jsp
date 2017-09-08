<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<s:form action="/valideUpdateCategorie">
		<s:textfield type="hidden" name="categorie2.id"><s:param>${categorie2.id }</s:param> </s:textfield>
		<s:textfield name="categorie2.libelle" label="designation" ><s:param>${article2.libelle } </s:param> </s:textfield>
		<s:submit value="valider Update"></s:submit>
	</s:form>
</body>
</html>