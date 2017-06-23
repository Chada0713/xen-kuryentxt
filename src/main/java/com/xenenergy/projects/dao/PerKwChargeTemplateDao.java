package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.PerKwChargeTemplate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xesi on 23/06/2017.
 */
@Repository
public interface PerKwChargeTemplateDao extends PagingAndSortingRepository<PerKwChargeTemplate, Long>{
    @Query("select max(printOrder) from PerKwChargeTemplate")
    Integer findTopByPrintOrderOrderByPrintOrderDesc();
}
