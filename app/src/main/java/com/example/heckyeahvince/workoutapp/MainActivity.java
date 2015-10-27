package com.example.heckyeahvince.workoutapp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements WorkoutList.WorkoutListListener {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id){
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            WorkoutDetail details = new WorkoutDetail();
            FragmentTransaction fragtran = getFragmentManager().beginTransaction();
            details.setWorkout(id);
            fragtran.replace(R.id.fragment_container, details);
            fragtran.addToBackStack(null);
            fragtran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragtran.commit();
        }
        else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int)id);
            startActivity(intent);
        }
    }
}