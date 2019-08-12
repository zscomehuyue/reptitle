package com.rxjava.test.flatmap;

import io.reactivex.Observable;
import org.junit.Test;

import java.util.List;

public class UserTest {
    User user = new User();
    List<User> users = user.createUsers();

    @Test
    public void flatmap() {
        users
                .stream()
                .map(User::getAddresses)
                .flatMap(list->list.stream())
                .forEach(System.out::println);

    }



    @Test
    public void map() {
        Observable.just(user.createUser(1))
                .map(User::getAddresses)
                .subscribe(l -> {
                    l.stream().forEach(System.out::println);
                })
        ;

    }

    @Test
    public void rxflatMap() {
        User user = new User();
        user.createUsers();
        Observable.just(user.createUser(1))
                .flatMap(user1 -> Observable.fromIterable(user1.getAddresses()))
                .subscribe(System.out::println)
        ;

    }


}
