package com.ctl.dccf.reconciler.controller;

import com.ctl.dccf.reconciler.core.user.Test;
import com.ctl.dccf.reconciler.service.TestService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

/**
 * Created by Pramod on 1/8/2018.
 */
@RestController
@Api(value="reconciler-api", description="Reconciler", tags = "Reconciler")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    private TestService testService;

    Gson gson = new Gson();

    @Autowired
    public TestController(final TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ApiOperation(hidden=false, value = "Test GET Servers",
            response = Test.class,
            httpMethod = "GET",
            responseContainer = "List")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Processed Successfully"),
            @ApiResponse(code = 500, message = "Internal Error")
    })
    @ResponseBody
    public Test getServer(@RequestParam(value = "id") final String id){
        LOGGER.debug("===BEGIN=== getTest GET /test/, params<> id:{}", id);

        Test test = testService.findById(id);

        LOGGER.debug("===END=== getServer [GET /test/], result:{}", test);
        return test;
    }
}
