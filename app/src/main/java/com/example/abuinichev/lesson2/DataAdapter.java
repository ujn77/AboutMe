package com.example.abuinichev.lesson2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Class implements data adapter for ListView.
 * */
public class DataAdapter extends BaseAdapter {

	/** Inner data for this adapter. */
	private DataSet mData = null;
	
	/** The {@code LayoutInflater} for inflate item layout. */
	private LayoutInflater mInflater = null;
	
	/** OnClick listener for view into list item. */
    private OnItemViewClickListener mOnItemViewClickListener = null;

    /** Listener used to dispatch remove events. */
    private OnRemoveItemListener mOnRemoveItemListener = null;
	
	/**
	 * Construct a new {@link DataSet} instance with specified parameters.
	 * */
	public DataAdapter(Context context, String[] strArr) {
		
		// Check context object
		if (context == null)
			throw new IllegalArgumentException("context is null");
		
		// Get inflater instance
		mInflater = LayoutInflater.from(context);
		
		// Create inner data object
		mData = new DataSet();

		// Create OnItemViewClickListener
		mOnItemViewClickListener = new OnItemViewClickListener();
	}

	/**
	 * How many items are in the data set represented by this Adapter.
	 * */
	@Override
	public int getCount() { return mData.size(); }

	/**
	 * Get the data item associated with the specified position in the data set.
	 * */
	@Override
	public Object getItem(int position) { return mData.get(position); }
	
	/**
	 * Get the row id associated with the specified position in the list. In 
	 * this implementation it equals {@code position}.
	 * */
	@Override
	public long getItemId(int position) { return position; }

	/**
	 * Adds the specified item at the end of this data set.
	 * */
	public void addItem(String object) {
		mData.add(object);
		this.notifyDataSetChanged();
	}
	
	/**
	 * Set a new value for the data item associated with the specified position
	 * in the data set.
	 * */
	public void setItem(int position, String object) {
		mData.set(position, object); this.notifyDataSetChanged();
	}

	/**
	 * Removes the data item associated with the specified position in the data
	 * set.
	 * */
	public void removeItem(int position) {
		final String item = mData.remove(position);
		this.notifyDataSetChanged();
		performRemoveItem(item, position);
	}
	
	/**
	 * Removes all items from this data set, leaving it empty.
	 * */
	public void clear() {
		mData.clear(); this.notifyDataSetChanged();
	}

	/**
	 * Register a callback to be invoked when a item is removed. 
	 * */
	public void setOnRemoveItemListener(OnRemoveItemListener l) {
		mOnRemoveItemListener = l;
	}
	
	/**
	 * Call this data set OnClickListener, if it is defined.
	 * */
	protected void performRemoveItem(String item, int position) {
		if (mOnRemoveItemListener != null)
			mOnRemoveItemListener.onRemoveItem(this, item, position);
	}

	/**
	 * Get a View that displays the data at the specified position in the data
	 * set.
	 * */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        
		// View for list item (if convertView is null, need to inflate item
		// view from resources)
        View v = convertView;
        if (v == null) { 
            v = mInflater.inflate(R.layout.my_list_item, parent, false);
        }
        
        // Data item
        final String data = mData.get(position);
        
        // Fill number field
        ((TextView) v.findViewById(R.id.number)).setText(
        		String.valueOf(position + 1));
        
        // Fill data field
        ((TextView) v.findViewById(R.id.data)).setText(data);

        // Configure remove action
        final View remove = v.findViewById(R.id.act_remove);
        remove.setTag(position);
        remove.setOnClickListener(mOnItemViewClickListener);

        // Return view for list item
        return v;
	}

	/**
	 * Inner class that implements OnClick listener for view into list item.
	 * */
    private class OnItemViewClickListener implements OnClickListener {

    	/**
    	 * Called when a view has been clicked.
    	 * */
		@Override
		public void onClick(View v) {

			// Checking v and get id and position
            if (v == null) return;
            int id = v.getId();
            int location = v.getTag() != null ? (Integer) v.getTag() : -1;

            // Remove item
            if (id == R.id.act_remove) {
            	DataAdapter.this.removeItem(location);
            }
		}
    }
    
    /**
     * Interface definition for a callback to be invoked when a item is
     * removed.
     * */
    public interface OnRemoveItemListener {
    	
    	/**
    	 * Callback method to be invoked when an item in this data set has
         * been remover.
         *
         * @param parent The adapter where the remove happened.
         * @param item The removed item
         * @param position The position of the removed item in the adapter. 
    	 * */    	
    	public void onRemoveItem(BaseAdapter adapter, String item, int position);

    }
}