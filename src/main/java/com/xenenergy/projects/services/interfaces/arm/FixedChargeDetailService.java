package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.FixedChargeDetail;
import com.xenenergy.projects.services.interfaces.CRUDService;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
public interface FixedChargeDetailService extends CRUDService<FixedChargeDetail> {
    void callCopyToTemplate(long id);
    List<FixedChargeDetail> findAllByIdFixedChargeDetail(long idMaster);
    int findTopByPrintOrderOrderByPrintOrderDesc(long idMaster);
    double findSumOfAmount(long idMaster);
}
