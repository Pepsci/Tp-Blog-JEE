<%@ include file="/nav/header.jsp" %>


<h1>Je suis la page article ${utilisateur }</h1>




<ul>
	<c:forEach var="art" items="${listArticles}">
		<div class="article articlebg">	
			<p class="article"><b>Titre : </b><c:out value="${art.titre}" /></p>
			<p class="article"><b>Résumé : </b><c:out value="${art.resume}" /></p>
			<p class="article"><b>Contenu : </b><c:out value="${art.contenu}" /><c:out value="${art.contenu}" /></p>
		</div>	
	</c:forEach>

</ul>







</body>
</html>