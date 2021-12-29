package com.codiaries.jot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Application;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.codiaries.jot.adapter.HomeAdapter;
import com.codiaries.jot.data.databaseController;
import com.codiaries.jot.data.repos.noteRepository;
import com.codiaries.jot.fragments.FoldersTab;
import com.codiaries.jot.fragments.NotesTab;
import com.codiaries.jot.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy {

    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private ArrayList<String> titles;
    private FloatingActionButton fab;

    private ImageView checklist, voice, image, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tab_layout);

        checklist = findViewById(R.id.checkList);
        voice = findViewById(R.id.voiceNote);
        image = findViewById(R.id.imageNote);
        text = findViewById(R.id.textNote);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSampleData(getApplication(), "Note Title 1", "Note Description #2 \n This description is for measuring height of an object.");
            }
        });

        setViewPagerAdapter();
        setTabLayout();
    }



    public void setAction(ImageView imageView, String title, String description) {
        imageView.setOnClickListener(view -> {
            addSampleData(this.getApplication(), title, description);
        });
    }

    public void setViewPagerAdapter() {
        HomeAdapter homeAdapter = new HomeAdapter(this);
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new NotesTab());
        fragmentList.add(new FoldersTab());
        homeAdapter.setData(fragmentList);
        viewPager2.setAdapter(homeAdapter);
    }

    public void setTabLayout() {
        titles = new ArrayList<>();
        titles.add("All Notes");
        titles.add("Folders");
        new TabLayoutMediator(tabLayout, viewPager2, this).attach();
    }

    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(titles.get(position));
    }

    void addSampleData(Application application, String title, String description) {
        databaseController.databaseWriteExecutor.execute(() -> {
            Note note = new Note(1, title, description, "", "");
            noteRepository repository = new noteRepository(application);
            repository.insert(note);
        });
    }
}