<%-- 
    Document   : admin
    Created on : Feb 16, 2023, 4:17:27 PM
    Author     : Chau Nhat Truong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>PTDK- Dashboard</title>

        <!-- Link customize -->
        <link rel="stylesheet" href="style/styleCustomize.css">

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="style/sb-admin-2.min.css" rel="stylesheet">

        <!--13/3/2023-->


    </head>

    <body id="page-top">

        <c:set var="adminName" value="${sessionScope.USER}"/>

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav  sidebar sidebar-dark accordion" id="accordionSidebar" style="background-color: #333">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="adminOrdersRevenueController">
                    <div class="sidebar-brand-icon rotate-n-15 ">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" style="width: 30px; color: #fff ">
                        <path d="M168.5 72L256 165l87.5-93h-175zM383.9 99.1L311.5 176h129L383.9 99.1zm50 124.9H256 78.1L256 420.3 433.9 224zM71.5 176h129L128.1 99.1 71.5 176zm434.3 40.1l-232 256c-4.6 5-11 7.9-17.8 7.9s-13.2-2.9-17.8-7.9l-232-256c-7.7-8.5-8.3-21.2-1.5-30.4l112-152c4.5-6.1 11.7-9.8 19.3-9.8H376c7.6 0 14.8 3.6 19.3 9.8l112 152c6.8 9.2 6.1 21.9-1.5 30.4z"/></svg>
                    </div>
                    <div class="sidebar-brand-text mx-3">PTDK <sup>Dashboard</sup></div>


                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item active">
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
                <li class="nav-item">
                    <a class="nav-link" href="adminAccountListController">
                        <i class="fas fa-fw fa-table"></i>
                        <span>List Account</span></a>
                </li>

                <!-- Nav Item - Tables -->
                <li class="nav-item">
                    <a class="nav-link" href="adminProductListController">
                        <i class="fas fa-fw fa-table"></i>
                        <span>List Product</span></a>
                </li>

                <!-- Nav Item - Tables -->
                <li class="nav-item">
                    <a class="nav-link" href="adminBrandListController">
                        <i class="fas fa-fw fa-table"></i>
                        <span>List Brand</span></a>
                </li>

                <!-- Nav Item - Tables -->
                <li class="nav-item">
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
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>



                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                     aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small"
                                                   placeholder="Search for..." aria-label="Search"
                                                   aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>



                            <!-- Nav Item - User Information -->

                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">${adminName.name}</span>
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="userDropdown">
                                    <!--<div class="dropdown-divider"></div>-->
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
                    <div class="container-fluid" >

                        <!-- Page Heading -->
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>

                        </div>

                        <div class="row"> 
                            <!-- Content Row -->
                            <c:set var="monthRevenue" value="${requestScope.MONTHREVENUE_RESULT}"/>
                            <c:set var="yearRevenue" value="${requestScope.YEARREVENUE_RESULT}"/>
                            <!-- Earnings (Monthly) Card Example -->
                            <c:if test="${not empty monthRevenue}">
                                <div class="change__card col-md-6 mb-4   ">
                                    <form action="adminOrdersRevenueSearchByMonthYearController" method="POST" >

                                        <div class="card border-left-primary shadow h-100 py-2 month-year ">
                                            <div class="card-body">
                                                <div class="row no-gutters align-items-center">
                                                    <div class="col mr-2">
                                                        <c:forEach var="dto" items="${monthRevenue}">
                                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                                Doanh thu (tháng ${dto.month} năm ${dto.year}) 
                                                            </div>
                                                            <div class="h5 mb-0 font-weight-bold text-gray-800">
                                                                <fmt:formatNumber value="${dto.revenue}"/> VNĐ
                                                            </div>
                                                        </c:forEach>
                                                    </div>
                                                    <div class="col-auto">
                                                        <i class="fas fa-calendar fa-2x text-gray-400" style="position: relative;"
                                                           onclick="showCalendarMonth()">
                                                        </i>
                                                        <div class="calendar_search">
                                                            <input class="calendar_month" type="month" name="txtDateMonthYearRevenue"
                                                                   />
                                                            <button class="calendar_month-button">Find</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>

                                </div>
                            </c:if>
                            <!-- Earnings (Year) Card Example -->
                            <c:if test="${not empty yearRevenue}">
                                <div class="change__card col-md-6 mb-4 ">
                                    <form action="adminOrdersRevenueSearchByYearController" method="POST" >
                                        <div class="card border-left-success shadow h-100 py-2 month-year ">
                                            <div class="card-body">
                                                <div class="row no-gutters align-items-center">
                                                    <div class="col mr-2">
                                                        <c:forEach var="dto" items="${yearRevenue}">
                                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                                Doanh thu (năm ${dto.year})
                                                            </div>
                                                            <div class="h5 mb-0 font-weight-bold text-gray-800">
                                                                <fmt:formatNumber value="${dto.revenue}"/> VNĐ
                                                            </div>
                                                        </c:forEach>
                                                    </div>
                                                    <!--13/3/2023-->
                                                    <div class="col-auto">
                                                        <i class="fas fa-dollar-sign fa-2x text-gray-300" onclick="revenueYears()"></i>
                                                        <div class="revenue_search">
                                                            <input class="revenue_year"  type="number" step="1" name="txtYearRevenue"  />
                                                            <button class="revenue_year-button">Find</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </c:if>
                        </div>


                        <div class="row">
                            <c:set var="monthOrder" value="${requestScope.TOTALORDERSINMONTH_RESULT}"/>
                            <c:set var="yearOrder" value="${requestScope.TOTALORDERSINYEAR_RESULT}"/>
                            <!-- Earnings (Monthly) Card Example -->
                            <c:if test="${not empty monthOrder}">

                                <div class="change__card col-md-6 mb-4">
                                    <form action="adminOrdersTotalSearchByMonthYearController" method="POST" >

                                        <div class="card border-left-info shadow h-100 py-2">
                                            <div class="card-body">
                                                <div class="row no-gutters align-items-center">
                                                    <div class="col mr-2">
                                                        <c:forEach var="dto" items="${monthOrder}">
                                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                                                Số đơn hàng tháng ${dto.month} năm ${dto.year}
                                                            </div>
                                                            <div class="row no-gutters align-items-center">
                                                                <div class="col-auto">
                                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${dto.totalOrders}</div>
                                                                </div>

                                                            </div>
                                                        </c:forEach>
                                                    </div>
                                                    <!--13/3/2023-->
                                                    <div class="col-auto">
                                                        <i class="fas fa-clipboard-list fa-2x text-gray-300"  onclick="numberOfOrders()"></i>
                                                        <div class="orders_search">
                                                            <input class="orders_month" type="month" name="txtDateOrder"
                                                                   />
                                                            <button class="orders_month-button">Find</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </c:if>
                            <!-- Pending Requests Card Example -->
                            <c:if test="${not empty yearOrder}">

                                <div class="change__card col-md-6 mb-4">
                                    <form action="adminOrdersTotalSearchByYearController" method="POST" >

                                        <div class="card border-left-warning shadow h-100 py-2">
                                            <div class="card-body">
                                                <div class="row no-gutters align-items-center">
                                                    <div class="col mr-2">
                                                        <c:forEach var="dto" items="${yearOrder}">
                                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                                Số đơn hàng trong năm ${dto.year}</div>
                                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${dto.totalOrders}</div>
                                                        </c:forEach>
                                                    </div>
                                                    <div class="col-auto">
                                                        <i class="fas fa-dollar-sign fa-dollar-sign-2 fa-2x text-gray-300" onclick="revenueYearsSecond()"></i>
                                                        <div class="revenue_search-second">
                                                            <input class="revenue_year-second"  type="number" step="1" name="txtYearOrder" />
                                                            <button class="revenue_year-button-second">Find</button>
                                                        </div>  
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </c:if>
                        </div>



                        <!-- Content Row -->

                        <div class="row">

                            <!-- Area Chart -->
                            <div class="col-xl col-lg">
                                <div class="card shadow mb-4">
                                    <!-- Card Header - Dropdown -->
                                    <div
                                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                        <h6 class="m-0 font-weight-bold text-primary" style="width: 100%">Thống kê doanh thu trong năm</h6>
                                        <jsp:include page="showChart.html"/>



                                    </div>
                                    <!-- Card Body -->
                                    <div class="card-body">
                                        <jsp:include page="chart.jsp"/>

                                    </div>
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
                            <span>Copyright &copy; PTDK 2023</span>
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
        <script src="vendor/chart.js/Chart.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/chart-area-demo.js"></script>
        <script src="js/demo/chart-pie-demo.js"></script>
        <script src="js/demo/styleCustomize.js"></script>
    </body>
</html>


