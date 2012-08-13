<%@page import="org.bitducks.gamenav.ejb.entity.Univers"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<label class="control-label" for="joueur_planete">Nom de la
				planète mère</label>
			<div class="controls">
				<input type="text" class="input-xlarge" id="joueur_planete"
					name="joueur_planete">
			</div>
		</div>


		<div class="form-actions">
			<input type="submit" class="btn btn-primary" value="Créer un compte" />
			<a class="btn">Annuler</a>
		</div>
	</fieldset>
</form>