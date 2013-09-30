package evertsd.todo;

import java.util.ArrayList;

import evertsd.todo.ListFragment.OnSelectedItemListener;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ToDoListActivity extends Activity implements OnSelectedItemListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_to_do_list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.to_do_list, menu);
		return true;
	}
	
	public void onToDoListItemSelected(String link)
	{
		DetailFragment fragment = (DetailFragment)getFragmentManager().findFragmentById(R.id.detailFragment);
		if(fragment != null && fragment.isInLayout())
			fragment.setText(link);
	}
	

}
