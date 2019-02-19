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
import java.util.List;

@WebServlet("/addPrenotazione")
public class AddPrenotazione extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String data = req.getParameter("data");
    String ora = req.getParameter("ora");
    String quant = req.getParameter("quantita");
    double quantita = 0;
    if (!quant.equals("") && quant != null) {
      quantita = Double.parseDouble(quant);
    }
    HttpSession session = req.getSession();
    RequestDispatcher dispatcher = session.getServletContext().getRequestDispatcher("/prenotati.jsp");
    List<Prenotazione> list = (List<Prenotazione>) session.getAttribute("listaPrenotazioni");

    /*controllo se è già presente nell'array*/
    for(Prenotazione p : list) {
      if (p.getData().equals(data) && p.getOra().equals(ora)) {
        req.removeAttribute("presente");
        req.setAttribute("presente" ,1);
        dispatcher.forward(req, resp);
      }
    }
    req.removeAttribute("presente");
    req.setAttribute("presente", 0);

    if (quantita <= 0) {
      req.removeAttribute("kgnull");
      req.setAttribute("kgnull" ,1);
    } else {
      req.removeAttribute("kgnull");
      req.setAttribute("kgnull" ,0);

      /* per l'aggiunta dell'id prendo quello dell'ultimo elemento della lista e aggiungo 1*/
      list.add(new Prenotazione(list.get(list.size() - 1).getId() + 1, data, ora, quantita));
    }

    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
