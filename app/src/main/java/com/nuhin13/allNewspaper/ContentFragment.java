package com.nuhin13.allNewspaper;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Admin on 04-06-2015.
 */
public class ContentFragment extends Fragment {


    ListView listView, listviwForBank;
    ArrayList<String> item, itemForBank;

    View rootView,rootViewForBank;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.bangla_newpaper, container,
                false);

        context = rootView.getContext();

        listView = (ListView) rootView.findViewById(R.id.listView1);

        item = new ArrayList<String>();

        item.add("Agrani Bank Limited");

        item.add("Sonali Bank Limited");

        item.add("Rupali Bank Limited");

        item.add("Janata Bank Limited");



        itemForBank = new ArrayList<String>();

        itemForBank.add("History");
        itemForBank.add("Bank Informations");
        itemForBank.add("Branches");

        CustomAdapter adapter = new CustomAdapter(getActivity(), item);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v,
                                    int position, long arg3) {
				/*
				 * Toast.makeText(getActivity().getApplicationContext(),
				 * item.get(position), Toast.LENGTH_LONG).show();
				 */

                if (position == 0) {
                    // Toast.makeText(getActivity().getApplicationContext(),
                    // "Agrani Paichi", Toast.LENGTH_LONG).show();

                    listView = (ListView) rootView.findViewById(R.id.listView1);
                    CustomAdapter adapterForBank = new CustomAdapter(getActivity(), itemForBank);
                    listView.setAdapter(adapterForBank);
                    listView.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapter, View v,
                                                int position, long arg3) {
                            if(position==0){

                                Toast.makeText(getActivity(), "hmm", Toast.LENGTH_SHORT).show();

                                //Intent inty = new Intent(getActivity(), Brances.class);
                                //startActivity(inty);
								/*Intent myIntent = new Intent(context.getApplicationContext(), PrivateBank.class);
								startActivity(myIntent);*/


							/*	//setContentView(R.layout.bank_info);
									rootViewForBank = inflater.inflate(R.layout.bank_info, container,
											true);

									v=rootViewForBank;

								try {

									InputStream is = context.getAssets().open("agrani_bank_history.txt");

									int size = is.available();

									byte[] buffer = new byte[size];

									is.read(buffer);

									is.close();

									String text = new String(buffer, "UTF-8");

									TextView tv = (TextView)v.findViewById(R.id.bank_info);
									//tv.setTypeface(Typeface.createFromAsset(context.getAssets(),
										//	"BenSenHandwriting.ttf"), Typeface.BOLD);
									//tv.setTextColor(Color.parseColor("#FFFFFF"));
									tv.setText(text);

								} catch (IOException e) {
									// Should never happen!
									throw new RuntimeException(e);
								}*/

                            }
                        }
                    });



                } else {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Pai nai", Toast.LENGTH_LONG).show();
                }

            }
        });

        return rootView;
    }
}
