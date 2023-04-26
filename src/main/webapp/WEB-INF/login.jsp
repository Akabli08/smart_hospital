<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="card col-md-6 offset-3 mt-2 bg-transparent">
			<div class="card">
				<div class="card-header justify-content-center ">Welcome Back</div>
				<div class="card-body">
				
					<c:if test="${error}">
						<div class="alert alert-danger">${errorMessage}</div>
					</c:if>
					<form action="<%=request.getContextPath()%>/login" method="post">
						<input type="text" name="method" value="connecter" hidden="true">
						<label for="" class="input-group-text my-2">Email: </label>
                		<input type="text" name="email" class="form-control my-2">
                		<label for="" class="input-group-text my-2">Password: </label>
                		<input type="text" name="password" class="form-control my-2">
                		<button class="btn btn-info offset-4 my-2" type="submit">Se Connecter</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>