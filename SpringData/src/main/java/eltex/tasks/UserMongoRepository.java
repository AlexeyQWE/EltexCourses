package eltex.tasks;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

interface UserMongoRepository extends MongoRepository <UserMongo, Integer> {
    List <UserMongo> findByFio(String fio);
}

