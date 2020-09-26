package com.eggdevs.theasiansaid.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "table_name")
public class DBModel implements Serializable {

   @ColumnInfo(name = "name")
   public String cName;
   @ColumnInfo(name = "capital")
   public String cCapital;
   @ColumnInfo(name = "region")
   public String cRegion;
   @ColumnInfo(name = "subregion")
   public String cSubRegion;
   @ColumnInfo(name = "population")
   public String cPopulation;
   @ColumnInfo(name = "languages")
   public String cLanguages;
   @ColumnInfo(name = "borders")
   public String cBorders;
   @ColumnInfo(name = "url")
   public String cUrl;
   private boolean expand = true;
   @PrimaryKey(autoGenerate = true)
   private int ID;

   public String getcUrl() {
      return cUrl;
   }

   public void setcUrl(String cUrl) {
      this.cUrl = cUrl;
   }

   public int getID() {
      return ID;
   }

   public void setID(int ID) {
      this.ID = ID;
   }

   public String getcName() {
      return cName;
   }

   public void setcName(String cName) {
      this.cName = cName;
   }

   public String getcCapital() {
      return cCapital;
   }

   public void setcCapital(String cCapital) {
      this.cCapital = cCapital;
   }

   public String getcRegion() {
      return cRegion;
   }

   public void setcRegion(String cRegion) {
      this.cRegion = cRegion;
   }

   public String getcSubRegion() {
      return cSubRegion;
   }

   public void setcSubRegion(String cSubRegion) {
      this.cSubRegion = cSubRegion;
   }

   public String getcPopulation() {
      return cPopulation;
   }

   public void setcPopulation(String cPopulation) {
      this.cPopulation = cPopulation;
   }

   public String getcLanguages() {
      return cLanguages;
   }

   public void setcLanguages(String cLanguages) {
      this.cLanguages = cLanguages;
   }

   public String getcBorders() {
      return cBorders;
   }

   public void setcBorders(String cBorders) {
      this.cBorders = cBorders;
   }

   public boolean isExpand() {
      return expand;
   }

   public void setExpand(boolean expand) {
      this.expand = expand;
   }
}
