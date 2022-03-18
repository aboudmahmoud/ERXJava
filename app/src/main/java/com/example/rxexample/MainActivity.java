package com.example.rxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.example.rxexample.databinding.ActivityMainBinding;


import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;


public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    public static String TAG="aboud";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                binding.text.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        if(charSequence.length()!=0)
                        emitter.onNext(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
            }
        })
                .doOnNext(o -> Log.d(TAG,"UpsTream:"+o))
                //filter make shor the specifc word doesnt send
             .filter(o -> !o.toString().equalsIgnoreCase("aboud"))
                //filter map is editng the data  we send
               .flatMap(new Function<Object, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Object o) throws Throwable {
                        return dataToApi(o.toString());
                    }
                })
                .subscribe(o ->{
                    //dataToApi(o.toString());
                    Log.d(TAG, "DownStream:"+o);

                });
    }

    public Observable  dataToApi(String data)
    {
        Observable observable= Observable.just("calling api to send "+data);
        observable.subscribe(o->Log.d(TAG,"Senrding the "+data+" data "));
        return observable;
    }
}