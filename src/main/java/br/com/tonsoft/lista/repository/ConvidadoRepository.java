package br.com.tonsoft.lista.repository;

import br.com.tonsoft.lista.model.Convidado;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {
    Convidado findById(long id);
}
