package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends PagingAndSortingRepository<Account, Long> {
}
