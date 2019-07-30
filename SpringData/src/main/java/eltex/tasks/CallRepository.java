package eltex.tasks;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

interface CallRepository extends MongoRepository <Call, Integer> {}

