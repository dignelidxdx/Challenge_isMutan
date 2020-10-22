package ar.com.mutan.xmen.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import ar.com.mutan.xmen.entities.Mutant;


public interface MutantRepository extends MongoRepository<Mutant, ObjectId> {
    Mutant findBy_id(ObjectId _id);

    Mutant findByUniqueHash(String hash);
}
