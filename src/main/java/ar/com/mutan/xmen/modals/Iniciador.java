package ar.com.mutan.xmen.modals;

import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ar.com.mutan.xmen.entities.ADNSample;
import ar.com.mutan.xmen.services.MutantService;

@Component
public class Iniciador implements CommandLineRunner {
    private Logger logger = LogManager.getLogger(Iniciador.class);

    @Autowired
    private MutantService mutantService;

    //Hardcodeado
    public String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"}; 

    @Override
    public void run(String... args) throws Exception {
        CompletableFuture<String> ejecucion1 = mutantService.isValid(new ADNSample(dna));
        //... Repetir para toda misma funcion diferentes casos

        CompletableFuture.allOf(ejecucion1);

        logger.info("Mostrando resultado");
        logger.info(ejecucion1.get());
        //... Repetir para todas las funciones

    }

    
}