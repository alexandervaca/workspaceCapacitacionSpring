package ar.com.eduit.configuration;

import ar.com.eduit.beans.EstacionMetereologica;
import ar.com.eduit.beans.EstacionMetereologicaNorte;
import ar.com.eduit.beans.Termometro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Marcelo on 20/03/2015.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"ar.com.eduit"})
public class SpringConfiguration {

    @Bean(name = "norteTermometro")
    public EstacionMetereologica getNorteTermometro(){
        EstacionMetereologica estacionMetereologica = new EstacionMetereologicaNorte(new Termometro());
        return estacionMetereologica;
    }
}
