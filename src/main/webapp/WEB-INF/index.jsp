<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	  <jsp:include page="shared/header.jsp"/>
      <jsp:include page="shared/sidebar.jsp"/>
      
        <div class="row">
          <div class="col-md-6">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Utilisateurs</h5>
                <p class="card-text">Gérer les utilisateurs de votre application.</p>
                <a href="#" class="btn btn-primary">Voir les utilisateurs</a>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Paramètres</h5>
                <p class="card-text">Modifier les paramètres de votre application.</p>
                <a href="#" class="btn btn-primary">Voir les paramètres</a>
              </div>
            </div>
          </div>
        </div>
  	  <jsp:include page="shared/footer.jsp"/>
</body>
</html>