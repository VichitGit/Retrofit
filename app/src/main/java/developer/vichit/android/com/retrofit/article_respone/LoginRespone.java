package developer.vichit.android.com.retrofit.article_respone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by VichitDeveloper on 6/21/17.
 */

public class LoginRespone {


    @SerializedName("CODE")
    private String code;
    @SerializedName("MESSAGE")
    private String message;
    @SerializedName("DATA")
    private DATA data;

    public String getCode() {
        return code;
    }

    public void setCODE(String CODE) {
        this.code = CODE;
    }

    public String getMessage() {
        return message;
    }

    public void setMESSAGE(String MESSAGE) {
        this.message = MESSAGE;
    }

    public DATA getData() {
        return data;
    }

    public void setDATA(DATA data) {
        this.data = data;
    }

    public static class DATA {
        @SerializedName("ID")
        private int ID;
        @SerializedName("NAME")
        private String NAME;
        @SerializedName("EMAIL")
        private String EMAIL;
        @SerializedName("GENDER")
        private String GENDER;
        @SerializedName("TELEPHONE")
        private String TELEPHONE;
        @SerializedName("STATUS")
        private String STATUS;
        @SerializedName("FACEBOOK_ID")
        private String FACEBOOK_ID;
        @SerializedName("IMAGE_URL")
        private String IMAGE_URL;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public String getEMAIL() {
            return EMAIL;
        }

        public void setEMAIL(String EMAIL) {
            this.EMAIL = EMAIL;
        }

        public String getGENDER() {
            return GENDER;
        }

        public void setGENDER(String GENDER) {
            this.GENDER = GENDER;
        }

        public String getTELEPHONE() {
            return TELEPHONE;
        }

        public void setTELEPHONE(String TELEPHONE) {
            this.TELEPHONE = TELEPHONE;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getFACEBOOK_ID() {
            return FACEBOOK_ID;
        }

        public void setFACEBOOK_ID(String FACEBOOK_ID) {
            this.FACEBOOK_ID = FACEBOOK_ID;
        }

        public String getIMAGE_URL() {
            return IMAGE_URL;
        }

        public void setIMAGE_URL(String IMAGE_URL) {
            this.IMAGE_URL = IMAGE_URL;
        }
    }
}
