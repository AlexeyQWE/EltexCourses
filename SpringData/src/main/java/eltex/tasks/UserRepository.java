package eltex.tasks;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

interface UserRepository extends CrudRepository <User, Integer> {
}