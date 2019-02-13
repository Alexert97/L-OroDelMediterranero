package servlet;

import bean.Prenotazione;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ModificaPrenotazione extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    String data = req.getParameter("data");
    String ora = req.getParameter("ora");

    HttpSession session = req.getSession();
    List<Prenotazione> list = (List<Prenotazione>) session.getAttribute("listaPrenotazioni");
    for (Prenotazione p : list) {
      if (p.getId() == id) {
        int i = list.indexOf(p);
        p.setData(data);
        p.setOra(ora);
        list.set(i, p);
      }
    }
    session.removeAttribute("listaPrenotazioni");
    session.setAttribute("listaPrenotazioni", list);

    RequestDispatcher dispatcher = session.getServletContext().getRequestDispatcher("/home1.jsp");
    dispatcher.forward(req, resp);
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
