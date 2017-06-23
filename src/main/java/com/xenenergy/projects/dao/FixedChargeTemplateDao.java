package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.FixedChargeTemplate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by xesi on 23/06/2017.
 */
public interface FixedChargeTemplateDao extends PagingAndSortingRepository<FixedChargeTemplate, Long> {

    @Query("select max(printOrder) from FixedChargeTemplate")
    Integer findTopByPrintOrderOrderByPrintOrderDesc();
}
