package com.troopz.trpzlootbackend.service;

import com.troopz.trpzlootbackend.model.Prize;
import com.troopz.trpzlootbackend.model.UsedPrize;
import com.troopz.trpzlootbackend.repository.PrizeRepository;
import com.troopz.trpzlootbackend.repository.UsedPrizeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
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

    public void deletePrize(UUID prizeId) {
        prizeRepository.deleteById(prizeId);
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
        int randomPriceNumber = 0;
        int prizesLeftInRank = getAllPrizesByRank(rank).size();
        while (randomPriceNumber == 0) {
            randomPriceNumber = rnd.nextInt(prizesLeftInRank);
        }
        return randomPriceNumber;
    }
}
