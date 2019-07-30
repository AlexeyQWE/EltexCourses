package eltex.tasks;

import org.springframework.data.mongodb.repository.MongoRepository;

interface CallRepository extends MongoRepository <Call, Integer> {}

