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

@WebServlet("/upddateOlio")
public class UpdateOlioQuantity extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int numeroBottiglie = Integer.parseInt(req.getParameter("numeroBottiglie"));
    int id = Integer.parseInt(req.getParameter("id"));

    HttpSession session = req.getSession();
    List<Olio> list = (List<Olio>) session.getAttribute("listaOlio");
    for (Olio o : list) {
      if (o.getId() == id) {
        int i = list.indexOf(o);
        /* se il numero di bottiglie è negativo(cioè le tolgo)
        * controllo se ne sono state tolte più di quelle presenti
        * e segnalo il problema
        */
        if (o.getNumeroBottiglie() < (-numeroBottiglie)) {
          req.setAttribute("QuantityException", 1);
          o.setNumeroBottiglie(0);
        } else {
          /* altrimenti le aggiungo (o sottraggo) dal totale */
          o.setNumeroBottiglie(o.getNumeroBottiglie() + numeroBottiglie);
        }
        list.set(i, o);
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
