package com.eggdevs.theasiansaid.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.eggdevs.theasiansaid.models.DBModel;
import com.eggdevs.theasiansaid.R;
import com.eggdevs.theasiansaid.roomdatabase.RoomDB;

import java.util.List;

public class DBAdapter extends RecyclerView.Adapter<DBAdapter.ViewHolder> {

   private Activity context;
   private List<DBModel> list;
   private RoomDB database;

   public DBAdapter(Activity context, List<DBModel> list) {
      this.context = context;
      this.list = list;
   }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_row, parent, false);
      return new ViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

      final DBModel data = list.get(position);

      database = RoomDB.getInstance(context);

      holder.tvSubregion.setText(data.getcSubRegion());
      holder.tvRegion.setText(data.getcRegion());
      holder.tvCapital.setText(data.getcCapital());
      holder.tvName.setText(data.getcName());
      holder.tvBorders.setText(data.getcBorders());
      holder.tvLanguages.setText(data.getcLanguages());
      holder.tvPopulation.setText(data.getcPopulation());

      holder.expand.setVisibility(data.isExpand() ? View.VISIBLE : View.GONE);
      holder.imageButton.setImageResource(data.isExpand() ? R.drawable.ic_up : R.drawable.ic_down);

      holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            data.setExpand(!data.isExpand());
            notifyItemChanged(position);
         }
      });

      holder.icDelete.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            DBModel del = list.get(holder.getAdapterPosition());

            database.mainDao().delete(del);

            int i = holder.getAdapterPosition();
            list.remove(i);
            notifyItemRemoved(i);
            notifyItemRangeChanged(i, list.size());
         }
      });

      SvgLoader.pluck()
              .with(context)
              .setPlaceHolder(R.mipmap.ic_launcher, R.drawable.ic_error)
              .load(data.getcUrl(), holder.ivFlag);

   }

   @Override
   public int getItemCount() {
      return list.size();
   }

   public class ViewHolder extends RecyclerView.ViewHolder {

      ConstraintLayout expand;
      ImageButton imageButton, icDelete;
      private TextView tvPopulation;
      private ImageView ivFlag;
      private TextView tvName, tvCapital, tvRegion, tvSubregion, tvLanguages, tvBorders;

      public ViewHolder(@NonNull View itemView) {
         super(itemView);

         ivFlag = itemView.findViewById(R.id.ivFlag);
         tvCapital = itemView.findViewById(R.id.tvCapital);
         tvName = itemView.findViewById(R.id.tvName);
         tvRegion = itemView.findViewById(R.id.tvRegion);
         tvSubregion = itemView.findViewById(R.id.tvSubregion);
         tvPopulation = itemView.findViewById(R.id.tvPopulation);
         tvLanguages = itemView.findViewById(R.id.tvLanguages);
         tvBorders = itemView.findViewById(R.id.tvBorders);
         imageButton = itemView.findViewById(R.id.imageButton);
         expand = itemView.findViewById(R.id.expand);
         icDelete = itemView.findViewById(R.id.icDelete);
      }
   }

}
