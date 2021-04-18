<%@ include file="/index.jsp" %>

	<center>
	<form id="formulaire" method="post" action="<%= request.getContextPath()%>/login">
       <label>Email</label>  
          <input type="text" name="email" id="email" placeholder="Entrez un Email">
        <label>Password</label>
      		<input type="text" name="password" id="passeword" placeholder=" Mot de pass">
       <button type="submit">Valider</button>
	</form> 
	</center>
</body>
</html>