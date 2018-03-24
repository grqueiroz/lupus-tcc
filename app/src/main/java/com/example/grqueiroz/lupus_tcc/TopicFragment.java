package com.example.grqueiroz.lupus_tcc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
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

import me.biubiubiu.justifytext.library.JustifyTextView;

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
        adapter = new Adapter();

        View rootView =inflater.inflate(R.layout.topic_screen, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.list);

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
            return null;
        }

        @Override
        public void onBindViewHolder(AdapterViewHolder holder, int position) {
            final Content content = session.getContentList().get(position);
            if (content instanceof TextContent) {
                TextViewHolder textViewHolder = (TextViewHolder) holder;

                textViewHolder.textView.setText(((TextContent) content).getTextId());

                if(((TextContent) content).getIsTitle()){
                    textViewHolder.textView.setTextSize(getResources().getDimension(R.dimen.title_size));
                    textViewHolder.textView.setTextColor(getResources().getColor(R.color.colorPrimary));
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
            }
        }

        @Override
        public int getItemViewType(int position) {
            Content content = session.getContentList().get(position);
            if (content instanceof TextContent) return 0;
            if (content instanceof ImageContent) return 1;
            if (content instanceof CardContent) return 2;
            throw new IllegalStateException("Invalid content");
        }

        @Override
        public int getItemCount() {
            return session.getContentList().size();
        }

        private void navigate(String topicId) {
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
        JustifyTextView textView;

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

}
