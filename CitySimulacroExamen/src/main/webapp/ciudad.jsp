<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Ciudades</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS v5.2.1 -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />
  </head>

  <body>
    <header class="bg-primary p-2">
      <div class="container">
        <nav>
          <div class="row justify-content-between align-items-center">
            <div class="div1 col-auto">
              <img src="img/logo.png" alt="" class="img-fluid" />
            </div>

            <div class="div2 col-auto">
              <a href="" class="text-white text-decoration-none me-2"
                >Ciudades</a
              >
              
              <form action="ControllerAdmin">
              <input type="hidden" name="operacion" value="rutaCiudad">
              <select
                name="opcionRuta"
                id="opcionRuta"
                class="form-select-sm rounded-2" onchange="this.form.submit()"
              >
              <c:forEach items="${listadoCiudadesRuta}" var="ciudad">
                <option value="${ciudad.idCiudad}">${ciudad.nombreCiudad}</option>
                </c:forEach>
              </select>
              </form>
            </div>
          </div>
        </nav>
      </div>
    </header>
    <main>
      <div class="container">
        <div class="row justify-content-center align-items-center">
        <c:forEach items="${listadoCiudades}" var="ciudad">
          <div class="col-md-12 col-lg-5 card h-100 mt-2 mb-2 me-2">
            <a href="${ciudad.link}"> <img
              class="card-img-top img-fluid"
              src="${ciudad.imagen}"
              alt="Title"
            /> </a>
            <div class="card-body">
              <h4 class="card-title"><c:out value="${ciudad.nombre}"></c:out> </h4>
              <p class="card-text"><c:out value="${ciudad.descripcion}"></c:out> </p>
              <div class="d-flex justify-content-end">
                <img src="${ciudad.mapa}" alt="" class="img-fluid" />
              </div>
            </div>
          </div>
          </c:forEach>

          
        </div>
      </div>
    </main>
    <footer class="bg-primary text-center text-white p-3">
      <div class="container">
        <h1>SIMULACRO - VAMOS A SUSPENDER</h1>
      </div>
    </footer>
    <!-- Bootstrap JavaScript Libraries -->
    <script
      src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
      integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
      crossorigin="anonymous"
    ></script>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
      integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
      crossorigin="anonymous"
    ></script>
  </body>
</html>