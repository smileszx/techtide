package com.ai.tide.pay.strategy;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/8 23:19
 **/
public class PayContext {
    private StrategyService strategyService;

    public PayContext (StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    public void pay() {
        strategyService.pay();
    }
}
