/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.utils;

/**
 *
 * @author Chau Nhat Truong
 */
public class MyApplicationConstants {

    public class CreateAccountServlet {

        public static final String ERROR_PAGE = "signUpPage";
        public static final String LOGIN_PAGE = "loginPage";
        public static final String SEND_EMAIL = "verifyCodePage";
    }

    public class DeleteAccountServlet {

        public static final String ERROR_PAGE = "errorPage";
    }

    public class DispatchController {

        public static final String LOGIN_PAGE = "loginPage";
        public static final String LOGIN_CONTROLLER = "loginController";
        public static final String LOGOUT_CONTROLLER = "logoutController";
        public static final String DELETE_ACCOUNT_CONTROLLER = "deleteAccountController";
        public static final String UPDATE_ACCOUNT_CONTROLLER = "updateAccountController";
        public static final String SIGN_UP_CONTROLLER = "signUpController";
    }

    public class FirstTimeRequestServlet {

        public static final String LOGIN_PAGE = "loginPage";
        public static final String MAIN_PAGE = "mainPage";
    }

    public class LoginServlet {

        public static final String LOGIN_PAGE = "loginPage";
        public static final String FORGOT_PASSWORD_PAGE = "ForgotPasswordPage";
        public static final String MAIN_PAGE = "mainPage";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class ForgotPasswordServlet {

        public static final String FORGOTPASSWORD_CONTROLLER = "forgotPasswordController";
        public static final String FORGOTPASSWORD_PAGE = "forgotPasswordPage";
    }

    public class LogoutServlet {

        public static final String LOGIN_PAGE = "loginPage";
        public static final String MAIN_PAGE = "mainPage";
    }

    public class UpdateAccountServlet {

        public static final String ERROR_PAGE = "errorPage";
    }

    public class CustomerVerifyServlet {

        public static final String CUSTOMERVERIFY_PAGE = "customerVerifyPage";
        public static final String VERIFYCODE_PAGE = "verifyCodePage";
    }

    public class VerifyCodeServlet {

        public static final String VERIFYCODE_PAGE = "verifyCodePage";
        public static final String RESETPASSWORD_PAGE = "resetPasswordPage";
    }

    public class ResetPasswordServlet {

        public static final String RESETPASSWORD_PAGE = "resetPasswordPage";
        public static final String LOGIN_PAGE = "loginPage";
    }

    public class ShowMainPageServlet {

        public static final String MAIN_PAGE = "mainPage";
    }

    public class SearchServlet {

        public static final String SEARCH_TEXT_PAGE = "searchTextPage";
        public static final String SEARCH_FILTER_PAGE = "searchFilterPage";
        public static final String SEARCH_FILTER_SERVLET = "searchByFilterController";
    }

    public class CartFeature {

        public static final String CART_SERVLET = "addToCartController";
        public static final String CART_PAGE = "addToCartPage";
    }

    public class ProductFeature {

        public static final String PRODUCT_SERVLET = "viewProductController";
        public static final String PRODUCT_PAGE = "viewProductPage";
    }

    public class AccountFeature {

        public static final String ACCOUNT_SERVLET = "updateAccountController";
        public static final String ACCOUNT_UPDATE_PAGE = "updateInforPage";
        public static final String ACCOUNT_INFOR_PAGE = "userInforPage";
    }

    public class CommentFeature {

        public static final String ADD_COMMENT_SERVLET = "addCommentController";
        public static final String PRODUCT_PAGE = "viewProductPage";
    }

    public class ShippingServlet {

        public static final String SHIPPING_PAGE = "shippingPage";
        public static final String PAYMENT_PAGE = "paymentPage";
    }

    public class PaymentServlet {

        public static final String PAYMENT_PAGE = "paymentPage";
        public static final String CHECKOUT_PAGE = "checkOutPage";
    }

    public enum AuthorizationFilterConstant {
        LOGIN_JSP_PAGE("loginPage"),
        NOT_FOUND_PAGE("404Page");

        public final String value;

        private AuthorizationFilterConstant(String value) {
            this.value = value;
        }
    }

