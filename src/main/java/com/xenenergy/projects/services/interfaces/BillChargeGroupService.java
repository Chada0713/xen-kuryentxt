package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.BillChargeGroup;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xesi on 02/06/2017.
 */
@Transactional
public interface BillChargeGroupService extends CRUDService<BillChargeGroup>{
    List<BillChargeGroup> findByBillNo(String billno);
}
