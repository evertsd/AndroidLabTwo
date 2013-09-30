package evertsd.todo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment{

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.detail_fragment, container, false);
		
		Bundle bundle = this.getArguments();
		
		String text = bundle.getString("text");
		
		TextView textView = (TextView) view.findViewById(R.id.todoName);
		
		textView.setText(text);
		
		return view;
	}
	
}
