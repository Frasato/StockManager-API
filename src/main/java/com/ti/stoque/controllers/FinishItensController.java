package com.ti.stoque.controllers;

import com.ti.stoque.models.FinishItensModel;
import com.ti.stoque.services.FinishItensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finish")
public class FinishItensController {

    @Autowired
    private FinishItensService finishItensService;

    @GetMapping(value = "/all")
    public List<FinishItensModel> findAll(){
        return finishItensService.findAl();
    }
}
