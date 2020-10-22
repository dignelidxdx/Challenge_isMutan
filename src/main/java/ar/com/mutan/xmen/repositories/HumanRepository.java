package ar.com.mutan.xmen.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import ar.com.mutan.xmen.entities.Human;

public interface HumanRepository extends MongoRepository<Human, ObjectId> {
    Human findBy_id(ObjectId _id);

    Human findByUniqueHash(String hash);
}