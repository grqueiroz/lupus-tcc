package com.example.grqueiroz.lupus_tcc;

import com.example.grqueiroz.lupus_tcc.entity.CardContent;
import com.example.grqueiroz.lupus_tcc.entity.Content;
import com.example.grqueiroz.lupus_tcc.entity.ImageContent;
import com.example.grqueiroz.lupus_tcc.entity.Session;
import com.example.grqueiroz.lupus_tcc.entity.TextContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriel-queiroz on 05/03/18.
 */

public class Repository {
    private static List<Session> sessionList = new ArrayList<>();

    //Topic 1
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic1, true));
        contentList.add(new TextContent(R.string.topic1_paragraph1));
        contentList.add(new TextContent(R.string.topic1_paragraph2));
        contentList.add(new ImageContent(R.drawable.t1f1));
        contentList.add(new TextContent(R.string.topic1_paragraph3));
        contentList.add(new TextContent(R.string.topic1_paragraph4));
        contentList.add(new ImageContent(R.drawable.t1f2));
        contentList.add(new CardContent("card1", "topic4", new ImageContent(R.drawable.t4f1), new TextContent(R.string.title_topic4)));
        sessionList.add(new Session("topic1", R.string.title_topic1, contentList, "url"));
    }

    //Topic 2
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic2, true));
        contentList.add(new TextContent(R.string.topic2_paragraph1));
        contentList.add(new TextContent(R.string.topic2_paragraph2));
        contentList.add(new ImageContent(R.drawable.t2f1));
        contentList.add(new TextContent(R.string.topic2_paragraph3));
        contentList.add(new TextContent(R.string.topic2_paragraph4));
        sessionList.add(new Session("topic2", R.string.title_topic2, contentList, "url"));
    }

    //Topic 3
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic3_friendly, true));
        contentList.add(new TextContent(R.string.topic3_paragraph1));
        contentList.add(new TextContent(R.string.topic3_paragraph2));
        contentList.add(new ImageContent(R.drawable.t3f1));
        contentList.add(new TextContent(R.string.topic3_paragraph3));
        sessionList.add(new Session("topic3", R.string.title_topic3, contentList, "url"));
    }

    //Topic 4
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic4, true));
        contentList.add(new TextContent(R.string.topic4_paragraph1));
        contentList.add(new ImageContent(R.drawable.t4f1));
        contentList.add(new TextContent(R.string.topic4_paragraph2));
        contentList.add(new CardContent("card4", "topic1", new ImageContent(R.drawable.t1f1), new TextContent(R.string.title_topic1)));
        sessionList.add(new Session("topic4", R.string.title_topic4_friendly, contentList, "url"));
    }

    //Topic 5
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic5, true));
        contentList.add(new TextContent(R.string.topic5_paragraph1));
        contentList.add(new ImageContent(R.drawable.t5f1));
        contentList.add(new TextContent(R.string.topic5_paragraph2));
        sessionList.add(new Session("topic5", R.string.title_topic5, contentList, "url"));
    }

    //Topic 6
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic6, true));
        contentList.add(new TextContent(R.string.topic6_paragraph1));
        contentList.add(new TextContent(R.string.topic6_paragraph2));
        contentList.add(new ImageContent(R.drawable.t6f1));
        contentList.add(new TextContent(R.string.topic6_paragraph3));
        sessionList.add(new Session("topic6", R.string.title_topic6, contentList, "url"));
    }

    public static Session getSession(String sessionId) {
        for (Session session : sessionList) {
            if (session.getId().equals(sessionId)) return session;
        }
        return null;
    }

}
