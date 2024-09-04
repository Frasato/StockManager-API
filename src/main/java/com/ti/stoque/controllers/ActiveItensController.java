package com.ti.stoque.controllers;

import com.ti.stoque.models.ActiveItensModel;
import com.ti.stoque.models.FinishItensModel;
import com.ti.stoque.services.ActiveItensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/itens")
public class ActiveItensController {

    @Autowired
    private ActiveItensService activeItensService;

    @GetMapping(value = "/all")
    public List<ActiveItensModel> showAllItens(){
        return activeItensService.findAllItens();
    }

    @GetMapping(value = "/find/{seacrhItens}")
    public List<ActiveItensModel> searchingItensFromTable(@PathVariable(name = "seacrhItens") String seacrhItens){
        return activeItensService.findBySearchInput(seacrhItens);
    }

    @PostMapping(value = "/create")
    public ActiveItensModel createItem(@RequestBody ActiveItensModel activeItensModel){
        return activeItensService.createItensOnDB(activeItensModel);
    }

    @PutMapping(value = "/update/{id}")
    public ActiveItensModel updateItem(@PathVariable(name = "id") UUID id, @RequestBody ActiveItensModel activeItensModel){
        return activeItensService.updateItensOnDB(activeItensModel, id);
    }

    @PutMapping(value = "/takeout/{id}")
    public ActiveItensModel takeOutItem(@PathVariable(name = "id") UUID id, @RequestBody ActiveItensModel activeItensModel, @RequestBody int removedAmount, @RequestBody String city, @RequestBody String sector){
        return activeItensService.updateItensOnDBOutTB(activeItensModel, id, removedAmount, city, sector);
    }

}
