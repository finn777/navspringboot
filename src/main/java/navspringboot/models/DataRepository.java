package navspringboot.models;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface DataRepository extends Repository<Data, Long> {

    List<Data> findByObjecttypeAndRangefromLessThanEqualAndRangetoGreaterThanEqual(String objecttype, long objectid, long objectid2);
}

