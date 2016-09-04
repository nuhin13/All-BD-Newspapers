package com.nuhin13.allNewspaper;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nuhin13 on 1/14/2016.
 */
public class CustomAdapter extends BaseAdapter {

    ArrayList<String> BankName;

    private Activity context;

    public CustomAdapter(Activity context, ArrayList<String> Bank) {

        // TODO Auto-generated constructor stub
        this.context = context;
        this.BankName = Bank;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return BankName.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.list_of_paper, parent, false);
        }

        TextView Bank_Name = (TextView) convertView
                .findViewById(R.id.bank_name);



        Bank_Name.setTypeface(Typeface.createFromAsset(context.getAssets(),
                "BenSenHandwriting.ttf"));
        Bank_Name.setTextColor(Color.parseColor("#FFFFFF"));


       /* Typeface face= Typeface.createFromAsset(context.getAssets(), "BenSenHandwriting.ttf");
        Bank_Name.setTypeface(face);
*/
        ImageView flag = (ImageView) convertView.findViewById(R.id.bank_image);

        String name = BankName.get(position);
        Bank_Name.setText(name);
        Bank_Name.setTextColor(Color.parseColor("#000000"));
        // time.setText(champion.get(position));

        if (name.contains("দৈনিক প্রথম আলো")) {

            flag.setImageResource(R.drawable.prothomalo);
        }

        else if (name.contains("দৈনিক ইত্তেফাক")) {

            flag.setImageResource(R.drawable.ittefaq);

        }

        else if (name.contains("দৈনিক আমারদেশ")) {

            flag.setImageResource(R.drawable.amardesh);

        } else if (name.contains("দৈনিক সমকাল")) {

            flag.setImageResource(R.drawable.samakal);

        }
        else if (name.contains("দৈনিক আমাদেরসময়")) {

            flag.setImageResource(R.drawable.amadershomoys);

        } else if (name.contains("দৈনিক নয়া-দিগন্ত")) {

            flag.setImageResource(R.drawable.nayadiganta);

        } else if (name.contains("দৈনিক কালের-কণ্ঠ")) {

            flag.setImageResource(R.drawable.kalerkantho);
        }

        else if (name.contains("দৈনিক যায়-যায় দিন")) {

            flag.setImageResource(R.drawable.jjdin);

        }

        else if (name.contains("দৈনিক বাংলাদেশ প্রতিদিন")) {

            flag.setImageResource(R.drawable.bd_pratidin);

        } else if (name.contains("দৈনিক ইনকিলাব")) {

            flag.setImageResource(R.drawable.dailyinqilab);

        } else if (name.contains("দৈনিক মানবজমিন")) {

            flag.setImageResource(R.drawable.mzamin);
        }

        else if (name.contains("দৈনিক সংগ্রাম")) {

            flag.setImageResource(R.drawable.songram);

        }

        else if (name.contains("দৈনিক ভোরের কাগজ")) {

            flag.setImageResource(R.drawable.vorer_kagoj);

        }
        if (name.contains("দৈনিক জণকন্ঠ")) {

            flag.setImageResource(R.drawable.janakantha);
        }

        else if (name.contains("দৈনিক যুগান্তর")) {

            flag.setImageResource(R.drawable.jugantor);

        }

        else if (name.contains("দৈনিক সংবাদ")) {

            flag.setImageResource(R.drawable.sangbad);

        } else if (name.contains("দৈনিক সকালের খবর")) {

            flag.setImageResource(R.drawable.shokalerkhobor);

        }
        else if (name.contains("দৈনিক গণকন্ঠ")) {

            flag.setImageResource(R.drawable.gonokantho);

        } else if (name.contains("দৈনিক বনিকবার্তা")) {

            flag.setImageResource(R.drawable.bonikbarta);

        } else if (name.contains("দৈনিক আমাদের অর্থনীতি")) {

            flag.setImageResource(R.drawable.amaderorthonete);
        }

        else if (name.contains("দৈনিক দিনকাল")) {

            flag.setImageResource(R.drawable.dailydinkal);

        }

        else if (name.contains("দৈনিক মানবকণ্ঠ")) {

            flag.setImageResource(R.drawable.manobkantha);

        } else if (name.contains("দৈনিক আলোকিত বাংলাদেশ")) {

            flag.setImageResource(R.drawable.alokito_bangladesh);

        } else if (name.contains("The Daily Independent")) {

            flag.setImageResource(R.drawable.theindependentbd);
        }

        else if (name.contains("The Daily Sun")) {

            flag.setImageResource(R.drawable.daily_sun);

        }

        else if (name.contains("The Daily Dhaka Tribune")) {

            flag.setImageResource(R.drawable.dhakatribune);

        }
        if (name.contains("The Daily Star")) {

            flag.setImageResource(R.drawable.thedailystar);
        }

        else if (name.contains("The Daily New Age")) {

            flag.setImageResource(R.drawable.newagebd);

        }

        else if (name.contains("The Daily Observer")) {

            flag.setImageResource(R.drawable.observerbd);

        } else if (name.contains("The Daily Bangladesh Today")) {

            flag.setImageResource(R.drawable.thebangladeshtoday);

        }
        else if (name.contains("The Daily Hawker")) {

            flag.setImageResource(R.drawable.hawker);

        } else if (name.contains("The Daily Gurdian")) {

            flag.setImageResource(R.drawable.theguardian);

        } else if (name.contains("The Daily News Today")) {

            flag.setImageResource(R.drawable.newstoday);
        }

        else if (name.contains("The Daily Prothom-alo")) {

            flag.setImageResource(R.drawable.prothomalo);

        }

        else if (name.contains("The Daily Financial Express")) {

            flag.setImageResource(R.drawable.thefinancialexpress);

        } else if (name.contains("The Daily Good Morning")) {

            flag.setImageResource(R.drawable.thegoodmorning);

        } else if (name.contains("The Daily Bd News24")) {

            flag.setImageResource(R.drawable.bdnews24);
        }

        else if (name.contains("The Daily Golf News")) {

            flag.setImageResource(R.drawable.gulf);

        }

        else if (name.contains("The Daily Economist")) {

            flag.setImageResource(R.drawable.economist);

        }
        if (name.contains("Bangla News24")) {

            flag.setImageResource(R.drawable.banglanews24);
        }

        else if (name.contains("Bd News24")) {

            flag.setImageResource(R.drawable.bdnews24);

        }

        else if (name.contains("Priyo")) {

            flag.setImageResource(R.drawable.priyo);

        } else if (name.contains("Bangla Mail24")) {

            flag.setImageResource(R.drawable.banglamail24);

        }
        else if (name.contains("Bangla Tribune")) {

            flag.setImageResource(R.drawable.banglatribune);

        } else if (name.contains("Barta Bangla")) {

            flag.setImageResource(R.drawable.bartabangla);

        } else if (name.contains("BBC Bangla")) {

            flag.setImageResource(R.drawable.bbc);
        }

        else if (name.contains("BD24 Live")) {

            flag.setImageResource(R.drawable.bd24live);

        }

        else if (name.contains("Dhaka Times")) {

            flag.setImageResource(R.drawable.dhakatimes24);

        } else if (name.contains("BD View24")) {

            flag.setImageResource(R.drawable.bdview24);

        } else if (name.contains("Sheersha News")) {

            flag.setImageResource(R.drawable.sheershanewsbd);
        }

        else if (name.contains("Poriborton")) {

            flag.setImageResource(R.drawable.poriborton);

        }

        else if (name.contains("Bss")) {

            flag.setImageResource(R.drawable.bssnews);

        }
        if (name.contains("Channel24")) {

            flag.setImageResource(R.drawable.channel24bd);
        }

        else if (name.contains("DMP News")) {

            flag.setImageResource(R.drawable.dmpnews);

        }

        else if (name.contains("Dnewsbd")) {

            flag.setImageResource(R.drawable.dnewsbd);

        } else if (name.contains("Independent TV")) {

            flag.setImageResource(R.drawable.independent24);

        }
        else if (name.contains("DW")) {

            flag.setImageResource(R.drawable.dw);

        } else if (name.contains("Jago News24")) {

            flag.setImageResource(R.drawable.jagonews24);

        } else if (name.contains("NTV")) {

            flag.setImageResource(R.drawable.ntvbd);
        }

        else if (name.contains("RTNN")) {

            flag.setImageResource(R.drawable.rtnn);

        }

        else if (name.contains("Risingbd")) {

            flag.setImageResource(R.drawable.risingbd);

        } else if (name.contains("Techtunes")) {

            flag.setImageResource(R.drawable.techtunes);

        } else if (name.contains("VOA")) {

            flag.setImageResource(R.drawable.voa);
        }

        else if (name.contains("Tuner Page")) {

            flag.setImageResource(R.drawable.tunerpage);

        }

        else if (name.contains("Somoyer Konthosor")) {

            flag.setImageResource(R.drawable.somoyerkonthosor);

        }



        else if (name.contains("Bangla Cricket")) {

            flag.setImageResource(R.drawable.banglacricket);

        } else if (name.contains("Bangladesh Khela")) {

            flag.setImageResource(R.drawable.bangladesherkhela);

        }
        else if (name.contains("Espn Cricinfo")) {

            flag.setImageResource(R.drawable.espncricinfo);

        } else if (name.contains("Espn Fc")) {

            flag.setImageResource(R.drawable.espnfc);

        } else if (name.contains("Fifa")) {

            flag.setImageResource(R.drawable.fifa);
        }

        else if (name.contains("Goal")) {

            flag.setImageResource(R.drawable.goal);

        }

        else if (name.contains("BBC Sports")) {

            flag.setImageResource(R.drawable.bbc_sports);

        } else if (name.contains("Bangladesh Cricket")) {

            flag.setImageResource(R.drawable.banglacricket);

        } else if (name.contains("Bangladesh Football")) {

            flag.setImageResource(R.drawable.banglafootball);
        }

        else if (name.contains("Khelar jagat")) {

            flag.setImageResource(R.drawable.khelarjagat);

        }

        else if (name.contains(" সিলেট ")) {

            flag.setImageResource(R.drawable.sylhet13);

        }
        else if (name.contains("চট্টগ্রাম")) {

            flag.setImageResource(R.drawable.chittagong);

        } else if (name.contains("খুলনা")) {

            flag.setImageResource(R.drawable.khulna);
        }

        else if (name.contains("রাজশাহী")) {

            flag.setImageResource(R.drawable.rajshahi);

        }
        else if (name.contains("অন্যান্য")) {

            flag.setImageResource(R.drawable.others);

        }


        else if (name.contains("সিলেটের আলাপ")) {

            flag.setImageResource(R.drawable.sylheteralap);

        } else if (name.contains("আমাদের সিলেট")) {

            flag.setImageResource(R.drawable.amadersylhet);
        }

        else if (name.contains(" সিলেটের সকাল ")) {

            flag.setImageResource(R.drawable.sylhetersokal);

        }

        else if (name.contains("ডেইলি সিলেট")) {

            flag.setImageResource(R.drawable.dailysylhet);

        }
        else if (name.contains("সিলেটের সংবাদ")) {

            flag.setImageResource(R.drawable.sylhetersongbad);

        }



        else if (name.contains("সিলেট এক্সপ্রেস ")) {

            flag.setImageResource(R.drawable.sylhet_express);

        } else if (name.contains("Sylhet News24")) {

            flag.setImageResource(R.drawable.sylhetnews24);
        }

        else if (name.contains("সিলেট নিউজ টাইম")) {

            flag.setImageResource(R.drawable.sylhetnewstimes);

        }else if (name.contains("সিলেট নিউজ ওয়াল্ড")) {

            flag.setImageResource(R.drawable.sylhetnewsworld);
        }

        else if (name.contains(" সিলেট রিপোর্ট্")) {

            flag.setImageResource(R.drawable.sylhetreport);

        }



        else if (name.contains("Sylhet View24")) {

            flag.setImageResource(R.drawable.sylhetview24);

        } else if (name.contains("Sylhet Watch24")) {

            flag.setImageResource(R.drawable.sylhetwatch24);
        }

        else if (name.contains("সুরমা টাইম")) {

            flag.setImageResource(R.drawable.surmatimes);

        }
        else if (name.contains("হবিগঞ্জ নিউজ ২৪")) {

            flag.setImageResource(R.drawable.habiganjnews24);

        }



        else if (name.contains("দৈনিক আজাদি")) {

            flag.setImageResource(R.drawable.dainikazadi);

        } else if (name.contains("দৈনিক পূর্বকোণ")) {

            flag.setImageResource(R.drawable.dainikpurbokone);
        }

        else if (name.contains("সুপ্রভাত বাংলাদেশ")) {

            flag.setImageResource(R.drawable.suprobhat);

        }

        else if (name.contains("দৈনিক পূর্বদেশ")) {

            flag.setImageResource(R.drawable.purbodesh);

        }
        else if (name.contains("চিটাগং ডেইলি ")) {

            flag.setImageResource(R.drawable.chittagongdaily);

        } else if (name.contains("Cakariya News")) {

            flag.setImageResource(R.drawable.chakarianews);
        }

        else if (name.contains("Cox's Baar News")) {

            flag.setImageResource(R.drawable.coxsbazarnews);

        }
        else if (name.contains("রামু নিউজ")) {

            flag.setImageResource(R.drawable.ramunews);

        }
        else if (name.contains("টেকনাফ নিউজ ")) {

            flag.setImageResource(R.drawable.teknafnews);

        }


        else if (name.contains("Khulna News")) {

            flag.setImageResource(R.drawable.khulnanews);

        } else if (name.contains("সাতক্ষিরা নিউজ")) {

            flag.setImageResource(R.drawable.satkhiranews);
        }

        else if (name.contains("দৈনিক পূর্বাচল ")) {

            flag.setImageResource(R.drawable.purbanchal);

        }
        else if (name.contains("আন্দোলনের বাজার ")) {

            flag.setImageResource(R.drawable.dailyandolonerbazar);

        }
        else if (name.contains("পত্রদুত ")) {

            flag.setImageResource(R.drawable.patradoot);

        }



        else if (name.contains("News Pabna")) {

            flag.setImageResource(R.drawable.newspabna);

        }
        else if (name.contains("দৈনিক করতোয়া")) {

            flag.setImageResource(R.drawable.karatoa);

        } else if (name.contains("সোনালী সংবাদ")) {

            flag.setImageResource(R.drawable.sonalisangbad);
        }

        else if (name.contains("মাথাভাঙ্গা")) {

            flag.setImageResource(R.drawable.mathabhanga);

        }
        else if (name.contains("মেহেরপুর সংবাদ")) {

            flag.setImageResource(R.drawable.meherpurnews);

        }
        else if (name.contains("সংবাদ কনিকা")) {

            flag.setImageResource(R.drawable.sangbadkonika);

        }



        else if (name.contains("দৈনিক পূর্বাচল ")) {

            flag.setImageResource(R.drawable.purbanchal);

        }
        else if (name.contains("আন্দোলনের বাজার ")) {

            flag.setImageResource(R.drawable.dailyandolonerbazar);

        }
        else if (name.contains("পত্রদুত ")) {

            flag.setImageResource(R.drawable.patradoot);

        }



        else if (name.contains("আজকের জামালপুর")) {

            flag.setImageResource(R.drawable.ajkerjamalpur);

        }
        else if (name.contains("চলমান নোয়াখালী")) {

            flag.setImageResource(R.drawable.chalomannoakhali);

        } else if (name.contains("গ্রামের কাগজ")) {

            flag.setImageResource(R.drawable.gramerkagoj);
        }

        else if (name.contains("লোক সংবাদ")) {

            flag.setImageResource(R.drawable.loksangbad);

        }
        else if (name.contains("দিনাজপুর নিউজ")) {

            flag.setImageResource(R.drawable.dinajpurnews);

        }
        else if (name.contains("United News")) {

            flag.setImageResource(R.drawable.unitednews24);

        }
        else if (name.contains("নতুন খবর")) {

            flag.setImageResource(R.drawable.notunkhobor);

        }





        else if (name.contains("সংবাদ কনিকা")) {

            flag.setImageResource(R.drawable.sangbadkonika);

        }



        else if (name.contains("দৈনিক পূর্বাচল ")) {

            flag.setImageResource(R.drawable.purbanchal);

        }
        else if (name.contains("আন্দোলনের বাজার ")) {

            flag.setImageResource(R.drawable.dailyandolonerbazar);

        }
        else if (name.contains("পত্রদুত ")) {

            flag.setImageResource(R.drawable.patradoot);

        }



        else if (name.contains("টেকটিউনস")) {

            flag.setImageResource(R.drawable.techtunes);

        }
        else if (name.contains("Tuner Page")) {

            flag.setImageResource(R.drawable.tunerpage);

        } else if (name.contains("প্রিয় টেক")) {

            flag.setImageResource(R.drawable.priyotech);
        }

        else if (name.contains("টেক্টুইটস")) {

            flag.setImageResource(R.drawable.techtweets);

        }
        else if (name.contains("বিজ্ঞান ও প্রযুক্তি")) {

            flag.setImageResource(R.drawable.biggan);

        }
        else if (name.contains("Teck Kotha")) {

            flag.setImageResource(R.drawable.techkotha);

        }
        else if (name.contains("মৌমাছি.net")) {

            flag.setImageResource(R.drawable.moumachi);

        }

        else if (name.contains("স্বপ্নবায.net")) {

            flag.setImageResource(R.drawable.sopnobaz);

        }
        else if (name.contains("Cricbuzz")) {

            flag.setImageResource(R.drawable.cricbuzz);

        }
        return convertView;
    }
}
