package tvalpha.com.zero.textviewbkalphademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    TextView text1, text2;
    SeekBar seekBar;
    CheckBox checkBox1, checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(this);
        checkBox1= (CheckBox) findViewById(R.id.checkbox1);
        checkBox2= (CheckBox) findViewById(R.id.checkbox2);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        if (checkBox1.isChecked()) {
            Log.i("onProgressChanged", "onProgressChanged: " + i);
            text1.getBackground().setAlpha(i);
        } else if (checkBox2.isChecked()){
            text1.getBackground().mutate().setAlpha(i);
        }
        //刷新textview  以便显示正确效果
        text2.invalidate();
        text1.setText("背景透明度值：" + text1.getBackground().getAlpha());
        text2.setText("背景透明度值：" + text2.getBackground().getAlpha());
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
