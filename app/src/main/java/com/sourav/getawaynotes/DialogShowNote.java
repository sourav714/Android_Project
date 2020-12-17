package com.sourav.getawaynotes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogShowNote extends DialogFragment {
    private Note mNote;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_show_note,null);
        TextView txtTitle = (TextView) dialogView.findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) dialogView.findViewById(R.id.txtDescription);
        txtTitle.setText(mNote.getTitle());
        txtDescription.setText(mNote.getDescription());

        TextView txtImportant = (TextView) dialogView.findViewById(R.id.textViewImportant);
        TextView txtTodo = (TextView) dialogView.findViewById(R.id.textViewTodo);
        TextView txtIdea = (TextView) dialogView.findViewById(R.id.textViewIdea);

        if(!mNote.isImportant()){
            txtImportant.setVisibility(View.GONE);
        }
        if(!mNote.isTodo()){
            txtTodo.setVisibility(View.GONE);
        }
        if(!mNote.isIdea()){
            txtIdea.setVisibility(View.GONE);
        }

        Button btnOK = (Button) dialogView.findViewById(R.id.btnOk);
        builder.setView(dialogView).setMessage("Your Note");
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return builder.create();
    }
    public void sendNoteSelected(Note noteSelected){
     mNote=noteSelected;
    }
}
