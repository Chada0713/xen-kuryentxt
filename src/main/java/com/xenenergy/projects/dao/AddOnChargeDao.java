package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.AddOnCharge;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xesi on 16/05/2017.
 */
@Repository
public interface AddOnChargeDao extends PagingAndSortingRepository<AddOnCharge, Long>{
}
