package com.prajwal.hcmysore.jsscanlender2023.ui.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.prajwal.hcmysore.jsscanlender2023.R;
import com.prajwal.hcmysore.jsscanlender2023.databinding.FragmentHomeBinding;
import com.prajwal.hcmysore.jsscanlender2023.util.BannerAdListener;
import com.prajwal.hcmysore.jsscanlender2023.util.InterstitialSample;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    public Context context;
    Activity myActivity;
    int id=1;
    public  WebView myWebView;
    Spinner spinner;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context=root.getContext();
        myActivity= this.getActivity();


       // final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        myWebView = (WebView)root. findViewById(R.id.webviewhome);
          spinner =(Spinner)root.findViewById(R.id.spinner);
        try{
            myWebView.setWebViewClient(new   WebViewClient() {
                public void onLoadResource (WebView view, String url) {

                }
                public void onPageFinished(WebView view, String url) {
                    view.getSettings().setBuiltInZoomControls(true);
                    view.getSettings().setSupportZoom(true);
                    view.getSettings().setJavaScriptEnabled(true);
                    // injectCSS();
                }
            });


            //String html = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">";
            // myWebView.loadData(html, "text/html", "utf-8");
            // String url = i.getStringExtra("url");
            myWebView.loadUrl( "file:///android_asset/"+id+".html");




            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("January");
            arrayList.add("February");
            arrayList.add("March");
            arrayList.add("April");
            arrayList.add("May");
            arrayList.add("June");
            arrayList.add("July");
            arrayList.add("August");
            arrayList.add("September");
            arrayList.add("October");
            arrayList.add("November");
            arrayList.add("December");






            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, arrayList);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(arrayAdapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                   // string tutorialsName = parent.getItemAtPosition(position).toString();
                  id=position+1;
                    myWebView.loadUrl( "file:///android_asset/"+id+".html");

                }
                @Override
                public void onNothingSelected(AdapterView <?> parent) {
                }
            });





        }catch(Exception e){

        }


        BannerAdListener.BannerM(context,myActivity);



        inds =new InterstitialSample();
        inds.loadIntersitialads(context,myActivity);
        return root;



    }
    public InterstitialSample inds;
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        inds.showInterstitial(context,myActivity);
        binding = null;
    }
}