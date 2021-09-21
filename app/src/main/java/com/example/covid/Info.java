package com.example.covid;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Info extends Fragment {

    Context context;
    WebView covid_wiki;
    RecyclerView covidNews;
    List<newsModel> newsModelList;
    newsAdaptor newsAdaptor;
    newsModel newsModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        context = view.getContext();
        covidNews = view.findViewById(R.id.covid_news);
        covidNews.setHasFixedSize(true);

        covid_wiki = view.findViewById(R.id.covid_wiki);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setReverseLayout(false);
        linearLayoutManager.setStackFromEnd(false);
        covidNews.setLayoutManager(linearLayoutManager);

        newsModelList = new ArrayList<>();
        fetchNews();

        covid_wiki.setWebViewClient(new WebViewClient());
        covid_wiki.getSettings().setJavaScriptEnabled(true);
        covid_wiki.loadUrl("https://www.webmd.com/lung/coronavirus");

        covid_wiki.canGoBack();
        covid_wiki.getSettings().setLoadsImagesAutomatically(true);
        covid_wiki.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        return view;
    }

    private void fetchNews() {
        String url = "https://saurav.tech/NewsAPI/top-headlines/category/health/in.json";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("articles");

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        String auth = jsonObject.get("author").toString(),
                                name = jsonObject.getJSONObject("source").get("name").toString(),
                                title = jsonObject.get("title").toString(),
                                url = jsonObject.get("url").toString(),
                                imgUrl = jsonObject.get("urlToImage").toString(),
                                con = jsonObject.get("content").toString(),
                                des = jsonObject.get("description").toString(),
                                pubAt = jsonObject.get("publishedAt").toString();

                        if (title.contains("covid") || title.contains("corona") || title.contains("COVID") || title.contains("CORONA")) {
                            newsModel = new newsModel(auth, name, title, url, imgUrl, des, con, pubAt);
                            newsModelList.add(newsModel);
                        }
                    }

                    newsAdaptor = new newsAdaptor(getContext(), newsModelList);
                    covidNews.setAdapter(newsAdaptor);

                } catch (JSONException e) {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
    }

}