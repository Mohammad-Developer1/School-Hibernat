package ir.schoolsystem.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    void save(T t);

    void delete(Long id);

    void update(T t);

    Optional<T> findById(Long id);

    Optional<List<T>> findAll();
}
