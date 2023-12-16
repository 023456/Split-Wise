package com.SplitWise.SplitWise.Strategies;

public class SettleUpStrategyFactory {
    private static SettleUpStrategy getSettleUpStartegy(){
        return new  HeapBasedSettleUpStrategy();
    }
}
