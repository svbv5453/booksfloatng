package com.booksfloating.adapter;

import java.util.ArrayList;
import java.util.List;

import com.booksfloating.adapter.SearchBooksDetailAdapter.ViewHolder;
import com.booksfloating.attr.BooksAttr;
import com.booksfloating.util.ImageLoader;
import com.booksfloating.util.ImageManager;
import com.booksfloating.util.LoaderImageUseVelloy;
import com.booksfloating.util.ImageLoader.RequestCallback;
import com.xd.booksfloating.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 
 * @author liuwenyuan
 *
 */
public class InfoNoticeAdapter extends BaseAdapter{
	private Context context;
	private List<BooksAttr> booksAttrsList = new ArrayList<BooksAttr>();
	private LayoutInflater inflater;
	
	public InfoNoticeAdapter(Context context, List<BooksAttr> booksAttrsList){
		this.context = context;
		this.booksAttrsList = booksAttrsList;
		inflater = LayoutInflater.from(this.context);

	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.booksAttrsList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this.booksAttrsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public void notifyDataSetChanged() {
		// TODO Auto-generated method stub
		super.notifyDataSetChanged();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		BooksAttr booksAttr = booksAttrsList.get(position);
		final ViewHolder viewHolder;
		if(convertView == null)
		{
			viewHolder = new ViewHolder();
			convertView = inflater.inflate(R.layout.info_notice_list_item, null);
			viewHolder.iv_books_image = (ImageView)convertView.findViewById(R.id.iv_books_image);
			viewHolder.tv_books_title = (TextView)convertView.findViewById(R.id.tv_books_title);
			viewHolder.tv_books_author = (TextView)convertView.findViewById(R.id.tv_books_author);
			viewHolder.tv_borrow_library = (TextView)convertView.findViewById(R.id.tv_borrow_library);
			viewHolder.tv_books_publish_time = (TextView)convertView.findViewById(R.id.tv_books_publish_time);
			viewHolder.tv_remark = (TextView)convertView.findViewById(R.id.tv_remark);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder)convertView.getTag();
		}
		if(booksAttr.getBookImageUrl() == null)
		{
			//加载本地图片
			viewHolder.iv_books_image.setImageDrawable(context.getResources().getDrawable(R.drawable.default_book));
		}
		else {
			//加载网络图片
			ImageManager.from(context).displayImage(viewHolder.iv_books_image, booksAttr.getBookImageUrl(), R.drawable.default_book);
		}
		
		viewHolder.tv_books_title.setText(booksAttr.getBookTitle());
		viewHolder.tv_books_author.setText(booksAttr.getBookAuthor());
		viewHolder.tv_books_publish_time.setText(booksAttr.getNoticePublishTime());
		viewHolder.tv_borrow_library.setText(booksAttr.getBorrowSchool());
		viewHolder.tv_remark.setText(booksAttr.getRemark());
		
		return convertView;
	}

	public static class ViewHolder{
		public ImageView iv_books_image;
		public TextView tv_books_title;
		public TextView tv_books_author;
		public TextView tv_borrow_library;
		public TextView tv_books_publish_time;
		public TextView tv_remark;
	}

}
