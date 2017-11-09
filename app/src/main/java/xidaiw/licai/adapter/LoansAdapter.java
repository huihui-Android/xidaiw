package xidaiw.licai.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import xidaiw.licai.bean.Loan;

@SuppressLint("ResourceAsColor")
public class LoansAdapter extends BaseAdapter{

	private List<Loan> loanList;
	private int resource;
	private LayoutInflater inflater;
	private Context context;


	public LoansAdapter(Context context, int resource, List<Loan> loanList){
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.loanList = loanList;
		this.resource = resource;
		this.context = context;
	}
	@Override
	public int getCount() {
		return loanList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return loanList.get(arg0);
	}

	@Override
	public long getItemId(int arg0){
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return convertView;


	}


	
}
