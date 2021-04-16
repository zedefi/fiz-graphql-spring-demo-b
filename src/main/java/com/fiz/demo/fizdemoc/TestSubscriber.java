package com.fiz.demo.fizdemoc;


import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.stereotype.Component;

@Component
public class TestSubscriber implements Subscriber<StockPrice> {
    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("onSubscribe");
    }

    @Override
    public void onNext(StockPrice stockPrice) {
        System.out.println("onNext");
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("onError");
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}