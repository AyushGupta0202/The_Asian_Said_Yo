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
import com.eggdevs.theasiansaid.models.Country;
import com.eggdevs.theasiansaid.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

   private List<Country> countries;
   private Activity activity;
   private onDeleteListener deleteListener;

   public CountryAdapter(List<Country> countries, Activity activity, onDeleteListener deleteListener) {
      this.countries = countries;
      this.activity = activity;
      this.deleteListener = deleteListener;
   }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_row, parent, false);
      return new ViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      Country currentCountry = countries.get(position);
      holder.setData(currentCountry.getName(), currentCountry.getCapital(),
              currentCountry.getRegion(),
              currentCountry.getSubRegion(), currentCountry.getUrl(),
              currentCountry.getPopulation(),
              currentCountry.getBorders(), currentCountry.getLanguages(), position, currentCountry);

      holder.expand.setVisibility(currentCountry.getExpanded() ? View.VISIBLE : View.GONE);
      holder.imageButton.setImageResource(currentCountry.getExpanded() ? R.drawable.ic_up : R.drawable.ic_down);

   }

   @Override
   public int getItemCount() {
      return countries.size();
   }

   public interface onDeleteListener {
      void onDelete(int position);
   }

   class ViewHolder extends RecyclerView.ViewHolder {

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

      private void setData(String name, String capital, String region, String subRegion,
                           String url, final int population, String borders, String languages, final int position, final Country currentCountry) {
         tvSubregion.setText(subRegion);
         tvRegion.setText(region);
         tvCapital.setText(capital);
         tvName.setText(name);
         tvBorders.setText(borders);
         tvLanguages.setText(languages);
         tvPopulation.setText("Population: " + NumberFormat.getNumberInstance(Locale.US).format(population));

         SvgLoader.pluck()
                 .with(activity)
                 .setPlaceHolder(R.mipmap.ic_launcher, R.drawable.ic_error)
                 .load(url, ivFlag);

         itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               currentCountry.setExpanded(!currentCountry.getExpanded());
               notifyItemChanged(position);
            }
         });

         icDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               deleteListener.onDelete(position);
               notifyItemRemoved(position);
            }
         });

      }
   }
}
