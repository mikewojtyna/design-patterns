package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task8;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Investment;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Investor;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Portfolio;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Project;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services.PortfolioCreator;

import java.util.List;

public class PortfolioCreatorTest {

    @Test
    void createJsonPortfolio() throws JsonProcessingException {
        var portfolioCreator = new PortfolioCreator();
        Portfolio portfolio = new Portfolio();
        portfolio.setId("1");
        portfolio.setTitle("My portfolio");
        portfolio.setDescription("My portfolio description");
        portfolio.setInvestor(new Investor("John", "Doe"));

        Investment investment0 = new Investment();
        investment0.setAmount(Money.of(CurrencyUnit.EUR, 1000));
        investment0.setProject(new Project("My project",
                                           "My project description",
                                           Money.of(CurrencyUnit.EUR, 1000),
                                           "My loan schedule",
                                           0.1,
                                           1,
                                           "My status",
                                           false));
        Investment investment1 = new Investment();
        investment1.setAmount(Money.of(CurrencyUnit.EUR, 1_000_000));
        investment1.setProject(new Project("My project 2",
                                           "My project description 2",
                                           Money.of(CurrencyUnit.EUR, 1_000_000),
                                           "My loan schedule 2",
                                           0.15,
                                           10,
                                           "My status 2",
                                           false));
        var investments = List.of(investment0, investment1);
        portfolio.setInvestments(investments);

        var portfolioJson = portfolioCreator.createJson(portfolio);
        System.out.println(portfolioJson);
    }
}
