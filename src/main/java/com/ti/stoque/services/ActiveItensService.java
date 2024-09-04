package com.ti.stoque.services;

import com.ti.stoque.models.ActiveItensModel;
import com.ti.stoque.models.FinishItensModel;
import com.ti.stoque.repositories.ActiveitensRepository;
import com.ti.stoque.repositories.FinishItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ActiveItensService {

    @Autowired
    private ActiveitensRepository activeitensRepository;
    @Autowired
    private FinishItensRepository finishItensRepository;

    public List<ActiveItensModel> findAllItens(){
        return activeitensRepository.findAll();
    }

    public List<ActiveItensModel> findBySearchInput(long barCode, String item, String mark){
        return activeitensRepository.findByBarCodeItemNameMarkName(barCode, item, mark);
    }

    public ActiveItensModel createItensOnDB(ActiveItensModel activeItensModel){
        return activeitensRepository.save(activeItensModel);
    }

    public ActiveItensModel updateItensOnDBOutTB(FinishItensModel finishItensModel, ActiveItensModel activeItensModel, UUID id, int removedAmount, String sector, String city){
        var item = activeitensRepository.findById(id).orElseThrow(()-> new RuntimeException("Item not found on ID: " + id));

        if(item.getAmount() < removedAmount){
            throw new RuntimeException("Not enough items in stock to remove: Requested " + removedAmount);
        }

        finishItensModel.setId(UUID.randomUUID());
        finishItensModel.setBarCorde(item.getBarCorde());
        finishItensModel.setItemName(item.getItemName());
        finishItensModel.setMarkName(item.getMarkName());
        finishItensModel.setAmount(removedAmount);
        finishItensModel.setCityName(city);
        finishItensModel.setSectorName(sector);
        finishItensModel.setOutDate(LocalDateTime.now());

        finishItensRepository.save(finishItensModel);

        item.setBarCorde(activeItensModel.getBarCorde());
        item.setItemName(activeItensModel.getItemName());
        item.setMarkName(activeItensModel.getMarkName());
        item.setAmount(activeItensModel.getAmount());
        item.setCreatedDate(LocalDateTime.now());

        return activeitensRepository.save(item);
    }

    public ActiveItensModel updateItensOnDB(ActiveItensModel activeItensModel, UUID id){
        var item = activeitensRepository.findById(id).orElseThrow(()-> new RuntimeException("Item not find on ID: " + id));

        item.setBarCorde(activeItensModel.getBarCorde());
        item.setItemName(activeItensModel.getItemName());
        item.setMarkName(activeItensModel.getMarkName());
        item.setAmount(activeItensModel.getAmount());

        return activeitensRepository.save(item);
    }

}
