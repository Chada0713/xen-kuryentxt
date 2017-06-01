package com.xenenergy.projects.services;

import com.xenenergy.projects.dao.dependence.RdmDao;
import com.xenenergy.projects.entities.Rdm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RdmService {

    @Autowired
    private RdmDao rdmDao;

    public Collection<Rdm> getAll() {
        List<Rdm> rmdEntities = new ArrayList<>();
        rdmDao.findAll().forEach(rmdEntities::add);
        return rmdEntities;
    }

    public boolean deleteById(long id) {
        rdmDao.delete(id);
        return true;
    }

    public Rdm insert(Rdm rdm) {
        return rdmDao.save(rdm);
    }

    public Rdm getById(long id) {
        return rdmDao.findOne(id);
    }

    public Rdm update(Rdm rdm) {
        return rdmDao.save(rdm);
    }

}
