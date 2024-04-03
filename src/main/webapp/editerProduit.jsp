<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Modification des Produits</div>
			<div class="card-body">
				<form action="update.do" method="post">
					<div hidden class="form-group">
						<label class="control-label">ID Produit :</label> <input
							type="text" name="id" class="form-control"
							value="${produit.id}" />
					</div>

					<div class="form-group">
						<label class="control-label">Marque Produit :</label> <input
							type="text" name="marque" class="form-control"
							value="${produit.marque}" />
					</div>
					<div class="form-group">
						<label class="control-label">Couleur Produit :</label> <input
							type="text" name="couleur" class="form-control"
							value="${produit.couleur}" />
					</div>
					<div class="form-group">
						<label class="control-label">Prix :</label> <input type="text"
							name="prix" class="form-control" value="${produit.prix}" />
					</div>
					<div class="form-group">
						<label class="control-label">Ram Produit :</label> <input
							type="text" name="ram" class="form-control"
							value="${produit.ram}" />
					</div>
					<div class="form-group">
						<label class="control-label">Stockage Produit :</label> <input
							type="text" name="stockage" class="form-control"
							value="${produit.stockage}" />
					</div>
					
					<div>
						<button type="submit" class="btn btn-primary">Modifier</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>