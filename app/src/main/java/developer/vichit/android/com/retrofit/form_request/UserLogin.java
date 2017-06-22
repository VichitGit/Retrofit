package developer.vichit.android.com.retrofit.form_request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by VichitDeveloper on 6/21/17.
 */

public class UserLogin {
    @SerializedName("EMAIL")
    private String email;
    @SerializedName("PASSWORD")
    private String password;

    public String getEMAIL() {
        return email;
    }

    public void setEMAIL(String email) {
        this.email = email;
    }

    public String getP() {
        return password;
    }

    public void setPassword(String PASSWORD) {
        this.password = PASSWORD;
    }

}
