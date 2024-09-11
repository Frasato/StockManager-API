package com.ti.stoque.services;

import com.ti.stoque.models.ActiveItensModel;
import com.ti.stoque.models.FinishItensModel;
import com.ti.stoque.repositories.ActiveitensRepository;
import com.ti.stoque.repositories.FinishItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<ActiveItensModel> findBySearchInput(String seacrhItens){
        return activeitensRepository.findByBarCodeItemNameMarkName(seacrhItens);
    }

    public ActiveItensModel createItensOnDB(ActiveItensModel activeItensModel){
        var item = new ActiveItensModel();

        String barCode = activeItensModel.getBarCode();
        if(barCode.length() < 13){
            barCode = String.format("%013d");
        }

        if(barCode.length() > 13){
            throw new RuntimeException("Bar code must have exactly 13 digits, but yours has: " + barCode.length());
        }

        item.setBarCode(barCode);
        item.setItemName(activeItensModel.getItemName());
        item.setMarkName(activeItensModel.getMarkName());
        item.setAmount(activeItensModel.getAmount());

        return activeitensRepository.save(item);
    }

    public ActiveItensModel updateItensOnDBOutTB(UUID id, int removedAmount, String sector, String city){
        var item = activeitensRepository.findById(id).orElseThrow(()-> new RuntimeException("Item not found on ID: " + id));
        FinishItensModel finishItensModel = new FinishItensModel();

        if(item.getAmount() < removedAmount){
            throw new RuntimeException("Not enough items in stock to remove: Requested " + removedAmount);
        }

        finishItensModel.setId(UUID.randomUUID());
        finishItensModel.setBarCorde(item.getBarCode());
        finishItensModel.setItemName(item.getItemName());
        finishItensModel.setMarkName(item.getMarkName());
        finishItensModel.setAmount(removedAmount);
        finishItensModel.setCityName(city);
        finishItensModel.setSectorName(sector);

        finishItensRepository.save(finishItensModel);

        item.setAmount(item.getAmount() - removedAmount);

        return activeitensRepository.save(item);
    }

    public ActiveItensModel updateItensOnDB(ActiveItensModel activeItensModel, UUID id){
        var item = activeitensRepository.findById(id).orElseThrow(()-> new RuntimeException("Item not find on ID: " + id));

        item.setBarCode(activeItensModel.getBarCode());
        item.setItemName(activeItensModel.getItemName());
        item.setMarkName(activeItensModel.getMarkName());
        item.setAmount(activeItensModel.getAmount());

        return activeitensRepository.save(item);
    }

}
