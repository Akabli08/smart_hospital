<header class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
      <a href="<%=request.getContextPath()%>/index" class="navbar-brand">Smart Hopital</a>
    </div>
    <div class="navbar-brand" id="navbarSupportedContent">
      <form class="position-absolute top-0 end-0" action="<%=request.getContextPath()%>/login" method="post">
      	<input type="text" name="method" value="deconnecter" hidden="true">
        <button class="btn btn-success m-2" type="submit">Se Deconnecter</button>
      </form>
    </div>
  </header>