package com.ti.stoque.controllers;

import com.ti.stoque.models.FinishItensModel;
import com.ti.stoque.services.FinishItensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finish")
@CrossOrigin(origins = "*")
public class FinishItensController {

    @Autowired
    private FinishItensService finishItensService;

    @GetMapping(value = "/all")
    public List<FinishItensModel> findAll(){
        return finishItensService.findAll();
    }

    @GetMapping(value = "/search")
    public List<FinishItensModel> findByQuery(@RequestBody String searchItem){
        return finishItensService.findByQuery(searchItem);
    }
}
