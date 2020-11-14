package org.eclipse.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.Utilisateur;

@WebFilter("/production")
public class ProductionFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		if (utilisateur == null) {
			res.sendRedirect("connexion");
		} else if (utilisateur.getType().equals("producteur")) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect("consommation");
		}
	}

}
