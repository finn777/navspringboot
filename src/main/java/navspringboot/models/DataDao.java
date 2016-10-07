package navspringboot.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface DataDao extends CrudRepository<Data, Long> {
    public Data findBydataid(long dataid);

} // class DataDao
