package com.android.msahakyan.fma.fragment;

import android.os.Bundle;
import android.view.View;

import com.android.msahakyan.fma.R;
import com.android.msahakyan.fma.util.Item;

import butterknife.Bind;

/**
 * Created by msahakyan on 07/08/16.
 */

public abstract class BaseItemDetailFragment<T extends Item> extends BaseLceFragment {

    protected static final String KEY_ITEM_PARCEL = "key_item_parcel";

    @Bind(R.id.main_detail_container)
    View mContentView;

    protected T mItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mItem = getArguments().getParcelable(KEY_ITEM_PARCEL);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setContentView(mContentView);

        if (mItem != null) {
            showBasicView();
            refresh();
        }
    }

    // Show basic view before related items will be loaded
    protected abstract void showBasicView();

    protected void setItem(T item) {
        mItem = item;
    }
}
