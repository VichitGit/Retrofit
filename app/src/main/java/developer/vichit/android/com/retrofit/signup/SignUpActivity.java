package developer.vichit.android.com.retrofit.signup;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.io.File;

import developer.vichit.android.com.retrofit.Model.ServiceGenerator;
import developer.vichit.android.com.retrofit.R;
import developer.vichit.android.com.retrofit.interfacce_generator.ImageService;
import dmax.dialog.SpotsDialog;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    Button btnGallery, btnUpload;

    private static final int OPEN_GALLERY = 1;
    private static final int READ_EXTERNAL_STORAGE_CODE = 1;
    private String imagePath;
    private SpotsDialog dialog;
    ImageService imageService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnGallery = (Button) findViewById(R.id.btnGallery);
        btnUpload = (Button) findViewById(R.id.btnUpload);

        imageService = ServiceGenerator.createService(ImageService.class);

        dialog = new SpotsDialog(this, "Please wait...");

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    int checkedPermission = ContextCompat.checkSelfPermission(SignUpActivity.this,
                            Manifest.permission.READ_EXTERNAL_STORAGE);
                    String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                    if (checkedPermission == PackageManager.PERMISSION_DENIED) {
                        requestPermissions(permissions, READ_EXTERNAL_STORAGE_CODE);
                    } else {
                        showGallery();
                    }
                } else {
                    showGallery();
                }
            }
        });


        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(imagePath);
                RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                MultipartBody.Part body = MultipartBody.Part.createFormData("FILE", file.getName(), requestBody);

                dialog.show();

                Call<JsonObject> uploadImage = imageService.uploadSingleImage(body);
                uploadImage.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
                            dialog.dismiss();
                            Toast.makeText(SignUpActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        t.printStackTrace();
                        dialog.dismiss();
                        Toast.makeText(SignUpActivity.this, "Failed", Toast.LENGTH_SHORT).show();


                    }
                });


            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == READ_EXTERNAL_STORAGE_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showGallery();
            } else {
                Toast.makeText(this, "Please Grant Permisson", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri selectedImage = data.getData();
        String[] pathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(selectedImage, pathColumn, null, null, null);
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(pathColumn[0]);
            imagePath = cursor.getString(columnIndex);
        }

    }

    void showGallery() {
        Intent galleryIntent = new Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, OPEN_GALLERY);
    }


}