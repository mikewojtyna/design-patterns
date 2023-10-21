package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Investor;

import java.util.List;

public class PortfolioXmlBuilder implements PortfolioBuilder<String> {

    private String id = "";
    private String title = "";
    private String description = "";

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
    public PortfolioBuilder<String> withInvestor(Investor investor) {
        return this;
    }

    @Override
    public String build() {
        return """
               <portfolio>
                    <id>%s</id>
                    <title>%s</title>
                    <description>%s</description>
               </portfolio>
               """.formatted(id, title, description);
    }

    @Override
    public PortfolioBuilder<String> withInvestments(List list) {
        return this;
    }
}
