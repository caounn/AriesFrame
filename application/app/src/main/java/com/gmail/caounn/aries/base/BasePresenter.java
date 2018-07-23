package com.gmail.caounn.aries.base;

public interface BasePresenter<T> {
  void takeView(T view);

  void dropView();
}
