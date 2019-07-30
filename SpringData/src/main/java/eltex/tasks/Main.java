package eltex.tasks;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
public class Main {

    private User user1;
    private User user2;
    private Date date;

    public static void main(String[] args) {

        SpringApplication.run(Main.class);
    }
    @Bean
    public CommandLineRunner demo(UserRepository CrudRepository) {
        return (args) -> {
            user1 = new User(1, "Ivan", "900");
            user2 = new User(2, "Boris", "800");
            CrudRepository.save(user1);
            CrudRepository.save(user2);
            for (User user : CrudRepository.findAll())
                System.out.println(user.getFio());
        };
    }
    @Bean
    public CommandLineRunner demo1(CallRepository MongoRepository) {
        Date date = new Date();
        return (args) -> {
            MongoRepository.save(new Call(1,  user1.getId(), user2.getId(),date.toString()));
            MongoRepository.save(new Call(2,user2.getId(), user1.getId(), date.toString()));
            for (Call call : MongoRepository.findAll())
                System.out.println(call.getId());
        };
    }
}
