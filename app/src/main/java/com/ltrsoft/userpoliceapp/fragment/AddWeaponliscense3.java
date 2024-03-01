package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.model.ArmLicenses;
import com.ltrsoft.userpoliceapp.utils.Validations;

public class AddWeaponliscense3 extends Fragment {
    public AddWeaponliscense3() {
    }
  private View view;
    private CheckBox checkBoxApplicantAppliedBefore, checkBoxFamilyMemberSuspendedForWeapon,
            checkBoxApplicantSuspended, checkBoxHasSafePlace, checkBoxHasTraining,
            checkBoxNeedForLicense;

    private EditText editTextArmsType, editTextAmmunationDescription, editTextAreaOfArmCarry,
            editTextSpecialConsideration, editTextDetailForFormIV, editTextPlaceOfBirth,
            editTextDobInWords;

    private Button buttonSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addweapenlicence3, container, false);

        setid();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
        return view;
    }

    private void submit() {
        String armsType = editTextArmsType.getText().toString();
        String ammunationDescription = editTextAmmunationDescription.getText().toString();
        String areaOfArmCarry = editTextAreaOfArmCarry.getText().toString();
        String specialConsideration = editTextSpecialConsideration.getText().toString();
        String detailForFormIV = editTextDetailForFormIV.getText().toString();
        String placeOfBirth = editTextPlaceOfBirth.getText().toString();
        String dobInWords = editTextDobInWords.getText().toString();

        // Get checked status from CheckBox fields
        boolean applicantAppliedBefore = checkBoxApplicantAppliedBefore.isChecked();
        boolean familyMemberSuspendedForWeapon = checkBoxFamilyMemberSuspendedForWeapon.isChecked();
        boolean applicantSuspended = checkBoxApplicantSuspended.isChecked();
        boolean hasSafePlace = checkBoxHasSafePlace.isChecked();
        boolean hasTraining = checkBoxHasTraining.isChecked();
        boolean needForLicense = checkBoxNeedForLicense.isChecked();
         ArmLicenses formData=new ArmLicenses();
        formData.setArms_type(armsType);
        formData.setAmmunition_desc(ammunationDescription);
        formData.setArea_of_arm_carry(areaOfArmCarry);
        formData. setSpecial_consideration(specialConsideration);
        formData.setDetail_for_form_IV(detailForFormIV);
        formData.setPlace_of_birth(placeOfBirth);
        formData.setDob_in_words(dobInWords);
        formData.setWhether_applicant_applied_before(String.valueOf(applicantAppliedBefore));
        formData.setWhether_applicant_family_member_suspended_for_using_weapon(String.valueOf(familyMemberSuspendedForWeapon));
        formData.setWhether_applicant_suspended(String.valueOf(applicantSuspended));
        formData.setHas_safe_place_to_keep_arm(String.valueOf(hasSafePlace));
        formData.setHas_training(String.valueOf(hasTraining));
        formData.setNeed_for_license(String.valueOf(needForLicense));

    }

    private void setid() {
        checkBoxApplicantAppliedBefore = view.findViewById(R.id.checkBoxApplicantAppliedBefore);
        checkBoxFamilyMemberSuspendedForWeapon = view.findViewById(R.id.checkBoxFamilyMemberSuspendedForWeapon);
        checkBoxApplicantSuspended = view.findViewById(R.id.checkBoxApplicantSuspended);
        checkBoxHasSafePlace = view.findViewById(R.id.checkBoxHasSafePlace);
        checkBoxHasTraining = view.findViewById(R.id.checkBoxHasTraining);
        checkBoxNeedForLicense = view.findViewById(R.id.checkBoxNeedForLicense);

        // Find all EditTexts
        editTextArmsType = view.findViewById(R.id.editTextArmsType);
        editTextAmmunationDescription = view.findViewById(R.id.editTextAmmunationDescription);
        editTextAreaOfArmCarry = view.findViewById(R.id.editTextAreaOfArmCarry);
        editTextSpecialConsideration = view.findViewById(R.id.editTextSpecialConsideration);
        editTextDetailForFormIV = view.findViewById(R.id.editTextDetailForFormIV);
        editTextPlaceOfBirth = view.findViewById(R.id.editTextPlaceOfBirth);
        editTextDobInWords = view.findViewById(R.id.editTextDobInWords);

        // Find the Button
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
    }
    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextArmsType,"Enter The ArmsType ");
        valid &= Validations.validateEditText( editTextAmmunationDescription,"Enter the AmmunationDescription ");
        valid &= Validations.validateEditText(editTextAreaOfArmCarry,"Enter The AreaOfArmCarry ");
        valid &= Validations.validateEditText(editTextSpecialConsideration,"Enter The SpecialConsideration ");
        valid &= Validations.validateEditText(editTextDetailForFormIV," Enter DetailForFormIV");
        valid &= Validations.validateEditText(editTextPlaceOfBirth," Enter The PlaceOfBirth");
        valid &= Validations.validateEditText(editTextDobInWords," Enter The DobInWords");

//        valid &= Validations.validateSpinner(spinnerComplaintId,"complaint type");
//        valid &= Validations.validateSpinner(spinnerTextEvidenceTypeId,"evidenece type");

        return valid;
    }
}
