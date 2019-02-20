package servlet;

import bean.Prenotazione;

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

@WebServlet("/modificaPrenotazioni")
public class ModificaPrenotazione extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    String data = req.getParameter("data");
    String ora = req.getParameter("ora");
    String q = req.getParameter("quantita");
    int quantita = Integer.parseInt(q);

    HttpSession session = req.getSession();
    List<Prenotazione> list = (List<Prenotazione>) session.getAttribute("listaPrenotazioni");
    boolean pres = false;
    Prenotazione prenotazione = null;
    Iterator<Prenotazione> i = list.iterator();
    while (i.hasNext()) {
      Prenotazione p = i.next();
      if (p.getId() == id) {
        prenotazione = p;
      }
      if (p.getData().equals(data) && p.getOra().equals(ora)) {
        req.removeAttribute("presente");
        req.setAttribute("presente", 1);
        pres = true;
      }
    }
    if (!pres) {
        int index = list.indexOf(prenotazione);
        prenotazione.setData(data);
        prenotazione.setOra(ora);
        prenotazione.setQuantita(quantita);
        list.set(index, prenotazione);

    }
    session.removeAttribute("listaPrenotazioni");
    session.setAttribute("listaPrenotazioni", list);

    RequestDispatcher dispatcher = session.getServletContext().getRequestDispatcher("/gestionePrenotazioni.jsp");
    dispatcher.forward(req, resp);
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
