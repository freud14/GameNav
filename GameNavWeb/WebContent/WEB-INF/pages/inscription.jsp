<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<fmt:setBundle basename="org.bitducks.gamenav.servlet.i18n.Inscription" />
<form class="form-horizontal" method="post">
	<fieldset>
		<legend>
			<fmt:message key="inscription.label.page" />
		</legend>

		<c:if test="${!empty errors.email}">
			<c:set var="status_email" value="error" />
		</c:if>
		<div class="control-group ${status_email}">
			<label class="control-label" for="email"><fmt:message
					key="inscription.label.email" /></label>
			<div class="controls">
				<input type="text" class="input-xlarge" id="email" name="email"
					value="<c:out value="${param.email}" />" />
				<c:if test="${!empty errors.email}">
					<span class="help-inline"><fmt:message key="${errors.email}" />
					</span>
				</c:if>
			</div>
		</div>

		<c:if test="${!empty errors.login}">
			<c:set var="status_login" value="error" />
		</c:if>
		<div class="control-group ${status_login}">
			<label class="control-label" for="login"><fmt:message
					key="inscription.label.login" /></label>
			<div class="controls">
				<input type="text" class="input-xlarge" id="login" name="login"
					value="<c:out value="${param.login}" />" />
				<c:if test="${!empty errors.login}">
					<span class="help-inline"><fmt:message key="${errors.login}" />
					</span>
				</c:if>
			</div>
		</div>

		<c:if test="${!empty errors.password}">
			<c:set var="status_password" value="error" />
		</c:if>
		<div class="control-group ${status_password}">
			<label class="control-label" for="password"><fmt:message
					key="inscription.label.password" /></label>
			<div class="controls">
				<input type="password" class="input-xlarge" id="password"
					name="password" />
				<c:if test="${!empty errors.password}">
					<span class="help-inline"><fmt:message
							key="${errors.password}" /> </span>
				</c:if>
			</div>
		</div>

		<c:if test="${!empty errors.password_confirmation}">
			<c:set var="status_password_confirmation" value="error" />
		</c:if>
		<div class="control-group ${status_password_confirmation}">
			<label class="control-label" for="password_confirmation"><fmt:message
					key="inscription.label.password_confirmation" /></label>
			<div class="controls">
				<input type="password" class="input-xlarge"
					id="password_confirmation" name="password_confirmation">
				<c:if test="${!empty errors.password_confirmation}">
					<span class="help-inline"><fmt:message
							key="${errors.password_confirmation}" /> </span>
				</c:if>
			</div>
		</div>

		<hr />

		<c:if test="${!empty errors.univers}">
			<c:set var="status_univers" value="error" />
		</c:if>
		<div class="control-group ${status_univers}">
			<label class="control-label" for="univers"><fmt:message
					key="inscription.label.univers" /></label>
			<div class="controls">
				<select name="univers">
					<option value="">
						<fmt:message key="inscription.label.univers.emptylist" />
					</option>

					<c:forEach var="u" items="${univers}">

						<c:choose>
							<c:when test="${param.univers == u.id}">
								<option value="<c:out value="${u.id}" />" selected="selected">
									<c:out value="${u.nom}" />
								</option>
							</c:when>
							<c:otherwise>
								<option value="<c:out value="${u.id}" />">
									<c:out value="${u.nom}" />
								</option>
							</c:otherwise>
						</c:choose>

					</c:forEach>

				</select>
				<c:if test="${!empty errors.univers}">
					<span class="help-inline"><fmt:message
							key="${errors.univers}" /> </span>
				</c:if>
			</div>
		</div>

		<c:if test="${!empty errors.planete}">
			<c:set var="status_planete" value="error" />
		</c:if>
		<div class="control-group ${status_planete}">
			<label class="control-label" for="planete"><fmt:message
					key="inscription.label.planete" /></label>
			<div class="controls">
				<input type="text" class="input-xlarge" id="planete" name="planete"
					value="<c:out value="${param.planete}" />" />
				<c:if test="${!empty errors.planete}">
					<span class="help-inline"><fmt:message
							key="${errors.planete}" /> </span>
				</c:if>
			</div>
		</div>

		<div class="form-actions">
			<button type="submit" class="btn btn-primary">
				<fmt:message key="inscription.label.form.submit" />
			</button>
			<button type="reset" class="btn">
				<fmt:message key="inscription.label.form.cancel" />
			</button>
		</div>
	</fieldset>
</form>