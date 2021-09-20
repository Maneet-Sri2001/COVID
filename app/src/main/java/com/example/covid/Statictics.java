package com.example.covid;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Statictics extends Fragment {

    TextView cases, todCases, death, todDeath, acitve, recovered, critical;
    TextView casesInd, todCasesInd, deathInd, todDeathInd, acitveInd, recoveredInd, criticalInd;
    RecyclerView stateList;

    Context context;

    public static List<stateModal> stateModalList;
    stateModal modal;
    stateAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statictics, container, false);

        context = view.getContext();

        stateList = view.findViewById(R.id.state_list_view);
        stateList.setHasFixedSize(true);
        cases = view.findViewById(R.id.cases);
        todCases = view.findViewById(R.id.today_cases);
        death = view.findViewById(R.id.death);
        todDeath = view.findViewById(R.id.today_death);
        acitve = view.findViewById(R.id.active);
        recovered = view.findViewById(R.id.recovered);
        critical = view.findViewById(R.id.serious);

        casesInd = view.findViewById(R.id.ind_cases);
        todCasesInd = view.findViewById(R.id.ind_today_cases);
        deathInd = view.findViewById(R.id.ind_death);
        todDeathInd = view.findViewById(R.id.ind_today_death);
        acitveInd = view.findViewById(R.id.ind_active);
        recoveredInd = view.findViewById(R.id.ind_recovered);
        criticalInd = view.findViewById(R.id.ind_serious);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setReverseLayout(false);
        linearLayoutManager.setStackFromEnd(false);
        stateList.setLayoutManager(linearLayoutManager);

        fetchDataGlobal();
        fetchDataIndia();

        stateModalList = new ArrayList<>();
        fetchDataIndiaCity();
        return view;
    }

    private void fetchDataIndiaCity() {

        String url = "https://disease.sh/v3/covid-19/gov/india";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("states");

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        String state = jsonObject.get("state").toString(),
                                cases = jsonObject.get("cases").toString(),
                                todcases = jsonObject.get("todayCases").toString(),
                                death = jsonObject.get("deaths").toString(),
                                todDeath = jsonObject.get("todayDeaths").toString(),
                                rec= jsonObject.get("recovered").toString(),
                                todRec= jsonObject.get("todayRecovered").toString();

                        modal = new stateModal(cases, todcases, death, todDeath, rec, todRec, state);
                        stateModalList.add(modal);
                        }

                    adapter = new stateAdapter(context, stateModalList);
                    stateList.setAdapter(adapter);

                    }
                 catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);

    }

    private void fetchDataGlobal() {

        String url = "https://disease.sh/v3/covid-19/all";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response.toString());
                    cases.setText(object.getString("cases"));
                    todCases.setText(object.getString("todayCases"));
                    death.setText(object.getString("deaths"));
                    todDeath.setText(object.getString("todayDeaths"));
                    acitve.setText(object.getString("active"));
                    recovered.setText(object.getString("recovered"));
                    critical.setText(object.getString("critical"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);

    }

    private void fetchDataIndia() {

        String url = "https://disease.sh/v3/covid-19/countries/india";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response.toString());
                    casesInd.setText(object.getString("cases"));
                    todCasesInd.setText(object.getString("todayCases"));
                    deathInd.setText(object.getString("deaths"));
                    todDeathInd.setText(object.getString("todayDeaths"));
                    acitveInd.setText(object.getString("active"));
                    recoveredInd.setText(object.getString("recovered"));
                    criticalInd.setText(object.getString("critical"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);

    }

}