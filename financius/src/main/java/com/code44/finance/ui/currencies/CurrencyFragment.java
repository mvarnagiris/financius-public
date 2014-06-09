package com.code44.finance.ui.currencies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.code44.finance.R;
import com.code44.finance.db.model.Currency;
import com.code44.finance.providers.BaseModelProvider;
import com.code44.finance.providers.CurrenciesProvider;
import com.code44.finance.ui.ModelFragment;

public class CurrencyFragment extends ModelFragment<Currency> {
    private TextView code_TV;

    public static CurrencyFragment newInstance(long currencyId) {
        final Bundle args = makeArgs(currencyId);

        final CurrencyFragment fragment = new CurrencyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_currency, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get view
        code_TV = (TextView) view.findViewById(R.id.code_TV);
    }

    @Override
    protected Class<? extends BaseModelProvider<Currency>> getModelProviderClass() {
        return CurrenciesProvider.class;
    }

    @Override
    protected Class<Currency> getModelClass() {
        return Currency.class;
    }

    @Override
    protected void onModelLoaded(Currency currency) {
        code_TV.setText(currency.getCode());
    }
}