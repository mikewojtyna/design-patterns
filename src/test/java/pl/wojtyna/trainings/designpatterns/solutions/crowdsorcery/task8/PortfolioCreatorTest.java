package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Investment;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Portfolio;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Project;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.services.*;

import java.util.List;

public class PortfolioCreatorTest {

    @Test
    void createMultipleRepresentationsOfPortfolio() {
        var portfolioCreator = new PortfolioCreator();

        var portfolio = prepareSomePortfolioForTesting();

        var portfolioJson = portfolioCreator.create(portfolio, new PortfolioJsonBuilder());
        System.out.println(portfolioJson);

        var portfolioRecord = portfolioCreator.create(portfolio, new PortfolioRecordBuilder());
        System.out.println(portfolioRecord);

        var portfolioXml = portfolioCreator.create(portfolio, new PortfolioXmlBuilder());
        System.out.println(portfolioXml);

        var compositeJsonBuilder = new PortfolioJsonBuilder();
        var compositeRecordBuilder = new PortfolioRecordBuilder();
        var compositePortfolioXmlBuilder = new PortfolioXmlBuilder();
        CompositePortfolioBuilder compositePortfolioBuilder = new CompositePortfolioBuilder(List.of(compositeJsonBuilder,
                                                                                                    compositeRecordBuilder,
                                                                                                    compositePortfolioXmlBuilder));
        portfolioCreator.create(portfolio, compositePortfolioBuilder);
        System.out.println("====================================");
        System.out.println("Composite results");
        System.out.println(compositeJsonBuilder.getLastResult());
        System.out.println(compositeRecordBuilder.getLastResult());
        System.out.println(compositePortfolioXmlBuilder.getLastResult());
    }

    private Portfolio prepareSomePortfolioForTesting() {
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
        return portfolio;
    }
}
