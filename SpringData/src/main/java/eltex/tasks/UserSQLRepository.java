package eltex.tasks;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

interface UserSQLRepository extends CrudRepository <UserSQL, Integer> {
    List<UserSQL> findByFio(String fio);
}