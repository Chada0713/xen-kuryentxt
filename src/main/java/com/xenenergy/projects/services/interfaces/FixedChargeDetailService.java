package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.FixedChargeDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface FixedChargeDetailService extends CRUDService<FixedChargeDetail> {
    void callCopyToTemplate(long id);
    List<FixedChargeDetail> findAllByIdFixedChargeDetail(long idMaster);
    int findTopByPrintOrderOrderByPrintOrderDesc(long idMaster);
    double findSumOfAmount(long idMaster);
    void deleteByIdMaster(long idMaster);
}
