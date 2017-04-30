package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CustomerCreate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_out_value_nobody.release();
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
      response.setContentType("text/html; charset=EUC-KR");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styling/CustomerCreate.css\">\r\n");
      out.write("        <title>Customer Creation</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>        \r\n");
      out.write("        <form method=\"POST\" action='CustomerController?action=createCust' name=\"frmAddCustomer\">\r\n");
      out.write("            <h1>Customer Creation</h1>\r\n");
      out.write("            <input\r\n");
      out.write("                type=\"text\" \r\n");
      out.write("                required \r\n");
      out.write("                placeholder=\"Username\"\r\n");
      out.write("                name=\"Username\"\r\n");
      out.write("                value=\"");
      if (_jspx_meth_c_out_0(_jspx_page_context))
        return;
      out.write("\" /> <br /> \r\n");
      out.write("            <input\r\n");
      out.write("                type=\"password\"\r\n");
      out.write("                required\r\n");
      out.write("                placeholder=\"password\"\r\n");
      out.write("                name=\"Password\"\r\n");
      out.write("                pattern=\"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}\" \r\n");
      out.write("                title=\"Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\"\r\n");
      out.write("                value=\"");
      if (_jspx_meth_c_out_1(_jspx_page_context))
        return;
      out.write("\" /> <br /> \r\n");
      out.write("            <select\r\n");
      out.write("                name=\"Customer_Pref\"\r\n");
      out.write("                required\r\n");
      out.write("                title=\"Please select your favorite movie genre\"\r\n");
      out.write("                value=\"");
      if (_jspx_meth_c_out_2(_jspx_page_context))
        return;
      out.write("\" />\r\n");
      out.write("            <br />\r\n");
      out.write("            <option value=\"Action\">Action</option>\r\n");
      out.write("            <option value=\"Animation\">Animation</option>\r\n");
      out.write("            <option value=\"Children\">Children</option>\r\n");
      out.write("            <option value=\"Classics\">Classics</option>\r\n");
      out.write("            <option value=\"Comedy\">Comedy</option>\r\n");
      out.write("            <option value=\"Documentary\">Documentary</option>\r\n");
      out.write("            <option value=\"Drama\">Drama</option>\r\n");
      out.write("            <option value=\"Family\">Family</option>\r\n");
      out.write("            <option value=\"Foreign\">Foreign</option>\r\n");
      out.write("            <option value=\"Games\">Games</option>\r\n");
      out.write("            <option value=\"Horror\">Horror</option>\r\n");
      out.write("            <option value=\"Music\">Music</option>\r\n");
      out.write("            <option value=\"New\">New</option>\r\n");
      out.write("            <option value=\"Sci-Fi\">Sci-Fi</option>\r\n");
      out.write("            <option value=\"Sports\">Sports</option>\r\n");
      out.write("            <option value=\"Travel\">Travel</option>\r\n");
      out.write("\r\n");
      out.write("        </select><br> \r\n");
      out.write("        <select  \r\n");
      out.write("            required\r\n");
      out.write("            placeholder=\"Customer Payment Preference\"\r\n");
      out.write("            name=\"Payment\" \r\n");
      out.write("            title=\"Please select your preferred method of payment\"\r\n");
      out.write("            value=\"");
      if (_jspx_meth_c_out_3(_jspx_page_context))
        return;
      out.write("\" /> <br />>\r\n");
      out.write("        <option value=\"debit\">Debit</option>\r\n");
      out.write("        <option value=\"credit\">Credit</option>\r\n");
      out.write("        <option value=\"bitcoin\">Bitcoin</option>\r\n");
      out.write("    </select><br/>          \r\n");
      out.write("    <input\r\n");
      out.write("        type=\"email\"\r\n");
      out.write("        placeholder=\"Email\"\r\n");
      out.write("        required\r\n");
      out.write("        name=\"Email\"\r\n");
      out.write("        value=\"");
      if (_jspx_meth_c_out_4(_jspx_page_context))
        return;
      out.write("\" /> <br /> \r\n");
      out.write("    <br /> \r\n");
      out.write("    <input type=\"submit\" value=\"Submit\" />\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<p><a href=\"CustomerController?action=browse\">Browse Movies</a></p>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_out_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer.Username}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent(null);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer.Password}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_out_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_2.setPageContext(_jspx_page_context);
    _jspx_th_c_out_2.setParent(null);
    _jspx_th_c_out_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer.Customer_Pref}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
    return false;
  }

  private boolean _jspx_meth_c_out_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_3.setPageContext(_jspx_page_context);
    _jspx_th_c_out_3.setParent(null);
    _jspx_th_c_out_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer.Customer_Pref}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_3 = _jspx_th_c_out_3.doStartTag();
    if (_jspx_th_c_out_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
    return false;
  }

  private boolean _jspx_meth_c_out_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_4.setPageContext(_jspx_page_context);
    _jspx_th_c_out_4.setParent(null);
    _jspx_th_c_out_4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer.Email}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_4 = _jspx_th_c_out_4.doStartTag();
    if (_jspx_th_c_out_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
    return false;
  }
}
