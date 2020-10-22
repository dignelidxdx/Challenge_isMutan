package ar.com.mutan.xmen.services;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ar.com.mutan.xmen.entities.DNASample;
import ar.com.mutan.xmen.entities.Human;
import ar.com.mutan.xmen.entities.Mutant;
import ar.com.mutan.xmen.repositories.HumanRepository;
import ar.com.mutan.xmen.repositories.MutantRepository;
import ar.com.mutan.xmen.utils.MatrixDNAIterator;

@Service
public class MutantService {

    @Autowired
    MutantRepository mutantRepo;
    @Autowired
    HumanRepository humanRepo;

    private Logger logger = LogManager.getLogger(MutantService.class);

    @Async("threadPoolExecutor")
    public CompletableFuture<String> isValid(DNASample dna) {
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

    
    public void create(Mutant mutant) {

        this.mutantRepo.save(mutant);
    }

    public void create(Human human) {

        this.humanRepo.save(human);
    }

    public boolean exists(String[] dna) {

        DNASample sample = new DNASample(dna);
        String uniqueHash = sample.uniqueHash();

        if (mutantRepo.findByUniqueHash(uniqueHash) != null)
            return true;

        if (humanRepo.findByUniqueHash(uniqueHash) != null)
            return true;

        return false;

    }

    public Mutant registerSample(String[] dna) {

        DNASample sample = new DNASample(dna);

        if (this.isMutant(dna)) {
            Mutant mutant = new Mutant();
            //Solo para mutantes lo encripto
            mutant.setDna(sample.encrypt());
            mutant.setUniqueHash(sample.uniqueHash());
            this.create(mutant);
            return mutant;
        } else {
            Human human = new Human();
            human.setDna(dna);
            human.setUniqueHash(sample.uniqueHash());
            this.create(human);
            return null;
        }
    }

    public boolean isValid(String[] dna) {

        DNASample sample = new DNASample(dna);
        return sample.isValid();
    }

    public boolean isMutant(String[] dna) {

        MatrixDNAIterator iterator = new MatrixDNAIterator();

        DNASample sample = new DNASample(dna);

        System.out.println(sample.toString());

        int matches = 0;
        int matchesByRows = 0;
        int matchesByColumns = 0;
        int matchesByDiagonals = 0;

        matchesByRows = iterator.matchesByRows(sample);
        System.out.println("Matcheos por Rows " + matchesByRows);
        matchesByColumns = iterator.matchesByColumns(sample);
        System.out.println("Matcheos por Columns " + matchesByColumns);
        matchesByDiagonals = iterator.matchesByDiagonals(sample);
        System.out.println("Matcheos por Diagonals " + matchesByDiagonals);

        matches = matchesByRows + matchesByColumns + matchesByDiagonals;

        return matches > 1;

    }

    public long countMutants() {

        return mutantRepo.count();

    }

    public long countHumans() {

        return humanRepo.count();

    }
}
