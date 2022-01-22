<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.Albums"%>
<%@page import="java.util.ArrayList"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
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
        <form method="post" action="upload">
            <h6 class="card-title mb-3">Statut de l'album</h6>
            <div class="d-flex flex-row"> <label class="radio mr-1"> 
            <input type="radio" name="visibility" value="public" checked> <span> <i class="fa fa-user"></i> Public </span> </label> <label class="radio"> 
            <input type="radio" name="visibility" value="private"> <span> <i class="fa fa-lock"></i> Prive </span> </label> </div>
            
            <c:if test="${empty form.erreurs.theme }">
               <div class="form-group">
                 <label for="theme">Theme</label>
                 <input type="text" name="theme" placeholder="Theme" class="form-control" value="${form.album.theme }">
               </div>
            </c:if>
            <c:if test="${!empty form.erreurs.theme }">
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="input-group"> <input class="form-control" name="theme" type="text" value="${form.album.theme }" placeholder="Theme"> </div>
                        <c:out value="${form.erreurs.theme }"/>
                    </div>
                </div>
            </div>
            </c:if>
            
            <c:if test="${empty form.erreurs.cover }">
               <div class="form-group">
                 <label for="theme">Couverture</label>
                 <input type="file" name="cover" placeholder="Couverture" class="form-control" value="${form.album.cover }">
               </div>
            </c:if>
            <c:if test="${!empty form.erreurs.cover }">
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="input-group"> <input class="form-control" name="cover" value="${form.album.cover }" type="file" placeholder="Choisir une image"> </div>
                    <c:out value="${form.erreurs.cover }"/>
                    </div>
                </div>
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