package evertsd.todo;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ListFragment extends Fragment {

	private OnSelectedItemListener listener;
	ArrayList<String> todoItems;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.list_fragment, container, false);
		
		ListView myListView = (ListView)view.findViewById(R.id.myListView);
		
		if(todoItems == null)
			todoItems = new ArrayList<String>();
		
		final ClickableArrayAdapter aa = new ClickableArrayAdapter(this.getActivity(), android.R.layout.simple_list_item_1, todoItems);
	
		myListView.setAdapter(aa);
		
		final EditText myEditText = (EditText)view.findViewById(R.id.myEditText);
		
		myEditText.setOnKeyListener(editListener(aa, todoItems, myEditText));
		
		return view;
	}
	
	public interface OnSelectedItemListener
	{
		public void onToDoListItemSelected(String item);
		public void replaceFragment(Fragment fragment);
	}
	
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		if(activity instanceof OnSelectedItemListener)
		{
			listener = (OnSelectedItemListener)activity;
		}
	}
	
	public void onDetach(){
		super.onDetach();
		listener = null;
	}
	
	private OnKeyListener editListener(final ArrayAdapter aa, final ArrayList<String> todoItems, final EditText myEditText)
	{
		OnKeyListener listen = new OnKeyListener()
		{
			public boolean onKey(View v, int keyCode, KeyEvent event)
			{
				if(event.getAction() == KeyEvent.ACTION_DOWN)
				{
					if(keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER)
					{
						todoItems.add(0, myEditText.getText().toString());
						aa.notifyDataSetChanged();
						myEditText.setText("");
						return true;
					}
				}
				return false;
			}
		};
		
		return listen;
	}

}
