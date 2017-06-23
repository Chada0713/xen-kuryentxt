package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.PerKwChargeTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 23/06/2017.
 */
@Transactional
public interface PerKwChargeTemplateService extends CRUDService<PerKwChargeTemplate> {
    Integer findTopByPrintOrderOrderByPrintOrderDesc();
}
