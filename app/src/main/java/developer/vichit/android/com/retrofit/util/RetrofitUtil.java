package developer.vichit.android.com.retrofit.util;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by VichitDeveloper on 6/20/17.
 */

public class RetrofitUtil {

    public static RequestBody toRequestBody(String value){
        return RequestBody.create(MediaType.parse("text/plain"), value);
    }

}
