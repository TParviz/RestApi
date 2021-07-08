package ru.main.testproblem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Textmodel {

    @SerializedName("data")
    @Expose
    private List<Dates> dates = null;

    public List<Dates> getDates() {
        return dates;
    }

    public void setDates(List<Dates> dates) {
        this.dates = dates;
    }

    public class Dates {


        @SerializedName("url")
        @Expose
        private String idUrl;

        @SerializedName("startDate")
        @Expose
        private String idStartDate;

        @SerializedName("endDate")
        @Expose
        private String idEndDate;

        @SerializedName("name")
        @Expose
        private String idName;

        @SerializedName("icon")
        @Expose
        private String idIcon;


        public String getIdUrl() {
            return idUrl;
        }

        public void setIdUrl(String idUrl) {
            this.idUrl = idUrl;
        }

        public String getIdStartDate() {
            return idStartDate;
        }

        public void setIdStartDate(String idStartDate) {
            this.idStartDate = idStartDate;
        }

        public String getIdEndDate() {
            return idEndDate;
        }

        public void setIdEndDate(String idEndDate) {
            this.idEndDate = idEndDate;
        }

        public String getIdName() {
            return idName;
        }

        public void setIdName(String idName) {
            this.idName = idName;
        }

        public String getIdIcon() {
            return idIcon;
        }

        public void setIdIcon(String idIcon) {
            this.idIcon = idIcon;
        }


    }

}
