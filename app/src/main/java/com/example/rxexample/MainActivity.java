package com.example.rxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
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
        AsyncSubject<String> subject = AsyncSubject.create();
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
        subject.onComplete();

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