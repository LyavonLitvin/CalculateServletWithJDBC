package by.tms.web.filter;

public final class Constants {

    private Constants() {
    }

    //links to JSP pages
    public static final String INDEX_LINK_JSP = "/pages/index.jsp";
    public static final String CALCULATOR_LINK_JSP = "/pages/calculator/calc.jsp";
    public static final String HISTORY_LINK_JSP = "/pages/calculator/history.jsp";
    public static final String AUTHORIZATION_LINK_JSP = "/pages/user/authorization.jsp";
    public static final String REGISTRATION_LINK_JSP = "/pages/user/reg.jsp";


    //links to servlet
    public static final String HOME_SERVLET_LINK = "/";
    public static final String REGISTRATION_SERVLET_LINK = "/registration";
    public static final String AUTHORIZATION_SERVLET_LINK = "/authorization";
    public static final String CALCULATION_SERVLET_LINK = "/calc";
    public static final String HISTORY_SERVLET_LINK = "/history";
    public static final String LOGOUT_SERVLET_LINK = "/logout";

    //Messages
    public static final String MSG_ERROR_NAME_USERNAME_PASSWORD_NULL = "name or username or password is null!";
    public static final String MSG_ERROR_NAME_USERNAME_PASSWORD_EMPTY = "name or username or password is empty!";
    public static final String MSG_ERROR_USER_HAS_FOUND = "User has found! Try to authorize!!";
    public static final String MSG_ERROR_USER_NOT_FOUND = "User not found!";
    public static final String MSG_ERROR_USERNAME_OR_PASSWORD_NULL = "username or password is null!";
    public static final String MSG_ERROR_USERNAME_OR_PASSWORD_EMPTY = "username or password is empty!";
    public static final String MSG_ERROR_PASSWORD_IS_INCORRECT = "Password is incorrect!";
    public static final String MSG_ERROR_NOT_AUTHORIZED = "You have to authorize first!";
    public static final String MSG_ERROR_NAME_EMPTY = "Name is empty";
    public static final String MSG_ERROR_LOGIN_EMPTY = "Login is empty";
    public static final String MSG_ERROR_PASSWORD_EMPTY = "Password is empty";
    public static final String MSG_ERROR_ROLE_INVALID = "The role is wrong";
    public static final String MSG_ERROR_LOGIN_OR_PASSWORD_INVALID = "Login or password error";
    public static final String MSG_ERROR_ONE_OF_THE_FIELDS_IS_NULL = "One of the fields is null!";
    public static final String MSG_ERROR_ONE_OF_THE_FIELDS_IS_EMPTY = "One of the fields is empty!";
    public static final String MSG_ERROR_WRONG_ENTER_NUMBERS_OR_OPERATION_TYPE = "Wrong enter numbers or opType";
}