package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {


//        if there is no subscriber, publisher shouldn't do anything. But with just() it does.
        Mono<String> stringMono = Mono.just(getName());




        // use just only when you have data already
       // Mono<String> mono = Mono.just(getName());

//        Publisher uses the supplier and executes the method.

        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(
                Util.onNext()
        );

        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext()
                );

//        https://www.baeldung.com/java-callable-vs-supplier


    }

    private static String getName(){
        System.out.println("Generating name..");
        return Util.faker().name().fullName();
    }


}
