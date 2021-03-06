<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/carousel/">

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
body {
    background-color: #FFEBEE
}

.card {
    width: 400px;
    background-color: #fff;
    border: none;
    border-radius: 12px
}

label.radio {
    cursor: pointer;
    width: 100%
}

label.radio input {
    position: absolute;
    top: 0;
    left: 0;
    visibility: hidden;
    pointer-events: none
}

label.radio span {
    padding: 7px 14px;
    border: 2px solid #eee;
    display: inline-block;
    color: #039be5;
    border-radius: 10px;
    width: 100%;
    height: 48px;
    line-height: 27px
}

label.radio input:checked+span {
    border-color: #039BE5;
    background-color: #81D4FA;
    color: #fff;
    border-radius: 9px;
    height: 48px;
    line-height: 27px
}

.form-control {
    margin-top: 10px;
    height: 48px;
    border: 2px solid #eee;
    border-radius: 10px
}

.form-control:focus {
    box-shadow: none;
    border: 2px solid #039BE5
}

.agree-text {
    font-size: 12px
}

.terms {
    font-size: 12px;
    text-decoration: none;
    color: #039BE5
}

.confirm-button {
    height: 50px;
    border-radius: 10px
}
</style>
</head>
<body>
<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card px-1 py-4">
        <div class="card-body">
            <form method="post">
		<jsp:useBean id="user" scope="request" class="beans.Users">
		   
		   </jsp:useBean>
            <!-- firstName control -->
                                                <c:if test="${empty form.erreurs.firstName }">
                                                    <div class="form-group">
                                                        <label for="firstName">Pr??nom</label>
                                                        <input type="text" name="firstName" placeholder="Pr??nom" class="form-control" value='<jsp:getProperty property="firstName" name="user"/>'>
                                                    </div>
                                                </c:if>
                                                <c:if test="${!empty form.erreurs.firstName }">
                                                    <div class="form-group">
                                                        <label for="firstName" class="text-danger">Pr??nom</label>
                                                        <input type="text" name="firstName" placeholder="Pr??nom"  class="form-control is-invalid"value='<jsp:getProperty property="firstName" name="user"/>'>
                                                        <small id="passwordHelp" class="text-danger">
                                                            <c:out value="${form.erreurs.firstName }"/>
                                                        </small> 
                                                    </div>
                                                </c:if>
                                                

                                                <!-- last name control -->
                                                <c:if test="${empty form.erreurs.lastName}">
                                                    <div class="form-group">
                                                        <label for="lastName">Nom</label>
                                                        <input type="text" name="lastName" placeholder="nom" required class="form-control" value='<jsp:getProperty property="lastName" name="user"/>'>
                                                    </div>
                                                </c:if>
                                                <c:if test="${!empty form.erreurs.lastName}">
                                                    <div class="form-group">
                                                        <label for="lastName" class="text-danger">Nom</label>
                                                        <input type="text" name="lastName" placeholder="nom" required class="form-control is-invalid"value='<jsp:getProperty property="lastName" name="user"/>'>
                                                        <small id="passwordHelp" class="text-danger">
                                                            <c:out value="${form.erreurs.lastName }"/>
                                                        </small> 
                                                    </div>
                                                </c:if>

                                                <!-- login control -->
                                                <c:if test="${empty form.erreurs.username}">
                                                    <div class="form-group">
                                                        <label for="username">Nom d'utilisateur</label>
                                                        <input type="text" name="login" placeholder="Jason Doe" required class="form-control" value='<jsp:getProperty property="login" name="user"/>'>
                                                      </div>
                                                </c:if>
                                                <c:if test="${!empty form.erreurs.username}">
                                                    <div class="form-group">
                                                        <label for="username" class="text-danger">Nom d'utilisateur</label>
                                                        <input type="text" name="login" placeholder="Jason Doe" required class="form-control is-invalid" value='<jsp:getProperty property="login" name="user"/>'>
                                                        <small id="passwordHelp" class="text-danger">
                                                            <c:out value="${form.erreurs.username }"/>
                                                        </small> 
                                                    </div>
                                                </c:if>
                                                
                                                <!-- Password control -->
                                                <c:if test="${empty form.erreurs.password }">
                                                    <div class="form-group">
                                                        <label for="password">Mot de passe</label>
                                                        <input type="text" name="passWord" placeholder="password" required class="form-control" value='<jsp:getProperty property="passWord" name="user"/>'>
                                                    </div>
                                                </c:if>
                                                <c:if test="${!empty form.erreurs.password }">
                                                    <div class="form-group">
                                                        <label for="password" class="text-danger">Mot de passe</label>
                                                        <input type="text" name="passWord" placeholder="password" required class="form-control is-invalid" value='<jsp:getProperty property="passWord" name="user"/>'>
                                                        <small id="passwordHelp" class="text-danger">
                                                            <c:out value="${form.erreurs.password }"/>
                                                        </small> 
                                                    </div>
                                                </c:if>
                                                
                                                <!-- Role control -->
                                                <c:if test="${empty form.erreurs.password }">
                                                    <div class="form-group">
                                                        <label for="password">Role</label>
                                                        <input type="text" name="role" placeholder="role" required class="form-control" value='<jsp:getProperty property="role" name="user"/>'>
                                                    </div>
                                                </c:if>
                                                <c:if test="${!empty form.erreurs.password }">
                                                    <div class="form-group">
                                                        <label for="password" class="text-danger">Role</label>
                                                        <input type="password" name="role" placeholder="role" required class="form-control is-invalid" value='<jsp:getProperty property="role" name="user"/>'>
                                                        <small id="passwordHelp" class="text-danger">
                                                            <c:out value="${form.erreurs.password }"/>
                                                        </small> 
                                                    </div>
                                                </c:if>
            <br><br>
             <button style="width: 100%" class="btn btn-primary btn-block">Enregistrer</button>
             </form>
        </div>
    </div>
</div>
</body>
</html>