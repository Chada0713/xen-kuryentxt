package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.ChargeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface ChargeTypeService extends CRUDService<ChargeType> {
    Page<ChargeType> findAllPageable(long idRateMaster, Pageable pageable);
    List<ChargeType> getChargeTypeById(long id);
}
