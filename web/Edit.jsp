<%-- 
    Document   : Edit.jsp
    Created on : Jun 13, 2024, 6:43:12 AM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body>
        
        <h1 class="modal-title">Edit Employee</h1>
        
        <div style="margin: 30px">

            <form action="edit">
                <div class="row mb-3">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">ID</label>
                    <div class="col-sm-10">
                        <input value="${product.id}" name="id" type="text" class="form-control" required readonly>
                    </div>
                </div>
                
                <div class="row mb-3">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-10">
                        <input value="${product.name}" name="name" type="text" class="form-control" required>
                    </div>
                </div>
                
                <div class="row mb-3">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">Image</label>
                    <div class="col-sm-10">
                        <input value="${product.image}"  name="image" type="text" class="form-control" required>
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Price</label>
                    <div class="col-sm-10">
                        <input value="${product.price}" name="price" type="text"  class="form-control" required>
                    </div>
                </div>
                    
                 <div class="row mb-3">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Title</label>
                    <div class="col-sm-10">
                        <textarea type="text" name="title" class="form-control" required>${product.title}</textarea>
                    </div>
                </div>
                    
                 <div class="row mb-3">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Description</label>
                    <div class="col-sm-10">
                        <textarea type="text" name="description" class="form-control" required>${product.description}</textarea>
                    </div>
                </div>
                
                    <div class="row mb-3">
                        <label for="inputPassword3" class="col-sm-2 col-form-label">Category</label>
                        <select name="category" class="form-select" aria-label="Default select example">
                            <c:forEach begin="1" end="3" var="o">
                                <option value="1">Giày Adidas</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                <div class="row mb-3">
                    <div class="col-sm-10 offset-sm-2">
                        <div class="form-check">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <button type="submit" class="btn btn-primary">save</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        
        
        
<!--         <div id="editEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="edit">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Employee</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>ID</label>
                                <input value="${product.id}" name="id" type="text" class="form-control" required readonly>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input value="${product.name}" name="name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input value="${product.image}"  name="image" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input value="${product.price}" name="price" type="text"  class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Title</label>
                                <textarea type="text" name="title" class="form-control" required>${product.title}</textarea>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <textarea type="text" name="description" class="form-control" required>${product.description}</textarea>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <c:forEach begin="1" end="3" var="o">
                                        <option value="1">Giày Adidas</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-info" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>-->
                            
    </body>
</html>
