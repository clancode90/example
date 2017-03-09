<%-- 
    Document   : error
    Created on : 30.03.2015, 16:20:58
    Author     : Юрий
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:if test="${! empty errors}">
    <center>
        <div class="alert alert-danger"" >
            <c:forEach items="${errors}" var="error" >
                <p>${error}</p>
            </c:forEach>
        </div>  
    </center>
</c:if>
