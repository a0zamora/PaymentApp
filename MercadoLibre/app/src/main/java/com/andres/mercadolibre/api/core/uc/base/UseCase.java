package com.andres.mercadolibre.api.core.uc.base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T, P> extends BaseUseCase<T> {

  public void execute(DisposableObserver<T> disposableObserver, P params) {
    final Observable<T> observable = buildUseCaseObservable(params).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());

    DisposableObserver observer = observable.subscribeWith(disposableObserver);
    compositeDisposable.add(observer);
  }

  protected abstract Observable<T> buildUseCaseObservable(P params);
}
