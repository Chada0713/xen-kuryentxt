package com.xenenergy.projects.services;

import com.xenenergy.projects.dao.dependence.ReadersDao;
import com.xenenergy.projects.entities.MeterReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ReadersService {
    
    @Autowired
    private ReadersDao readersDao;

    public Collection<MeterReader> getAll() {
        List<MeterReader> readersEntities = new ArrayList<>();
        readersDao.findAll().forEach(readersEntities::add);
        return readersEntities;
    }

    public boolean deleteById(long id) {
        readersDao.delete(id);
        return true;
    }

    public MeterReader insert(MeterReader reader) {
        return readersDao.save(reader);
    }

    public MeterReader getById(long id) {
        return readersDao.findOne(id);
    }

    public MeterReader update(MeterReader reader) {
        return readersDao.save(reader);
    }
}
