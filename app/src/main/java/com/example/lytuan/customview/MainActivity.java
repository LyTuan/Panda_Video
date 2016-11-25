package com.example.lytuan.customview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listAlbum;
    int []hinhAlbum = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six};
    String []tenAlbum = {"Thiên nhiên 1","Tn 2","Tn3","Tn4","Tn5","Tn6"};
    String []ngayPhatHanh ={"20/11/2016","20/11/2016","20/11/2016","20/11/2016","20/11/2016","20/11/2016"};
    List<Album> danhSachAlbum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAlbum = (ListView) findViewById(R.id.listAlbum);
        danhSachAlbum = new ArrayList<>();
        for(int i=0; i<tenAlbum.length; i++){
            Album album = new Album();
            album.setHinhAnh(hinhAlbum[i]);
            album.setTenAlbum(tenAlbum[i]);
            album.setNgayPhatHanh(ngayPhatHanh[i]);
            danhSachAlbum.add(album);
        }
        CustomAdapter customAdapter = new CustomAdapter(this,R.layout.custom_layout_view,danhSachAlbum );
        customAdapter.notifyDataSetChanged();
        listAlbum.setAdapter(customAdapter);
    }
    public  class CustomAdapter extends ArrayAdapter<Album>{
        Context context;
        int resoure;
        List<Album> listAlbum;
        public CustomAdapter(Context context, int resource, List<Album> objects) {
            super(context, resource, objects);
            this.context = context;
            this.resoure = resource;
            this.listAlbum = objects;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View rowItem = inflater.inflate(resoure,parent,false);
            ImageView hinhAlbum = (ImageView) rowItem.findViewById(R.id.hinhAlbum);
            TextView tenAlbum = (TextView) rowItem.findViewById(R.id.tenAlbum);
            TextView ngayPhatHanh = (TextView) rowItem.findViewById(R.id.ngayPhatHanh);

            hinhAlbum.setImageResource(listAlbum.get(position).getHinhAnh());
            tenAlbum.setText(listAlbum.get(position).getTenAlbum().toString());
            ngayPhatHanh.setText(listAlbum.get(position).getNgayPhatHanh().toString());
            return rowItem;
        }
    }

}
