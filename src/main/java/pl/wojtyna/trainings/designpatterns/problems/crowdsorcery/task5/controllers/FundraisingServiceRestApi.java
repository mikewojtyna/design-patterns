package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task5.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task5.domain.Project;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task5.services.CreditScoreProcessor;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task5.services.FundraisingService;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task5.services.ProposalProcessor;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/fundraising")
public class FundraisingServiceRestApi {

    private final FundraisingService fundraisingService;

    public FundraisingServiceRestApi(FundraisingService fundraisingService) {this.fundraisingService = fundraisingService;}

    @PostMapping("/process")
    public void processProposal(@RequestBody Project project) throws InterruptedException {
        fundraisingService.processProposal(project, createProposalProcessor());
    }

    private ProposalProcessor createProposalProcessor() throws InterruptedException {
        var configuration = fetchConfigurationFromDatabase();
        return createProposalWithSomeBusinessLogic(configuration);
    }

    private ProposalProcessor createProposalWithSomeBusinessLogic(Configuration configuration) {
        var proposalProcessor = makeSomeDecisionsBasedOn(configuration);
        var now = LocalDate.now();
        if (now.getMonth().equals(Month.DECEMBER)) {
            var dayOfMonth = now.getDayOfMonth();
            if (dayOfMonth > 20) {
                return proposal -> "REJECTED";
            }
        }
        return proposalProcessor;
    }

    private ProposalProcessor makeSomeDecisionsBasedOn(Configuration configuration) {
        if (configuration.type().equals("CREDIT_SCORE")) {
            return new CreditScoreProcessor();
        }
        return proposal -> "NO_DECISION";
    }

    private Configuration fetchConfigurationFromDatabase() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return new Configuration("CREDIT_SCORE");
    }
}
