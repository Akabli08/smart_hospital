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
						<th>Nom et Prenom du patient</th>
						<th>titre</th>
						<th>Date</th>
						<th>#</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${consultations	}" var="c">
						<tr>
							<td>${c.getIdConsultation()}</td>
							<td>${c.getRendezvousId().getPatient().getNom()} ${c.getRendezvousId().getPatient().getPrenom()}</td>
							<td>${c.getTitre()}</td>
							<td>${c.getRendezvousId().getDateRendezVous()}</td>
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