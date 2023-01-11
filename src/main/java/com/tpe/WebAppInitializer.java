package com.tpe;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml yerine bu sinifi kullanacagiz
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //DB ve Hibernate ayarlarim icin kullancagim
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootContextConfig.class
        };
    }

    //MCV config ayarlari
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebMvcConfig.class
        };
    }


    //Hangi URL hangi Servlet ile iliskilendirilecek
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};//gelen butun requestleri bu servlet tarafindan karsilansin.
    }
}
