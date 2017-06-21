package developer.vichit.android.com.retrofit.interfacce_generator;

import developer.vichit.android.com.retrofit.Model.LoginRespone;
import developer.vichit.android.com.retrofit.form.UserLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by VichitDeveloper on 6/21/17.
 */

public interface LoginService {

    @POST("/v1/api/authentication")
    Call<LoginRespone> loginUser(@Body UserLogin userLogin);
}
