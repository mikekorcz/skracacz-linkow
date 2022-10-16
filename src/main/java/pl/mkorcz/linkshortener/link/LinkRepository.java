package pl.mkorcz.linkshortener.link;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Primary
interface LinkRepository extends CrudRepository<LinkEntity, String> {
    @Query("SELECT e FROM LinkEntity e WHERE e.expirationDate < ?1")
    List<LinkEntity> findLinksBeforeDay(LocalDate currentDate);

    List<LinkEntity> findAllByVisitsGreaterThan(Integer visits);


}
