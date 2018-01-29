package com.eduit.spring.clase4.test;

import com.eduit.spring.clase4.conf.SpringConfig;
import com.eduit.spring.clase4.model.Articulo;
import com.eduit.spring.clase4.service.ArticuloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by Marcelo on 27/03/2015.
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ArticuloService articuloService = context.getBean(ArticuloService.class);

        List<Articulo> articulos = articuloService.findByNombre("wqqw");

        for(Articulo articulo : articulos){
            System.out.println(articulo);
        }



    }
}
