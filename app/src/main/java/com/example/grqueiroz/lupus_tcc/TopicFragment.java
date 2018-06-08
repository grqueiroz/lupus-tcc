package com.example.grqueiroz.lupus_tcc;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grqueiroz.lupus_tcc.entity.CardContent;
import com.example.grqueiroz.lupus_tcc.entity.Content;
import com.example.grqueiroz.lupus_tcc.entity.ImageContent;
import com.example.grqueiroz.lupus_tcc.entity.Session;
import com.example.grqueiroz.lupus_tcc.entity.TextContent;
import com.example.grqueiroz.lupus_tcc.entity.TitleContent;
import com.example.grqueiroz.lupus_tcc.entity.VideoContent;
import com.example.grqueiroz.lupus_tcc.manager.NavigationStackManager;
import com.example.grqueiroz.lupus_tcc.manager.PreCachingLayoutManager;
import com.example.grqueiroz.lupus_tcc.manager.UserManager;
import com.example.grqueiroz.lupus_tcc.util.DeviceUtils;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by gabriel-queiroz on 09/03/18.
 */

public class TopicFragment extends Fragment {
    private static final String ARGUMENT_ID = "ARGUMENT_ID";
    Session session;
    Adapter adapter;

    public static TopicFragment newInstance(String sessionId) {
        TopicFragment fragment = new TopicFragment();

        Bundle args = new Bundle();
        args.putString(ARGUMENT_ID, sessionId);

        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String sessionId = this.getArguments().getString(ARGUMENT_ID);
        session = Repository.getSession(sessionId);
        getActivity().setTitle(session.getMainTopicTitle());

        PreCachingLayoutManager layoutManager = new PreCachingLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //layoutManager.setExtraLayoutSpace(DeviceUtils.getScreenHeight(getActivity()));

        adapter = new Adapter();

        View rootView = inflater.inflate(R.layout.topic_screen, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return rootView;
    }


    class Adapter extends RecyclerView.Adapter<AdapterViewHolder> {

        @Override
        public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            if (viewType == 0) {
                View view = inflater.inflate(R.layout.topic_screen_item_text, parent, false);
                return new TextViewHolder(view);
            }
            if (viewType == 1) {
                View view = inflater.inflate(R.layout.topic_screen_item_image, parent, false);
                return new ImageViewHolder(view);
            }
            if (viewType == 2) {
                View view = inflater.inflate(R.layout.topic_screen_item_card, parent, false);
                return new CardViewHolder(view);
            }
            if (viewType == 3) {
                View view =inflater.inflate(R.layout.topic_screen_item_video, parent, false);
                return new VideoViewHolder(view);
            }
            return null;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onBindViewHolder(AdapterViewHolder holder, int position) {
            final Content content = session.getContentList().get(position);
            if (content instanceof TextContent) {
                TextViewHolder textViewHolder = (TextViewHolder) holder;

                textViewHolder.textView.setText(((TextContent) content).getTextId());

                if (content instanceof TitleContent && position == 0) {
                    int size = getResources().getDimensionPixelSize(R.dimen.text_size);
                    textViewHolder.textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, size+size/2);
                    textViewHolder.textView.setTextColor(getResources().getColor(R.color.colorAccent));
                } else {
                    int size = getResources().getDimensionPixelSize(R.dimen.text_size);
                    textViewHolder.textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
                    textViewHolder.textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                }

                if(((TextContent) content).getJustify() && DeviceUtils.isVersionOver26()){
                    textViewHolder.textView.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
                }

            } else if (content instanceof ImageContent) {
                ImageViewHolder imageViewHolder = (ImageViewHolder) holder;

                imageViewHolder.imageView.setImageResource(((ImageContent) content).getDrawableResId());
            } else if (content instanceof CardContent) {
                CardViewHolder cardViewHolder = (CardViewHolder) holder;

                cardViewHolder.imageView.setImageResource(((CardContent) content).getCardImage().getDrawableResId());
                cardViewHolder.textView.setText(((CardContent) content).getCardText().getTextId());

                cardViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        navigate(((CardContent) content).getDestinationId());
                    }
                });
            } else if (content instanceof VideoContent) {
                VideoViewHolder videoViewHolder = (VideoViewHolder) holder;

                videoViewHolder.videoView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        User loggedUser = UserManager.getLoggedUser();

                        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(getContext());
                        Bundle params = new Bundle();
                        mFirebaseAnalytics.setUserProperty("idade", loggedUser.getAgeGroup());
                        mFirebaseAnalytics.setUserProperty("gênero", loggedUser.getGender());
                        mFirebaseAnalytics.setUserProperty("tipo", loggedUser.getType());
                        params.putString("video_topic", getTopicNameById(session.getId()));
                        mFirebaseAnalytics.setUserId(loggedUser.getShaid());
                        mFirebaseAnalytics.logEvent("View_Video", params);
                        Intent intent = YouTubeStandalonePlayer.createVideoIntent(getActivity(), "aaaaaaaateste", ((VideoContent) content).getUrl(), 0, true, false);
                        startActivity(intent);
                    }
                });
            }
        }

        @Override
        public int getItemViewType(int position) {
            Content content = session.getContentList().get(position);
            if (content instanceof TextContent) return 0;
            if (content instanceof ImageContent) return 1;
            if (content instanceof CardContent) return 2;
            if (content instanceof VideoContent) return 3;
            throw new IllegalStateException("Invalid content");
        }

        @Override
        public int getItemCount() {
            return session.getContentList().size();
        }

        private void navigate(String topicId) {
            User loggedUser = UserManager.getLoggedUser();

            FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(getContext());
            Bundle params = new Bundle();
            mFirebaseAnalytics.setUserProperty("idade", loggedUser.getAgeGroup());
            mFirebaseAnalytics.setUserProperty("gênero", loggedUser.getGender());
            mFirebaseAnalytics.setUserProperty("tipo", loggedUser.getType());
            params.putString("topic_name", getTopicNameById(topicId));
            mFirebaseAnalytics.setUserId(loggedUser.getShaid());
            mFirebaseAnalytics.logEvent("View_Topic", params);

            TopicFragment fragment = TopicFragment.newInstance(topicId);
            NavigationStackManager.stackSession(topicId);
            getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
    }

    abstract class AdapterViewHolder extends RecyclerView.ViewHolder {
        public AdapterViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class TextViewHolder extends AdapterViewHolder {
        TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }
    }

    private class ImageViewHolder extends AdapterViewHolder {
        ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }

    class CardViewHolder extends AdapterViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;

        public CardViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card);
            imageView = itemView.findViewById(R.id.card_image);
            textView = itemView.findViewById(R.id.card_text);
        }
    }

    class VideoViewHolder extends AdapterViewHolder {
        ImageView videoView;

        public VideoViewHolder(View itemView){
            super(itemView);

            videoView = itemView.findViewById(R.id.button);
        }
    }

    public String getTopicNameById(String topicId) {
        Session session = Repository.getSession(topicId);
        TitleContent title = (TitleContent) session.getContentList().get(0);
        return getResources().getString(title.getTextId());
    }

}
