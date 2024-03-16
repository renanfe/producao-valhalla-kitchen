package br.com.producaovalhallakitchen.adapter.driven.infra.jpa;

import br.com.producaovalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PedidoRepositoryJpa extends MongoRepository<PedidoEntity, String> {

    List<PedidoEntity> findByStatusIn(List<String> status);

}
