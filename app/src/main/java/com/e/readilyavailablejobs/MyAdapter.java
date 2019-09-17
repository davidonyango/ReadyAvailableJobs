


package com.e.readilyavailablejobs;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Davido> {

    private Activity context;
    private List<Davido>userJobsList;

    public MyAdapter(Activity context,List<Davido>userJobsList){
        super(context,R.layout.list_view,userJobsList);
        this.context = context;
        this.userJobsList = userJobsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listview = inflater.inflate(R.layout.list_view,null,true);

        TextView userName = (TextView)listview.findViewById(R.id.tv_getname_id);
        TextView userCountry = (TextView)listview.findViewById(R.id.tv_getcountry1_id);
        TextView userLocation = (TextView)listview.findViewById(R.id.tv_getlocation_id);
        TextView userPhoneNumber = (TextView)listview.findViewById(R.id.tv_getphonenumber_id);
        TextView userJobDescription = (TextView)listview.findViewById(R.id.tv_getjobdescription_id);
        TextView userJobDuration = (TextView)listview.findViewById(R.id.tv_getdescribethetermsofemployment);
        TextView userRequirements = (TextView)listview.findViewById(R.id.tv_getskillsandrequrements_id);

        Davido userJob = userJobsList.get(position);
        userName.setText(userJob.getUserName());
        userCountry.setText(userJob.getUserCountry());
        userLocation.setText(userJob.getUserLocation());
        userPhoneNumber.setText(userJob.getUserPhoneNumber());
        userJobDescription.setText(userJob.getUserJob());
        userJobDuration.setText(userJob.getUserJobDuration());
        userRequirements.setText(userJob.getUserRequirements());

        return listview;
    }
}



