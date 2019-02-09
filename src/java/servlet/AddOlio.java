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
import java.util.List;

@WebServlet("/addOlio")
public class AddOlio extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String nome = req.getParameter("nome");
    String categoria = req.getParameter("categoria");
    Float prezzo = Float.parseFloat(req.getParameter("prezzo"));
    int centilitri = Integer.parseInt(req.getParameter("centilitri"));

    Olio bean = new Olio(nome, categoria, prezzo, centilitri);

    HttpSession session = req.getSession();

    List<Olio> list = (List<Olio>) session.getAttribute("listaOlio");
    list.add(bean);
    session.setAttribute("listaOlio", list);

    RequestDispatcher dispatcher = session.getServletContext().getRequestDispatcher("/home1.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
