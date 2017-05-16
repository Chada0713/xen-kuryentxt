package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.AccountDao;
import com.xenenergy.projects.entities.Account;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements CRUDService<Account> {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Page<Account> findAllPageable(Pageable pageable) {
        return accountDao.findAll(pageable);
    }

    @Override
    public Account getById(long id) {
        return accountDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        accountDao.delete(id);
        return true;
    }

    @Override
    public Account insert(Account account) {
        return accountDao.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountDao.save(account);
    }
}
