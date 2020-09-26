package com.eggdevs.theasiansaid.models;

public class Country {

   private String name, capital, region, subRegion, url, languages, borders;
   private int population;
   private boolean isExpanded;

   public Country() {
      isExpanded = false;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCapital() {
      return capital;
   }

   public void setCapital(String capital) {
      this.capital = capital;
   }

   public String getRegion() {
      return region;
   }

   public void setRegion(String region) {
      this.region = region;
   }

   public String getSubRegion() {
      return subRegion;
   }

   public void setSubRegion(String subRegion) {
      this.subRegion = subRegion;
   }

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public int getPopulation() {
      return this.population;
   }

   public void setPopulation(int population) {
      this.population = population;
   }

   public String getLanguages() {
      return languages;
   }

   public void setLanguages(String languages) {
      this.languages = languages;
   }

   public String getBorders() {
      return borders;
   }

   public void setBorders(String borders) {
      this.borders = borders;
   }

   public boolean getExpanded() {
      return isExpanded;
   }

   public void setExpanded(boolean expanded) {
      isExpanded = expanded;
   }
}
