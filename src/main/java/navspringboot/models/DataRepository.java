package navspringboot.models;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface DataRepository extends Repository<Data, Long> {

    List<Data>
    findByObjecttypeAndRangefromLessThanEqualAndRangetoGreaterThanEqualOrderByModulenameAscProductlineAscVersionnameAscDataidAsc
            (String objecttype, Long objectid, Long objectid2);
    // Query creation from method names

} // class DataRepository

