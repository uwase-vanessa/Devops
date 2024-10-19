package com.introduction;

public class Money {
    private final int amount;
    private final String currency;
    public Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }
    public int getAmount(){ return amount;}
    public String getCurrency(){return currency;}
    public boolean equals(Object o){
        if(o instanceof Money){
            Money money = (Money) o;
            return money.getCurrency().equalsIgnoreCase(getCurrency()) && getAmount()== money.getAmount();
        }
        return false;
    }
}