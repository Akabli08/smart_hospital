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
		<div class="row">
			<div class="card">
				<div class="card-head">
					<div class="alert alert-light text-center" role="alert">
						<h4>Liste pour les Consultations du patient</h4>
					</div>
				</div>
				<div class="card-body">
					<div class="row">
						<label class="col-4">Nom</label>
						<input class="form-control col-8" type="text" value="${patient.getNom()}" disabled readonly>	
					</div>
					<div class="row ny-2">
						<label class=" col-4">Prenom</label>
						<input class="form-control col-8" type="text" value="${patient.getPrenom()}" disabled readonly>
					</div>
					<c:if test="<% ${consultations} == null ;%>">
					
					</c:if>
					<br>
					<c:forEach items="${consultations}" var="c">
						<input class="form-control text-center" type="text" value="Consultation Numero ${c.getIdConsultation()}" disabled readonly>
						<br>
						<div class="row">
							<label class="col-4">Titre</label>
							<input class="form-control col-8" type="text" value="${c.getTitre()}" disabled readonly>
						</div>
						<div class="row my-2">
							<label class="col-4">Date de consultation</label>
							<input class="form-control col-8" type="text" value="${c.getRendezvous().getDateRendezVous()}" disabled readonly>
						</div>
						<div class="alert alert-light text-center" role="alert">Les examens cliniques :</div>
						<c:forEach items="${c.getExamenClinique()}" var="ex">
							<div class="row">
								<label class="col-4">Examen Numero</label>
								<input class="form-control col-8" type="text" value="${ex.getIdExamenClinique()}" disabled readonly>
							</div>
							<div class="row my-2">
								<label class="col-4">Date d'examen</label>
								<input class="form-control col-8" type="text" value="${ex.getDateExamenClinique()}" disabled readonly>
							</div>
						</c:forEach>
						<div class="alert alert-light text-center" role="alert">Les ordonnances :</div>
						<c:forEach items="${c.getOrdonnance()}" var="o">
							<div class="row">
								<label class="col-4">Ordonnance Numero</label>
								<input class="form-control col-8" type="text" value="${o.getIdOrdonnance()}" disabled readonly>
							</div>
							<div class="row my-2">
								<label class="col-4">Ordonnance description</label>
								<input class="form-control col-8" type="text" value="${o.getDescription()}" disabled readonly>
							</div>
							<div class="alert alert-light text-center" role="alert">Les traitements :</div>
							<c:forEach items="${ o.getTraitements() }" var="t">
								<div class="row">
									<label class="col-4">Medicament</label>
									<input class="form-control col-8" type="text" value="${ t.getMedicament() }" disabled readonly>
								</div>
								<div class="row my-2">
									<label class="col-4">Quantite</label>
									<input class="form-control col-8" type="text" value="${ t.getQuantite() }" disabled readonly>
								</div>
								<div class="row">
									<label class="col-4">Duree de traitement</label>
									<input class="form-control col-8" type="text" value="${ t.getDuree_traitement() }" disabled readonly>
								</div>
							</c:forEach>
						</c:forEach>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../shared/footer.jsp"/>
</body>
</html>