package com.troopz.trpzlootbackend.api;

import com.troopz.trpzlootbackend.model.Prize;
import com.troopz.trpzlootbackend.model.UsedPrize;
import com.troopz.trpzlootbackend.service.PrizeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class PrizeController {
    PrizeService prizeService;

    public PrizeController(PrizeService prizeService) {
        this.prizeService = prizeService;
    }

    @GetMapping("/{rank}/prizes")
    public List<Prize> getAllPrizesByRank(@PathVariable String rank) {
        return prizeService.getAllPrizesByRank(rank);
    }

    @GetMapping("/{rank}/randomPrize")
    public Prize getRandomPrizeByRank(@PathVariable String rank) {
        return prizeService.getRandomPrizeByRank(rank);
    }

    @DeleteMapping("/{prizeId}")
    public void removePrize(@PathVariable UUID prizeId) {
        prizeService.deletePrize(prizeId);
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUsedPrize(@RequestBody UsedPrize usedPrize) {
        prizeService.saveRandomPrizeInUsedPrizeTable(usedPrize);
    }
}
