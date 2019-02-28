package com.example.customviewlab.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.customviewlab.R;

public class MoneyView extends LinearLayout {
    private TextView textMoneyCurrency;
    private TextView textMoneyValue;

    private float currencySize;
    private float valueSize;
    private int defaultColor;
    private int negativeColor;
    private boolean enableChangeColor;
    private String value;

    public MoneyView(Context context) {
        super(context);
        init();
    }

    public MoneyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWithStyle(context, attrs);
    }

    public MoneyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initWithStyle(context, attrs);
    }


    private void init() {
        inflate(getContext(), R.layout.view_money, this);

        textMoneyCurrency = findViewById(R.id.text_money_currency);
        textMoneyCurrency.setTextSize(TypedValue.COMPLEX_UNIT_PX, currencySize);

        textMoneyValue = findViewById(R.id.text_money_value);
        textMoneyValue.setTextSize(TypedValue.COMPLEX_UNIT_PX, valueSize);

        setCurrency(R.string.default_currency);

        textMoneyCurrency.setTextColor(defaultColor);
        textMoneyValue.setTextColor(defaultColor);

        if (TextUtils.isEmpty(value)) {
            setValue(R.string.default_value);
        } else {
            setValue(value);
        }
    }

    private void initWithStyle(final Context context, final AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MoneyView);

        currencySize = typedArray.getDimensionPixelSize(R.styleable.MoneyView_mv_currencySize, getResources().getDimensionPixelSize(R.dimen.dimen_text_15_sp));
        valueSize = typedArray.getDimensionPixelSize(R.styleable.MoneyView_mv_valueSize, getResources().getDimensionPixelSize(R.dimen.dimen_text_15_sp));

        defaultColor = typedArray.getColor(R.styleable.MoneyView_mv_defaultColor, ContextCompat.getColor(getContext(), R.color.black));
        negativeColor = typedArray.getColor(R.styleable.MoneyView_mv_negativeColor, ContextCompat.getColor(getContext(), R.color.red));

        value = typedArray.getString(R.styleable.MoneyView_mv_value);
        enableChangeColor = typedArray.getBoolean(R.styleable.MoneyView_mv_enableChangeColor, Boolean.TRUE);

        typedArray.recycle();
        init();
    }

    public void setCurrency(@StringRes int text) {
        textMoneyCurrency.setText(text);
    }

    public void setCurrency(String text) {
        textMoneyCurrency.setText(text);
    }

    public void setValue(@StringRes int value) {
        textMoneyValue.setText(value);
    }

    public void setValue(String value) {
        textMoneyValue.setText(value);
    }
}
