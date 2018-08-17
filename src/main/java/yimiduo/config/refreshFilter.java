package yimiduo.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName="refreshFilter",urlPatterns = "/*")
public class refreshFilter implements Filter {

    private final String hostIP = "120.26.103.7";
    private final String uri = "/bus/refresh";


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestIP=request.getRemoteHost();
        String requestURI=request.getRequestURI();
        if(requestURI.equals(uri)){

           if(requestIP.equals(hostIP)){

               filterChain.doFilter(servletRequest, servletResponse);
           }
           else{

            System.out.println("非法请求");
           }
        }
        else{

            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
    @Override
    public void destroy() {

    }
}


