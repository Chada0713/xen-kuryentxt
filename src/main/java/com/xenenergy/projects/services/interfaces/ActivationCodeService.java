package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.ActivationCode;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface ActivationCodeService extends CRUDService<ActivationCode>{
    ActivationCode findActivationCode(String activationCode);
}
