package com.codiaries.jot.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codiaries.jot.R;
import com.codiaries.jot.adapter.NotesAdapter;
import com.codiaries.jot.fragments.vms.NotesVM;
import com.google.android.material.internal.FlowLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotesTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotesTab extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NotesTab() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotesTab.
     */
    // TODO: Rename and change types and number of parameters
    public static NotesTab newInstance(String param1, String param2) {
        NotesTab fragment = new NotesTab();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.notes_tab, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recView);
        final NotesAdapter adapter = new NotesAdapter(new NotesAdapter.WordDiff());

        NotesVM vm = new ViewModelProvider(this).get(NotesVM.class);
        vm.getmNotes().observe(getViewLifecycleOwner(), adapter::submitList);

        recyclerView.setAdapter(adapter);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(layoutManager);

        return v;
    }
}