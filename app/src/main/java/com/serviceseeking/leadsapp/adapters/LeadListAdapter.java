package com.serviceseeking.leadsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.serviceseeking.leadsapp.R;
import com.serviceseeking.leadsapp.lead_details.LeadDetailsActivity;
import com.serviceseeking.leadsapp.remote.responses.Data;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeadListAdapter extends ArrayAdapter<Data> {

    private Context context;

    public LeadListAdapter(Context context, List<Data> leads) {
        super(context, 0, leads);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_lead_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        final Data data = getItem(position);
        holder.tvName.setText(data.getAttributes().getName());
        holder.tvUsername.setText(data.getAttributes().getUserName());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LeadDetailsActivity.class);
                intent.putExtra("leadId", data.getId());
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_username)
        TextView tvUsername;
        @BindView(R.id.tv_name)
        TextView tvName;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
