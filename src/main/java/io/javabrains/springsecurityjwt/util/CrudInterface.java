package io.javabrains.springsecurityjwt.util;

import java.util.List;

public interface CrudInterface <T>{

    T save(T t);
    T get(Long id);
    Long count();
    void delete(Long id);
    List<T> getAll();
    List<T> getAll(int page, int size);
    void saveAll(List<T> list);


}
