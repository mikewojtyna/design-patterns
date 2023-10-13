package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.domain.Asset;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.domain.Investor;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.domain.Project;

import java.math.RoundingMode;
import java.util.List;

public class InvestService {

    private final DepositService depositService = new DepositService();
    private final AssetFinder assetFinder = new AssetFinder();
    private final ProjectFinder projectFinder = new ProjectFinder();
    private TransferService transferService;

    void investIntoAsset(Investor investor, Asset asset, Money amount) {
        for (Project project : projectFinder.byAsset(asset.name())) {
            investIntoProject(investor, amount, project);
        }
    }

    void investAccordingToStrategies(String investmentStrategy, Investor investor) {
        var lowRiskAssets = assetFinder.findLowRisk();
        var highRiskAssets = assetFinder.findHighRisk();
        var mediumRiskAssets = assetFinder.findMediumRisk();
        if ("LOW_RISK".equals(investmentStrategy)) {
            investPercentOfMoneyIntoAssets(investor, lowRiskAssets, 0.8);
            investPercentOfMoneyIntoAssets(investor, mediumRiskAssets, 0.15);
            investPercentOfMoneyIntoAssets(investor, highRiskAssets, 0.05);
        }
        else if ("HIGH_RISK".equals(investmentStrategy)) {
            investPercentOfMoneyIntoAssets(investor, lowRiskAssets, 0.05);
            investPercentOfMoneyIntoAssets(investor, mediumRiskAssets, 0.15);
            investPercentOfMoneyIntoAssets(investor, highRiskAssets, 0.8);
        }
        else if ("MEDIUM_RISK".equals(investmentStrategy)) {
            investPercentOfMoneyIntoAssets(investor, lowRiskAssets, 0.15);
            investPercentOfMoneyIntoAssets(investor, mediumRiskAssets, 0.7);
            investPercentOfMoneyIntoAssets(investor, highRiskAssets, 0.15);
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
        // and so on...
    }

    void investIntoProject(Investor investor, Money amount, Project project) {
        project.setDeposit(project.getDeposit().plus(amount));
        project.getInvestors().put(investor.name(), amount);
        transferService.transfer(amount, investor.name(), project.getTitle());
    }

    private void youGetWhatIMean() {

    }

    private void someCustomCastleRenovationLogic() {

    }

    private void someCustomOrangePlantationLogic() {

    }

    private void someCustomStartupLogic() {

    }

    private void investPercentOfMoneyIntoAssets(Investor investor, List<Asset> assets, double percnet) {
        var investorDepositAmount = depositService.get(investor);
        for (Asset asset : assets) {
            investIntoAsset(investor, asset, investorDepositAmount.multipliedBy(percnet, RoundingMode.UP));
        }
    }
}
