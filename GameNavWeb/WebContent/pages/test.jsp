<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.bitducks.gamenav.ejb.entity.Univers"%>
<%@page import="java.util.List"%>
This is the body.
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