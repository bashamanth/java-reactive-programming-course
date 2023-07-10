package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {

//        publisher
        Mono<Integer> mono = Mono.just(1);
        System.out.println(mono);
//        above, nothing happens until you subscribe to the observable.
//        similar to stream without invoking terminal operators, nothing will process for the streams.

        mono.subscribe(i-> System.out.println("Received:"+i));



    }

}
