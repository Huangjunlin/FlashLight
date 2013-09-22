package com.king.flashlight;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button light_bt;
	private boolean isopen = false;
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 
		/*//±£³ÖÆÁÄ»»½ÐÑ
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, 
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);*/
		intent = new Intent(MainActivity.this,LightService.class);
		light_bt = (Button) findViewById(R.id.bt_light);
		light_bt.setOnClickListener(this);
	}

	
	@Override
	public void onClick(View view) {
		
		if (!isopen) {
			MainActivity.this.startService(intent);
			light_bt.setBackgroundResource(R.drawable.shou_on);
			isopen = true;
		}else {
			MainActivity.this.stopService(intent);
			light_bt.setBackgroundResource(R.drawable.shou_off);
			isopen = false;
		}
		
	}
	

	


	

}
