package eltex.tasks;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository <User, Integer> {}