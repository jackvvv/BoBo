package sinia.com.bobo.utils;

import android.widget.Toast;

import com.mobsandgeeks.saripaar.Rule;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;

import java.util.List;

import sinia.com.bobo.base.BaseApplication;

public class ValidationUtils {

    public static class ValidationListener implements
            Validator.ValidationListener {

        @Override
        public void onValidationSucceeded() {
            // TODO Auto-generated method stub

        }

        @SuppressWarnings("rawtypes")
        @Override
        public void onValidationFailed(List<ValidationError> errors) {
            // TODO Auto-generated method stub
            for (ValidationError error : errors) {
                boolean flag = false;
                List<Rule> failedRules = error.getFailedRules();
                for (Rule failedRule : failedRules) {
                    Toast.makeText(BaseApplication.getInstance(),
                            failedRule.getMessage(BaseApplication.getInstance()),
                            Toast.LENGTH_SHORT).show();
                    flag = true;
                    break;
                }
                if (flag) {
                    break;
                }
            }
        }
    }
}
