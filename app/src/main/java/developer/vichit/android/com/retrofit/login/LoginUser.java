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

import developer.vichit.android.com.retrofit.R;

public class LoginUser extends AppCompatActivity implements View.OnClickListener, Validator.ValidationListener {

    @Email(message = "Wrong Email")
    EditText edEmail;

    @Password(min = 8, message = "Invaild Password..!")
    EditText edPassword;
    Button btnLogin;
    private Validator validator;

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


    }

    @Override
    public void onClick(View v) {
        validator.validate();

    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "Doing something", Toast.LENGTH_SHORT).show();
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
