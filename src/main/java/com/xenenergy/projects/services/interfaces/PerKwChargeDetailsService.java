package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.PerKwChargeDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xesi on 29/05/2017.
 */
@Transactional
public interface PerKwChargeDetailsService extends CRUDService<PerKwChargeDetail> {
    void callCopyToTemplate(long id);
    List<PerKwChargeDetail> findAllPageable(long id);
    int getMaxPrintOrder(long id);
    double findSumOfTotalAmount(long id);
    void deleteByIdMaster(long idMaster);
}
