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
						<th>Date RDV</th>
						<th>status</th>
						<th>#</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${rendezvous}" var="rdv">
						<tr>
							<td>${rdv.getIdRendezVous()}</td>
							<td>${rdv.getPatient().getNom()} ${rdv.getPatient().getPrenom()}</td>
							<td>${rdv.getMedecin().getNom()}</td>
							<td>${rdv.getDateRendezVous()}</td>
							<td>${rdv.getStatut()}</td>
							<td>
							<c:if test="${sessionScope.utilisateur.getRole() == 'SECRETAIRE'}">
								<button class="btn btn-warning">Update</button>
								<button class="btn btn-danger">Remove</button>
							</c:if>
							<c:if test="${sessionScope.utilisateur.getRole() == 'MEDECIN'}">
								<form action="<%=request.getContextPath()%>/consultation/${rdv.getIdRendezVous()}" method="get">
									<button class="btn btn-info">Consulter</button>
								</form>
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