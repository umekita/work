package jp.mixi.practice.intent.beg;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class NewActivity1 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		Toast.makeText(this, "NewActivity1", Toast.LENGTH_SHORT).show();
	}
}
