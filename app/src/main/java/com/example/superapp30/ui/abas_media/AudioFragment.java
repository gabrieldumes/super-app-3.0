package com.example.superapp30.ui.abas_media;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.superapp30.R;

public class AudioFragment extends Fragment {

    private Button buttonVolume, buttonPlayPause, buttonStop;
    private TextView textStatusPlayer;
    private SeekBar seekVolume;

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio, container, false);

        buttonVolume = view.findViewById(R.id.buttonVolume);
        buttonPlayPause = view.findViewById(R.id.buttonPlayPause);
        buttonStop = view.findViewById(R.id.buttonStop);
        textStatusPlayer = view.findViewById(R.id.textPlayerStatus);
        seekVolume = view.findViewById(R.id.seekVolume);

        seekVolume.setVisibility(View.INVISIBLE);

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

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.bensound_erf_short);
                    textStatusPlayer.setText("Pressione o play para iniciar");
                    buttonPlayPause.setText("Play");
                }
            }
        });

        buttonVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seekVolume.getVisibility() != View.VISIBLE) {
                    seekVolume.setVisibility(View.VISIBLE);
                } else {
                    seekVolume.setVisibility(View.INVISIBLE);
                }
            }
        });

        controlarSeekBar();

        return view;
    }

    public void controlarSeekBar() {
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        int volMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        seekVolume.setMax(volMax);
        seekVolume.setProgress(volAtual);
        seekVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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