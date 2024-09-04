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

    @Query(value = "SELECT * FROM itens_tb WHERE CAST(bar_code AS CHAR) LIKE %:searchItem% OR item LIKE %:searchItem% OR mark LIKE %:searchItem% OR sector LIKE %:searchItem% OR city LIKE %:searchItem%", nativeQuery = true)
    List<FinishItensModel> findByBarCodeItemNameMarkName(@Param("searchItem") String searchItem);

}
