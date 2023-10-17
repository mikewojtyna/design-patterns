package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task5.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task5.domain.Project;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task5.services.FundraisingService;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task5.services.ProposalProcessors;

@RestController
@RequestMapping("/api/fundraising")
public class FundraisingServiceRestApi {

    private final FundraisingService fundraisingService;
    private final ProposalProcessors proposalProcessors;

    public FundraisingServiceRestApi(FundraisingService fundraisingService, ProposalProcessors proposalProcessors) {
        this.fundraisingService = fundraisingService;
        this.proposalProcessors = proposalProcessors;
    }

    @PostMapping("/process")
    public void processProposal(@RequestBody Project project) throws InterruptedException {
        fundraisingService.processProposal(project, proposalProcessors.chooseTheRightProcessor());
    }

}
