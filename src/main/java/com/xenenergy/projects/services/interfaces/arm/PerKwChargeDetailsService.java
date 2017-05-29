package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.PerKwChargeDetail;
import com.xenenergy.projects.services.interfaces.CRUDService;

import java.util.List;

/**
 * Created by xesi on 29/05/2017.
 */
public interface PerKwChargeDetailsService extends CRUDService<PerKwChargeDetail> {
    void callCopyToTemplate(long id);
    List<PerKwChargeDetail> findAllPageable(long id);
    int getMaxPrintOrder(long id);
    double findSumOfTotalAmount(long id);
}
