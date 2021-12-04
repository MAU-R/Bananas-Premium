package bananas.premium.web.interceptors;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import bananas.premium.web.modelos.Helado;

public class heladoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
                if(request.getMethod().equalsIgnoreCase("post")){
                    return true;
                }
                if(handler instanceof HandlerMethod){
                    HandlerMethod metodo = (HandlerMethod) handler;
                }
                if(request.getAttribute("helados")==null)
                request.setAttribute("helados",new ArrayList<Helado>());
		return true;
	}
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {

    }
}
