package ar.com.mutan.xmen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mutan.xmen.modals.GenericResponse;
import ar.com.mutan.xmen.modals.MutantRequest;
import ar.com.mutan.xmen.services.MutanService;

@RestController
public class MutanController {
    
    @Autowired
    MutanService mutanService;

    @PostMapping("/mutant")
    public ResponseEntity<GenericResponse> createLoan(@RequestBody MutantRequest mutantADN) {

        Boolean isMutant = mutanService.isMutan(mutantADN);
        
        if(isMutant == false) {
            GenericResponse gR = new GenericResponse(403, false, "The human isnt a mutant");
            return new ResponseEntity<>(gR , HttpStatus.FORBIDDEN);
        }
        GenericResponse gR = new GenericResponse(200, true, "The human is a mutant");                
        return new ResponseEntity<>(gR , HttpStatus.OK);
    }
}
