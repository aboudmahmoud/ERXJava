package com.example.rxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //cold  Observable 1 and 2 get all info
      /*  Observable<Long> cold=Observable.intervalRange(0,5,0,1, TimeUnit.SECONDS);
        cold.subscribe(aLong ->System.out.println("Student 1  is"+ aLong));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cold.subscribe(aLong ->System.out.println("Student 2  is"+ aLong));*/
        //cold Observable connect to hot  Observable 1 get all info 2 get form the info that send it
       /* ConnectableObservable<Long> cold=ConnectableObservable.intervalRange(0,5,0,1, TimeUnit.SECONDS).publish();
        cold.connect();
        cold.subscribe(aLong ->System.out.println("Student 1  is"+ aLong));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cold.subscribe(aLong ->System.out.println("Student 2  is"+ aLong));*/
        //PublishSubject 1 get all info 2 get form the info that send it
        /*   PublishSubject<String>subject = PublishSubject.create();
        subject.subscribe(aLong ->System.out.println("Student 1  is"+ aLong));
        subject.onNext("A");
        nape(1000);
        subject.onNext("B");
        nape(1000);
        subject.onNext("C");
        nape(1000);
        subject.onNext("D");
        nape(1000);
        subject.subscribe(aLong ->System.out.println("Student 2  is "+ aLong));
        subject.onNext("E");
        nape(1000);
        subject.onNext("F");
        nape(1000);
        subject.onNext("G");
        nape(1000);*/
        //BehaviorSubject 1 get all info 2 get form the last info was  send it
       /* BehaviorSubject<String>subject = BehaviorSubject.create();
        subject.subscribe(aLong ->System.out.println("Student 1  is "+ aLong));
        subject.onNext("A");
        nape(1000);
        subject.onNext("B");
        nape(1000);
        subject.onNext("C");
        nape(1000);
        subject.onNext("D");
        nape(1000);
        subject.subscribe(aLong ->System.out.println("Student 2  is "+ aLong));
        subject.onNext("E");
        nape(1000);
        subject.onNext("F");
        nape(1000);
        subject.onNext("G");
        nape(1000);*/

      //  ReplaySubject 1 get all info but when 2 is coming 1 stop geting info tell 2 get all perivos info then both get the remainning info
     /*   ReplaySubject<String>subject = ReplaySubject.create();
        subject.subscribe(aLong ->System.out.println("Student 1  is "+ aLong));
        subject.onNext("A");
        nape(1000);
        subject.onNext("B");
        nape(1000);
        subject.onNext("C");
        nape(1000);
        subject.onNext("D");
        nape(1000);
        subject.subscribe(aLong ->System.out.println("Student 2  is "+ aLong));
        subject.onNext("E");
        nape(1000);
        subject.onNext("F");
        nape(1000);
        subject.onNext("G");
        nape(1000);*/
  //AsyncSubject both 1 an  2 getall info just last one
       /* AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(aLong ->System.out.println("Student 1  is "+ aLong));
        subject.onNext("A");
        nape(1000);
        subject.onNext("B");
        nape(1000);
        subject.onNext("C");
        nape(1000);
        subject.onNext("D");
        nape(1000);
        subject.subscribe(aLong ->System.out.println("Student 2  is "+ aLong));
        subject.onNext("E");
        nape(1000);
        subject.onNext("F");
        nape(1000);
        subject.onNext("G");
        nape(1000);
        subject.onComplete();*/
        //observable.create to observer using suscribe pathing observer as pramter and send data using onnext
        /*Observable observable=Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                for (int i=0 ; i<5 ;i++)
                {
                    emitter.onNext("Aboud is Codeing "+ i);
                }
                emitter.onComplete();
            }
        });*/

        //Observable.just to observer with pathing item limit 10 only with auto complet
        /*Observable observable=Observable.just(0,1,2,3,5);*/

        //Observable.fromArray take array as parrmeter
       Integer[] list = new Integer[5];
        for (int i=0 ; i<5; i++)
        {
            list[i]=i;
        }
        Observable observable=Observable.fromArray(list);
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("aboud","onSubscribe ");
            }

            @Override
            public void onNext(Object o) {
                Log.d("aboud","onNext "+o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("aboud","onError "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d("aboud","onComplete");
            }
        };

        observable.subscribe(observer);

    }

    public void nape(int i)
    {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}