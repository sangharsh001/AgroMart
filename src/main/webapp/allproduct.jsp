<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h2>Product List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th><th>Name</th><th>Price</th><th>Details</th><th>Image</th><th>Action</th>
            </tr>
        </thead>
        <tbody id="productTable">
        
        
        
        
        
        </tbody>
    </table>

    <script>
        $(document).ready(function() {
            fetch("http://localhost:8080/Timex/DisplayProduct")
                .then(response => response.json())
                .then(data => {
                    let table = $("#productTable");
                    data.forEach(product => {
                        let imageTag = product.image ? `<img src="${product.image}" width="100" height="100">` : "No Image";
                        table.append(`
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                                <td>${product.details}</td>
                                <td>${imageTag}</td>
                                <td><button onclick="deleteProduct(${product.id})">Delete</button></td>
                            </tr>
                        `);
                    });
                })
                .catch(error => console.error("Error loading products:", error));
        });

        function deleteProduct(id) {
            $.post("DeleteProductServlet", { id: id }, function(response) {
                if (response === "success") location.reload();
            });
        }
    </script>
</body>
</html>
