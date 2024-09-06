package com.ti.stoque.controllers;

import com.ti.stoque.dtos.TakeOutItemDTO;
import com.ti.stoque.models.ActiveItensModel;
import com.ti.stoque.services.ActiveItensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/itens")
@CrossOrigin(origins = "*")
public class ActiveItensController {

    @Autowired
    private ActiveItensService activeItensService;

    @GetMapping(value = "/all")
    public List<ActiveItensModel> showAllItens(){
        return activeItensService.findAllItens();
    }

    @GetMapping(value = "/find/{seacrhItens}")
    public List<ActiveItensModel> searchingItensFromTable(@PathVariable String seacrhItens){
        return activeItensService.findBySearchInput(seacrhItens);
    }

    @PostMapping(value = "/create")
    public ActiveItensModel createItem(@RequestBody ActiveItensModel activeItensModel){
        if(activeItensModel.getBarCode() == null || activeItensModel.getBarCode().isEmpty()){
            throw new IllegalArgumentException("BarCode cannot be null or empty!");
        }
        return activeItensService.createItensOnDB(activeItensModel);
    }

    @PutMapping(value = "/update/{id}")
    public ActiveItensModel updateItem(@PathVariable(name = "id") UUID id, @RequestBody ActiveItensModel activeItensModel){
        return activeItensService.updateItensOnDB(activeItensModel, id);
    }

    @PutMapping(value = "/takeout")
    public ActiveItensModel takeOutItem(@RequestBody TakeOutItemDTO takeOutItemDTO){

        UUID id = takeOutItemDTO.getId();
        int removedAmount = takeOutItemDTO.getRemovedAmount();
        String city = takeOutItemDTO.getCity();
        String sector = takeOutItemDTO.getSector();

        return activeItensService.updateItensOnDBOutTB(id, removedAmount, city, sector);
    }

}
