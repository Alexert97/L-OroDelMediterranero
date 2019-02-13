package servlet;

import bean.Olio;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class RemoveOlio extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));

    HttpSession session = req.getSession();
    List<Olio> list = (List<Olio>) session.getAttribute("listaOlio");
    for (Olio o : list) {
      if (o.getId() == id) {
        list.remove(o);
      }
    }
    session.removeAttribute("listaOlio");
    session.setAttribute("listaOlio", list);

    RequestDispatcher dispatcher = session.getServletContext().getRequestDispatcher("/home1.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
