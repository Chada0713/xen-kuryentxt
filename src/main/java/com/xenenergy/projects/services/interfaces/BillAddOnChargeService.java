package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.BillAddOnCharge;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xesi on 13/06/2017.
 */
@Transactional
public interface BillAddOnChargeService extends CRUDService<BillAddOnCharge> {
    List<BillAddOnCharge> findByBillNo(String billNo);
}
