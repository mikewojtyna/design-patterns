package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Portfolio;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.PortfolioRecord;

import java.util.stream.Collectors;

public class PortfolioCreator {

    public String createJson(Portfolio portfolio) throws JsonProcessingException {
        var investments =
            portfolio.getInvestments().stream().map(investment -> {
                var goal = """
                           {
                             "value": "%s",
                             "currency": "%s"
                           }
                           """.formatted(investment.getProject().getGoal().getAmount().doubleValue(),
                                         investment.getProject().getGoal().getCurrencyUnit().getCode());
                var project = """
                              {
                                 "title":  "%s",
                                 "description": "%s",
                                 "goal": %s,
                                 "interestRate": "%s"
                              }
                              """.formatted(investment.getProject().getTitle(),
                                            investment.getProject().getDescription(),
                                            goal,
                                            investment.getProject().getInterestRate());
                return """
                       {
                           "amount": %s,
                           "project": %s
                       }
                       """.formatted(goal, project);
            }).collect(Collectors.joining(",", "[", "]"));
        var investor = """
                       {
                         "name": "%s",
                         "surname": "%s"
                       }
                       """.formatted(portfolio.getInvestor().getName(), portfolio.getInvestor().getSurname());
        var json = """
                   {
                    "id": "%s",
                    "title": "%s",
                    "description": "%s",
                    "investments": %s,
                    "investor": %s
                   }
                   """.formatted(portfolio.getId(),
                                 portfolio.getTitle(),
                                 portfolio.getDescription(),
                                 investments,
                                 investor);
        var objectMapper = new ObjectMapper();
        var jsonObject = objectMapper.readValue(json, Object.class);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
    }

    public PortfolioRecord createPortfolioRecord(Portfolio portfolio) {
        return new PortfolioRecord(portfolio.getId(), portfolio.getTitle(), portfolio.getDescription());
    }

    public String createXml(Portfolio portfolio) {
        // create the xml representation of the portfolio
        throw new UnsupportedOperationException("Implement this method");
    }

    public String createYaml(Portfolio portfolio) {
        // create the yaml representation of the portfolio
        throw new UnsupportedOperationException("Implement this method");
    }

    // possible many more methods for different formats...
    // this can easily grow out of control, especially when we want to support new formats dynamically
}
