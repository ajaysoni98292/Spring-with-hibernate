package com.spring.example.config;

import static com.spring.example.utils.Constant.BASE_PACKAGE;
import static com.spring.example.utils.Constant.VIEW_PREFIX;
import static com.spring.example.utils.Constant.VIEW_SUFFIX;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 *
 * @author ajay
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = BASE_PACKAGE)
public class AppConfig {

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix(VIEW_PREFIX);
		resolver.setSuffix(VIEW_SUFFIX);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Bean
    public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	//Uncomment if Aspectj is needed in application
	/*@Bean // the Aspect itself must also be a Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }*/
}