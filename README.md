# AndroidAnnotations
AndroidAnnotations配置及使用

### 准备工作

1.在Android Studio中新建一个Android项目
2.在工程gradle.build文件中加入androidannotations依赖，更新gradle，使在工程中可以成功引用相关方法
在工程build.gradle(最外层)文件dependencies中添加：

```
dependencies {
      classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8+'
}
```

在app/build.gradle文件中添加：

```
apply plugin: 'android-apt'
def AAVersion = '4.0+'  // 可根据需要修改版本号

dependencies {
    //配置【2】Android annotations
    apt "org.androidannotations:androidannotations:$AAVersion"
    compile "org.androidannotations:androidannotations-api:$AAVersion"
}

//配置【3】Android annotations
apt {
    arguments {
        androidManifestFile variant.outputs[0].processResources.manifestFile
        resourcePackageName 'credit.sina.com.androidannotations'
    }
}
```

此时同步下工程gradle下载文件，等下载完毕准备工作就完成了。

### 开始使用

接下来通过对比原来写法和现在写法来方便记录使用方法

1.设置布局

```
@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

```

2.实例化控件
`TextView textview = (TextView) findViewById(R.id.tv_id);`  
现在写法

```
 @ViewById(R.id.tv)
 TextView tv;
```

3.初始化控件显示

```
@AfterViews
void initViews() {
    // 初始化控件
    tv.setText("你好");
}
```

4.设置控件点击事件

```
@Click(R.id.bt)
void btnClick() {
    // do something
}
```

5.定义常量

```
@Extra
String name;   // 可被外部访问到
```

6.打开新的Activity

```
Main2Activity_.intent(this).start(); // 不带参数
Main2Activity_.intent(this).mInfoStr("this is infoStr.").start(); // 带参数
```

7.控件ListView的使用，含adapter（代码较多，请直接看Demo）

8.在AndroidManifest.xml定义方式

类名加下划线

```
<activity android:name=".Main2Activity_"></activity>
```

更多使用方法和方式请参考:
[Cookbook](https://link.jianshu.com?t=https://github.com/excilys/androidannotations/wiki/Cookbook)   
[AvailableAnnotations](https://link.jianshu.com?t=https://github.com/excilys/androidannotations/wiki/AvailableAnnotations)

### 总结

使用androidannotations
优点：减少了代码量，监听事件更容易看懂；
缺点：有新的变量需要编译更新，否则显示红色的错误提示。

