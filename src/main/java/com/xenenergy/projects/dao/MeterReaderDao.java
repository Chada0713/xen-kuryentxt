package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.Reader;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterReaderDao extends PagingAndSortingRepository<Reader, Long> {
    /* Uncomment this if you want to display the record in desc order*/
    // Page<Reader> findAllByOrderByIdDesc(Pageable pageable);
}
