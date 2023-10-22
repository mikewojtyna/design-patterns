package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12;

import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.domain.Portfolio;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.services.CommandInvoker;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.services.PortfolioDatabase;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.services.PortfolioEditor;

import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PortfolioEditorTest {

    @Test
    void invokingCommandExamples() {
        var portfolioDb = inMemory();
        var initialPortfolio = new Portfolio();
        initialPortfolio.setTitle("Initial title");
        initialPortfolio.setDescription("Initial description");
        initialPortfolio.setId("initial-id");
        portfolioDb.save(initialPortfolio);
        var commandInvoker = new CommandInvoker();
        var portfolioEditor = new PortfolioEditor(portfolioDb, commandInvoker);

        portfolioEditor.changeTitle("initial-id", "New title");
        assertThat(portfolioDb.findById("initial-id").getTitle()).isEqualTo("New title");

        portfolioEditor.undo();
        assertThat(portfolioDb.findById("initial-id").getTitle()).isEqualTo("Initial title");

        portfolioEditor.changeTitle("initial-id", "title 1");
        assertThat(portfolioDb.findById("initial-id").getTitle()).isEqualTo("title 1");
        portfolioEditor.changeTitle("initial-id", "title 2");
        assertThat(portfolioDb.findById("initial-id").getTitle()).isEqualTo("title 2");
        portfolioEditor.changeTitle("initial-id", "title 3");
        assertThat(portfolioDb.findById("initial-id").getTitle()).isEqualTo("title 3");
        portfolioEditor.undo();
        assertThat(portfolioDb.findById("initial-id").getTitle()).isEqualTo("title 2");
        portfolioEditor.undo();
        assertThat(portfolioDb.findById("initial-id").getTitle()).isEqualTo("title 1");
    }

    private PortfolioDatabase inMemory() {
        return new PortfolioDatabase() {

            private final ConcurrentHashMap<String, Portfolio> db = new ConcurrentHashMap<>();

            @Override
            public Portfolio findById(String id) {
                return db.get(id);
            }

            @Override
            public void save(Portfolio portfolio) {
                db.put(portfolio.getId(), portfolio);
            }
        };
    }
}
