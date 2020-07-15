package com.rickyhr.utssehatku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.rickyhr.utssehatku.model.dokter;


import java.util.ArrayList;
import java.util.List;

public class ListDokterAdaptor extends BaseAdapter implements Filterable {
    private Context mContext;
    private List<dokter> listDokter, filterd;

    public ListDokterAdaptor(Context mContext, List<dokter> listDokter){
        this.mContext = mContext;
        this.listDokter = listDokter;
        this.filterd = this.listDokter;
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
            convertView = inflater.inflate(R.layout.dokter_list, null);
        }
        TextView txtnama = convertView.findViewById(R.id.nama_dokter);
        TextView txtalamat = convertView.findViewById(R.id.nohp_dokter);
        dokter dok = filterd.get(position);
        txtnama.setText(dok.getNama_dokter());
        txtalamat.setText(dok.getNo_telp());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        dokterFilter filter = new dokterFilter();
        return filter;
    }


    private class dokterFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<dokter> filteredData = new ArrayList<dokter>();
            FilterResults results = new FilterResults();
            String filterString = constraint.toString().toLowerCase();
            for (dokter dok: listDokter) {
                if (dok.getNama_dokter().toLowerCase().contains(filterString)){
                    filteredData.add(dok);
                }

            }results.count = filteredData.size();
            results.values = filteredData;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filterd = (List<dokter>) results.values;
            notifyDataSetChanged();
        }
    }
}
