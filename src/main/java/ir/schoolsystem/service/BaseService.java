package ir.schoolsystem.service;

public interface BaseService<T> {
    void save(T t);

    void delete(Long id);

    void update(T t);


    void printAll();
}
