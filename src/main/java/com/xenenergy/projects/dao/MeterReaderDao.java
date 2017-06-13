package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.MeterReader;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeterReaderDao extends PagingAndSortingRepository<MeterReader, Long> {
    /* Uncomment this if you want to display the record in desc order*/
    // Page<MeterReader> findAllByOrderByIdDesc(Pageable pageable);
    List<MeterReader> findAll();
}
