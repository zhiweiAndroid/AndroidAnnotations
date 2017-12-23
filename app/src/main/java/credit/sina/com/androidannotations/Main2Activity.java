package credit.sina.com.androidannotations;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main2)
public class Main2Activity extends AppCompatActivity {

    @AfterViews
    void initViews(){

    }

}
