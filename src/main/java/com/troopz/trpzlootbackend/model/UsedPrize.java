package com.troopz.trpzlootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "usedprizes")
public class UsedPrize {

    @Id
    private int id;

    @Column(name = "rank")
    private String rank;

    @Column(name = "prize")
    private String prize;

    @Column(name = "value")
    private int value;

    @Column(name = "nftid")
    private String nftid;

    @Column(name = "image")
    private String image;

    @Column(name = "uniqueid")
    private UUID uniqueid;

    @Column(name = "wallet")
    private String wallet;

    public UsedPrize() {
    }

    public UsedPrize(int id, String rank, String prize, int value, String nftid, String image, UUID uniqueid, String wallet) {
        this.id = id;
        this.rank = rank;
        this.prize = prize;
        this.value = value;
        this.nftid = nftid;
        this.image = image;
        this.uniqueid = uniqueid;
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    public String getRank() {
        return rank;
    }

    public String getPrize() {
        return prize;
    }

    public int getValue() {
        return value;
    }

    public String getNftid() {
        return nftid;
    }

    public String getImage() {
        return image;
    }

    public UUID getUniqueid() {
        return uniqueid;
    }

    public String getWallet() {
        return wallet;
    }

    @Override
    public String toString() {
        return "UsedPrize{" +
                "id=" + id +
                ", rank='" + rank + '\'' +
                ", prize='" + prize + '\'' +
                ", value=" + value +
                ", nftid='" + nftid + '\'' +
                ", image='" + image + '\'' +
                ", uniqueid=" + uniqueid +
                ", wallet='" + wallet + '\'' +
                '}';
    }
}

