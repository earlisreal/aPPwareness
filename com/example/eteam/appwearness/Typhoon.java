package com.example.eteam.appwearness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.github.paolorotolo.appintro.BuildConfig;
import com.github.paolorotolo.appintro.C0394R;

public class Typhoon extends AppCompatActivity {
    String[] after;
    TextView aftert;
    String[] before;
    TextView beforet;
    String[] description;
    TextView descriptiont;
    String[] during;
    TextView duringt;
    String[] title;
    TextView titlet;

    /* renamed from: com.example.eteam.appwearness.Typhoon.1 */
    class C03671 implements OnClickListener {
        C03671() {
        }

        public void onClick(View v) {
            Typhoon.this.finish();
        }
    }

    /* renamed from: com.example.eteam.appwearness.Typhoon.2 */
    class C03682 implements OnClickListener {
        C03682() {
        }

        public void onClick(View v) {
            Typhoon.this.startActivity(new Intent("com.example.anthony.visualrecog.MainActivity"));
        }
    }

    public Typhoon() {
        this.title = new String[]{"TYPHOONS", "FIRE", "EARTHQUAKE", "LANDSLIDES", "STORM SURGE", "VOLCANO"};
        this.description = new String[]{"The term \u201cTyphoon\u201d is a mature tropical cyclone that develops in the Northwest Pacific for a severe (or mature) tropical cyclone\n\nTyphoons are associated with a spiral inflow of mass at the bottom level and spiral outflow at the top level usually over oceans that produce strong winds, heavy rain and thunderstorms.\n\nThey are classified according to their strength which is determined by the speed of the maximum sustained winds near the center (30 KPH to > 185 KPH)\n", "The greatest cause of death are home fires. Most fire deaths are preventable with careful action. It is important to safeguard your home and be prepared to evacuate should there be a fire.\n", "An earthquake is a sudden, rapid shaking of the ground caused by the shifting of rocks beneath the earth\u2019s surface. Earthquakes strike suddenly, without warning, and can occur at any time of the year \u2013 day or night.", "A landslide refers to a downhill movement of mud, rocks, soil, and other debris. It can be slow and capable of causing gradual damage or fast and capable of quickly destroying anything in its path. A majority of landslides are caused by heavy rains, earthquake, snowmelt and other natural forces.\n\nLandslides tend to occur in the same area. During rainstorms, a sudden or gradual flow of debris onto roads is common. Areas that become highly saturated with water have higher chances of debris and mud flows.\n", "Storm surge can occur along all coastal areas of Canada. It can also occur in large lakes, such as the Great Lakes. A storm surge consists of very high waves and high water levels caused by wind and air pressure. It often results in coastal flooding. A storm surge can occur at any time of the year and can be particularly damaging in icy waters of winter.\n\nStorm surges can happen quickly, without allowing much time for preparation. Residents, particularly those living in low-lying areas near the coastline, should prepare in advance.\n", "Volcanic eruptions happen with early warnings unlike earthquakes that are sudden. There are early warning signs before a volcano erupts so there is at least time for residents around the volcano to prepare before the actual eruption occurs. People should know that before a volcano erupts there are warning signs such as rumbling sounds, continuous emissions of steam, increasing temperature around the volcano that results to withering of plants around and unusual behaviors of animals and earthquakes."};
        this.before = new String[]{"Prepare for a typhoon\n\n|Store food and clean potable water.\n\n|Make sure that you have emergency battery operated lights and a transistor radio ready and handy.\n\n|Monitor TV and radio stations for weather updates.\n\n|Check your house for structures that needs retrofitting or repair and strengthen it when necessary to withstand the strong winds.\n\n|Herd domestic animals to safe grounds. If you have agricultural crops that can already be harvested, harvest them before the typhoon strike.\n\n|If you live in an area that is frequently flooded, near mountains, near riverbanks or near the sea, you must have your lifeline kit ready for grab should an evacuation be required.\n\n|Small fishing boats or vessels should be well-anchored in/to safer areas.\n", "|Eliminate the hazard through good housekeeping\n\n|Oil or gas lamps and candles should be placed away from curtains or flammable materials\n\n|PUT OUT THE FLAME before going to bed.\n\n|NEVER leave a lighted cigarette/cigar/pipe unattended\n\n|Do not keep FLAMMABLE materials like gasoline, kerosene, alcohol and paint inside the house\n\n|Regularly CHECK your electrical installations and have all threadbare wirings and electrical equipment changed or repaired by a licensed electrician.\n", BuildConfig.FLAVOR, "|To begin preparing, you should build an emergency kit and make a family communications plan.\n\n|Prepare for landslides by following proper land-use procedures - avoid building near steep slopes, close to mountain edges, near drainage ways or along natural erosion valleys.\n\n|Become familiar with the land around you. Learn whether debris flows have occurred in your area by contacting local officials. Slopes where debris flows have occurred in the past are likely to experience them in the future.\n\n|Get a ground assessment of your property.\n\n|Consult a professional for advice on appropriate preventative measures for your home or business, such as flexible pipe fittings, which can better resist breakage.\n|Protect your property by planting ground cover on slopes and building retaining walls.\n\n|In mudflow areas, build channels or deflection walls to direct the flow around buildings. Be aware, however, if you build walls to divert debris flow and the flow lands on a neighbor's property, you may be liable for damages.\n", "|Check your house and land for any potential dangers related to flooding. Identify any vulnerability and repair it.\n\n|Sandbags are a valuable tool to prevent water from entering your home. This approach requires specific instructions from your local emergency officials.\n\n|Learn how to turn off the gas and electricity in your house. You may be instructed by local authorities to shut these off.\n\n|If you live in an area that is subject to flooding, do not store your important documents in the basement. \n\n|Keep them at a higher level, protected from flood damage.\n\n|Ensure that your family has an emergency kit and plan.\n\n|Ensure your emergency kit is portable, in a back-pack or suitcase with wheels.\n", "|Each one should be aware of the dangers that volcanic eruptions pose to lives and be prepared to face whatever circumstances the eruption may bring.\n\n|Prepare all necessary things to bring once evacuation is needed. Those in danger zones are warned when to evacuate. Once given the signal refrain from saying you will be all right. Refusing to evacuate will pose more serious problems.\n\n|Store as much food, water, light sources and batteries that are very useful in case of emergency.\n\n|Volcanic eruptions have ash falls so be prepared for masks or anything to cover nose and mouth.\n\n|Prioritize the safety of kids before other things. If you have relatives or friends who are far from the volcano, take your children there until such time that your place is safe.\n"};
        this.during = new String[]{"|Monitor the news and weather forecast on radio and TV to get the latest information\n\n|Stay indoors all the time unless you are told to evacuate to the nearest evacuation center.\n\n|Boil tap water\n\n|Ensure that candles or lanterns are kept away from flammable objects or materials when using them.\n\n|Never walk in or expose yourself unnecessarily to flood waters\n\n|If you need to evacuate, be calm and move in an orderly and safe manner.\n", "|If you see smoke or fire, immediately find the nearest fire exit nearest you.\n\n|Before the fire gets out of control, if you have close access to a fire extinguisher or a bucket full of sand, use it to put out the fire.\n\n|Cover with a very wet blanket / cloth or throw a bucketful of sand to put out fire caused by faulty electrical wiring, gasoline or petrol, never douse with water.\n\n|If you must exit through smoke, crawl to your nearest exit.\n\n|If the cause or source of fire is electrical in nature, immediately turn off the main power switch.\n", "|Trust your senses. Assume that the first shaking you feel is an earthquake\n\n|Move away from hazardous objects\n\n|Extinguish any and all flames\n\n|If you are near an exit door, open it a little so that if it becomes misshapen it will not be stuck closed.\n\n|Remain calm.\n\nIf you are indoors:\n|Drop, cover and hold on.\n\n|Stay indoors until the shaking stops and you are sure it is safe to exit\n\n|If you are on the ground floor of an adobe house with heavy roof, exit quickly\n\nIf you are outdoors:\n|Find a clear spot away from overhead hazards\n\n|Drop, cover and hold on and stay there until the shaking stops.\n\n|Stay outside and remain in open areas away from hazards\n", "|Listen to local news stations on a battery-powered radio for warnings of heavy rainfall.\n\n|Listen for unusual sounds that might indicate moving debris, such as trees cracking or boulders knocking together.\n\n|Move away from the path of a landslide or debris flow as quickly as possible. The danger from a mudflow increases near stream channels and with prolonged heavy rains. Mudflows can move faster than you can walk or run. Look upstream before crossing a bridge and do not cross the bridge if a mudflow is approaching.\n\n|Avoid river valleys and low-lying areas.\n\n|If you are near a stream or channel, be alert for any sudden increase or decrease in water flow and notice whether the water changes from clear to muddy. Such changes may mean there is debris flow activity upstream so be prepared to move quickly.\n\n|Curl into a tight ball and protect your head if escape is not possible.\n", "|Stay inside where you are protected from the water. It's best to be on the downwind side of the house, away from windows.\n\n|Monitor the storm's progress and listen for warnings or instructions from local officials.\n\n|Before driving anywhere, listen carefully to rescue officials who will be coordinating evacuation plans.\n\n|Do not drive through flood waters.\n\n|Be aware of risks such as hypothermia from cold water or drowning from running water.\n", "|Avoid all low-lying places because lava flows and mudflows are more likely to pass here.\n\n|Seek cover in case of ash falls rock falls.\n\n|Use masks and cover your mouth and nose to avoid breathing in ashes.\n\n|If you are inside a house; close all doors and windows to avoid ashes from getting inside.\n\n|Always stay indoors.\n\n|Stay in the evacuation center until further instructions. Do not attempt to leave the place unless told to do.\n\n|Keep a watchful eye on the kids because they might be tempted to go out and see what\u2019s going on outside.\n"};
        this.after = new String[]{"|return home only when local authorities have declared that your area is safe.\n\n|Stay away from power lines and electrical wires.\n\n|Before entering your homes, look for loose power lines and other damage.\n\n|Look out for wild animals especially snakes.\n\n|Throw away or empty containers that have accumulated water as this is a breeding ground for mosquitos.\n", "|Immediately go to the nearest clinic or hospital if you have burn injuries or have inhaled smoke.\n\n|Even if the building or house did not totally burn down, never enter the premises until you are sure that the structure is still sound and it is safe from falling debris.\n", "|Expect aftershock\n|Check for damage and stay out of damaged buildings\n\n|Extinguish flames and put out small fires\n\n|Look for and prevent fire hazards\n", "|Go to a designated public shelter if you have been told to evacuate or you feel it is unsafe to remain in your home. \n\n|Stay away from the slide area. There may be danger of additional slides.\n\n|Listen to local radio or television stations for the latest emergency information.\n\n|Watch for flooding, which may occur after a landslide or debris flow. Floods sometimes follow landslides and debris flows because they may both be started by the same event.\n\n|Check for injured and trapped persons near the slide, without entering the direct slide area. Direct rescuers to their locations.\n\n|Look for and report broken utility lines and damaged roadways and railways to appropriate authorities. \n|Reporting potential hazards will get the utilities turned off as quickly as possible, preventing further hazard and injury.\n\n|Check the building foundation, chimney, and surrounding land for damage. Damage to foundations, chimneys, or surrounding land may help you assess the safety of the area.\n\n|Replant damaged ground as soon as possible since erosion caused by loss of ground cover can lead to flash flooding and additional landslides in the near future.\n\n|Seek advice from a geotechnical expert for evaluating landslide hazards or designing corrective techniques to reduce landslide risk. A professional will be able to advise you of the best ways to prevent or reduce landslide risk, without creating further hazard.\n", BuildConfig.FLAVOR, "|Go back to your house but leave the kids behind someone who can take care of them while you check your house.\n\n|Clean everything around and check all damages incurred.\n\n|Use masks while cleaning ash and other debris.\n\n|Wait for further announcements related to the volcano activities.\n\n|Make sure that your house is still safe for all of you.\n"};
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0361R.layout.activity_typhoon);
        this.titlet = (TextView) findViewById(C0394R.id.title);
        this.descriptiont = (TextView) findViewById(C0394R.id.description);
        this.beforet = (TextView) findViewById(C0361R.id.before);
        this.duringt = (TextView) findViewById(C0361R.id.during);
        this.aftert = (TextView) findViewById(C0361R.id.after);
        int s = getIntent().getExtras().getInt("index");
        if (s == 6) {
            s = 0;
        }
        loadInfo(s);
        Toolbar tb = (Toolbar) findViewById(C0361R.id.toolbartyp);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tb.setNavigationOnClickListener(new C03671());
        ((Button) findViewById(C0361R.id.btnTyphoon)).setOnClickListener(new C03682());
    }

    private void loadInfo(int index) {
        this.titlet.setText(this.title[index]);
        this.descriptiont.setText(this.description[index]);
        this.beforet.setText(this.before[index]);
        this.duringt.setText(this.during[index]);
        this.aftert.setText(this.after[index]);
    }
}
