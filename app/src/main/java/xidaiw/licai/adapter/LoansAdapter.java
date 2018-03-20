package xidaiw.licai.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xidaiw.btj.R;

import java.util.List;

import xidaiw.licai.bean.LoanPageAdapter;
import xidaiw.widget.RoundProgressBar;


@SuppressLint("ResourceAsColor")
public class LoansAdapter extends BaseAdapter{

	private List<LoanPageAdapter.DataBean.ListBean> loanList;
	private int resource;
	private LayoutInflater inflater;
	private Context context;


	public LoansAdapter(Context context, List<LoanPageAdapter.DataBean.ListBean> loanList){
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.loanList = loanList;
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
		Viewholder holder=null;
		if (convertView==null){
			convertView=View.inflate(context, R.layout.productlist_items,null);
			holder=new Viewholder();
			holder.productName=convertView.findViewById(R.id.tv_productName);
			holder.interest=convertView.findViewById(R.id.tv_interest);
			holder.duration=convertView.findViewById(R.id.tv_duration);
			holder.totalAmount=convertView.findViewById(R.id.tv_amount);
			holder.finishRatio=convertView.findViewById(R.id.roundProgressBar);
			holder.progress1=convertView.findViewById(R.id.progress1);
			holder.progress2=convertView.findViewById(R.id.progress2);
			holder.progress3=convertView.findViewById(R.id.progress3);
			holder.bfh=convertView.findViewById(R.id.bfh);
			convertView.setTag(holder);
		}else {
			holder= (Viewholder) convertView.getTag();
		}
		holder.productName.setText(loanList.get(position).getProductName());
		holder.interest.setText(loanList.get(position).getInterest()+"");
		holder.duration.setText(loanList.get(position).getMaturityDuration());
		holder.totalAmount.setText(loanList.get(position).getTotalAmount()+"");
		switch (loanList.get(position).getProductStatus()){
			case "SALES"://销售中
				if (loanList.get(position).getProductTypeName()=="常规固定期限产品"){
					holder.progress1.setVisibility(View.VISIBLE);
					holder.progress2.setVisibility(View.GONE);
					holder.progress3.setVisibility(View.GONE);
					holder.finishRatio.setProgress(Float.parseFloat(loanList.get(position).getFinishRatio()));
					holder.interest.setTextColor(context.getResources().getColor(R.color.primary));
					holder.bfh.setTextColor(ContextCompat.getColor(context,R.color.primary));
				}

				break;
			case "LENDING"://已满标  还款中
				holder.progress1.setVisibility(View.GONE);
				holder.progress2.setVisibility(View.VISIBLE);
				holder.progress3.setVisibility(View.GONE);
				holder.interest.setTextColor(context.getResources().getColor(R.color.blue1));
				holder.bfh.setTextColor(ContextCompat.getColor(context,R.color.blue1));
				break;
			case "ENDED"://已还款
				holder.progress1.setVisibility(View.GONE);
				holder.progress2.setVisibility(View.GONE);
				holder.progress3.setVisibility(View.VISIBLE);
				holder.interest.setTextColor(context.getResources().getColor(R.color.blue1));
				holder.bfh.setTextColor(ContextCompat.getColor(context,R.color.blue1));
				break;
			case "SALES_OVER"://满标 未还款
				holder.progress1.setVisibility(View.GONE);
				holder.progress2.setVisibility(View.VISIBLE);
				holder.progress3.setVisibility(View.GONE);
				holder.interest.setTextColor(context.getResources().getColor(R.color.blue1));
				holder.bfh.setTextColor(ContextCompat.getColor(context,R.color.blue1));
				break;
		}
		return convertView;
	}
	private final class  Viewholder{
		public TextView productName;
		public TextView interest;
		public TextView duration;
		public TextView totalAmount;
		public RoundProgressBar finishRatio;
		public RelativeLayout progress1;
		public RelativeLayout progress2;
		public RelativeLayout progress3;
		public TextView bfh;
	}
	
}
