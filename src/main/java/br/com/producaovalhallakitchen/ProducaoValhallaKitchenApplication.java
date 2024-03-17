package br.com.producaovalhallakitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ProducaoValhallaKitchenApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducaoValhallaKitchenApplication.class, args);
    }
}
