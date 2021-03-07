package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {
    private LottieAnimationView animationView;
    private RecyclerView listView;
    private ListAdapter mListAdapter = new ListAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View mView = inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView = mView.findViewById(R.id.animation_view);
        listView = mView.findViewById(R.id.rv);
        listView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        listView.setAdapter(mListAdapter);
        listView.setAlpha(0.0f);
        final List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add("Line " + i);
        }
        mListAdapter.notifyItems(items);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator lottieAnimator = ObjectAnimator.ofFloat(animationView,
                        "alpha", 1.0f, 0.0f);
                ObjectAnimator listAnimator = ObjectAnimator.ofFloat(listView,
                        "alpha", 0.0f, 1.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(lottieAnimator, listAnimator);
                animatorSet.start();
            }
        }, 5000);
    }
}
