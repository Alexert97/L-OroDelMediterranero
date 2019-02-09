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


@WebServlet("/removePrenotazione")
public class RemovePrenotazione extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));

    HttpSession session = req.getSession();
    List<Prenotazione> list = (List<Prenotazione>) session.getAttribute("listaPrenotazioni");
    for (Prenotazione p : list) {
      if (p.getId() ==  id) {
        list.remove(p);
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
