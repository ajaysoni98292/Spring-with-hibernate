package com.spring.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 *
 * @author ajay
 */

@EnableWebMvc
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	/**Overrided to access resources such as css , js, images from resources folder otherwise won't be able to access these resources */	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	  /**
	   * Setup a simple strategy: use all the defaults and return json by default when not sure. 
	   * This is implemented because of extension like *.htm, Spring will use a org.springframework.web.accept.ServletPathExtensionContentNegotiationStrategy 
	   * and resolve that the acceptable media type to return is text/html which does not match what MappingJacksonHttpMessageConverter produces, 
	   * ie. application/json and therefore a 406 is returned.
	   * If we don't use .htm extension then it is not required.
	  */
	@Override
	  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	    configurer.favorPathExtension(false).
	            favorParameter(true).
	            parameterName("mediaType").
	            ignoreAcceptHeader(true).
	            useJaf(false).
	            defaultContentType(MediaType.APPLICATION_JSON).
	            mediaType("xml", MediaType.APPLICATION_XML).
	            mediaType("json", MediaType.APPLICATION_JSON);
	  }
	
	
	@Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
        String[] resources= {"classpath:validationMessages","classpath:messages"};
        messageSource.setBasenames(resources);
        messageSource.setCacheSeconds(1);
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }
	
	@Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
	    LocalValidatorFactoryBean resource = new LocalValidatorFactoryBean();
	    resource.setValidationMessageSource(messageSource());
	    return resource;
	}
	
	@Override
	public Validator getValidator(){
	    return validator();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);
	}
	
	/**
	 * To save the locale in a cookie on the browser, and not in the session.
	 * @return
	 */
	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setCookieName("locale");
		return localeResolver;
	}
}