package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Investment;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Investor;

import java.util.List;
import java.util.stream.Collectors;

public class PortfolioJsonBuilder implements PortfolioBuilder<String> {

    private String id = "";
    private String title = "";
    private String description = "";
    private String investments = "";
    private String investor = "";

    @Override
    public PortfolioBuilder<String> withId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public PortfolioBuilder<String> withTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public PortfolioBuilder<String> withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public PortfolioBuilder<String> withInvestments(List<Investment> investments) {
        this.investments =
            investments.stream().map(investment -> {
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
        return this;
    }

    @Override
    public PortfolioBuilder<String> withInvestor(Investor investor) {
        this.investor = """
                        {
                          "name": "%s",
                          "surname": "%s"
                        }
                        """.formatted(investor.getName(), investor.getSurname());
        return this;
    }

    @Override
    public String build() {
        var json = """
                   {
                    "id": "%s",
                    "title": "%s",
                    "description": "%s",
                    "investments": %s,
                    "investor": %s
                   }
                   """.formatted(id,
                                 title,
                                 description,
                                 investments,
                                 investor);
        var objectMapper = new ObjectMapper();
        try {
            var jsonObject = objectMapper.readValue(json, Object.class);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
