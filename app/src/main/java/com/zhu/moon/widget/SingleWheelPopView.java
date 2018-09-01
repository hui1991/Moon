package com.zhu.moon.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;
import com.zhu.moon.R;

import java.util.List;

/**
 *
 * Created by zhuguangjun on 2018/3/19.
 */

public class SingleWheelPopView implements View.OnClickListener {
    private View mView;
    private PopupWindow mPop;
    private Context mContext;
    /**
     * 取消
     */
    private TextView tvCancel;
    private TextView tvTextTip;
    /**
     * 确认
     */
    private TextView tvOk;
    private TextView tvSelect;

    private WheelView wheel;

    private List mList;

    public SingleWheelPopView(Context context , View view, PopupWindow popupWindow, TextView textView, List list, String tip) {
        mView = view;
        mPop = popupWindow;
        tvSelect = textView;
        mList = list;
        mContext = context;
        initView(tip);
        initListener();
    }

    private void initView(String tip) {
        tvCancel = (TextView) mView.findViewById(R.id.tvCancel);
        tvTextTip = (TextView) mView.findViewById(R.id.tvTextTip);
        tvOk = (TextView) mView.findViewById(R.id.tvOk);
        wheel = (WheelView) mView.findViewById(R.id.WheelViewSingle);
        wheel.setWheelAdapter(new ArrayWheelAdapter(mContext));
        wheel.setSkin(WheelView.Skin.None);
        WheelView.WheelViewStyle style = new WheelView.WheelViewStyle();
        style.selectedTextZoom = 1.5f;
        style.selectedTextSize = 20;
        style.textSize = 14;
        style.textAlpha = 0.5f;
        style.holoBorderColor = Color.GRAY;
        wheel.setStyle(style);
        wheel.setWheelData(mList);
        tvTextTip.setText(tip);
    }

    private void initListener(){
        tvCancel.setOnClickListener(this);
        tvOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvCancel:
                if (mPop.isShowing()){
                    mPop.dismiss();
                }
                break;
            case R.id.tvOk:
                tvSelect.setText(wheel.getSelectionItem().toString());
                if (mPop.isShowing()){
                    mPop.dismiss();
                }

                break;
        }
    }

}
