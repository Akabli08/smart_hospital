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
	<div class="row">
		<div class="col-3"></div>
		<div class="col-9">
			<div class="container">
				<div class="row">
					<div class="col-12 mx-auto">
						<div class="card">
							<div class="card-head">
								<c:if test="${erreur}">
									<div class="alert alert-danger">
										Tous les champs doivent être remplis.
									</div>
								</c:if>
								<c:if test="${succes}">
									<div class="alert alert-succes">
										Le patient a ete bien ajouté.
									</div>
								</c:if>
							</div>
							<div class="card-body">
								<form action="<%=request.getContextPath()%>/addpatient" method="post">
									<div class="row mb-3">
									  <div class="col">
									    <input type="text" name="nom" class="form-control" placeholder="Nom" aria-label="Nom">
									  </div>
									  <div class="col">
									    <input type="text" name="prenom" class="form-control" placeholder="Prenom" aria-label="Prenom">
									  </div>
									</div>
									<div class="row mb-3">
										<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
									    <div class="col-sm-10">
									      <input type="email" class="form-control" name="email">
									    </div>
									</div>
									<div class="row mb-3">
									    <label for="inputPassword3" class="col-sm-2 col-form-label">Telephon</label>
									    <div class="col-sm-10">
									      <input type="text" class="form-control" name="telephone">
									    </div>
									</div>
									<div class="row mb-3">
										<div class="col-12">
										    <input type="text" class="form-control" name="adress" placeholder="Adresse">
										</div>
									</div>
									<div class="row mb-3">
										<div class="col-md-6">
										    <label for="inputCity" class="form-label">Ville</label>
										    <input type="text" class="form-control" name="ville">
										  </div>
										  <div class="col-md-2">
										    <label for="inputState" class="form-label">Sexe</label>
										    <select name="sexe" class="form-select">
										      <option selected>Male</option>
										      <option>Female</option>
										    </select>
										  </div>
										  <div class="col-md-4">
										    <label for="inputZip" class="form-label">Date Naissance</label>
										    <input type="date" class="form-control" name="dateNaissance">
										  </div>
									</div>
									<div class="row mb-3">
									  <div class="col">
									    <input type="text" name="profession" class="form-control" placeholder="Profession" aria-label="Profession">
									  </div>
									  <div class="col">
									    <input type="text" name="etatcevil" class="form-control" placeholder="Etat-civil">
									  </div>
									</div>
									<div class="row mb-3">
										<label for="inputEmail3" class="col-sm-2 col-form-label">Groupe Sanguin</label>
									    <div class="col-sm-10">
									      <input type="text" class="form-control" name="groupeSanguin">
									    </div>
									</div>
									<span class="mb-3">
										<button class="btn btn-primary">Enregistrer</button>
									</span>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../shared/footer.jsp"/>
</body>
</html>