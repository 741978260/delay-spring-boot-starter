package com.mumu.concurrent.chapter16;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/27
 */
public class FlightSecurity {
    private int count = 0;
    //登机牌
    private String boardingPass = "null";
    //身份证
    private String idCard = "null";

    public void pass(String boardingPass, String idCard) {
        this.boardingPass = boardingPass;
        this.idCard = idCard;
        check();
    }

    private void check() {
        if (boardingPass.charAt(0) != idCard.charAt(0)) {
            throw new RuntimeException("=========exception==========" + toString());
        }
    }

    @Override
    public String toString() {
        return "The " + count + " passengers,boardingPass [" + boardingPass + "],idCard [" + idCard + "]";
    }
}
