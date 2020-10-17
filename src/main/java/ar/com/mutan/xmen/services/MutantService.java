package ar.com.mutan.xmen.services;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ar.com.mutan.xmen.entities.ADNSample;
import ar.com.mutan.xmen.modals.MutantRequest;

@Service
public class MutantService {

    private Logger logger = LogManager.getLogger(MutantService.class);

    @Async("threadPoolExecutor")
    public CompletableFuture<String> isValid(ADNSample dna) {
        logger.info("Validando si es mutante" + dna.getDna()); //Tambien puede ir LoggerFactory

        int tiempo = ejecutarTiempoEjecucion();

        return CompletableFuture.completedFuture("Se calculo " + dna.getDna() + " durante " + tiempo / 1000 + " segundos");

    }

    public int ejecutarTiempoEjecucion() {
        int tiempo = new Random().nextInt(1000);
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            logger.error("Ha ocurrido un error ", ex);
        }

        return tiempo;
    }

    public boolean isMutant(String[] dna){
        
        return true;
    }
    
    public boolean isMutant(MutantRequest mutantADN) {
        List<String> adn = mutantADN.dna;

        for (int i = 0; i < adn.size(); i++) {

            for (int j = 0; j < adn.get(i).length(); j++) {
                char letter = adn.get(i).charAt(j);

                if((adn.get(i).equals("ATGCGA") || adn.get(i).equals("CAGTGC") || adn.get(i).equals("TTATGT") || adn.get(i).equals("AGAAGG") || adn.get(i).equals("CCCCTA") || adn.get(i).equals("TCACTG") || String.valueOf(letter).equals("A") || String.valueOf(letter).equals("T") || String.valueOf(letter).equals("C") || String.valueOf(letter).equals("G")) && (adn.get(i).length() == 6))
                    return true; 
                else if(adn.get(i).length() != 6) 
                    return false; 
                else return false;  
            }               
        }
        return false;        
    }

}
