package ar.com.mutan.xmen.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.mutan.xmen.entities.ADN;
import ar.com.mutan.xmen.modals.MutantRequest;

@Service
public class MutanService {
    
    public Boolean isMutan(MutantRequest mutantADN) {
        List<ADN> adn = mutantADN.dna;

        for (int i = 0; i < adn.size(); i++) {

            if(adn.get(i).secuencyLetter.equals("ATGCGA") || adn.get(i).secuencyLetter.equals("CAGTGC") || adn.get(i).secuencyLetter.equals("TTATGT") || adn.get(i).secuencyLetter.equals("AGAAGG") || adn.get(i).secuencyLetter.equals("CCCCTA") || adn.get(i).secuencyLetter.equals("TCACTG"))
                return Boolean.TRUE;   

            if(adn.get(i).secuencyLetter.length() != 6) 
                return Boolean.FALSE;

            for (int j = 0; j < adn.get(i).secuencyLetter.length(); j++) {
                char letter = adn.get(i).secuencyLetter.charAt(j);
                if(String.valueOf(letter).equals("A") || String.valueOf(letter).equals("T")
                 || String.valueOf(letter).equals("C") || String.valueOf(letter).equals("G")) 
                    return Boolean.TRUE;    
            }               
        }
        return Boolean.FALSE;        
    }
}
