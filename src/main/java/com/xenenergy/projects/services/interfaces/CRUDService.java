package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.arm.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
public interface CRUDService<T> {
    Page<T> findAllPageable(Pageable pageable);

    T getById(long id);

    boolean deleteById(long id);

    T insert(T t);

    T update(T t);

}
