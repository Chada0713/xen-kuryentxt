package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.AddOnChargeSpecial;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xesi on 27/07/2017.
 */
@Repository
public interface AddOnChargeSpecialDao extends PagingAndSortingRepository<AddOnChargeSpecial, Long> {
}
