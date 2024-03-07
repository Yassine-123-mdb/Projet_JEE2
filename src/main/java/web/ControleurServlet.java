package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

import dao.IPhoneDao;

import dao.SmartPhoneDaoImpl;
import metier.entities.Smartphone;;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
	IPhoneDao metier;

	@Override
	public void init() throws ServletException {
		metier = new SmartPhoneDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			PhoneModele model = new PhoneModele();
			model.setMotCle(motCle);
			List<Smartphone> prods = metier.PhonesParMC(motCle);
			model.setProduits(prods);
			request.setAttribute("model", model);
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		} else if (path.equals("/saisie.do")) {
			request.getRequestDispatcher("saisieProduit.jsp").forward(request, response);
		} else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
			String marque = request.getParameter("marque");
			String couleur = request.getParameter("couleur");
			String ram = request.getParameter("ram");
			String stockage = request.getParameter("stockage");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Smartphone p = metier.save(new Smartphone(marque, couleur, prix, ram, stockage));
			request.setAttribute("produit", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		} else if (path.equals("/supprimer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deletePhone(id);
			response.sendRedirect("chercher.do?motCle=");
		} else if (path.equals("/editer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Smartphone p = metier.getPhone(id);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("editerProduit.jsp").forward(request, response);
		} else if (path.equals("/update.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String marque = request.getParameter("marque");
			String couleur = request.getParameter("couleur");
			String ram = request.getParameter("ram");
			String stockage = request.getParameter("stockage");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Smartphone p = new Smartphone();
			p.setId(id);
			p.setMarque(marque);
			p.setCouleur(couleur);
			p.setRam(ram);
			p.setStockage(stockage);
			p.setPrix(prix);
			metier.updatePhone(p);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
