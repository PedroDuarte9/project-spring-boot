package med.voll.api.medico;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Para utilizar a integração com o banco de dado utilizamos uma interface chamada JPARepository<T,K> Onde T é o Tipo de Entidade que queremos usar e o
 * K É o tipo do atributo da chave primária dessa entidade
 */
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
