package sellFan.filter;

import sellFan.dao.iterface.ICartDAO;
import sellFan.dao.iterface.IUserDAO;
import sellFan.dto.User;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class UserCurrentFilter implements Filter {
    @Inject
    ICartDAO _cartDAO;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        chain.doFilter(request, response);
        HttpServletRequest req = ((HttpServletRequest) request);
        HttpSession session = req.getSession();
        if(session.getAttribute("usercurrent") != null){
            User u = (User) session.getAttribute("usercurrent");
            int cartCount = _cartDAO.count(u.getId());

            req.setAttribute("nameUserCurrent", u.getFullName());
            req.setAttribute("cartCount", cartCount);
            req.setAttribute("avatarUserCurrent", u.getPublic_url());
        }

    }

    @Override
    public void destroy() {

    }
}
