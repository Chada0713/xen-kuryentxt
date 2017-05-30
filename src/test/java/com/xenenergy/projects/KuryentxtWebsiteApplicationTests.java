package com.xenenergy.projects;

import com.xenenergy.projects.dao.arm.DuDao;
import com.xenenergy.projects.dao.cum.DistUtilDao;
import com.xenenergy.projects.dbconfig.DbConfigArm;
import com.xenenergy.projects.dbconfig.DbConfigCum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DbConfigArm.class, DbConfigCum.class })
@SpringBootTest
public class KuryentxtWebsiteApplicationTests {

	@Autowired
	private DistUtilDao distUtilDao;

	@Autowired
	private DuDao duDao;

	@Test
	public void contextLoads() {
	}

}
