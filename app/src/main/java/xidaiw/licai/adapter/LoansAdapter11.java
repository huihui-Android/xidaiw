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
import xidaiw.util.GlobalUtils;
import xidaiw.widget.RoundProgressBar;

import static com.xidaiw.btj.R.id.bfh;
import static com.xidaiw.btj.R.id.progress1;
import static com.xidaiw.btj.R.id.progress2;
import static com.xidaiw.btj.R.id.progress3;


@SuppressLint("ResourceAsColor")
public class LoansAdapter11 extends BaseAdapter{

	private List<LoanPageAdapter.DataBean.ListBean> loanList;
	private int resource;
	private LayoutInflater inflater;
	private Context context;
	public static final int SHORT_TASTE_PRODUCT = 0;
	public static final int FIXED_TERM_PRODUCT = 1;


	public LoansAdapter11(Context context, List<LoanPageAdapter.DataBean.ListBean> loanList){
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
		Viewholder holder = null;
		Viewholder2 holder2 = null;
		LoanPageAdapter.DataBean.ListBean loan = (LoanPageAdapter.DataBean.ListBean) getItem(position);
		int type = getItemViewType(position);
		if (convertView==null){
			switch(type) {
				case SHORT_TASTE_PRODUCT:
					convertView=inflater.inflate(R.layout.productlist_item_newhand,null);
					holder2=new Viewholder2();
					holder2.rd_productName=convertView.findViewById(R.id.tv_rd_productName);
					holder2.rd_interest=convertView.findViewById(R.id.tv_rd_interest);;
					holder2.rd_maturityDuration=convertView.findViewById(R.id.tv_rd_duration);
					holder2.rd_totalAmount=convertView.findViewById(R.id.tv_rd_amount);
					holder2.rd_sales=convertView.findViewById(R.id.tv_rd_sales);
					holder2.rd_remain=convertView.findViewById(R.id.tv_rd_remain);
					holder2.btnInvest=convertView.findViewById(R.id.btn_rd_invest);
					convertView.setTag(holder2);
					break;
				case FIXED_TERM_PRODUCT:
					convertView=inflater.inflate(R.layout.productlist_items,null);
					holder=new Viewholder();
					holder.productName=convertView.findViewById(R.id.tv_productName);
					holder.interest=convertView.findViewById(R.id.tv_interest);
					holder.bfh=convertView.findViewById(bfh);
					holder.maturityDuration=convertView.findViewById(R.id.tv_duration);
					holder.totalAmount=convertView.findViewById(R.id.tv_amount);
					holder.finishRatio=convertView.findViewById(R.id.roundProgressBar);
					holder.progress1=convertView.findViewById(progress1);
					holder.progress2=convertView.findViewById(progress2);
					holder.progress3=convertView.findViewById(progress3);
					convertView.setTag(holder);
					break;
			}
		}else {
			switch(type) {
				case SHORT_TASTE_PRODUCT:
					holder2= (Viewholder2) convertView.getTag();
					break;
				case FIXED_TERM_PRODUCT:
					holder = (Viewholder) convertView.getTag();
					break;
			}
		}
		//进行数据的绑定
		switch(type){
			case SHORT_TASTE_PRODUCT:
					holder2.rd_productName.setText(loan.getProductName());
					holder2.rd_interest.setText(loan.getInterest()+"");
					holder2.rd_maturityDuration.setText(loan.getMaturityDuration());
					holder2.rd_totalAmount.setText(loan.getTotalAmount()+"元");
					holder2.rd_remain.setText("剩余 "+loan.getRemainingAmount()+" 份");
					holder2.rd_sales.setText("已售 "+loan.getSaleAmount()+" 份");

				break;
			case FIXED_TERM_PRODUCT:
				holder.productName.setText(loan.getProductName());
				holder.interest.setText(loan.getInterest()+"");
				holder.maturityDuration.setText(loan.getMaturityDuration());
				holder.totalAmount.setText(GlobalUtils.NumberFormatTransfer(loan.getTotalAmount()+"")+"元");
				//finishRatio标的进度productStatus 1：销售中 SALES；2：还款中 LENDING  3：已还完 ENDED 4:虚增满标 SALES_OVER
				switch(loan.getProductStatus()){
					case "SALES":
						holder.progress1.setVisibility(View.VISIBLE);
						holder.progress2.setVisibility(View.GONE);
						holder.progress3.setVisibility(View.GONE);
						holder.finishRatio.setProgress(Float.parseFloat(loan.getFinishRatio()));
						holder.interest.setTextColor(context.getResources().getColor(R.color.primary));
						holder.bfh.setTextColor(ContextCompat.getColor(context,R.color.primary));
						break;
					case "LENDING":
						holder.bfh.setTextColor(ContextCompat.getColor(context,R.color.blue1));
						holder.interest.setTextColor(context.getResources().getColor(R.color.blue1));
						holder.progress1.setVisibility(View.GONE);
						holder.progress2.setVisibility(View.VISIBLE);
						holder.progress3.setVisibility(View.GONE);
						break;
					case "ENDED":
						holder.bfh.setTextColor(ContextCompat.getColor(context,R.color.blue1));
						holder.interest.setTextColor(context.getResources().getColor(R.color.blue1));
						holder.progress1.setVisibility(View.GONE);
						holder.progress2.setVisibility(View.GONE);
						holder.progress3.setVisibility(View.VISIBLE);
						break;
					case "SALES_OVER":
						holder.bfh.setTextColor(ContextCompat.getColor(context,R.color.blue1));
						holder.interest.setTextColor(context.getResources().getColor(R.color.blue1));
						holder.progress1.setVisibility(View.GONE);
						holder.progress2.setVisibility(View.VISIBLE);
						holder.progress3.setVisibility(View.GONE);
						break;
				}
				break;
		}
		return convertView;
	}
	private final class  Viewholder{
		public TextView productName;//标的名称
		public TextView interest;//标的利率
		public TextView maturityDuration;//投资期限
		public TextView totalAmount;//总金额
		public RoundProgressBar finishRatio;//标的进度
		public RelativeLayout progress1;//标的进度一
		public RelativeLayout progress2;//标的进度二
		public RelativeLayout progress3;//标的进度三
		public TextView bfh;//百分号的颜色
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
