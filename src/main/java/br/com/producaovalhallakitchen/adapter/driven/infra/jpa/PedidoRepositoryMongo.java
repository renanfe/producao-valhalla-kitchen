package br.com.producaovalhallakitchen.adapter.driven.infra.jpa;

import br.com.producaovalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.producaovalhallakitchen.core.domain.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PedidoRepositoryMongo extends MongoRepository<PedidoEntity, String> {

    List<PedidoEntity> findByStatusIn(List<Status> status);

}
