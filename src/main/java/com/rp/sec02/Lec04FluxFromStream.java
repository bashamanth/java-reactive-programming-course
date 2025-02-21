package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

       // stream.forEach(System.out::println); // closed
       // stream.forEach(System.out::println);

//        in the below statement list.stream() gives always new Object,
//        if you replace with stream it shares the same object and second subscriber will not get any events.

        Flux<Integer> integerFlux = Flux.fromStream(() -> list.stream());

        integerFlux
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        integerFlux
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );


    }

}
