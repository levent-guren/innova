package tr.com.innova.filter;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginFilter extends OncePerRequestFilter {
	private final List<String> permittedUrls = List.of("/");
	private final List<String> permittedUrlBegins = List.of("/css/");

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		boolean permit = false;
		String url = request.getServletPath();
		if (permittedUrls.contains(url)) {
			permit = true;
		} else {
			for (String u : permittedUrlBegins) {
				if (url.startsWith(u)) {
					permit = true;
				}
			}
		}
		if (permit) {
			filterChain.doFilter(request, response);
		} else {
			if (request.getSession().getAttribute("loginUsername") != null) {
				// logged in. Permit
				filterChain.doFilter(request, response);
			} else {
				// Not logged in. Denied
				request.setAttribute("message", "Please log in first");
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			}
		}
	}

}
