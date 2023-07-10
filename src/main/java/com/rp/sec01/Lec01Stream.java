package com.rp.sec01;

import java.util.stream.Stream;

public class Lec01Stream {

    public static void main(String[] args) {

//        Stream<Integer> stream = Stream.of(1)
//                                        .map(i -> {
//                                            try {
//                                                Thread.sleep(1000);
//                                            } catch (InterruptedException e) {
//                                                e.printStackTrace();
//                                            }
//                                            return i * 2;
//                                        });
//
//        //System.out.println(stream);
//        stream.forEach(System.out::println);


        Stream<Integer> stream1 = Stream.of(1)
                .map(i-> {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i*2;
                });


        System.out.println(stream1);
//        in the above statement stream1 gets printed and actual stream processing will not happen.
//        coz streams are lazy.

        stream1.forEach(System.out::println);
//        the above statment blocks the call





    }


}
