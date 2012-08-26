<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--           <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> -->
<!--             <span class="icon-bar"></span> -->
<!--             <span class="icon-bar"></span> -->
<!--             <span class="icon-bar"></span> -->
<!--           </a> -->
<a class="brand" href="#">Project name</a>
<div class="btn-group pull-right">
	<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"> <i
		class="icon-user"></i> Username <span class="caret"></span>
	</a>
	<ul class="dropdown-menu">
		<li><a href="<c:url value="/inscription#"/>">Profile</a></li>
		<li class="divider"></li>
		<li><a href="<c:url value="/inscription#"/>">Sign Out</a></li>
	</ul>
</div>
<div class="nav-collapse">
	<ul class="nav">
		<li class="active"><a href="<c:url value="/inscription#"/>">Home</a></li>
		<li><a href="<c:url value="/inscription#about"/>">About</a></li>
		<li><a href="<c:url value="/inscription#contact"/>">Contact</a></li>
	</ul>
</div>