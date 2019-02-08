package servlet;

import bean.Olio;
import manager.ManagerOlio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addOlio")
public class AddOlio extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String nome = req.getParameter("nome");
    String categoria = req.getParameter("categoria");
    Float prezzo = Float.parseFloat(req.getParameter("prezzo"));
    int centilitri = Integer.parseInt(req.getParameter("centilitri"));

    Olio bean = new Olio(nome, categoria, prezzo, centilitri);
    ManagerOlio manager = new ManagerOlio();
    manager.addOlio(bean);

    
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
