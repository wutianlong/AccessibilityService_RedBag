package com.dxytech.oden.annotations.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dxytech.oden.annotations.R;
import com.dxytech.oden.annotations.model.HongbaoInfo;

import java.util.List;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.ViewHolder> {

    private List<HongbaoInfo> mList;
    private LayoutInflater inflater;

//    private  OnItemClickListener listener;
//
//    public interface  OnItemClickListener{
//        void onClick(View v,int position, HongbaoInfo hongbaoInfo);
//    }
//
//    public void setOnItemClickListener(OnItemClickListener listener){
//        this.listener = listener;
//    }


    public LogAdapter(List<HongbaoInfo> hongbaoInfoList) {
        this.mList = hongbaoInfoList;
    }

    public void delete(HongbaoInfo hongbaoInfoList) {
        mList.remove(hongbaoInfoList);
        notifyDataSetChanged();
    }


    public void deleteAll() {
        mList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
//        L.d("mList.size:" + mList.size());
        return mList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_log, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.sender.setText(mList.get(position).getSender());
        holder.money.setText(mList.get(position).getMoney()+"");
        holder.time.setText(mList.get(position).getTime());
    }

    class  ViewHolder extends  RecyclerView.ViewHolder{
        private TextView sender;
        private TextView money;
        private TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            sender = (TextView) itemView.findViewById(R.id.tv_sender);
            money = (TextView) itemView.findViewById(R.id.tv_money);
            time = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }
}