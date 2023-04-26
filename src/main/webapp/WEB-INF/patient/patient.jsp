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
		<div class="card-header">
			<a href="<%=request.getContextPath()%>/addpatient">ajouter un patient</a>
		</div>
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
					<c:forEach items="${patients}" var="p">
						<tr>
							<td>${p.getIdPatient()}</td>
							<td>${p.getNom()}</td>
							<td>${p.getPrenom()}</td>
							<td>${p.getDateNaissance()}</td>
							<td>
								<form action="<%=request.getContextPath()%>/consultationpatient" method="get">
									<c:if test="${sessionScope.utilisateur.getRole() == 'MEDECIN'}">
										<input name="id" hidden="true" value="${p.getIdPatient()}">
										<button class="btn btn-info">Consulter</button>
									</c:if>
								</form>
								<c:if test="${sessionScope.utilisateur.getRole() == 'SECRETAIRE'}">
									<button class="btn btn-warning">Update</button>
									<button class="btn btn-danger">Remove</button>
								</c:if>
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