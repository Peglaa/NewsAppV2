package android.damir.stipancic.com.newsreaderv2.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ErrorDialog extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Greška")
                .setMessage("Ups, došlo je do pogreške.")
                .setPositiveButton("U REDU", (dialogInterface, i) -> {

                })
                .setCancelable(false);
        return builder.create();

    }
}
