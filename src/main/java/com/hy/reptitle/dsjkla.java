package com.hy.reptitle;

import io.reactivex.Observable;

import java.util.List;

public class dsjkla {

    private List<String> urls;
    public void ddd(){
        Observable.fromIterable(urls)
                .flatMap(url->Observable.just(url))
                ;

    }
}
