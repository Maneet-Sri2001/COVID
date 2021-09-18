package com.example.covid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Info extends Fragment {

    WebView covid_india, covid_state, covid_wiki;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        covid_india = view.findViewById(R.id.covid_news);
        covid_india.setWebViewClient(new WebViewClient());
        covid_state = view.findViewById(R.id.covid_state);
        covid_wiki = view.findViewById(R.id.covid_wiki);

        WebSettings webSettings = covid_india.getSettings();
        webSettings.setJavaScriptEnabled(true);
        covid_india.loadUrl("https://www.google.com/search?q=covid-19+news+in+india&biw=767&bih=712&tbm=nws&sxsrf=AOaemvL4m8w1pwMpPUxGCvXEYvOw9xQKwA%3A1631872629797&ei=dWZEYYePMKHVmAXhiaKoAg&oq=covid-19+news+in+&gs_l=psy-ab.3.1.0i512k1l10.618543.623538.0.625752.21.19.0.0.0.0.657.2080.0j3j4j5-1.8.0....0...1c.1.64.psy-ab..16.5.1411...0i67k1j0i512i433i131k1j0i433i131k1j0i433i131i273k1j0i273k1.0.lVBxgDH5I_w");
        if (covid_india.canGoBack())
            covid_india.goBack();
        return view;
    }

}