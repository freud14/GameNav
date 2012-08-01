<%@page import="org.bitducks.gamenav.ejb.entity.Univers"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<!--           <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> -->
				<!--             <span class="icon-bar"></span> -->
				<!--             <span class="icon-bar"></span> -->
				<!--             <span class="icon-bar"></span> -->
				<!--           </a> -->
				<a class="brand" href="#">Project name</a>
				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i> Username <span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">Profile</a></li>
						<li class="divider"></li>
						<li><a href="#">Sign Out</a></li>
					</ul>
				</div>
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Sidebar</li>
						<li class="active"><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li class="nav-header">Sidebar</li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li class="nav-header">Sidebar</li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->


			<div class="span9">
				<!-- 				<div class="hero-unit"> -->
				<form class="form-horizontal" method="post">
					<fieldset>
						<legend>Inscription</legend>
						<div class="control-group">
							<label class="control-label" for="joueur_email">Adresse
								courriel</label>
							<div class="controls">
								<input type="text" class="input-xlarge" id="joueur_email"
									name="joueur_email">
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="joueur_login">Nom
								d'utilisateur</label>
							<div class="controls">
								<input type="text" class="input-xlarge" id="joueur_login"
									name="joueur_login">
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="joueur_password">Mot de
								passe</label>
							<div class="controls">
								<input type="password" class="input-xlarge" id="joueur_password"
									name="joueur_password">
							</div>
						</div>

						<hr />

						<div class="control-group">
							<label class="control-label" for="joueur_univers">Univers</label>
							<div class="controls">
								<select name="joueur_univers">
									<option value=""></option>
									<%
										@SuppressWarnings("unchecked")
										List<Univers> univers = (List<Univers>) request
												.getAttribute("univers");
										for (Univers u : univers) {
									%>
									<option value="<%=u.getId()%>"><%=u.getNom()%></option>
									<%
										}
									%>
								</select>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="joueur_planete">Nom de
								la planète mère</label>
							<div class="controls">
								<input type="text" class="input-xlarge" id="joueur_planete"
									name="joueur_planete">
							</div>
						</div>


						<div class="form-actions">
							<input type="submit" class="btn btn-primary"
								value="Créer un compte" /> <a class="btn">Annuler</a>
						</div>
					</fieldset>
				</form>
			</div>
			<!-- 			</div> -->
			<!--/span-->
		</div>
		<!--/row-->

		<hr />

		<footer>
			<p>&copy; Company 2012</p>
		</footer>

	</div>
	<!--/.fluid-container-->

</body>
</html>