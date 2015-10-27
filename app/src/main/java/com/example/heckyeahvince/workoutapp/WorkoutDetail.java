package com.example.heckyeahvince.workoutapp;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WorkoutDetail extends Fragment {
    private long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(savedInstanceState != null) {
            workoutId = savedInstanceState.getLong("workoutId");
        }
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putLong("workoutId", workoutId);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null){
            TextView workoutTitle = (TextView) view.findViewById(R.id.workoutTitle);
            Workout workout = Workout.workouts[(int) workoutId ];
            workoutTitle.setText(workout.getName());
            TextView workoutDescription = (TextView) view.findViewById(R.id.workoutDescription);
            workoutDescription.setText(workout.getDescription());
        }
    }

    public void setWorkout(long id){
        this.workoutId = id;
    }
}
