package com.ti.stoque.repositories;

import com.ti.stoque.models.ActiveItensModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ActiveitensRepository extends JpaRepository<ActiveItensModel, UUID> {

    @Query(value = "SELECT * FROM itens_tb WHERE bar_code=:barcode OR item=:item OR mark=:mark", nativeQuery = true)
    List<ActiveItensModel> findByBarCodeItemNameMarkName(@Param("barcode") long barCode, @Param("item") String item, @Param("mark") String mark);

}