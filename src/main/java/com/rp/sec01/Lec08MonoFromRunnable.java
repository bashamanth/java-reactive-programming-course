package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {

// runnable will not return any values, this Mono would be useful when u just want to notify the operation is complete without the return statement.
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("process is done. Sending emails...");
                        });


    }

    private static Runnable timeConsumingProcess(){
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }


}
