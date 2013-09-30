package evertsd.todo;

import java.util.ArrayList;

import evertsd.todo.ListFragment.OnSelectedItemListener;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ClickableArrayAdapter extends ArrayAdapter {
	
	private final Context context;
	private final OnSelectedItemListener listener;
	private final ArrayList<String> values;
	
	public ClickableArrayAdapter(Activity activity, int simpleListItem1,
			ArrayList<String> todoItems) {
		super(activity, simpleListItem1, todoItems);
		this.context = activity;
		
		if(activity instanceof OnSelectedItemListener)
		{
			listener = (OnSelectedItemListener)activity;
		}else
		{
			listener = null;
		}
		
		values = todoItems;
		// TODO Auto-generated constructor stub
	}

	public View getView(int position, View convertView, ViewGroup parent)
	{
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.todolist_rowlayout, parent, false);
		
		final Button button = (Button) rowView.findViewById(R.id.rowName);
		
		button.setText(values.get(position));
		Log.d("GetView: ", (String)button.getText());
		
		button.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				listener.onToDoListItemSelected((String)((Button)v).getText());
				Log.d("ButtonText: ", (String)((Button)v).getText());
			}
		});
		

		return rowView;
	}
}
