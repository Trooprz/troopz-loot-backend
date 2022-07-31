package com.troopz.trpzlootbackend.repository;

import com.troopz.trpzlootbackend.model.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PrizeRepository extends JpaRepository<Prize, Integer> {
    @Query("SELECT p FROM Prize p WHERE p.rank = :rank")
    List<Prize> findAllByRank(@Param("rank") String rank);
    @Query("SELECT p FROM Prize p WHERE p.rank = :rank AND p.id = :nextInt")
    Prize findPrizeByRankAndId(String rank, int nextInt);
    void deletePrizeById(int id);
}
