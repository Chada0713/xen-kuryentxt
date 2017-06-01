package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.ActivationCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationCodeDao extends PagingAndSortingRepository<ActivationCode, Long> {
   /*Uncomment this if you want to display a record in desc order*/
    Page<ActivationCode> findAllByOrderByIdDesc(Pageable pageable);
    ActivationCode findByActivationCode(String activationCode);
}
