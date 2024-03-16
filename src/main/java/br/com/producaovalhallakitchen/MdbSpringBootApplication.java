package br.com.producaovalhallakitchen;

import br.com.producaovalhallakitchen.adapter.driven.infra.jpa.PedidoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication {

    @Autowired
    PedidoRepositoryJpa pedidoRepositoryJpa;

    public static void main(String[] args) {
        SpringApplication.run(MdbSpringBootApplication.class, args);
    }
}
