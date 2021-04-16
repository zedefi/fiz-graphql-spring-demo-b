package com.fiz.demo.fizdemoc;


import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class SubscriptionResolver implements GraphQLSubscriptionResolver {

    public Publisher<StockPrice> stockPrice(String symbol) {

//        Random random = new Random();
//        return Flux.interval(Duration.ofSeconds(1))
//                .map(num -> new StockPrice(symbol, random.nextDouble(), LocalDateTime.now()));


        Publisher<StockPrice> publisher = s -> {
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
            executorService.scheduleAtFixedRate(() -> {
                StockPrice ret = new StockPrice(symbol, 2d, LocalDateTime.now());
                s.onNext(ret);
            }, 0, 2, TimeUnit.SECONDS);
        };

//        publisher.subscribe(new TestSubscriber());

        return publisher;
    }


}