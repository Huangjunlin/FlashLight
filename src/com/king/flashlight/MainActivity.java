package com.king.flashlight;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private Button light_bt;
	private boolean isopen = false;
	private Camera camera;
	private Parameters pm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//±£³ÖÆÁÄ»»½ÐÑ
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, 
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		light_bt = (Button) findViewById(R.id.bt_light);
		light_bt.setOnClickListener(this);
	}

	
	@Override
	public void onClick(View view) {
		if (!isopen) {
			light_bt.setBackgroundResource(R.drawable.shou_on);
			camera = Camera.open();
			pm = camera.getParameters();
			pm.setFlashMode(Parameters.FLASH_MODE_TORCH);
			camera.setParameters(pm);
			isopen = true;
		}else {
			light_bt.setBackgroundResource(R.drawable.shou_off);
			pm.setFlashMode(Parameters.FLASH_MODE_OFF);
			camera.setParameters(pm);
			camera.release();
			camera = null;
			isopen = false;
		}
		
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

}
