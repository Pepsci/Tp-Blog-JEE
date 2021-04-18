<%@ include file="/nav/header.jsp" %>

<c:if test="${empty utilisateur }">
	<div class="skill">
		<div class="name" >
				<span>
						<a href="<%= request.getContextPath()+"/login"%>"> Se connecter </a>
		  		</span>
		  		<span>
					<a href="<%= request.getContextPath()+"/inscription"%>"> S'inscrire </a>
				</span>
</c:if>
<h1>${article}</h1>
<div>
	<c:if test="${not empty utilisateur }">
	<div id="redac">
		<h1>
			<p>Bienvenue</p>
			<p>sur la page</p>
			<p>de rédaction</p>
		</h1>
</div>	
	<form  id="redaction" method="post" action="<%= request.getContextPath()+"/redaction"%>">
	          <label>Titre</label>
	            <input type="text" name="titre" id="titre" placeholder="Entrez le titre de votre Article">
	          <label>Résumé</label>
	            <textarea name="resume" rows="10" id="resume" placeholder="Ici la rédaction d'un Résumé de votre Article"></textarea>
	          <label>Contenu</label>
	            <textarea name="contenu" rows="20" id="contenu" placeholder="Ici la rédaction du Contenu de votre Article"></textarea>
	            <button>Poster</button>
	</form>
</c:if>