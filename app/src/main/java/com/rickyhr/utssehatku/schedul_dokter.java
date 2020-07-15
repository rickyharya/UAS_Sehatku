package com.rickyhr.utssehatku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.rickyhr.utssehatku.api.ClientAsyncTask;
import com.rickyhr.utssehatku.model.dokter;
import com.rickyhr.utssehatku.model.rumahsakit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class schedul_dokter extends AppCompatActivity {
private ListView listView;
private ListDokterAdaptor mAdapter;
private List<dokter> listdokter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedul_dokter);
        listView = findViewById(R.id.list_dok);
        listdokter = new ArrayList<dokter>();
        mAdapter = new ListDokterAdaptor(this, listdokter);
        listView.setAdapter(mAdapter);

        loadData();
    }

    private void loadData() {
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
            task.api_url = "dokter.php";
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
            JSONArray jsonArray = jsonObj.getJSONArray("dokter");
            dokter dok = null;
            for (int i=0; i<jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                dok = new dokter();
                dok.setId_dokter(obj.getString("id_dokter"));
                dok.setNama_dokter(obj.getString("nama_dokter"));
                dok.setNo_telp(obj.getString("no_telp"));
                listdokter.add(dok);
            }
            mAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
