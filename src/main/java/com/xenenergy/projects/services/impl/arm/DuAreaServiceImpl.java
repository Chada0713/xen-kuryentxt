package com.xenenergy.projects.services.impl.arm;

import com.xenenergy.projects.dao.arm.AreaDao;
import com.xenenergy.projects.entities.arm.DuArea;
import com.xenenergy.projects.services.interfaces.arm.DuAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class DuAreaServiceImpl implements DuAreaService {

    @Autowired
    private AreaDao areaDao;


    @Override
    public Page<DuArea> findAllPageable(Pageable pageable) {
        return areaDao.findAllByOrderByAreaName(pageable);
    }

    @Override
    public DuArea getById(long id) {
        return areaDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        areaDao.delete(id);
        return true;
    }

    @Override
    public DuArea insert(DuArea area) {
        return areaDao.save(area);
    }

    @Override
    public DuArea update(DuArea area) {
        return areaDao.save(area);
    }

    @Override
    public Collection<DuArea> getAll() {
        return areaDao.findAllByOrderByAreaName();
    }


}
