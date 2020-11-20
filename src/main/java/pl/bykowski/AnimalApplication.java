package pl.bykowski;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class AnimalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalApplication.class, args);
    }

    @Autowired
    private AnimalRepo animalRepo;

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        animalRepo.save(new Animal("cat"));
        animalRepo.save(new Animal("dog"));
    }



}
