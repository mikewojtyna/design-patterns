package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.controllers;

import org.springframework.web.bind.annotation.*;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.domain.Borrower;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.infrastructure.BorrowersRegistryFactory;

import java.util.SequencedCollection;

@RestController
@RequestMapping("/borrowers")
public class BorrowersRestController {

    private final BorrowersRegistryFactory borrowersRegistryFactory;

    public BorrowersRestController(BorrowersRegistryFactory borrowersServiceFactory) {
        this.borrowersRegistryFactory = borrowersServiceFactory;
    }

    @PostMapping
    public void register(@RequestBody Borrower borrower) {
        borrowersRegistryFactory.borrowersRegistry().register(borrower);
    }

    @GetMapping
    public SequencedCollection<Borrower> getBorrowers() {
        return borrowersRegistryFactory.borrowersRegistry().getBorrowers();
    }
}
