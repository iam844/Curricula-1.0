package com.iam844.adityajaiswal.curricula.Sem4Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.iam844.adityajaiswal.curricula.Adapter.MaterialExpandableListAdapter;
import com.iam844.adityajaiswal.curricula.Model.DataURL;
import com.iam844.adityajaiswal.curricula.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OOT4Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oot4);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_oot4);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_oot4);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Object Oriented Technology");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.oot4_listView);
        initData();
        listAdapter = new MaterialExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                if(listHash.get(listDataHeader.get(i)).get(i1).getmURL() == null ){
                    Toast.makeText(getApplicationContext(), "Will be updated soon!", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(listHash.get(listDataHeader.get(i)).get(i1).getmURL()));
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(),
                            listDataHeader.get(i) + " : " + listHash.get(listDataHeader.get(i)).get(i1).getmName(),
                            Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

    }

    public void initData() {
        listDataHeader = new ArrayList<>();     //Group list
        listHash = new HashMap<>();             //Child List

        //Header
        listDataHeader.add("Class Materials");
        listDataHeader.add("Books");
        listDataHeader.add("Exam Papers");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("Constructor destructor","https://drive.google.com/open?id=1SxioCVbVXfeMXJbzKsmAGncIz-4zuWhM"));
        classMaterials.add(new DataURL("Exception Handling","https://drive.google.com/open?id=1pzU3urGz8RIUBL93-AmkUXcWYcO-lZh9"));
        classMaterials.add(new DataURL("Inheritance and Polymorphism","https://drive.google.com/open?id=1Nj0GuunrwxGErBdwERBZrm1gJliy5vCl"));
        classMaterials.add(new DataURL("OOP (Object Oriented Programming)","https://drive.google.com/open?id=1N1UKM7Ljy9NltjM0WLvrdF5htDqwgkkA"));
        classMaterials.add(new DataURL("Overloading","https://drive.google.com/open?id=1hdwHRGRosiVUuCJLoM9gN3oU0FOC0ICR"));
        classMaterials.add(new DataURL("SDLC","https://drive.google.com/open?id=18aYtlqvftfsKL_bruz0a7mrXdEEbbVPb"));
        classMaterials.add(new DataURL("Reference Notes","https://drive.google.com/open?id=1QkuRd1aBAC2lDVByCyy7BJHiNICR8Sm4"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Unified Modeling Language","https://drive.google.com/open?id=1JZ8SgpenSbwdxTFnlv_SWB3Ma8hMvUaM"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=1-DlIT_WEP09QomfR1-Xbhb828YcTipUe"));
//        examPapers.add(new DataURL("EndSem 19"));


        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}
