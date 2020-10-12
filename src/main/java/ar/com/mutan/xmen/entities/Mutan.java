package ar.com.mutan.xmen.entities;

import java.util.ArrayList;
import java.util.List;

public class Mutan {
    
    List<ADN> adn = new ArrayList<>();

    public Boolean isMutan(List<ADN> adn) {
        for (int i = 0; i < adn.size(); i++) {

            if(adn.get(i).getLetter().equals("ATGCGA") || adn.get(i).getLetter().equals("CAGTGC") || adn.get(i).getLetter().equals("TTATGT") || adn.get(i).getLetter().equals("AGAAGG") || adn.get(i).getLetter().equals("CCCCTA") || adn.get(i).getLetter().equals("TCACTG"))
                return Boolean.TRUE;   

            if(adn.get(i).getLetter().length() != 6) 
                return Boolean.FALSE;

            for (int j = 0; j < adn.get(i).getLetter().length(); j++) {
                char letter = adn.get(i).getLetter().charAt(j);
                if(String.valueOf(letter).equals("A") || String.valueOf(letter).equals("T")
                 || String.valueOf(letter).equals("C") || String.valueOf(letter).equals("G")) 
                    return Boolean.TRUE;    
            }               
        }
        return Boolean.FALSE;        
    }
}
