package navspringboot.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface DataCrud extends CrudRepository<Data, Long> {

} // class DataCrud
