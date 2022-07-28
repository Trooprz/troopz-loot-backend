package com.troopz.trpzlootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "trpzloot")
public class Prize {

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

    public Prize() {
    }

    public Prize(int id, String rank, String prize, int value, String nftid, String image, UUID uniqueid) {
        this.id = id;
        this.rank = rank;
        this.prize = prize;
        this.value = value;
        this.nftid = nftid;
        this.image = image;
        this.uniqueid = uniqueid;
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

    @Override
    public String toString() {
        return "Prize{" +
                "id=" + id +
                ", rank='" + rank + '\'' +
                ", prize='" + prize + '\'' +
                ", value=" + value +
                ", nftid='" + nftid + '\'' +
                ", image='" + image + '\'' +
                ", uniqueid=" + uniqueid +
                '}';
    }
}
