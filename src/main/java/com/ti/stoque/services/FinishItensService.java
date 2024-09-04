package com.ti.stoque.services;

import com.ti.stoque.models.FinishItensModel;
import com.ti.stoque.repositories.FinishItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinishItensService {

    @Autowired
    private FinishItensRepository finishItensRepository;

    public List<FinishItensModel> findAll(){
        return finishItensRepository.findAll();
    }

    public List<FinishItensModel> findByQuery(String searchItem){
        return finishItensRepository.findByBarCodeItemNameMarkName(searchItem);
    }

}
