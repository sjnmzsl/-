package com.example.mylibrary.api;

public interface ICallBack<T> {
    void success(T bean);
    void failure(String error);

}
