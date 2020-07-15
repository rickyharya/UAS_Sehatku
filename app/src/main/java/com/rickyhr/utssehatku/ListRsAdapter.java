package com.rickyhr.utssehatku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.rickyhr.utssehatku.model.rumahsakit;

import java.util.ArrayList;
import java.util.List;

public class ListRsAdapter extends BaseAdapter implements Filterable
{
    private Context mContext;
    private List<rumahsakit> listRs, filterd;

    public ListRsAdapter(Context mContext, List<rumahsakit> listRs){
        this.mContext = mContext;
        this.listRs = listRs;
        this.filterd = this.listRs;
    }

    @Override
    public int getCount() {
        return filterd.size();
    }

    @Override
    public Object getItem(int position) {
    return filterd.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(this.mContext);
            convertView = inflater.inflate(R.layout.rumahsakit_list, null);
        }
        TextView txtnama = convertView.findViewById(R.id.nama);
        TextView txtalamat = convertView.findViewById(R.id.alamat);
        TextView txthohp = convertView.findViewById(R.id.nohp);
        rumahsakit rs = filterd.get(position);
        txtnama.setText(rs.getNama_rs());
        txtalamat.setText(rs.getAlamat_rs());
        txthohp.setText(rs.getNo_telp());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        rumahsakitFilter filter = new rumahsakitFilter();
        return filter;
    }


    private class rumahsakitFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<rumahsakit> filteredData = new ArrayList<rumahsakit>();
            FilterResults results = new FilterResults();
            String filterString = constraint.toString().toLowerCase();
            for (rumahsakit rs: listRs) {
                if (rs.getNama_rs().toLowerCase().contains(filterString)){
                    filteredData.add(rs);
                }

            }results.count = filteredData.size();
            results.values = filteredData;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filterd = (List<rumahsakit>) results.values;
            notifyDataSetChanged();
        }
    }
}
