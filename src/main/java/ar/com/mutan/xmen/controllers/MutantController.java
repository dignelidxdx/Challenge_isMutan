package ar.com.mutan.xmen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mutan.xmen.entities.Mutant;
import ar.com.mutan.xmen.models.request.SampleRequest;
import ar.com.mutan.xmen.models.response.GenericResponse;
import ar.com.mutan.xmen.models.response.StatsResponse;
import ar.com.mutan.xmen.services.MutantService;

@RestController
public class MutantController {

    @Autowired
    MutantService mutantService;

    @PostMapping("/mutant")
    public ResponseEntity<?> createMutant(@RequestBody SampleRequest req) {

        if (!this.mutantService.isValid(req.dna)) {
            GenericResponse gr = new GenericResponse(false, "Invaled format");
           
            return ResponseEntity.badRequest().body(gr);
        }

        if (this.mutantService.exists(req.dna)) {
            GenericResponse gr = new GenericResponse(false, "Already registered");            
            return ResponseEntity.badRequest().body(gr);
        }

        Mutant mutant = this.mutantService.registerSample(req.dna);

        if (mutant != null) {
            GenericResponse gr = new GenericResponse(true, "Hello mutant!");
            return ResponseEntity.ok(gr);
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<StatsResponse> getStats() {
        StatsResponse stats = new StatsResponse();
        stats.countHumanDNA = this.mutantService.countHumans();
        stats.countMutantDNA = this.mutantService.countMutants();
        stats.ratio = stats.countMutantDNA * 1.00d / stats.countHumanDNA * 1.00d;

        int ratio = (int)(stats.ratio * 100);
        stats.ratio = ratio * 1.0d / 100;

        return ResponseEntity.ok(stats);
    }

}