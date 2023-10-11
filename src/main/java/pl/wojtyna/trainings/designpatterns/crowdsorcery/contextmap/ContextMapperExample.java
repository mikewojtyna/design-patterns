package pl.wojtyna.trainings.designpatterns.crowdsorcery.contextmap;

import guru.nidi.graphviz.engine.Format;
import org.contextmapper.contextmap.generator.ContextMapGenerator;
import org.contextmapper.contextmap.generator.model.*;

import java.io.IOException;

public class ContextMapperExample {

    public static void main(String[] args) throws IOException {
        var deposit = new BoundedContext("Deposit");
        var investment = new BoundedContext("Investment");
        var payment = new BoundedContext("Payment");
        var profile = new BoundedContext("Profile");
        var fundraising = new BoundedContext("Fundraising");
        var simulation = new BoundedContext("Simulation");
        var interest = new BoundedContext("Interest");

        var contextMap = new ContextMap()
            .addBoundedContext(deposit)
            .addBoundedContext(investment)
            .addBoundedContext(payment)
            .addBoundedContext(profile)
            .addBoundedContext(fundraising)
            .addBoundedContext(simulation)
            .addBoundedContext(interest)
            .addRelationship(new UpstreamDownstreamRelationship(
                deposit,
                investment).setUpstreamPatterns(UpstreamPatterns.OPEN_HOST_SERVICE)
                           .setDownstreamPatterns(
                               DownstreamPatterns.ANTICORRUPTION_LAYER,
                               DownstreamPatterns.CONFORMIST).setCustomerSupplier(true)
                           .setImplementationTechnology("in-process call"))
            .addRelationship(new UpstreamDownstreamRelationship(payment,
                                                                deposit).setUpstreamPatterns(
                UpstreamPatterns.OPEN_HOST_SERVICE,
                UpstreamPatterns.PUBLISHED_LANGUAGE).setDownstreamPatterns(
                DownstreamPatterns.ANTICORRUPTION_LAYER).setCustomerSupplier(false))
            .addRelationship(new UpstreamDownstreamRelationship(deposit, fundraising).setUpstreamPatterns(
                                                                                         UpstreamPatterns.OPEN_HOST_SERVICE).setDownstreamPatterns(DownstreamPatterns.CONFORMIST)
                                                                                     .setCustomerSupplier(true))
            .addRelationship(new Partnership(investment, simulation))
            .addRelationship(new UpstreamDownstreamRelationship(deposit, interest).setCustomerSupplier(true)
                                                                                  .setUpstreamPatterns(UpstreamPatterns.OPEN_HOST_SERVICE)
                                                                                  .setDownstreamPatterns(
                                                                                      DownstreamPatterns.ANTICORRUPTION_LAYER));
        new ContextMapGenerator().generateContextMapGraphic(contextMap,
                                                            Format.PNG,
                                                            "target/crowd-sorcery-context-map.png");
    }
}
