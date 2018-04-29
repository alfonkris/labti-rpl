package tokoalattulis.app;


import tokoalattulis.model.AlatTulis;
import tokoalattulis.service.AlatTulisService;
import tokoalattulis.view.AlatTulisView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gde14002
 */
public class App {
    
    private static ApplicationContext applicationContext;
    
    public static void main(String[] args){
        applicationContext = new ClassPathXmlApplicationContext("spring-configuration.xml");
        new AlatTulisView().setVisible(true);
    }
    
    public static AlatTulisService getAlatTulisService(){
        return (AlatTulisService) applicationContext.getBean("AlatTulisService");
    }
    
}
