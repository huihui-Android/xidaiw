package xidaiw.licai.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
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
	public static final int SHORT_TASTE_PRODUCT = 0;
	public static final int FIXED_TERM_PRODUCT = 1;


	public LoansAdapter(Context context, List<LoanPageAdapter.DataBean.ListBean> loanList){
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
		View ret = null;
		Viewholder holder = null;
		Viewholder2 holder2 = null;

		TextView productName = null;//标的名称
		TextView interest = null;//总利率
		TextView bfh = null;//百分号的符号%
		TextView maxInterest = null;//最大利率
		TextView awardInterest = null;//奖励利率
		TextView normalInterest = null;//正常利率
		TextView maturityDuration = null;//投资期限
		TextView id;//标的id
		TextView totalAmount = null;//标的的总金额
		RoundProgressBar finishRatio = null;//销售进度
		RelativeLayout progress1 = null;//进度一
		RelativeLayout progress2 = null;//进度一
		RelativeLayout progress3 = null;//进度一

		TextView rd_productName = null;//推荐的标的
		TextView rd_interest = null;//推荐的标的利率
		TextView rd_maturityDuration = null;//推荐的标的期限
		TextView rd_totalAmount = null;//推荐的标的总额
		TextView rd_sales = null;//推荐的标的已收份数
		TextView rd_remain = null;//推荐的标的剩余份数
		Button btnInvest = null;
		LoanPageAdapter.DataBean.ListBean loan = (LoanPageAdapter.DataBean.ListBean) getItem(position);
		int type = getItemViewType(position);
		if (convertView != null) {
			ret=convertView;
		}else{
			switch(type){
				case SHORT_TASTE_PRODUCT:
					ret = LayoutInflater.from(context).inflate(R.layout.productlist_item_newhand, null);
					break;
				case FIXED_TERM_PRODUCT:
					ret = LayoutInflater.from(context).inflate(R.layout.productlist_items, null);
					break;
			}
		}
		//实例化ViewHolder ，findViewById
		switch (type){
			case SHORT_TASTE_PRODUCT:
				holder = (Viewholder) ret.getTag();
				if (holder==null){
					holder=new Viewholder();
					rd_productName=ret.findViewById(R.id.tv_rd_productName);
					rd_interest=ret.findViewById(R.id.tv_rd_interest);
					rd_maturityDuration=ret.findViewById(R.id.tv_rd_duration);
					rd_sales=ret.findViewById(R.id.tv_rd_sales);
					rd_remain=ret.findViewById(R.id.tv_rd_remain);
					rd_totalAmount=ret.findViewById(R.id.tv_rd_amount);
					btnInvest=ret.findViewById(R.id.btn_rd_invest);
					ret.setTag(holder);
				}
				break;
			case FIXED_TERM_PRODUCT:
				holder2 = (Viewholder2) ret.getTag();
				if (holder2==null){
					holder2=new Viewholder2();
					productName=ret.findViewById(R.id.tv_productName);
					interest=ret.findViewById(R.id.tv_interest);
					maturityDuration=ret.findViewById(R.id.tv_duration);
					totalAmount=ret.findViewById(R.id.tv_duration);
					finishRatio=ret.findViewById(R.id.roundProgressBar);
					progress1=ret.findViewById(R.id.progress1);
					progress2=ret.findViewById(R.id.progress2);
					progress3=ret.findViewById(R.id.progress3);
					bfh=ret.findViewById(R.id.bfh);
					ret.setTag(holder2);
				}
				break;
		}
		//进行赋值
		switch(type){
			case SHORT_TASTE_PRODUCT:
				holder2.rd_productName.setText(loan.getProductName());
				holder2.rd_interest.setText(loan.getInterest());
				holder2.rd_maturityDuration.setText(loan.getMaturityDuration());
				holder2.rd_sales.setText(loan.getSaleAmount());
				holder2.rd_remain.setText(loan.getRemainingAmount());
				holder2.rd_totalAmount.setText(loan.getTotalAmount());
				break;
			case FIXED_TERM_PRODUCT:
				productName.setText(loan.getProductName());
				interest.setText(loan.getInterest()+"");
				maturityDuration.setText(loan.getMaturityDuration());
				totalAmount.setText(loan.getTotalAmount()+"元");
				//finishRatio标的进度productStatus 1：销售中 SALES；2：还款中 LENDING  3：已还完 ENDED 4:虚增满标 SALES_OVER
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
		public Button btnInvest;//立即投资
	}
	
}
