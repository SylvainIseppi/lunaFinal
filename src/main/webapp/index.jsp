<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Authentification</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css"
	media="all" />
	<link rel="stylesheet" type="text/css" href="styles/style.css"media="all" />
</head>
<body>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4 login">
			<s:form name="loginForm" method="POST" action="j_spring_security_check" theme="css_xhtml">
			<div class="espace-top">
				<h2>
					<img src="images/Moon-32.png" />SARL Luna
				</h2>
			</div>
			<div class="espace-top">
				<h5>Identification</h5>
			</div>
			<div class="espace-top">
				<s:textfield type="text"  name="username"
					placeholder="Nom d'utilisateur" requiredLabel="true" />
			</div>
			<div class="espace-top">
				<s:textfield type="password"  name="password"
					placeholder="Mot de passe" requiredLabel="true" />			
			</div>	
			<div class="espace-top">
				<s:submit type="submit" class="btn btn-primary "
					value="Valider" />			
			</div>
			</s:form>
		</div>
		<div class="col-md-4"></div>
	</div>
</body>
</html>