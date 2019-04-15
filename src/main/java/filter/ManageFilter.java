package filter;

//import entity.User;

import entity.Account;
import entity.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebFilter("/manage")
public class ManageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpServletRequest.getSession();
        Account account = (Account) httpSession.getAttribute("account");
        if (account == null) account = new Account();
        List<String> roles = new ArrayList<>();
        account.getRoles().forEach(r -> roles.add(r.getName()));
        String role = "";
        for (String r:
             roles) {
            if (r.equals("admin")) {
                role = r;
            }
        }
        if (!role.equals("admin")) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/unauthorized");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
