package com.introduction;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class MoneyTest {
    public void immutableConstructor(){
        Money money = new Money(1000,"RWF");
        assertEquals(money.getAmount(),1000);
        assertEquals(money.getCurrency(),"RWF");
    }
}