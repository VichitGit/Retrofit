package developer.vichit.android.com.retrofit.interfacce_generator;

import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by VichitDeveloper on 6/20/17.
 */

public interface ImageService {

    @Multipart
    @POST("v1/api/uploadfile/single")
    Call<JsonObject> uploadSingleImage(@Part MultipartBody.Part body);


}
