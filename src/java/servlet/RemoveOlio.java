package servlet;

import bean.Olio;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/removeOlio")
public class RemoveOlio extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));

    HttpSession session = req.getSession();
    List<Olio> list = (List<Olio>) session.getAttribute("listaOlio");
    Iterator<Olio> i = list.iterator();
    while (i.hasNext()) {
      Olio o = i.next();
      if (o.getId() == id) {
        i.remove();
      }
    }
    session.removeAttribute("listaOlio");
    session.setAttribute("listaOlio", list);

    RequestDispatcher dispatcher = session.getServletContext().getRequestDispatcher("/gestioneAcquistaOlio.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
