package eltex.tasks;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class);
    }
    @Bean
    public CommandLineRunner demo(UserSQLRepository CrudRepository) {
        return (args) -> {
            CrudRepository.save(new UserSQL("Ivan", "900"));
            CrudRepository.save(new UserSQL("Boris", "800"));
            for (UserSQL user : CrudRepository.findAll())
                System.out.println(user.getFio());
        };
    }
    @Bean
    public CommandLineRunner demo1(UserMongoRepository MongoRepository) {
        return (args) -> {
            MongoRepository.save(new UserMongo("Ivan", "900", 1));
            MongoRepository.save(new UserMongo("Boris", "800", 2));
            for (UserMongo user : MongoRepository.findAll())
                System.out.println(user.getFio());
        };
    }
}
