<%-- 
    Document   : adminProductList
    Created on : Feb 16, 2023, 4:16:33 PM
    Author     : Chau Nhat Truong
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>PTDK Admin 2 - Danh sách Sản phẩm</title>

        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="style/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
              integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />

        <!-- lIST ACCOUNT CSS -->
        <link rel="stylesheet" href="style/listProductEdit.css">

    </head>

    <body id="page-top">
        <c:set var="adminName" value="${sessionScope.USER}"/>

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav sidebar sidebar-dark accordion" id="accordionSidebar" style="background-color: #333">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="adminOrdersRevenueController">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <!--<i class="fas fa-laugh-wink"></i>-->
                    </div>
                    <div class="sidebar-brand-text mx-3">PTDK <sup>Store</sup></div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item">
                    <a class="nav-link" href="adminOrdersRevenueController">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">




                <!-- Heading -->
                <div class="sidebar-heading">
                    Addons
                </div>




                <!-- Nav Item - Tables -->
                <li class="nav-item active">
                    <a class="nav-link" href="adminAccountListController">
                        <i class="fas fa-fw fa-table"></i>
                        <span>List Account</span></a>
                </li>

                <!-- Nav Item - Tables -->
                <li class="nav-item active">
                    <a class="nav-link" href="adminProductListController">
                        <i class="fas fa-fw fa-table"></i>
                        <span>List Product</span></a>
                </li>

                <!-- Nav Item - Tables -->
                <li class="nav-item active">
                    <a class="nav-link" href="adminBrandListController">
                        <i class="fas fa-fw fa-table"></i>
                        <span>List Brand</span></a>
                </li>

                <!-- Nav Item - Tables -->
                <li class="nav-item active">
                    <a class="nav-link" href="adminCategoryListController">
                        <i class="fas fa-fw fa-table"></i>
                        <span>List Category</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="adminOrderedListController">
                        <i class="fas fa-fw fa-table"></i>
                        <span>List Ordered</span></a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="adminFeedBackListController">
                        <i class="fas fa-fw fa-table"></i>
                        <span>List FeedBack</span></a>
                </li>
                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <form class="form-inline">
                            <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                                <i class="fa fa-bars"></i>
                            </button>
                        </form>
                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">
                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">${adminName.name}</span>
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <h1 class="h3 mb-2 text-gray-800">List Product</h1>
                        <p class="mb-4">Danh sách các Product được tạo trên Store PTDK.</p>

                        <button class="button__form-create-product" onclick="showCreateProduct()">Add a new Product</button>

                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">DataTables Product</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">

                                    <c:set var="result" value="${requestScope.PRODUCT_RESULT}"/>
                                    <c:if test="${not empty result}">
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Name</th>
                                                    <th>Image1</th>
                                                    <th>Image2</th>
                                                    <th>Description</th>
                                                    <th>Quantity</th>
                                                    <th>Price</th>
                                                    <th>Size</th>
                                                    <th>Status</th>
                                                    <th>Update</th>
                                                    <th>Delete</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="dto" items="${result}">
                                                    <tr>
                                                        <td>${dto.id}</td>
                                                        <td>${dto.name}</td>
                                                        <td><img src="${pageContext.request.contextPath}/images/Store/${dto.avatar}" style="width: 50px; height: 50px"></td>
                                                        <td><img src="${pageContext.request.contextPath}/images/Store/${dto.avatar2}" style="width: 50px; height: 50px"></td>
                                                        <td>${dto.description}</td>
                                                        <td>${dto.quantity}</td>
                                                        <td>${dto.price}</td>
                                                        <td>${dto.size}</td>
                                                        <td>${dto.status == true ? 'Sản phẩm còn hàng' : 'Sản phẩm đã hết'}</td>

                                                        <td class="icon-edit" onclick="showEdit(${dto.id},'${dto.name}','${dto.description}',${dto.quantity},${dto.price})">
                                                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                                                            <path
                                                                d="M471.6 21.7c-21.9-21.9-57.3-21.9-79.2 0L362.3 51.7l97.9 97.9 30.1-30.1c21.9-21.9 21.9-57.3 0-79.2L471.6 21.7zm-299.2 220c-6.1 6.1-10.8 13.6-13.5 21.9l-29.6 88.8c-2.9 8.6-.6 18.1 5.8 24.6s15.9 8.7 24.6 5.8l88.8-29.6c8.2-2.8 15.7-7.4 21.9-13.5L437.7 172.3 339.7 74.3 172.4 241.7zM96 64C43 64 0 107 0 160V416c0 53 43 96 96 96H352c53 0 96-43 96-96V320c0-17.7-14.3-32-32-32s-32 14.3-32 32v96c0 17.7-14.3 32-32 32H96c-17.7 0-32-14.3-32-32V160c0-17.7 14.3-32 32-32h96c17.7 0 32-14.3 32-32s-14.3-32-32-32H96z" />
                                                            </svg>
                                                        </td>

                                                        <td class="icon-delete" onclick="showDelete(${dto.id})">
                                                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                                                            <path
                                                                d="M135.2 17.7L128 32H32C14.3 32 0 46.3 0 64S14.3 96 32 96H416c17.7 0 32-14.3 32-32s-14.3-32-32-32H320l-7.2-14.3C307.4 6.8 296.3 0 284.2 0H163.8c-12.1 0-23.2 6.8-28.6 17.7zM416 128H32L53.2 467c1.6 25.3 22.6 45 47.9 45H346.9c25.3 0 46.3-19.7 47.9-45L416 128z" />
                                                            </svg>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- End of Main Content -->
                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; PDTK 2023</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="logoutController">Logout</a>
                    </div>
                </div>
            </div>
        </div>


        <!-- Chỗ này hiện ra khi mà click Delete (Update) -->

        <div class="form__include-delete">
            <form action="adminDeleteProductController" class="form-delete" method="POST">
                <div class="close-tab" onclick="showDelete()">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                    <path
                        d="M64 32C28.7 32 0 60.7 0 96V416c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64H64zM175 175c9.4-9.4 24.6-9.4 33.9 0l47 47 47-47c9.4-9.4 24.6-9.4 33.9 0s9.4 24.6 0 33.9l-47 47 47 47c9.4 9.4 9.4 24.6 0 33.9s-24.6 9.4-33.9 0l-47-47-47 47c-9.4 9.4-24.6 9.4-33.9 0s-9.4-24.6 0-33.9l47-47-47-47c-9.4-9.4-9.4-24.6 0-33.9z" />
                    </svg>
                </div>
                <div class="delete__content">
                    <div class="delete-title">
                        <p>Are you sure? This Product will be deleted</p>
                    </div>

                    <div class="button__delete-include">
                        <button class="button__delete-yes" name="productIdDelete" id="productIdDelete" type="submit" >Yes</button>
                        <button class="button__delete-no"  onclick="showDelete()" type="reset">No</button>
                    </div>
                </div>

            </form>
        </div>


        <!-- Chỗ này hiện ra khi mà click Edit (Update) -->
        <div class="form__include-update">
            <form action="adminUpdateProductController" class="form-update" id="form-update" method="POST">
                <div class="close-tab" onclick="showEdit()">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                    <path
                        d="M64 32C28.7 32 0 60.7 0 96V416c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64H64zM175 175c9.4-9.4 24.6-9.4 33.9 0l47 47 47-47c9.4-9.4 24.6-9.4 33.9 0s9.4 24.6 0 33.9l-47 47 47 47c9.4 9.4 9.4 24.6 0 33.9s-24.6 9.4-33.9 0l-47-47-47 47c-9.4 9.4-24.6 9.4-33.9 0s-9.4-24.6 0-33.9l47-47-47-47c-9.4-9.4-9.4-24.6 0-33.9z" />
                    </svg>
                </div>

                <div class="update-content">
                    <h3>Update Product</h3>
                    <div class="form__group">
                        ProductID: <input id="productIdUpdate" name="productIdUpdate"  type="text" value="${dto.id}" readonly/>
                        <span class="form__message"></span>
                    </div>
                    <div class="form__group">
                        Name: <input id="name" name="txtName"  type="text" value="${dto.name}" class="name-create"/>
                        <span class="form__message"></span>
                    </div>
                    <div class="form__group">
                        Description: <input id="description" name="txtDescription" type="text" value="${dto.description}"  class="description-create" />
                        <span class="form__message"></span>
                    </div>
                    <div class="form__group">
                        Quantity: <input id="quantity" name="txtQuantity" type="number" value="${dto.quantity}" class="quantity-create"/>
                        <span class="form__message"></span>
                    </div>
                    <div class="form__group">
                        Price: <input id="price" name="txtPrice" value="${dto.price}" type="text" class="price-create"/>
                        <span class="form__message"></span>
                    </div>
                    <div class="button__group">
                        <button type="submit" class="button-update" >Update</button>
                    </div>
                </div>
            </form>
        </div>



























        <!-- Chỗ này hiện ra khi mà add a new product á  -->

        <div class="form__create">
            <form method="POST"  action="AdminNewProductServlet" class="form-create" id="form-create" enctype="multipart/form-data"  >
                <div class="close-tab" onclick="showCreateProduct()">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                    <path
                        d="M64 32C28.7 32 0 60.7 0 96V416c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64H64zM175 175c9.4-9.4 24.6-9.4 33.9 0l47 47 47-47c9.4-9.4 24.6-9.4 33.9 0s9.4 24.6 0 33.9l-47 47 47 47c9.4 9.4 9.4 24.6 0 33.9s-24.6 9.4-33.9 0l-47-47-47 47c-9.4 9.4-24.6 9.4-33.9 0s-9.4-24.6 0-33.9l47-47-47-47c-9.4-9.4-9.4-24.6 0-33.9z" />
                    </svg>
                </div>

                <div class="create-content">
                    <h3>Add a new Product to the Store </h3>
                    <div class="form__group">
                        Name: <input id="name" name="txtName"  type="text" class="name-create"/>
                        <span class="form__message"></span>
                    </div>
                    <div class="form__group" style="display: flex; flex-direction: column">
                        Description: <textarea id="description" name="txtDescription" type="text" class="description-create" style="width: 100%;"></textarea>
                        <span class="form__message"></span>
                    </div>
                    <div class="form__group">
                        Quantity: <input id="quantity" name="txtQuantity" type="number" class="quantity-create"/>
                                         <span class="form__message"></span>
                    </div>
                    <div class="form__group">
                        Price: <input id="price" name="txtPrice" type="text" class="price-create"/>
                        <span class="form__message"></span>
                    </div>
                    <div class="form__group">
                        <c:set var="categoryResults" value="${requestScope.CATEGORY_RESULT}"/>
                        Category: <select name="cboCategory" id="category"  class="category-create" >
                            <c:forEach var="dto1" items="${categoryResults}">
                                <option value="${dto1.cateID}">${dto1.cateID}-${dto1.name}</option>
                            </c:forEach>
                        </select>
                        <span class="form__message"></span>
                    </div>
                    <div class="form__group">
                        <c:set var="brandResults" value="${requestScope.BRAND_RESULT}"/>
                        Brand: <select name="cboBrand" id="brand" class="brand-create" >
                            <c:forEach var="dto2" items="${brandResults}">
                                <option value="${dto2.brandID}">${dto2.brandID}-${dto2.name}</option>
                            </c:forEach>
                        </select>
                        <span class="form__message"></span>
                    </div>
                    <div class="form__group">
                        <c:set var="sizeResults" value="${requestScope.SIZE_RESULT}"/>
                        Size: <select name="txtSize" id="size" class="size-create" >
                            <c:forEach var="dto2" items="${sizeResults}">
                                <option value="${dto2.sizeID}">${dto2.sizeID}-${dto2.size}</option>
                            </c:forEach>
                        </select>
                        <span class="form__message"></span>
                    </div>
                    <div class="form__group">
                        <input type="file" name="image1" onchange="previewImage(this, 'uploaded-image1')"><br><br>
                        <img id="uploaded-image1" src="#" alt="Uploaded Image 1" style="width: 150px; height: 200px;"><br>
                        <input type="file" name="image2" onchange="previewImage(this, 'uploaded-image2')" ><br><br>
                        <img id="uploaded-image2" src="#" alt="Uploaded Image 2" style="width: 150px; height: 200px;">
                    </div>
                    <div class="button__group">
                        <button type="submit" class="button-create" >Add</button>
                    </div>
                </div>
            </form>
        </div>



        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/datatables-demo.js"></script>
        <!-- list Product -->
        <script src="js/demo/listProductEdit.js"></script>
        <script>
                            Validator({
                                form: '#form-update',
                                errorSelector: '.form__message',
                                rules: [
                                    Validator.isRequired('#name'),
                                    Validator.isRequired('#quantity'),
                                    Validator.isNumber('#quantity'),
                                    Validator.isPositive('#quantity'),
                                    Validator.isRequired('#price'),
                                    Validator.isNumber('#price'),
                                    Validator.isPositive('#price'),
//                                    Validator.isRequired('#size'),
//                                    Validator.isPositive('#size'),
                                ],
                                onsubmit: function (data) {
                                    console.log(data);
                                }
                            });

                            Validator2({
                                form: '#form-create',
                                errorSelector: '.form__message',
                                rules: [
                                    Validator2.isRequired('#name'),
                                    Validator2.isRequired('#quantity'),
                                    Validator2.isNumber('#quantity'),
                                    Validator.isPositive('#quantity'),
                                    Validator2.isRequired('#price'),
                                    Validator2.isNumber('#price'),
                                    Validator.isPositive('#price'),
                                    Validator2.isRequired('#size'),
                                    Validator2.isNumber('#size'),
                                    Validator2.isPositive('#size'),
                                ],
                                onsubmit: function (data) {
                                    console.log(data)
                                }
                            });

                            function previewImage(input, previewId) {
                                if (input.files && input.files[0]) {
                                    var reader = new FileReader();
                                    reader.onload = function (e) {
                                        document.getElementById(previewId).setAttribute("src", e.target.result);
                                    };
                                    reader.readAsDataURL(input.files[0]);
                                }
                            }

        </script>
    </body>

</html>





















