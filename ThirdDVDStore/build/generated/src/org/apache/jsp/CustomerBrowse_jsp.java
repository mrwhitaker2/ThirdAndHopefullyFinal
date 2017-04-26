package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CustomerBrowse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <script  src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            $(document).ready(function () {\r\n");
      out.write("                $('#genre').hide();\r\n");
      out.write("                $('#actor').hide();\r\n");
      out.write("                $('#store').hide();\r\n");
      out.write("                $('#criteria').change(function () {\r\n");
      out.write("                    if ($('#criteria option:selected').text() == \"Genre\") {\r\n");
      out.write("                        $('#genre').show();\r\n");
      out.write("                        $('#actor').hide();\r\n");
      out.write("                        $('#store').hide();\r\n");
      out.write("                    } else if ($('#criteria option:selected').text() == \"Actor\") {\r\n");
      out.write("                        $('#actor').show();\r\n");
      out.write("                        $('#genre').hide();\r\n");
      out.write("                        $('#store').hide();\r\n");
      out.write("                    } else if ($('#criteria option:selected').text() == \"Store\") {\r\n");
      out.write("                        $('#store').show();\r\n");
      out.write("                        $('#genre').hide();\r\n");
      out.write("                        $('#actor').hide();\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <h1>Hello, ");
      out.print(session.getAttribute("Username"));
      out.write(" </h1>\r\n");
      out.write("        <h2>Your Customer ID is: ");
      out.print(session.getAttribute("Customer_Id"));
      out.write(" </h2>\r\n");
      out.write("        <p><a href=\"CustomerController?action=viewcart\">View Shopping Cart</a></p>\r\n");
      out.write("        <p><a href=\"CustomerController?action=return\">Return a Movie</a></p>\r\n");
      out.write("\r\n");
      out.write("        <form method=\"post\" action=\"SearchController?action=search\">\r\n");
      out.write("            <h3>Search your movie:</h3>  \r\n");
      out.write("\r\n");
      out.write("            Search Category (Genre, Actor, Store):\r\n");
      out.write("            <select name=\"criteria\" id=\"criteria\">\r\n");
      out.write("                <option value=\"selection\">Search by...</option>\r\n");
      out.write("                <option value=\"Genre\">Genre</option>\r\n");
      out.write("                <option value=\"Actor\">Actor</option>\r\n");
      out.write("                <option value=\"Store\">Store</option>\r\n");
      out.write("            </select> <br>\r\n");
      out.write("           \r\n");
      out.write("            <select name=\"genrefield\" id=\"genre\">\r\n");
      out.write("                <option value=\"Action\">Action</option>\r\n");
      out.write("                <option value=\"Animation\">Animation</option>\r\n");
      out.write("                <option value=\"Children\">Children</option>\r\n");
      out.write("                <option value=\"Classics\">Classics</option>\r\n");
      out.write("                <option value=\"Comedy\">Comedy</option>\r\n");
      out.write("                <option value=\"Documentary\">Documentary</option>\r\n");
      out.write("                <option value=\"Drama\">Drama</option>\r\n");
      out.write("                <option value=\"Family\">Family</option>\r\n");
      out.write("                <option value=\"Foreign\">Foreign</option>\r\n");
      out.write("                <option value=\"Games\">Games</option>\r\n");
      out.write("                <option value=\"Horror\">Horror</option>\r\n");
      out.write("                <option value=\"Music\">Music</option>\r\n");
      out.write("                <option value=\"New\">New</option>\r\n");
      out.write("                <option value=\"Sci-Fi\">Sci-Fi</option>\r\n");
      out.write("                <option value=\"Sports\">Sports</option>\r\n");
      out.write("                <option value=\"Travel\">Travel</option>\r\n");
      out.write("            </select><br>\r\n");
      out.write("            \r\n");
      out.write("             <select name=\"actorfield\" id=\"actor\">\r\n");
      out.write("                <option value=\"Akroyd\">Akroyd</option>\r\n");
      out.write("                <option value=\"Astaire\">Astaire</option>\r\n");
      out.write("                <option value=\"Bailey\">Bailey</option>\r\n");
      out.write("                <option value=\"Barrymore\">Barrymore</option>\r\n");
      out.write("                <option value=\"Bergen\">Bergen</option>\r\n");
      out.write("                <option value=\"Berry\">Berry</option>\r\n");
      out.write("                <option value=\"Bloom\">Bloom</option>\r\n");
      out.write("                <option value=\"Bolger\">Bolger</option>\r\n");
      out.write("                <option value=\"Bridges\">Bridges</option>\r\n");
      out.write("                <option value=\"Brody\">Brody</option>\r\n");
      out.write("                <option value=\"Cage\">Cage</option>\r\n");
      out.write("                <option value=\"Chaplin\">Chaplin</option>\r\n");
      out.write("                <option value=\"Chase\">Chase</option>\r\n");
      out.write("                <option value=\"Costner\">Costner</option>\r\n");
      out.write("                <option value=\"Crawford\">Crawford</option>\r\n");
      out.write("                <option value=\"Cronyn\">Cronyn</option>\r\n");
      out.write("                 <option value=\"Cruise\">Cruise</option>\r\n");
      out.write("                <option value=\"Cruz\">Cruz</option>\r\n");
      out.write("                <option value=\"Damon\">Damon</option>\r\n");
      out.write("                <option value=\"Davis\">Davis</option>\r\n");
      out.write("                <option value=\"Day-Lewis\">Day-Lewis</option>\r\n");
      out.write("                <option value=\"Dean\">Dean</option>\r\n");
      out.write("                <option value=\"Degeneres\">Degeneres</option>\r\n");
      out.write("                <option value=\"Dench\">Dench</option>\r\n");
      out.write("                <option value=\"Depp\">Depp</option>\r\n");
      out.write("                <option value=\"Dukakis\">Dukakis</option>\r\n");
      out.write("                <option value=\"Fawcett\">Fawcett</option>\r\n");
      out.write("                <option value=\"Gable\">Gable</option>\r\n");
      out.write("                <option value=\"Goldberg\">Goldberg</option>\r\n");
      out.write("                <option value=\"Grant\">Grant</option>\r\n");
      out.write("                <option value=\"Guiness\">Guiness</option>\r\n");
      out.write("                <option value=\"Hackman\">Hackman</option>\r\n");
      out.write("                <option value=\"Harris\">Harris</option>\r\n");
      out.write("                <option value=\"Hawke\">Hawke</option>\r\n");
      out.write("                <option value=\"Hoffman\">Hoffman</option>\r\n");
      out.write("                <option value=\"Hopkins\">Hopkins</option>\r\n");
      out.write("                <option value=\"Hudson\">Hudson</option>\r\n");
      out.write("                <option value=\"Hunt\">Hunt</option>\r\n");
      out.write("                <option value=\"Johansson\">Johansson</option>\r\n");
      out.write("                <option value=\"Jolie\">Jolie</option>\r\n");
      out.write("                <option value=\"Jovovich\">Jovovich</option>\r\n");
      out.write("                <option value=\"Keitel\">Keitel</option>\r\n");
      out.write("                <option value=\"Kilmer\">Kilmer</option>\r\n");
      out.write("                <option value=\"Lollobrigida\">Lollobrigida</option>\r\n");
      out.write("                <option value=\"Marx\">Marx</option>\r\n");
      out.write("                <option value=\"Mcconaughey\">Mcconaughey</option>\r\n");
      out.write("                <option value=\"Mckellen\">Mckellen</option>\r\n");
      out.write("                <option value=\"Mcqueen\">Mcqueen</option>\r\n");
      out.write("                <option value=\"Miranda\">Miranda</option>\r\n");
      out.write("                <option value=\"Mostel\">Mostel</option>\r\n");
      out.write("                <option value=\"Neeson\">Neeson</option>\r\n");
      out.write("                <option value=\"Nicholson\">Nicholson</option>\r\n");
      out.write("                <option value=\"Olivier\">Olivier</option>\r\n");
      out.write("                <option value=\"Paltrow\">Paltrow</option>\r\n");
      out.write("                <option value=\"Peck\">Peck</option>\r\n");
      out.write("                <option value=\"Penn\">Penn</option>\r\n");
      out.write("                <option value=\"Pesci\">Pesci</option>\r\n");
      out.write("                <option value=\"Phoenix\">Phoenix</option>\r\n");
      out.write("                <option value=\"Pinkett\">Pinkett</option>\r\n");
      out.write("                <option value=\"Pitt\">Pitt</option>\r\n");
      out.write("                <option value=\"Posey\">Posey</option>\r\n");
      out.write("                <option value=\"Presley\">Presley</option>\r\n");
      out.write("                <option value=\"Sinatra\">Sinatra</option>\r\n");
      out.write("                <option value=\"Sobieski\">Sobieski</option>\r\n");
      out.write("                <option value=\"Stallone\">Stallone</option>\r\n");
      out.write("                <option value=\"Streep\">Streep</option>\r\n");
      out.write("                <option value=\"Swank\">Swank</option>\r\n");
      out.write("                <option value=\"Tandy\">Tandy</option>\r\n");
      out.write("                <option value=\"Tautou\">Tautou</option>\r\n");
      out.write("                <option value=\"Temple\">Temple</option>\r\n");
      out.write("                <option value=\"Torn\">Torn</option>\r\n");
      out.write("                <option value=\"Tracy\">Tracy</option>\r\n");
      out.write("                <option value=\"Voight\">Voight</option>\r\n");
      out.write("                <option value=\"Wahlberg\">Wahlberg</option>\r\n");
      out.write("                <option value=\"Wayne\">Wayne</option>\r\n");
      out.write("                <option value=\"Williams\">Williams</option>\r\n");
      out.write("                <option value=\"Willis\">Willis</option>\r\n");
      out.write("                <option value=\"Winslet\">Winslet</option>\r\n");
      out.write("            </select><br>\r\n");
      out.write("\r\n");
      out.write("              <select name=\"storefield\" id=\"store\">\r\n");
      out.write("                <option value=\"1\">1 - Alberta District</option>\r\n");
      out.write("                <option value=\"2\">2 - QLD District</option>\r\n");
      out.write("            </select> <br>\r\n");
      out.write("\r\n");
      out.write("            <input type=\"submit\" value=\"Search\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
