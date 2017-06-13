package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.MeterReader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface MeterReaderService extends CRUDService<MeterReader> {
    List<MeterReader> findAll();
}
