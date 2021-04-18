<%@ include file="/index.jsp" %>

	<center>
        <form method="post" action="<%= request.getContextPath()+"/inscription"%>">
          <label>Nom</label>
            <input type="text" name="nom" id="nom" placeholder="Entrez votre nom">
          <label>Prenom</label>
            <input type="text" name="prenom" id="prenom" placeholder="Entrez votre Prenom">
          <label>Email</label>  
            <input type="text" name="email" id="email" placeholder="Entrez un Email">
           <label>Password</label>
           	<input type="password" name="password" placeholder="Entrez votre PassWord">
            <button>Valider</button>
        </form> 
	</center>
</body>
</html>