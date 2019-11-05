package com.example.demo.app.view.recycleview;

/**
 * Created by
 * desc: 多布局条目类型
 */

public interface MultipleType<T> {
    int getLayout(T item, int position);
}
