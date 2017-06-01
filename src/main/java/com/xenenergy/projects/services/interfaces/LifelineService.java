package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.LifeLine;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface LifelineService extends CRUDService<LifeLine> {
}
