package com.xenenergy.projects.services.impl.arm;

import com.xenenergy.projects.dao.arm.AccountDao;
import com.xenenergy.projects.entities.arm.Account;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements CRUDService<Account> {


    @Autowired
    private AccountDao accountDao;

    public List<Account> getAllAccounts(){
        return accountDao.findAll();
    }

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

    public Account getByAccountNo(String oldAccountNo) {
        return accountDao.findByOldAccountNo(oldAccountNo);
    }

}