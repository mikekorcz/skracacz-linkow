package pl.mkorcz.linkshortener.link;

import org.apache.commons.lang3.NotImplementedException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class LinkInMemoryRepository implements LinkServiceRepository {

    final Map<String, LinkEntity> entityMap;

    LinkInMemoryRepository() {
        entityMap = new HashMap<>();
    }

    @Override
    public <S extends LinkEntity> S save(final S entity) {
        return (S) entityMap.put(entity.getId(), entity);
    }

    @Override
    public <S extends LinkEntity> Iterable<S> saveAll(final Iterable<S> entities) {
        throw new NotImplementedException();
    }

    @Override
    public Optional<LinkEntity> findById(final String s) {
        return Optional.ofNullable(entityMap.get(s));
    }

    @Override
    public boolean existsById(final String s) {
        throw new NotImplementedException();
    }

    @Override
    public Iterable<LinkEntity> findAll() {
        throw new NotImplementedException();
    }

    @Override
    public Iterable<LinkEntity> findAllById(final Iterable<String> strings) {
        throw new NotImplementedException();
    }

    @Override
    public long count() {
        throw new NotImplementedException();
    }

    @Override
    public void deleteById(final String s) {

    }

    @Override
    public void delete(final LinkEntity entity) {

    }

    @Override
    public void deleteAllById(final Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(final Iterable<? extends LinkEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
