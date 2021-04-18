<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()+"/css/header.css"%>">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()+"/css/inscription.css"%>">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()+"/css/index.css"%>">
<title>Insert title here</title>
</head>
<body>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav>
  <ul>
    <li><a href="<%= request.getContextPath()+"/menu/Accueil.jsp"%>">Accueil</a></li>
    <li><a href="<%= request.getContextPath()+"/listearticle"%>">Articles</a></li>
    <li><a href="<%= request.getContextPath()+"/redaction"%>">Rédiger un Article</a></li>
    <li><a href="<%= request.getContextPath()+"/menu/Contact.jsp"%>">Contact</a></li>
  </ul>
</nav>
<div id="connect">
  <ul>
  	<li>
		<c:if test="${empty utilisateur }">
			<a href="<%= request.getContextPath()+"/login"%>"> Se connecter </a>
  		</c:if>
		<c:if test="${not empty utilisateur }">
		      			${utilisateur }|<button type="button" class="deconnection">
		   <a href="<%= request.getContextPath()+"/logout"%>"> Se déconnecter </a>
		   </button>
		</c:if>
  	</li>
  </ul>
</div>
