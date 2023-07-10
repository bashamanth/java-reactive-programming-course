package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

//    building the pipeline vs executing the pipeline.
//    with the first getName() call it, doesnt execute the pipeline. just builds it so thread sleep will not execute.

    public static void main(String[] args) {
        getName();
        getName().subscribeOn(Schedulers.boundedElastic()).subscribe(t -> System.out.println(t));
        getName();

//        you can use block() method on mono

        Util.sleepSeconds(8);
    }

    private static Mono<String> getName() {
        System.out.println("Entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating Name...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);

    }

}
