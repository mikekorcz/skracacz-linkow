package pl.mkorcz.linkshortener.link;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface LinkServiceRepository extends CrudRepository<LinkEntity, String> {
}
