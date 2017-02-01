package com.github.austinmckinley;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardRequest {
    private String cardNumber;

    @JsonCreator
    public CardRequest(
            @JsonProperty("cardNumber") String cardNumber
    ) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return "CardRequest{" +
                "cardNumber='" + cardNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardRequest that = (CardRequest) o;

        return !(cardNumber != null ? !cardNumber.equals(that.cardNumber) : that.cardNumber != null);

    }

    @Override
    public int hashCode() {
        return cardNumber != null ? cardNumber.hashCode() : 0;
    }
}
