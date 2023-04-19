<%-- 
    Document   : aboutUs
    Created on : Mar 31, 2023, 5:28:50 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="swp391.cart.CartObject"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="swp391.product.ProductDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>About us</title>
        <link rel="stylesheet" href="style/reset.css">
        <link rel="stylesheet" href="style/aboutUs.css">
        <link rel="stylesheet" href="style/base.css">
        <link rel="stylesheet" href="style/curtain.css">
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
            />

    </head>

    <body>
        <div class="wrapper">
            <header class="header">
                <div class="nav-top">
                    <div class="container">
                        <div class="shipping">
                            <p class="shipping-text">Free shipping with recept from 200$</p>
                        </div>
                    </div>
                </div>
                <img src="assets/image/Nav-line.png" alt="" class="nav-line" />
                <!-- NAV DESKTOP - TABLET -->
                <div class="nav-bot">
                    <div class="container">
                        <a href="mainPage" class="menu-logo"> <img srcset="images/LOGO.png 2x" alt=""> </a>
                        <ul class="menu">
                            <li class="menu-item">
                                <a href="#!" class="menu-link menu-link-category">Categories</a>
                                <ul class="menu-link-category-tab">
                                    <div class="container">
                                        <c:set var="categoryList" value="${sessionScope.CATEGORY}"/>
                                        <c:forEach var="category" items="${categoryList}">
                                            <li class="menu-link-category-tab-title">
                                                <a href="SearchByFilterServlet?txtProductCateID=${category.cateID}" class="menu-link menu-link-bracelet"
                                                   >${fn:toUpperCase(category.name)}</a
                                                >
                                            </li>
                                        </c:forEach>
                                    </div>
                                </ul>
                            </li>
                            <li class="menu-item">
                                <a href="aboutUs.jsp" class="menu-link">About</a>
                            </li>
                            <li class="menu-item">
                                <a href="#!" class="menu-link">Shop</a>
                            </li>
                            <li class="menu-item">
                                <a href="contactPage.jsp" class="menu-link">Contact</a>
                            </li>
                        </ul>
                        <div class="menu-icon">
                            <!-- SEARCH -->
                            <div class="menu-icon-tab">
                                <button class="menu-icon-tab-search" href="#!">
                                    <img
                                        class="menu-icon-img"
                                        srcset="assets/image/search-normal.png 2x"
                                        alt=""
                                        />
                                </button>
                                <div class="menu-icon-tab-search-content">
                                    <div class="container">
                                        <div class="menu-icon-tab-search-content-title">
                                            <p class="menu-icon-tab-search-content-title-desc">
                                                SEARCH
                                            </p>
                                            <img srcset="assets/image/Footer-line.png 2x" alt="" />
                                        </div>
                                        <div class="menu-icon-tab-search-form">
                                            <form action="searchTextController">
                                                <input
                                                    type="text"
                                                    id="search-button"
                                                    class="menu-icon-tab-search-input"
                                                    placeholder="Search Product..."
                                                    name="txtSearch" value=""
                                                    />

                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- PROFILE -->
                            <div class="menu-icon-tab">
                                <button class="menu-icon-tab-profile" href="#!">
                                    <img
                                        class="menu-icon-img"
                                        srcset="assets/image/profile-circle.png 2x"
                                        alt=""
                                        />
                                </button>
                                <div class="menu-icon-tab-profile-content">
                                    <div class="container">

                                        <c:if test="${not empty sessionScope.USER}">
                                            <div class="menu-icon-tab-profile-content-title">
                                                <p class="menu-icon-tab-profile-content-title-desc">
                                                    ACCOUNT INFORMATION
                                                </p>
                                                <img srcset="images/Footer-line.png 2x" alt="" />
                                            </div>
                                            <div class="menu-icon-tab-profile-form">
                                                <p class="menu-icon-tab-profile-form-name">${sessionScope.USER.name}</p>
                                                <a href="userInforPage" class="menu-icon-tab-profile-form-link"
                                                   >My account</a
                                                >
                                                <!--                                            <a href="#!" class="menu-icon-tab-profile-form-link"
                                                                                               >Address List</a
                                                                                            >-->
                                                <a href="logoutController" class="menu-icon-tab-profile-form-link"
                                                   >Log out</a
                                                >
                                            </div>
                                        </c:if>
                                        <c:if test="${empty sessionScope.USER}">
                                            <p style="font-size: 15px; margin: 5px 0">You are not already logged <span style="color: red">PLEASE LOGIN FIRST!!</span></p><br/>
                                            <%--<c:set var="URL" value="userCart.jsp" scope="session"/>--%>
                                            <form action="loginPage" method="GET">
                                                <button class="menu-icon-tab-cart-content-function-method-btn">
                                                    <a style="font-size: 15px; text-decoration: none; font-weight: bold; color: inherit" href="loginPage">LOGIN</a>
                                                </button>
                                            </form>
                                        </c:if>

                                    </div>
                                </div>
                            </div>
                            <!-- CART -->
                            <div class="menu-icon-tab">
                                <button class="menu-icon-tab-cart" href="#!">
                                    <img
                                        class="menu-icon-img"
                                        srcset="assets/image/shopping-cart.png 2x"
                                        alt=""
                                        />
                                </button>
                                <div class="menu-icon-tab-cart-content">
                                    <div class="container">
                                        <div class="menu-icon-tab-cart-content-title">
                                            <div class="menu-icon-tab-cart-content-title-container">
                                                <p class="menu-icon-tab-cart-content-title-desc">
                                                    Cart
                                                </p>
                                                <img
                                                    srcset="assets/image/Footer-line.png 2x"
                                                    alt=""
                                                    class="menu-icon-tab-cart-space"
                                                    />
                                            </div>
                                        </div>
                                        <div class="menu-icon-tab-cart-content-show">
                                            <div class="menu-icon-tab-cart-content-show-icon">
                                                <img
                                                    srcset="assets/image/shopping-icon-tab.png 2x"
                                                    alt=""
                                                    />
                                            </div>
                                            <div class="menu-icon-tab-cart-content-show-txt">
                                                <c:set var="cartSize" value="${sessionScope.CART.items.size()}"/>
                                                <c:set var="totalQuantity" value="${0}" />
                                                <c:forEach var="quantity" items="${sessionScope.CART.items.values()}">
                                                    <c:set var="totalQuantity" value="${totalQuantity + quantity}" />
                                                </c:forEach>
                                                <c:if test="${empty sessionScope.CART.items.size()}">
                                                    <c:set var="totalQuantity" value="${0}"/>
                                                </c:if>

                                                <p
                                                    class="menu-responsive-icon-tab-cart-content-show-txt-desc"
                                                    >
                                                <c:if test="${totalQuantity eq 0}">
                                                    There are <span id="cart-size-header" style="font-weight: bold">no</span> currently products.
                                                </c:if>
                                                <c:if test="${totalQuantity ne 0}">
                                                    There are <span id="cart-size-header" style="font-weight: bold">${totalQuantity}</span> products
                                                </c:if>
                                                </p>
                                            </div>
                                        </div>
                                        <img srcset="assets/image/Footer-line.png 2x" alt="" />
                                        <c:set var="listCart" value="${sessionScope.CART}"/>
                                        <c:set var="totalPrice" value="${0}"/>

                                        <c:forEach var="item" items="${sessionScope.CART.items}">
                                            <c:forEach var="detail" items="${sessionScope.CART.itemDetail}">
                                                <c:if test="${item.key eq detail.key}">
                                                    <c:set var="totalPrice" value="${totalPrice + (item.value * detail.value.price)}"/>
                                                </c:if>
                                            </c:forEach>
                                        </c:forEach>
                                        <div class="menu-icon-tab-cart-content-function">
                                            <div class="menu-icon-tab-cart-content-function-total">
                                                <p
                                                    class="menu-icon-tab-cart-content-function-total-txt"
                                                    >
                                                    TOTAL AMOUNT
                                                </p>
                                                <p
                                                    class="menu-icon-tab-cart-content-function-total-price"
                                                    id="totalPrice"
                                                    >
                                                    <fmt:formatNumber var="price" value="${totalPrice}" pattern="#,###"/>
                                                    ${price}₫
                                                </p>
                                            </div>
                                            <div class="menu-icon-tab-cart-content-function-method">
                                                <form action="addToCartPage" method="POST">
                                                    <button
                                                        class="menu-icon-tab-cart-content-function-method-btn"
                                                        >
                                                        VIEW CART
                                                    </button>
                                                </form>
                                                <button
                                                    class="pay-button menu-icon-tab-cart-content-function-method-btn"
                                                    >
                                                    PAY
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- NAV MOBILE -->
                <div class="nav-bot-responsive">
                    <div class="container">
                        <div class="menu-responsive-icon">
                            <!-- <img
                              class="menu-responsive-icon-img"
                              srcset="./assets/image/shopping-cart.png 2x"
                              alt=""
                            /> -->
                            <div class="menu-responsive-icon-tab">
                                <button class="menu-responsive-icon-tab-cart" href="#!">
                                    <img
                                        class="menu-responsive-icon-img menu-responsive-icon-img-cart"
                                        srcset="assets/image/shopping-cart.png 2x"
                                        alt=""
                                        />
                                </button>
                                <div class="menu-responsive-icon-tab-cart-content">
                                    <div class="container">
                                        <div class="menu-responsive-icon-tab-cart-content-title">
                                            <div
                                                class="menu-responsive-icon-tab-cart-content-title-container"
                                                >
                                                <p
                                                    class="menu-responsive-icon-tab-cart-content-title-desc"
                                                    >
                                                    Cart
                                                </p>
                                                <img
                                                    srcset="assets/image/Footer-line.png 2x"
                                                    alt=""
                                                    class="menu-responsive-icon-tab-cart-space"
                                                    />
                                            </div>
                                        </div>
                                        <div class="menu-responsive-icon-tab-cart-content-show">
                                            <div
                                                class="menu-responsive-icon-tab-cart-content-show-icon"
                                                >
                                                <img
                                                    srcset="assets/image/shopping-icon-tab.png 2x"
                                                    alt=""
                                                    />
                                            </div>
                                            <div
                                                class="menu-responsive-icon-tab-cart-content-show-txt"
                                                >
                                                <c:set var="cartSize" value="${sessionScope.CART.items.size()}"/>
                                                <c:set var="totalQuantity" value="${0}" />
                                                <c:forEach var="quantity" items="${sessionScope.CART.items.values()}">
                                                    <c:set var="totalQuantity" value="${totalQuantity + quantity}" />
                                                </c:forEach>
                                                <c:if test="${empty sessionScope.CART.items.size()}">
                                                    <c:set var="totalQuantity" value="${0}"/>
                                                </c:if>
                                                <p
                                                    class="menu-responsive-icon-tab-cart-content-show-txt-desc"
                                                    >
                                                <c:if test="${totalQuantity eq 0}">
                                                    There are <span id="cart-size-header-mobile" style="font-weight: bold">no</span> currently products.
                                                </c:if>
                                                <c:if test="${totalQuantity ne 0}">
                                                    There are <span id="cart-size-header-mobile" style="font-weight: bold">${totalQuantity}</span> products
                                                </c:if>
                                                </p>

                                            </div>
                                        </div>
                                        <img srcset="assets/image/Footer-line.png 2x" alt="" />
                                        <div class="menu-responsive-icon-tab-cart-content-function">
                                            <div
                                                class="menu-responsive-icon-tab-cart-content-function-total"
                                                >
                                                <p
                                                    class="menu-responsive-icon-tab-cart-content-function-total-txt"
                                                    >
                                                    TOTAL AMOUNT
                                                </p>
                                                <p
                                                    class="menu-responsive-icon-tab-cart-content-function-total-price"
                                                    id="total-price-nav-mobile"
                                                    >
                                                    <fmt:formatNumber var="price" value="${totalPrice}" pattern="#,###" />
                                                    ${price}₫
                                                </p>
                                            </div>
                                            <div
                                                class="menu-responsive-icon-tab-cart-content-function-method"
                                                >
                                                <form action="addToCartPage" method="POST">
                                                    <button
                                                        class="menu-responsive-icon-tab-cart-content-function-method-btn"
                                                        >
                                                        VIEW CART
                                                    </button>
                                                </form>
                                                <button
                                                    class="menu-responsive-icon-tab-cart-content-function-method-btn"
                                                    >
                                                    PAY
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a href="mainPage" class="menu-responsive-logo"> <img srcset="images/LOGO.png 2x" alt=""> </a>
                        <div class="menu-responsive-icon">
                            <img
                                class="menu-responsive-icon-img menu-responsive-icon-img-bar"
                                srcset="assets/image/textalign-justifycenter.png 2x"
                                alt=""
                                />
                        </div>
                    </div>
                </div>
                <!--  -->
                <hr style="opacity: 0.6">
                <!--<img src="assets/image/Nav-line.png" alt="" class="nav-line-bot" />-->
            </header>

            <div class="grid">



                <p class="about-description">Welcome to our online store, where we specialize in providing the finest quality jewels to our valued customers. We are passionate about all things sparkly and beautiful, and we're committed to offering an extensive selection of exquisite jewels that are perfect for any occasion.

                    Our team consists of experienced and knowledgeable professionals who are dedicated to providing exceptional customer service. We believe that every customer should have an enjoyable shopping experience and should feel confident that they are getting the best possible value for their money.

                    At our store, we offer a wide range of high-quality jewels, including stunning diamond rings, beautiful necklaces, and elegant bracelets. We carefully select each piece for its exceptional quality and timeless beauty, ensuring that our customers receive only the very best.

                    Whether you're looking for a special gift for a loved one or simply treating yourself, our store has something for everyone. We are committed to providing a seamless shopping experience, and we offer fast and reliable shipping to ensure that you receive your jewels quickly and safely.

                    Thank you for choosing our store for your jewel needs. We are confident that you will love our selection, quality, and service, and we look forward to serving you for years to come.</p>

                <div class="process_img-standard-quality">
                    <span class="title_standard-quality">Standar-Quality</span>
                    <p style="text-align: center; margin-bottom: 30px;">
                        "Standard - substance" are two exact words to describe 
                        <span style="font-weight: bold;">PTDK</span>.
                    </p>
                    <span style="font-size: 20px; font-weight: bold;">"STANDARD"</span>
                    <p>With the spirit of the "jewelry enthusiasts", we always fight ourselves every day to bring the most experienced experience as well as services and products to customers.</p>
                    <img src="https://i.pinimg.com/564x/bb/bc/39/bbbc39519180ed1b8ee344a45d241de0.jpg" alt="">


                    <span style="font-size: 20px; font-weight: bold; ">"QUALITY"</span>
                    <p>Unlike many other brands, our inspiration is derived from everything around, but has been designed and upgraded to produce unique - new - cool, hard -to -see products.</p>
                    <img src="https://cdn.shopify.com/s/files/1/0644/2958/8701/files/MG_8152_3_480x480.jpg?v=1655261660" alt="">
                </div>

                <div class="title_founder-include">
                    <hr style="width: 250px; height: 2px; background-color: #333; margin: auto;">
                    <h2 class="title-founder">Founding members</h2>
                    <hr style="width: 250px; height: 2px; background-color: #333; margin: auto;">
                </div>

                <div class="stage">
                    <div class="stage-content">


                        <div class="grid__row container__info-group">

                            <div class="column">
                                <div class="card">
                                    <div class="background">
                                        <!-- <img src="assets/image/5obvza.png" alt=""> -->
                                    </div>
                                    <div class="card__img">
                                        <img src="images/phát.jpg" alt="Phát"
                                             style="width:100%">

                                    </div>
                                    <div class="container__info">
                                        <h2>Nguyễn Tiến Phát</h2>
                                        <p class="title">CEO & Founder & Backend</p>
                                        <p>Leader.</p>
                                        <p>phat@gmail.com</p>
                                        <p><button class="button">Contact</button></p>
                                    </div>
                                </div>
                            </div>


                            <div class="column">
                                <div class="card">
                                    <div class="background">

                                        <!-- <img src="assets/image/5obvza.png" alt=""> -->
                                    </div>
                                    <img src="images/dũng.jpg" alt="Dũng" style="width:100%">
                                    <div class="container__info">
                                        <h2>Nguyễn Văn Dũng</h2>
                                        <p class="title">Front End</p>
                                        <p>Front end</p>
                                        <p>dung@gmail.com</p>
                                        <p><button class="button">Contact</button></p>
                                    </div>
                                </div>
                            </div>

                            <div class="column">
                                <div class="card">
                                    <div class="background">


                                        <!-- <img src="assets/image/5obvza.png" alt=""> -->
                                    </div>
                                    <img src="images/Thầy Trường.jpg" alt="Trường" style="width:100%">
                                    <div class="container__info">
                                        <h2>Châu Nhật Trường</h2>
                                        <p class="title">Document writter, backend</p>
                                        <p>Document.</p>
                                        <p>truong@gmail.com</p>
                                        <p><button class="button">Contact</button></p>
                                    </div>
                                </div>
                            </div>



                            <div class="column">
                                <div class="card">
                                    <div class="background">

                                        <!-- <img src="assets/image/5obvza.png" alt=""> -->
                                    </div>
                                    <img src="images/ảnh cv.jpg" alt="Khoa" style="width:100%">
                                    <div class="container__info">
                                        <h2>Trương Đinh Đăng Khoa</h2>
                                        <p class="title">Front end</p>
                                        <p>Front end.</p>
                                        <p>khoa@gmail.com</p>
                                        <p><button class="button">Contact</button></p>
                                    </div>
                                </div>
                            </div>



                            <div class="column">
                                <div class="card">
                                    <div class="background">


                                        <!-- <img src="assets/image/5obvza.png" alt=""> -->
                                    </div>
                                    <img src="images/Duy.jpg" alt="Duy" style="width:100%">
                                    <div class="container__info">
                                        <h2>Nguyễn Thanh Duy</h2>
                                        <p class="title">Back end</p>
                                        <p>Back end</p>
                                        <p>duy@gmail.com</p>
                                        <p><button class="button">Contact</button></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <label class="curtain-container">
                        <div class="curtain-panel">
                            <input type="checkbox" class="curtain-trigger" />
                            <div class="left-curtain curtain" data-title="PTDK"></div>
                            <div class="right-curtain curtain" data-title="PTDK"></div>

                        </div>
                    </label>
                </div>
            </div>
        </div>
                                                <script src="js/header.js"></script>
    </body>

</html>
