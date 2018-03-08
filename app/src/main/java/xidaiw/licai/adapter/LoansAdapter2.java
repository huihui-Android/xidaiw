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
public class LoansAdapter2 extends BaseAdapter{

	private List<LoanPageAdapter.DataBean.ListBean> loanList;
	private int resource;
	private LayoutInflater inflater;
	private Context context;
	public static final int SHORT_TASTE_PRODUCT = 0;
	public static final int FIXED_TERM_PRODUCT = 1;


	public LoansAdapter2(Context context, int resource, List<LoanPageAdapter.DataBean.ListBean> loanList){
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.loanList = loanList;
		this.resource = resource;
		this.context = context;
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public int getItemViewType(int position) {
		LoanPageAdapter.DataBean.ListBean listBean = loanList.get(position);
		String productTypeName = listBean.getProductTypeName();
		switch (productTypeName){
			case "短期体验产品":
				return SHORT_TASTE_PRODUCT;
			case "常规固定期限产品":
				return FIXED_TERM_PRODUCT;
		}
		return super.getItemViewType(position);
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
		TextView productName;//标的名称
		TextView interest;//总利率
		TextView bfh;//百分号的符号%
		TextView maxInterest;//最大利率
		TextView awardInterest;//奖励利率
		TextView normalInterest;//正常利率
		TextView maturityDuration;//投资期限
		TextView id;//标的id
		TextView totalAmount;//标的的总金额
		RoundProgressBar finishRatio;//销售进度
		RelativeLayout progress1;//进度一
		RelativeLayout progress2;//进度一
		RelativeLayout progress3;//进度一
		LoanPageAdapter.DataBean.ListBean loan = (LoanPageAdapter.DataBean.ListBean) getItem(position);
		if (convertView==null){
			convertView=inflater.inflate(resource,null);
			productName = convertView.findViewById(R.id.tv_productName);
			interest=convertView.findViewById(R.id.tv_interest);
			maturityDuration=convertView.findViewById(R.id.tv_duration);
			totalAmount=convertView.findViewById(R.id.tv_amount);
			finishRatio=convertView.findViewById(R.id.roundProgressBar);
			progress1=convertView.findViewById(R.id.progress1);
			progress2=convertView.findViewById(R.id.progress2);
			progress3=convertView.findViewById(R.id.progress3);
			bfh=convertView.findViewById(R.id.bfh);
			Viewholder holder=new Viewholder();
			holder.productName=productName;
			holder.interest=interest;
			holder.bfh=bfh;
			holder.maturityDuration=maturityDuration;
			holder.totalAmount=totalAmount;
			holder.finishRatio=finishRatio;
			holder.progress1=progress1;
			holder.progress2=progress2;
			holder.progress3=progress3;
			convertView.setTag(holder);
		}else {
			Viewholder holder = (Viewholder) convertView.getTag();
			interest=holder.interest;
			bfh=holder.bfh;
			productName=holder.productName;
			maturityDuration=holder.maturityDuration;
			totalAmount=holder.totalAmount;
			finishRatio=holder.finishRatio;
			progress1=holder.progress1;
			progress2=holder.progress2;
			progress3=holder.progress3;
		}
		//进行数据的绑定
		productName.setText(loan.getProductName());
		interest.setText(loan.getInterest()+"");
		maturityDuration.setText(loan.getMaturityDuration());
		totalAmount.setText(loan.getTotalAmount()+"元");
		//finishRatio标的进度productStatus（1：销售中 SALES；2：还款中 LENDING  3：已还完 ENDED 4:虚增满标 SALES_OVER
		switch(loan.getProductStatus()){
			case "SALES":
				progress1.setVisibility(View.VISIBLE);
				progress2.setVisibility(View.GONE);
				progress3.setVisibility(View.GONE);
				finishRatio.setProgress(Float.parseFloat(loan.getFinishRatio()));
				interest.setTextColor(context.getResources().getColor(R.color.primary));
				bfh.setTextColor(ContextCompat.getColor(context,R.color.primary));
				break;
			case "LENDING":
				bfh.setTextColor(ContextCompat.getColor(context,R.color.blue1));
				interest.setTextColor(context.getResources().getColor(R.color.blue1));
				progress1.setVisibility(View.GONE);
				progress2.setVisibility(View.VISIBLE);
				progress3.setVisibility(View.GONE);
				break;
			case "ENDED":
				bfh.setTextColor(ContextCompat.getColor(context,R.color.blue1));
				interest.setTextColor(context.getResources().getColor(R.color.blue1));
				progress1.setVisibility(View.GONE);
				progress2.setVisibility(View.GONE);
				progress3.setVisibility(View.VISIBLE);
				break;
			case "SALES_OVER":
				bfh.setTextColor(ContextCompat.getColor(context,R.color.blue1));
				interest.setTextColor(context.getResources().getColor(R.color.blue1));
				progress1.setVisibility(View.GONE);
				progress2.setVisibility(View.VISIBLE);
				progress3.setVisibility(View.GONE);
				break;
		}
		return convertView;
	}
	private final class  Viewholder{
		public TextView productName;
		public TextView interest;
		public TextView maturityDuration;
		public TextView totalAmount;
		public RoundProgressBar finishRatio;
		public RelativeLayout progress1;
		public RelativeLayout progress2;
		public RelativeLayout progress3;
		public TextView bfh;
	}
	private final class  Viewholder2{
		public TextView rd_productName;//推荐的标的
		public TextView rd_interest;//推荐的标的利率
		public TextView rd_maturityDuration;//推荐的标的期限
		public TextView rd_totalAmount;//推荐的标的总额
		public TextView rd_sales;//推荐的标的已收份数
		public TextView rd_remain;//推荐的标的剩余份数
	}
	
}
