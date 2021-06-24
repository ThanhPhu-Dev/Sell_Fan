package sellFan.filter;

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
            req.setAttribute("nameUserCurrent", u.getFullName());
        }

    }

    @Override
    public void destroy() {

    }
}
