package com.rickyhr.utssehatku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.rickyhr.utssehatku.api.ClientAsyncTask;
import com.rickyhr.utssehatku.model.rumahsakit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Cekrumahsait extends AppCompatActivity {
private ListView listView;
private ListRsAdapter mAdapter;
private List<rumahsakit> listRs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cekrumahsait);
        listView = findViewById(R.id.list_rumah);
        listRs = new ArrayList<rumahsakit>();
        mAdapter = new ListRsAdapter(this, listRs);
        listView.setAdapter(mAdapter);
        loadData();
    }
    private void loadData(){
        try{
            ClientAsyncTask task = new ClientAsyncTask(this, new ClientAsyncTask.OnPostExecuteListener() {
                @Override
                public void onPostExecute(String result) {
                    if (result.equals("error")){
                        Toast.makeText(getBaseContext(),"Tidak dapat terkoneksi dengan server",Toast.LENGTH_SHORT).show();

                    }else {
                        prosessResponse(result);
                    }
                }
            });
            task.reques_type = "GET";
            task.api_url = "rs.php";
            task.showDiaog = true;
            task.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void prosessResponse(String response) {
        Log.d("JSON_DATA" , response);
        try{
            JSONObject jsonObj = new JSONObject(response);
            JSONArray jsonArray = jsonObj.getJSONArray("rumahsakit");
            rumahsakit rs = null;
            for (int i=0; i<jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                rs = new rumahsakit();
                rs.setId_rs(obj.getString("id_rs"));
                rs.setNama_rs(obj.getString("nama_rs"));
                rs.setAlamat_rs(obj.getString("alamat_rs"));
                rs.setNo_telp(obj.getString("no_telp"));
                listRs.add(rs);
            }
            mAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
