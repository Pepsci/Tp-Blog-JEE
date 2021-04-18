
<%@ include file="/nav/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
	<h1>Blog CDA 314 </h1>
    

	<c:if test="${not empty utilisateur }">
		<h1>Bienvenue ${utilisateur} sur la version EE du Blog</h1>
	</c:if>
	<div class="skill">
		<div class="name" >
					<c:if test="${empty utilisateur }">
				<span>
						<a href="<%= request.getContextPath()+"/login"%>"> Se connecter </a>
		  		</span>
			  		</c:if>
					<c:if test="${empty utilisateur }">
		  		<span>
					<a href="<%= request.getContextPath()+"/inscription"%>"> S'inscrire </a>
				</span>
					</c:if>
		</div>
</div>

