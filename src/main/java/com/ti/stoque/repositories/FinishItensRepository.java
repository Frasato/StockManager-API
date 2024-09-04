package com.ti.stoque.repositories;

import com.ti.stoque.models.FinishItensModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FinishItensRepository extends JpaRepository<FinishItensModel, UUID> {

    @Query(value = "SELECT * FROM itens_tb WHERE bar_code=:barcode OR item=:item OR mark=:mark OR sector=:sector OR city=:city", nativeQuery = true)
    List<FinishItensModel> findByBarCodeItemNameMarkName(@Param("barcode") long barCode, @Param("item") String item, @Param("mark") String mark, @Param("sector") String sector, @Param("city") String city);

}
