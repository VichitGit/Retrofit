package developer.vichit.android.com.retrofit.interfacce_generator;

import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface UserService {

    @Multipart
    @POST("/v1/api/users")
    Call<JsonObject> createUser(
            @Part("EMAIL") RequestBody email,
            @Part("NAME") RequestBody name,
            @Part("PASSWORD") RequestBody password,
            @Part("GENDER") RequestBody gender,
            @Part("TELEPHONE") RequestBody telephone,
            @Part("FACEBOOK_ID") RequestBody facebook_id,
            @Part MultipartBody.Part photo
    );


}
