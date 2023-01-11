package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc//MVC ile calisacagim diyorum
@ComponentScan("com.tpe")
public class WebMvcConfig implements WebMvcConfigurer {

    //viewResolver objesi objemi bean olarak ekliyorum
    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");//view classinin oldugu yer
        resolver.setSuffix(".jsp");//hangi uzantili dosylari dikkate almamizi soyluyor.
        return resolver;
    }

    //Kullanacagimiz kaynaklarin yerini gosteriyorum.(css,image vs.) bu web app resouce i
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(0);
    }
}
