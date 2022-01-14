<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="products">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#birthDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h2>
           Product
        </h2>
        <form:form modelAttribute="product"
                   class="form-horizontal">
            <input type="hidden" name="id" value="${product.id}"/>
            <div class="form-group has-feedback">
                
                <petclinic:inputField label="Name" name="name"/>
                <span class="help-inline"><form:errors path="name"/></span>
                <petclinic:inputField label="Price" name="price"/>
                <span class="help-inline"><form:errors path="price"/></span>
                <div class="control-group">
                    <petclinic:selectField name="productType" label="Product Type" names="${productType}" size="3"/>
                    <span class="help-inline"><form:errors path="productType"/></span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-default" type="submit">Add Product</button>
                </div>
            </div>
        </form:form>
        <c:if test="${!pet['new']}">
        </c:if>
    </jsp:body>
</petclinic:layout>
