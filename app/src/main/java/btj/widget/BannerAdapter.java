package btj.widget;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

import btj.index.entity.BannerListBean;

public class BannerAdapter extends PagerAdapter {

	private DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true)
			.imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
	private List<BannerListBean> imgs;

	public BannerAdapter(LayoutInflater mInflater, List<BannerListBean> imgs) {
		this.imgs = imgs;
	}

	public int getCount() {
		return imgs.size();
	}

	public boolean isViewFromObject(View view, Object o) {
		return view == o;
	}

	public Object instantiateItem(ViewGroup container, int position) {
		ImageView view = new ImageView(container.getContext());
		view.setScaleType(ImageView.ScaleType.FIT_XY);
		ImageLoader.getInstance().displayImage(imgs.get(position).getImageURI(), view, options);
		container.addView(view);
		return view;
	}

	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

}
