package com.ti.stoque.services;

import com.ti.stoque.repositories.FinishItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinishItensService {

    @Autowired
    private FinishItensRepository finishItensRepository;

}
