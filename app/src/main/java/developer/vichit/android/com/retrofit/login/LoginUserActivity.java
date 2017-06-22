package developer.vichit.android.com.retrofit.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import developer.vichit.android.com.retrofit.article_respone.LoginRespone;
import developer.vichit.android.com.retrofit.service_generator.ServiceGenerator;
import developer.vichit.android.com.retrofit.R;
import developer.vichit.android.com.retrofit.form_request.UserLogin;
import developer.vichit.android.com.retrofit.interfacce_generator.LoginService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserActivity extends AppCompatActivity implements View.OnClickListener, Validator.ValidationListener {

    @Email(message = "Wrong Email")
    EditText edEmail;

    @Password(min = 6, message = "Invaild Password..!")
    EditText edPassword;
    Button btnLogin;

    Validator validator;
    LoginService loginService;
    UserLogin userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        edEmail = (EditText) findViewById(R.id.edEmail_Login);
        edPassword = (EditText) findViewById(R.id.edPassowrd_Login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        validator = new Validator(this);
        validator.setValidationListener(this);

        loginService = ServiceGenerator.createService(LoginService.class);



    }

    @Override
    public void onClick(View v) {
        validator.validate();

    }

    @Override
    public void onValidationSucceeded() {
        userLogin = new UserLogin();
        userLogin.setEMAIL(edEmail.getText().toString());
        userLogin.setPassword(edPassword.getText().toString());

        Call<LoginRespone> loginRespone = loginService.loginUser(userLogin);
        loginRespone.enqueue(new Callback<LoginRespone>() {
            @Override
            public void onResponse(Call<LoginRespone> call, Response<LoginRespone> response) {
                if (response.body().getCode().equals("0000")){
                    Toast.makeText(getApplicationContext(),"successfully",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(),"suceesfully failed",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginRespone> call, Throwable t) {

            }
        });



    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }

    }
}
