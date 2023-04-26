+++++++++++++++++++++++++++++++++<div class="container row">
		<div class="container-fluid">
		    <div class="row">

<!-- Barre latérale -->
<nav class="col-md-3 col-lg-2 d-md-block bg-light sidebar">
  <div class="position-sticky pt-3">
    <ul class="nav flex-column">
      <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="#">Tableau de bord</a>
      </li>	
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/patient">Patient</a>
      </li>
      <c:if test="${sessionScope.utilisateur.getRole() == 'SECRETAIRE'}">
      	<li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/medecin">Medecin</a>
      </li>
      </c:if>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/rendezvous">Rendez-Vous</a>
      </li>
      <c:if test="${sessionScope.utilisateur.getRole() == 'MEDECIN'}">
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/consultation">Consultation</a>
      </li>
      </c:if>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/ordonance">Ordonance</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Paramètres</a>
      </li>
    </ul>
  </div>
</nav>


<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
		        