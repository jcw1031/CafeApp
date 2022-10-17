package jcw.CAMO_Server.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Coupon {
    @Id
    private int couponId;
    private int memberId;
    private int cafeId;
    private int stampsNumber;
    private String colorCode;
}
