package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.Rdm;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface RouteDefinitionService extends CRUDService<Rdm> {
}
