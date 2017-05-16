package com.xenenergy.projects.services;

import com.xenenergy.projects.dao.dependence.ReadersDao;
import com.xenenergy.projects.entities.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ReadersService {
    
    @Autowired
    private ReadersDao readersDao;

    public Collection<Reader> getAll() {
        List<Reader> readersEntities = new ArrayList<>();
        readersDao.findAll().forEach(readersEntities::add);
        return readersEntities;
    }

    public boolean deleteById(long id) {
        readersDao.delete(id);
        return true;
    }

    public Reader insert(Reader reader) {
        return readersDao.save(reader);
    }

    public Reader getById(long id) {
        return readersDao.findOne(id);
    }

    public Reader update(Reader reader) {
        return readersDao.save(reader);
    }
}