    public class LoginForCheckoutServlet {

        public static final String LOGINFORCHECKOUT_PAGE = "loginForCheckoutPage";
        public static final String SHIPPING_PAGE = "shippingPage";
    }

    public class AdminNewAccountServlet {

        public static final String ADMINACCOUNTLIST_PAGE = "adminAccountListController";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminNewBrandServlet {

        public static final String ADMINBRANDLIST_PAGE = "adminBrandListController";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminNewCategoryServlet {

        public static final String ADMINCATEGORYLIST_PAGE = "adminCategoryListController";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminNewProductServlet {

        public static final String ADMINPRODUCTLIST_PAGE = "adminProductListController";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminAccountListServlet {

        public static final String ADMINACCOUNTLIST_PAGE = "adminAccountListPage";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminBrandListServlet {

        public static final String ADMINBRANDLIST_PAGE = "adminBrandListPage";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminCategoryListServlet {

        public static final String ADMINCATEGORYLIST_PAGE = "adminCategoryListPage";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminProductListServlet {

        public static final String ADMINPRODUCTLIST_PAGE = "adminProductListPage";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminUpdateAccountServlet {

        public static final String ADMINACCOUNTLIST_PAGE = "adminAccountListController";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminUpdateBrandServlet {

        public static final String ADMINBRANDLIST_PAGE = "adminBrandListController";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminUpdateCategoryServlet {

        public static final String ADMINCATEGORYLIST_PAGE = "adminCategoryListController";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminUpdateProductServlet {

        public static final String ADMINPRODUCTLIST_PAGE = "adminProductListController";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminDeleteAccountServlet {

        public static final String ADMINACCOUNTLIST_PAGE = "adminAccountListController";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminDeleteBrandServlet {

        public static final String ADMINBRANDLIST_PAGE = "adminBrandListController";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminDeleteCategoryServlet {

        public static final String ADMINCATEGORYLIST_PAGE = "adminCategoryListController";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class AdminDeleteProductServlet {

        public static final String ADMINPRODUCTLIST_PAGE = "adminProductListController";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }

    public class ChartDetail {

        public static final String ADMINCHART_PAGE = "chartDetailController";
    }

    public class AdminOrdersRevenueServlet {

        public static final String ADMIN_PAGE = "adminPage";
    }

    public class AdminOrdersRevenueSearchByMonthYearServlet {

        public static final String ADMIN_PAGE = "adminPage";

    }

    public class AdminOrdersRevenueSearchByYearServlet {

        public static final String ADMIN_PAGE = "adminPage";

    }

    public class AdminOrdersTotalSearchByMonthYearServlet {

        public static final String ADMIN_PAGE = "adminPage";

    }

    public class AdminOrdersTotalSearchByYearServlet {

        public static final String ADMIN_PAGE = "adminPage";

    }

    public class AdminOrdersListServlet {

        public static final String ADMIN_ORDERS_LIST_PAGE = "adminOrdersListPage";
        public static final String ADMIN_PAGE = "AdminOrderedListServlet";
    }
    
      public class AdminViewDetailOrderServlet {

        public static final String ADMIN_VIEW_DETAIL_ORDERS_LIST_PAGE = "adminViewOrderDetailListPage";
        public static final String ADMIN_PAGE = "AdminOrderedListServlet";
    }

    public class CustomerOrdersList {

        public static final String CUSTOMER_ORDERS_LIST_PAGE = "customerOrdersListPage";
        public static final String CUSTOMER_PAGE = "AdminOrderedListServlet";
    }

    public class AdminFeedBackListServlet {

        public static final String ADMIN_FEEDBACK_LIST_PAGE = "adminFeedBackListPage";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }
    
     public class AdminDeleteFeedBackServlet {
        public static final String ADMINDELETEFEEDBACKLIST_PAGE = "adminFeedBackListController";
        public static final String ADMIN_PAGE = "adminOrdersRevenueController";
    }
     public class ChartServlet{
         public static final String ADMIN_CHART_PAGE = "adminChartController";
         public static final String ADMIN_PAGE = "adminOrdersRevenueController";

     }
}
