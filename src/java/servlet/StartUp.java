package servlet;

import bean.Olio;
import bean.Prenotazione;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/startup")
public class StartUp extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();

    List<Olio> listaOlio = new ArrayList<>();
    List<Prenotazione> listaPrenotazioni = new ArrayList<>();

    listaOlio.add(new Olio(1, "terre di mezzo", "extravergine", 9.50, 75, 100));
    listaOlio.add(new Olio(2, "mordor", "extravergine", 7.50, 75, 100));
    listaOlio.add(new Olio(3, "gandalf", "vergine", 8.00, 75, 100));

    listaPrenotazioni.add(new Prenotazione(1,"Alessandro","Rigido","25/02/2019","10:00",240));

    session.setAttribute("listaOlio", listaOlio);
    session.setAttribute("listaPrenotazioni", listaPrenotazioni);

    RequestDispatcher dispatcher = session.getServletContext().getRequestDispatcher("/home1.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
