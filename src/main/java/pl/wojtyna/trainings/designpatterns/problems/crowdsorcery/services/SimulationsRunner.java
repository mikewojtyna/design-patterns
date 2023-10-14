package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.domain.Asset;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.domain.HistoricalData;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimulationsRunner {

    private static Money initialDeposit;

    public double runSimulation(HistoricalData historicalDate,
                                String investmentStrategy,
                                Money money) throws InterruptedException {
        initialDeposit = money;
        if ("LOW_RISK".equals(investmentStrategy)) {
            investPercentOfMoneyIntoAssets(money, historicalDate.lowRiskAssets(), 0.8);
            investPercentOfMoneyIntoAssets(money, historicalDate.mediumRiskAssets(), 0.15);
            investPercentOfMoneyIntoAssets(money, historicalDate.highRiskAssets(), 0.05);
        }
        else if ("HIGH_RISK".equals(investmentStrategy)) {
            investPercentOfMoneyIntoAssets(money, historicalDate.lowRiskAssets(), 0.05);
            investPercentOfMoneyIntoAssets(money, historicalDate.mediumRiskAssets(), 0.15);
            investPercentOfMoneyIntoAssets(money, historicalDate.highRiskAssets(), 0.8);
        }
        else if ("MEDIUM_RISK".equals(investmentStrategy)) {
            investPercentOfMoneyIntoAssets(money, historicalDate.lowRiskAssets(), 0.15);
            investPercentOfMoneyIntoAssets(money, historicalDate.mediumRiskAssets(), 0.7);
            investPercentOfMoneyIntoAssets(money, historicalDate.highRiskAssets(), 0.15);
        }
        else if ("STARTUP_STRATEGY".equals(investmentStrategy)) {
            someCustomStartupLogic();
        }
        else if ("ORANGE_PLANTATION".equals(investmentStrategy)) {
            someCustomOrangePlantationLogic();
        }
        else if ("CASTLE_RENOVATION".equals(investmentStrategy)) {
            someCustomCastleRenovationLogic();
        }
        else if ("ORANGE_PLANTATION_COMBINED_WITH_STARTUP_STRATEGY_MEDIUM_RISK_STRATEGY".equals(investmentStrategy)) {
            youGetWhatIMean();
        }
        else if ("ORANGE_PLANTATION_COMBINED_WITH_STARTUP_STRATEGY_HIGH_RISK_STRATEGY".equals(investmentStrategy)) {
            youGetWhatIMean();
        }
        else if ("CASTLE_RENOVATION_COMBINED_WITH_STARTUP_STRATEGY_MEDIUM_RISK_STRATEGY".equals(investmentStrategy)) {
            youGetWhatIMean();
        }
        else if ("CASTLE_RENOVATION_COMBINED_WITH_STARTUP_STRATEGY_HIGH_RISK_STRATEGY".equals(investmentStrategy)) {
            youGetWhatIMean();
        }
        return computeResults(historicalDate, investmentStrategy).getAmount().doubleValue() / initialDeposit.getAmount()
                                                                                                            .doubleValue();
    }

    private void investPercentOfMoneyIntoAssets(Money money, List<Asset> assets, double percnet) {
        // invest into historical data
    }

    private Money computeResults(HistoricalData historicalDate, String investmentStrategy) throws InterruptedException {
        TimeUnit.MINUTES.sleep(30);
        Money finalResult = calculateFinalResult();
        return finalResult.minus(initialDeposit);
    }

    private Money calculateFinalResult() {
        return null;
    }

    private void youGetWhatIMean() {

    }

    private void someCustomCastleRenovationLogic() {

    }

    private void someCustomOrangePlantationLogic() {

    }

    private void someCustomStartupLogic() {

    }
}
