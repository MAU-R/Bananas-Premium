package bananas.premium.web.interceptors;

import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.Interceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class interceptorConfig implements WebMvcConfigurer{
    
    private HandlerInterceptor helados= new heladoInterceptor();
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        List<String> patterns = new ArrayList<>();
        patterns.add("/inicio/shop");
        patterns.add("/inicio/carrito");
        registro.addInterceptor(helados).addPathPatterns(patterns);
    }
}
