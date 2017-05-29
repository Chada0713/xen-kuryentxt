package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.SeniorCitizen;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xesi on 16/05/2017.
 */
@Repository
public interface SeniorCitizenDao extends PagingAndSortingRepository<SeniorCitizen, Long>{
    SeniorCitizen save(SeniorCitizen seniorCitizen);
}
