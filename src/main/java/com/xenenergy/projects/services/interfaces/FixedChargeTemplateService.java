package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.FixedChargeTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 23/06/2017.
 */
@Transactional
public interface FixedChargeTemplateService extends CRUDService<FixedChargeTemplate>{
    Integer findTopByPrintOrderOrderByPrintOrderDesc();
}
