package com.ctl.dccf.reconciler.service;

import com.ctl.dccf.reconciler.core.user.Test;
import com.ctl.dccf.reconciler.respository.TestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pramod on 1/8/2018.
 */
@Service
public class TestService {
    private TestRepository testRepo;
    private static final Logger log = LoggerFactory.getLogger(TestService.class);

    @Autowired
    public TestService(TestRepository testRepo){
        this.testRepo = testRepo;
    }

    public Test findById(final String id){
        log.debug("Looking up test by id:{} ", id);
        Test test = testRepo.findById(id);
        log.debug("Found test :{} ", test);

        return test;
    }

}
