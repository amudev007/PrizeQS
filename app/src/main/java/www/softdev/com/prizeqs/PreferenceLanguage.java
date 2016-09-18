package www.softdev.com.prizeqs;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.app.NavigationPolicy;
import com.heinrichreimersoftware.materialintro.app.OnNavigationBlockedListener;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

import www.softdev.com.prizeqs.Classes.FoodDatabase;

public class PreferenceLanguage extends IntroActivity {

    SharedPreferences app_first_time;
    Boolean check_first;

    FoodDatabase fd;
    String indian, italian, mexican, chinese, american, common;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_language);
        fd = new FoodDatabase(this);

        indian = "Indian";
        italian = "Italian";
        mexican = "Mexican";
        american = "American";
        chinese = "Chinese";
        common = "Common";

        app_first_time = getSharedPreferences("FitnessnMotion", MODE_WORLD_READABLE);

        check_first = app_first_time.getBoolean("first", true);
/**
 * Standard slide (like Google's intros)
 */

            addSlide(new SimpleSlide.Builder()
                    .title(R.string.dummy_content)
                    .description(R.string.dummy_button)
                    .image(R.drawable.welcome_01)
                    .background(R.color.black_overlay)
                    .backgroundDark(R.color.colorPrimary)
                    .permission(Manifest.permission.CAMERA)
                    .build());


      /* Enable/disable fullscreen */
        setFullscreen(true);



        /* Enable/disable skip button */
        setSkipEnabled(true);

        /* Enable/disable finish button */
        setFinishEnabled(true);

        /* Add a navigation policy to define when users can go forward/backward */
        setNavigationPolicy(new NavigationPolicy() {
            @Override
            public boolean canGoForward(int position) {
                return true;
            }

            @Override
            public boolean canGoBackward(int position) {
                return false;
            }
        });

        /* Add a listener to detect when users try to go to a page they can't go to */
        addOnNavigationBlockedListener(new OnNavigationBlockedListener() {
            @Override
            public void onNavigationBlocked(int position, int direction) {
            }
        });

        /* Add your own page change listeners */
        addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


    public void InsertIntoDatabase() {
        fd.open();

        fd.clearDatabase();

        fd.Insert("Aloo Chaat", 50, 5, 0.2, 1.3, 13, indian, 231);
        fd.Insert("Aloo Channa Chat", 34, 6, 0, 2, 16.2, indian, 170);
        fd.Insert("Aloo Gobi", 23, 6, 3.1, 14, 126, indian, 239);
        fd.Insert("Aloo Paratha", 47, 18, 4, 11, 99, indian, 360);
        fd.Insert("Aloo Tikki", 28, 3, 2, 8.2, 74, indian, 196);
        fd.Insert("Bhajji", 0, 0, 3, 27, 185, indian, 350);
        fd.Insert("Bhel", 61, 10, 3.4, 15, 135, indian, 415);
        fd.Insert("Buttermilk", 1, 1, 0, 2, 3.6, indian, 19);
        fd.Insert("Curd", 0, 3, 0, 4, 10, indian, 60);
        fd.Insert("Chapathi", 22, 4, 1.6, 4.5, 41, indian, 137);
        fd.Insert("Channa Masala", 0, 0, 0, 0, 91, indian, 158);
        fd.Insert("Chicken Tikka", 2, 27, 0, 16, 144, indian, 260);

        fd.close();

    }
}