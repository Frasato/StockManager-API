package com.ti.stoque.services;

import com.ti.stoque.models.ActiveItensModel;
import com.ti.stoque.repositories.ActiveitensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiveItensService {

    @Autowired
    private ActiveitensRepository activeitensRepository;

    public List<ActiveItensModel> findAllItens(){
        return activeitensRepository.findAll();
    }

    public List<ActiveItensModel> findBySearchInput(long barCode, String item, String mark){
        return activeitensRepository.findByBarCodeItemNameMarkName(barCode, item, mark);
    }

}
