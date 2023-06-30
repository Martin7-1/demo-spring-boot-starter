package com.zyinnju.service.impl;

import com.zyinnju.service.DemoService;
import com.zyinnju.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

    private final DemoService demoService;

    @Autowired
    public SampleServiceImpl(DemoService demoService) {
        this.demoService = demoService;
    }

    @Override
    public String hello() {
        return demoService.hello();
    }
}
