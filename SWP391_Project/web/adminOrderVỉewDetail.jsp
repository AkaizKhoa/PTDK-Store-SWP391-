<%-- 
    Document   : adminOrderVỉewDetail
    Created on : Mar 31, 2023, 11:15:15 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>PDDTK Admin 2 - Danh sách Sản phẩm</title>

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
        <link rel="stylesheet" href="style/listCategory.css">

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
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">PDTK <sup>Store</sup></div>
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
                        <h1 class="h3 mb-2 text-gray-800">List Order Detail</h1>
                        <p class="mb-4">Danh sách các Order được tạo trên Store PDDTK <a target="_blank"
                                                                                         href="https://datatables.net">Link edit danh sách</a>.</p>


                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">DataTables OrdersDetail</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <c:set var="result" value="${requestScope.ORDERS_OBJECT}"/>
                                    <c:if test="${not empty result}">
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <thead>
                                                <tr>
                                                    <th>Order ID</th>
                                                    <th>Customer Name</th>
                                                    <th>Customer Phone</th>
                                                    <th>Customer Address</th>
                                                    <th>Payment name</th>
                                                    <th>Shipping Name</th>
                                                    <th>Date Create</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>${result.ordersID}</td>
                                                    <td>${result.cusName}</td>
                                                    <td>${result.cusPhone}</td>
                                                    <td>${result.cusAddress}</td>
                                                    <td>${result.getNameOfPaymentMethod()}</td>
                                                    <td>${result.getNameOfMethod()}</td>         
                                                    <td>${result.dateOrders}</td>
                                                </tr>
                                            </tbody>
                                        </table>

                                        <c:if test="${not empty orders_detail}">
                                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"> <!-- Add a new table for the order details information -->
                                                <tr>
                                                    <td>OrderDetailsID</td>
                                                    <td>Product Name</td>
                                                    <td>Product Price</td>
                                                    <td>Quantity</td>
                                                    <td>Total</td>
                                                </tr>
                                                <!-- Add your order details information here -->
                                                <c:set var="total" value="${0}"/>
                                                <c:forEach var="ordersDetail" items="${orders_detail}">
                                                    <tr>
                                                        <td>${ordersDetail.ordersDetailID}</td>
                                                        <td>${ordersDetail.productName}</td>
                                                        <td>
                                                            <fmt:formatNumber var="price1" value="${ordersDetail.price}" pattern="#,###"/>   
                                                            ${price1}đ
                                                        </td>
                                                        <td>${ordersDetail.quantity}</td>
                                                        <td>
                                                            <fmt:formatNumber var="price2" value="${ordersDetail.price}" pattern="#,###"/> 
                                                            ${price2}đ
                                                        </td>
                                                        <c:set var="total" value="${total + ordersDetail.total}"/>
                                                    </tr>
                                                </c:forEach>

                                                <tr>
                                                    <td style="color: red;">
                                                        <fmt:formatNumber var="totalPrice" value="${total}" pattern="#,###"/>  
                                                        Total: ${totalPrice}đ
                                                    </td>
                                                </tr>
                                            </table>
                                        </c:if>
                                        <c:if test="${empty orders_detail}">
                                            <p style="color: red; font-size: 15px;">This orders is empty!!</p>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${empty result}">
                                        <p style="color: red; font-size: 15px;">This orders does not existed!!</p>
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
        <script src="js/demo/listCategory.js"></script>

    </body>

</html>


