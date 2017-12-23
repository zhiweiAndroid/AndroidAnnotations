package credit.sina.com.androidannotations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
//1.设置布局
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    //2.实例化控件
    @ViewById(R.id.tv)
    TextView tv;

    @ViewById(R.id.bt)
    Button btn;

    //3.定义常量
    @Extra
    String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //4.初始化控件显示
    @AfterViews
    void initViews(){
        tv.setText("你好");
    }

    //5.设置控件点击事件
    @Click(R.id.bt)
    void btnClick(){
       //6.打开新的Activity
        Main2Activity_.intent(this).start();
    }




}
