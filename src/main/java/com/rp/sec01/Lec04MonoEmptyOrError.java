package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

    public static void main(String[] args) {

        userRepository(3).subscribe(i-> System.out.println(i),exception-> System.out.println(exception), ()-> System.out.println("Completed"));

    }

   public static Mono<String> userRepository(int userId){

        if (userId==1){
            return  Mono.just(Util.faker().name().firstName());
        }
        else if (userId==2){
            return Mono.empty();
        }
        else {
            return Mono.error(new RuntimeException("Not allowed in the range"));
        }

    }

}
