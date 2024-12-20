package com.coze.request;

public interface EventHandler<T> {
    void onEvent(T event);
    void onComplete();
    void onError(Throwable error);
}
