package ar.com.mutan.xmen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.com.mutan.xmen.entities.Mutant;
import ar.com.mutan.xmen.services.MutantService;

@Controller
public class MutantMVController {

    @Autowired
    MutantService mutantService;
    
    @GetMapping("/mutant/firstMutant")
    public String firstMutant(Model model){
        Mutant m = mutantService.firstMutant();

        String view = "firstMutant";
        if (m == null){
            view = "noMutants";
        }
        else {
            model.addAttribute("mutantName", m.getName());

            model.addAttribute("mutantUniqueHash", m.getUniqueHash());

            model.addAttribute("mutant", m);
        }

        return view;
        
    }
}
