package com.troopz.trpzlootbackend.service;

import com.troopz.trpzlootbackend.model.Prize;
import com.troopz.trpzlootbackend.model.UsedPrize;
import com.troopz.trpzlootbackend.repository.PrizeRepository;
import com.troopz.trpzlootbackend.repository.UsedPrizeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@Transactional
public class PrizeService {
    PrizeRepository prizeRepository;
    UsedPrizeRepository usedPrizeRepository;

    public PrizeService(PrizeRepository prizeRepository, UsedPrizeRepository usedPrizeRepository) {
        this.prizeRepository = prizeRepository;
        this.usedPrizeRepository = usedPrizeRepository;
    }

    public List<Prize> getAllPrizesByRank(String rank) {
        return prizeRepository.findAllByRank(rank);
    }

    public List<Prize> getAllPrizes() {
        return prizeRepository.findAll();
    }

    public void deletePrize(int prizeId) {
        prizeRepository.deletePrizeById(prizeId);
    }

    public Prize getRandomPrizeByRank(String rank) {
        List<Prize> prizeList = getAllPrizesByRank(rank);
        int randomPrizeId = prizeList.get(pickRandomPrizeFromListByRank(rank)).getId();
        return prizeRepository.findPrizeByRankAndId(rank, randomPrizeId);
    }

    public void saveRandomPrizeInUsedPrizeTable(UsedPrize usedPrize) {
        usedPrizeRepository.save(usedPrize);
    }

    public int pickRandomPrizeFromListByRank(String rank) {
        Random rnd = new Random();
        int prizesLeftInRank = getAllPrizesByRank(rank).size();
        return rnd.nextInt(prizesLeftInRank);

    }

    public void savePrize(Prize prize) {
        prizeRepository.save(prize);
    }
}
