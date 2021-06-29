package com.example.RestApp.MindsApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;


@RestController
public class FilesController {
    private final BusinessClass businessClass;
    @Autowired
    public FilesController(BusinessClass businessClass){
        this.businessClass = businessClass;
    }

    @GetMapping("information/{id}")
    public List<String> getinfo(@PathVariable String id) throws FileNotFoundException {
    return businessClass.getinfo(id);
    }
}
