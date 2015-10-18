package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import Config.Keys;
import butterknife.Bind;
import butterknife.ButterKnife;
import firebase.mychat.com.gamelistassignment.R;


public class Youtube_Sample_Video_Fragment extends Fragment implements YouTubePlayer.Provider,
        YouTubePlayer.OnInitializedListener {


    @Bind(R.id.fragment_youtube_player)
    FrameLayout fragmentYoutubePlayer;

    @Override
    public void initialize(String s, YouTubePlayer.OnInitializedListener onInitializedListener) {


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View v = inflater.inflate(R.layout.youtube_player, container, false);
        YouTubePlayerSupportFragment mYoutubePlayerFragment = new YouTubePlayerSupportFragment();
        FragmentManager manger= getFragmentManager();
        FragmentTransaction transaction =manger.beginTransaction();
        mYoutubePlayerFragment.initialize(Keys.YOUTUBE_DEVELOPER_KEY, this);
        transaction.replace(R.id.fragment_youtube_player, mYoutubePlayerFragment);
       transaction.commit();
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer
            youTubePlayer, boolean b) {


            youTubePlayer.cueVideo("pzDifBWtPek");


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this.getActivity(), 1).show();
        } else {
            Toast.makeText(this.getActivity(),
                    "YouTubePlayer.onInitializationFailure(): " + youTubeInitializationResult
                            .toString(),
                    Toast.LENGTH_LONG).show();
        }

    }
}
