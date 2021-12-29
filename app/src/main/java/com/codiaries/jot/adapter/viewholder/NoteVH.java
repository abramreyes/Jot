package com.codiaries.jot.adapter.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codiaries.jot.R;


public class NoteVH extends RecyclerView.ViewHolder {

    private TextView noteTitle, noteDescription;

    public NoteVH(@NonNull View itemView) {
        super(itemView);

        noteTitle = itemView.findViewById(R.id.noteTitle);
        noteDescription = itemView.findViewById(R.id.noteDescription);

    }

    public void bind(String title, String desc) {
        noteTitle.setText(title);
        noteDescription.setText(desc);
    }

    public static NoteVH create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);

        return new NoteVH(view);
    }
}
