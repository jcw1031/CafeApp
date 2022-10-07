package jcw.CAMO_Spring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeMenu {
    private Long menuId; //메뉴번호(PK)
    private Long cafeId; //카페번호(PK)(FK)
    private String menuName; //메뉴 이름
    private int menuPrice; //메뉴 가격
    private boolean couponAvailability; //쿠폰 사용 가능 여부
}
