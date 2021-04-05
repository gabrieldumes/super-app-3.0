package com.example.superapp30.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.superapp30.R;
import com.example.superapp30.ui.abas_media.AudioFragment;
import com.example.superapp30.ui.abas_media.VideoFragment;

public class MediaFragment extends Fragment {

    private Button buttonAudio, buttonVideo;
    private AudioFragment audioFragment;
    private VideoFragment videoFragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_media, container, false);

        buttonAudio = view.findViewById(R.id.buttonAudio);
        buttonVideo = view.findViewById(R.id.buttonVideo);

        audioFragment = new AudioFragment();
        videoFragment = new VideoFragment();

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameMedia, audioFragment).commit();

        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameMedia, audioFragment).commit();
            }
        });

        buttonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameMedia, videoFragment).commit();
            }
        });

        return view;
    }
}