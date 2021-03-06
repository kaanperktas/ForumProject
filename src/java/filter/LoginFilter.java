package filter;
import entity.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/*") 
public class LoginFilter implements Filter{

   
    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {

//        
        HttpServletRequest request =(HttpServletRequest) sr;
        HttpServletResponse response =(HttpServletResponse) sr1;
        
        String url = request.getRequestURI();
        HttpSession session = request.getSession();
        
        User user = null;
        
        if (session!=null) {
            user=(User)session.getAttribute("user");
        }
        
        if (user==null && url.contains("panel")) {
            response.sendRedirect(request.getContextPath()+"/index.xhtml");
        }
        else{
            fc.doFilter(sr, sr1);
        }
    }
}