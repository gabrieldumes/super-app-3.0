package com.example.superapp30.ui.abas_media;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.superapp30.R;

public class AudioFragment extends Fragment {

    private Button buttonPlayPause;
    private TextView textStatusPlayer;

    private MediaPlayer mediaPlayer;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio, container, false);

        buttonPlayPause = view.findViewById(R.id.buttonPlayPause);
        textStatusPlayer = view.findViewById(R.id.textPlayerStatus);

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.bensound_erf_short);

        buttonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        buttonPlayPause.setText("Play");
                        textStatusPlayer.setText("Pausado");
                    } else {
                        mediaPlayer.start();
                        buttonPlayPause.setText("Pause");
                        textStatusPlayer.setText("Em execução");
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}