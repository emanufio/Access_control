package Second_site;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

//e' un annotazione che aggiunge le seguenti annotazioni
//@configuration->  tagga le classi come sorgenti di definizione di bean per il contesto 
//dell applicazione
//@enableautoconfiguration->   dice a spring boot di aggiungere beans basati sulle proprieta' del
//classpath e impostazioni varie
//@componentscan->   dice a spring di controllare altri componenti e impostazioni nel package 
//hello

//indica una classe di configurazione che dichiara uno o più metodi bean
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	//lancia l applicazione
        SpringApplication.run(Application.class, args);
    }

}