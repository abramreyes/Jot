package com.codiaries.jot.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.codiaries.jot.adapter.viewholder.NoteVH;
import com.codiaries.jot.fragments.vms.NotesVM;
import com.codiaries.jot.model.Note;

public class NotesAdapter extends ListAdapter<Note, NoteVH> {

    public NotesAdapter(@NonNull DiffUtil.ItemCallback<Note> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public NoteVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NoteVH.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteVH holder, int position) {
        Note current = getItem(position);

        holder.bind(current.getNoteTitle(), current.getNoteDescription());

    }

    public static class WordDiff extends DiffUtil.ItemCallback<Note> {

        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getNoteTitle().equals(newItem.getNoteTitle());
        }
    }
}
