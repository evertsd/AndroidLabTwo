package evertsd.todo;

import java.util.ArrayList;

import evertsd.todo.ListFragment.OnSelectedItemListener;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ToDoListActivity extends Activity implements OnSelectedItemListener{

	ArrayList<String> todoItems;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if (savedInstanceState != null) {
		    todoItems = savedInstanceState.getStringArrayList("todoItems");
		}
		
		ListFragment fragment = new ListFragment();
		
		replaceFragment(fragment);
		
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
		DetailFragment fragment = new DetailFragment();
		
		Bundle bundle = new Bundle();
		
		bundle.putString("text", link);
		
		fragment.setArguments(bundle);
		
		replaceFragment(fragment);
	}
	
	public void replaceFragment(Fragment fragment)
	{
		fragment.setRetainInstance(false);
		
		FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
		
		transaction.replace(R.id.activity_to_do_fragment_holder, fragment);
		
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		
		transaction.addToBackStack(null);
		
		transaction.commit();
	}
	
	public ArrayList<String> getItems()
	{
		if(todoItems == null)
			todoItems = new ArrayList<String>();
		return todoItems;
	}
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		  super.onSaveInstanceState(savedInstanceState);
		  savedInstanceState.putStringArrayList("todoItems", todoItems);
	}

}
