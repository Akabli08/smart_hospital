<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../shared/header.jsp"/>
    <jsp:include page="../shared/sidebar.jsp"/>
    
    <div class="container">
		<div class="card">
		<div class="card-header"></div>
		<div class="card-body">
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Date Naissance</th>
						<th>#</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${medecins}" var="m">
						<tr>
							<td>${m.getIdUtilisateur()}</td>
							<td>${m.getNom()}</td>
							<td>${m.getPrenom()}</td>
							<td>${m.getEmail()}</td>
							<td>
								<button class="btn btn-warning">Update</button>
								<button class="btn btn-danger">Remove</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>
    <jsp:include page="../shared/footer.jsp"/>
</body>
</html>