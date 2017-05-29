package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.MeterReader;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterReaderDao extends PagingAndSortingRepository<MeterReader, Long> {
    /* Uncomment this if you want to display the record in desc order*/
    // Page<MeterReader> findAllByOrderByIdDesc(Pageable pageable);
}
