package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.Rdm;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface RouteDefinitionService extends CRUDService<Rdm> {
    Page<Rdm> findAllByOrderByIdDesc(Pageable pageable);

    @Query("select a from Rdm a where a.rdmName like %?1% or a.id like %?1%")
    Page<Rdm> findByRdmNameAndIdContaining(String value);
}
