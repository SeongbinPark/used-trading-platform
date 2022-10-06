package com.seongbinpark.usedtradingplatform.post.domain.entity;

public enum TradeStatus {
    SALE("판매중"),
    RESERVED("예약중"),
    SOLD("판매완료");

    private String tradeStatus;

    TradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getTradeStatus() {
        return this.tradeStatus;
    }
}
