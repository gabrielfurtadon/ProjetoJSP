<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<title>Página JSP</title>
</head>

<style type="text/css">

#formLogin{
	position: absolute;
	top: 35%;
	left: 35%;
	right: 35%;
	
}


#titleLogin{
	position: absolute;
	top: 22%;
	left: 47%;
	right: 35%;
}

.msg{
display: flex;
/* position: absolute; */
	
	font-weight: normal;
	margin-left: 40%;
	margin-top: 39%;
	
	
}






</style>


<body>

	<div class="container">
		<h2 id="titleLogin">Login</h2>
	</div>
	<%-- <% out.println("Boa tarde"); %> --%>
	 
	
	<form action="servletLogin" method="post" class="row g-3 needs-validation" novalidate  id="formLogin" >
		<input type="hidden" value="<%= request.getParameter("url")%>" name="url" > <!-- QUANDO COLOCAR UMA VALOR DENTRO DE UMA TAG VALUE TEM QUE COLOCAR O = -->
		<!-- TABELA DE LOGIN -->
		<div class="mb-3">
				<label class="form-label">Login :</label>
				<input class="form-control" name="login" type="text" required> 
				<div class="valid-feedback">
	      			Login Preenchido
	    		</div>
	    		<div class="invalid-feedback">
        			Digite o Login.
      			</div>
		</div>
		<div class="mb-3">
				<label class="form-label">Senha :</label>
				<input class="form-control" name="senha" type="password" required>
				<div class="valid-feedback">
	      			Senha Preenchida
	    		</div>
	    		<div class="invalid-feedback">
        			Digite a Senha.
      			</div>
		</div>
		
			
			<input type="submit" value="Entrar" class="btn btn-primary">
			
   
		
	
	</form>
	
	
		<h4 class="msg">${msg}</h4>
	

	    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	
	<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function () {
	  'use strict'

	  // Fetch all the forms we want to apply custom Bootstrap validation styles to
	  var forms = document.querySelectorAll('.needs-validation')

	  // Loop over them and prevent submission
	  Array.prototype.slice.call(forms)
	    .forEach(function (form) {
	      form.addEventListener('submit', function (event) {
	        if (!form.checkValidity()) {
	          event.preventDefault()
	          event.stopPropagation()
	        }

	        form.classList.add('was-validated')
	      }, false)
	    })
	})()
	</script>

</body>
</html>