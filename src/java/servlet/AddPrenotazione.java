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

    HttpSession session = req.getSession();
    RequestDispatcher dispatcher = session.getServletContext().getRequestDispatcher("/home1.jsp");
    List<Prenotazione> list = (List<Prenotazione>) session.getAttribute("listaPrenotazioni");
    for(Prenotazione p : list) {
      if (p.getData().equals(data) && p.getOra().equals(ora)) {
        req.removeAttribute("presente");
        req.setAttribute("presente" ,1);
        dispatcher.forward(req, resp);
      }
    }
    req.removeAttribute("presente");
    req.setAttribute("presente", 0);

    list.add(new Prenotazione(data, ora));

    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
