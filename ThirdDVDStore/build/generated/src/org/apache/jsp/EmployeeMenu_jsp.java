package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EmployeeMenu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <style>\r\n");
      out.write("            * {\r\n");
      out.write("                margin:0;\r\n");
      out.write("                padding:0;\r\n");
      out.write("                font-family: 'Source Sans Pro', sans-serif;\r\n");
      out.write("            }\r\n");
      out.write("            body {\r\n");
      out.write("                background:url(\"Styling/Photos/JalenHurts.jpeg\") no-repeat center center fixed; \r\n");
      out.write("                background-size:     cover;                      /* <------ */\r\n");
      out.write("                background-repeat:   no-repeat;\r\n");
      out.write("                background-position: center center;\r\n");
      out.write("            }\r\n");
      out.write("            .topnav {\r\n");
      out.write("                background-color: #333;\r\n");
      out.write("                overflow: hidden;\r\n");
      out.write("                align-content: center;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Style the links inside the navigation bar */\r\n");
      out.write("            .topnav a {\r\n");
      out.write("                float: left;\r\n");
      out.write("                display: block;\r\n");
      out.write("                color: #f2f2f2;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                padding: 14px 16px;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("                font-size: 17px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Change the color of links on hover */\r\n");
      out.write("            .topnav a:hover {\r\n");
      out.write("                background-color: #ddd;\r\n");
      out.write("                color: black;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Add a color to the active/current link */\r\n");
      out.write("            .topnav a.active {\r\n");
      out.write("                background-color: #4CAF50;\r\n");
      out.write("                color: white;\r\n");
      out.write("            }\r\n");
      out.write("            .button-link {\r\n");
      out.write("                padding: 10px 15px;\r\n");
      out.write("                background:#7f8c8d;\r\n");
      out.write("                color: #FFF;\r\n");
      out.write("                -webkit-border-radius: 4px;\r\n");
      out.write("                -moz-border-radius: 4px;\r\n");
      out.write("                border-radius: 4px;\r\n");
      out.write("                border: solid 1px white;\r\n");
      out.write("                text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.4);\r\n");
      out.write("                -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.4), 0 1px 1px rgba(0, 0, 0, 0.2);\r\n");
      out.write("                -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.4), 0 1px 1px rgba(0, 0, 0, 0.2);\r\n");
      out.write("                box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.4), 0 1px 1px rgba(0, 0, 0, 0.2);\r\n");
      out.write("                -webkit-transition-duration: 0.2s;\r\n");
      out.write("                -moz-transition-duration: 0.2s;\r\n");
      out.write("                transition-duration: 0.2s;\r\n");
      out.write("            }\r\n");
      out.write("            .button-link:hover, .button-link:focus {\r\n");
      out.write("                background: #356094;\r\n");
      out.write("                border: solid 1px #2A4E77;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .button-link:active {\r\n");
      out.write("                -webkit-box-shadow: inset 0 1px 4px rgba(0, 0, 0, 0.6);\r\n");
      out.write("                -moz-box-shadow: inset 0 1px 4px rgba(0, 0, 0, 0.6);\r\n");
      out.write("                box-shadow: inset 0 1px 4px rgba(0, 0, 0, 0.6);\r\n");
      out.write("                background: #2E5481;\r\n");
      out.write("                border: solid 1px #203E5F;\r\n");
      out.write("            }\r\n");
      out.write("            .menu {\r\n");
      out.write("                position:relative;\r\n");
      out.write("                opacity: .8;\r\n");
      out.write("                width:40%;\r\n");
      out.write("                height:35%;\r\n");
      out.write("                margin:10% auto;\r\n");
      out.write("                text-align:center;\r\n");
      out.write("                background:#ecf0f1;\r\n");
      out.write("                padding:40px;\r\n");
      out.write("                -webkit-border-radius:20px 0 0 0;\r\n");
      out.write("                -moz-border-radius:20px 0 0 0;\r\n");
      out.write("                border-radius:20px 0 0 0;\r\n");
      out.write("                -webkit-box-shadow: 0px 1px 0px #ad392d, inset 0px 1px 0px white;\r\n");
      out.write("                -moz-box-shadow: 0px 1px 0px #ad392d, inset 0px 1px 0px white;\r\n");
      out.write("                box-shadow: 0px 1px 0px #ad392d, inset 0px 1px 0px white;\r\n");
      out.write("                box-shadow: 20px 20px 20px;\r\n");
      out.write("            }\r\n");
      out.write("            .menu:hover\r\n");
      out.write("            {  \r\n");
      out.write("                opacity: 1.0;           \r\n");
      out.write("            }\r\n");
      out.write("            p,h1 {\r\n");
      out.write("                font-family: 'Source Sans Pro', sans-serif;\r\n");
      out.write("                font-size:2em;\r\n");
      out.write("                font-weight:300;\r\n");
      out.write("                margin: auto;\r\n");
      out.write("                margin-bottom:auto;\r\n");
      out.write("                color:#7f8c8d;\r\n");
      out.write("                text-shadow:1px 1px 0px white;\r\n");
      out.write("                text-align:center;\r\n");
      out.write("            }h1{\r\n");
      out.write("                color:black;\r\n");
      out.write("                text-decoration:underline;\r\n");
      out.write("            }\r\n");
      out.write("            input,select {\r\n");
      out.write("                display:block;\r\n");
      out.write("                width:90%;\r\n");
      out.write("                padding:14px;\r\n");
      out.write("                -webkit-border-radius:6px;\r\n");
      out.write("                -moz-border-radius:6px;\r\n");
      out.write("                border-radius:6px;\r\n");
      out.write("                border:0;\r\n");
      out.write("                margin-bottom:12px;\r\n");
      out.write("                color:#7f8c8d;\r\n");
      out.write("                font-weight:600;\r\n");
      out.write("                font-size:16px;\r\n");
      out.write("                align-content: center;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            input:focus {\r\n");
      out.write("                background:#fafafa;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            li {\r\n");
      out.write("                position:absolute;\r\n");
      out.write("                right:40px;\r\n");
      out.write("                bottom:62px;\r\n");
      out.write("                list-style:none;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("        <title>Employee Menu</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"topnav\" id=\"myTopnav\" method=\"POST\" action='EmployeeController' name=\"frmEmployee\">\r\n");
      out.write("            <a href=\"EmployeeController?action=movieinventoryinfo\">Checkouts, Sales, and Revenues</a>\r\n");
      out.write("            <a href=\"EmployeeController?action=avlinventory\">Available Inventory</a>\r\n");
      out.write("            <a href=\"EmployeeController?action=bestandworstsellers\">Best and worst sellers</a>\r\n");
      out.write("            <a href=\"EmployeeController?action=movienotsold\">Not sold last year</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"menu\" id=\"myMenu\">\r\n");
      out.write("            <form method=\"POST\" action='CustomerController' name=\"frmCustomer\"> \r\n");
      out.write("                <p><a href=\"CustomerController?action=viewcustomers\">Customer Profiles</a></p>\r\n");
      out.write("            </form>\r\n");
      out.write("            <!--\r\n");
      out.write("            <form method=\"POST\" action='EmployeeController' name=\"frmEmployee\"> \r\n");
      out.write("                <p><a href=\"EmployeeController?action=movieinventoryinfo\">Movie Checkouts and associated sales and revenue</a></p>\r\n");
      out.write("                <p><a href=\"EmployeeController?action=avlinventory\">Available Inventory</a></p>            \r\n");
      out.write("                <p><a href=\"EmployeeController?action=bestandworstsellers\">Best and worst sellers</a></p>\r\n");
      out.write("                <p><a href=\"EmployeeController?action=movienotsold\">Not sold last year</a></p>\r\n");
      out.write("            </form>\r\n");
      out.write("            -->\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
