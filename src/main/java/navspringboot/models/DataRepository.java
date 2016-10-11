package navspringboot.models;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface DataRepository extends Repository<Data, Long> {

    List<Data> findByObjecttypeAndRangefrom(String objecttype, long rangefrom);
}

