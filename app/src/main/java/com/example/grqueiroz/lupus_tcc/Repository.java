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
        contentList.add(new TextContent(R.string.topic1_paragraph1));
        contentList.add(new TextContent(R.string.topic1_paragraph2));
        contentList.add(new ImageContent(R.drawable.t1f1));
        contentList.add(new TextContent(R.string.topic1_paragraph3));
        contentList.add(new TextContent(R.string.topic1_paragraph4));
        contentList.add(new CardContent("card1", "topic4", new ImageContent(R.drawable.t4f1), new TextContent(R.string.title_topic4)));
        sessionList.add(new Session("topic1", contentList, "url"));
    }

    //Topic 4
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.topic4_paragraph1));
        contentList.add(new ImageContent(R.drawable.t4f1));
        contentList.add(new TextContent(R.string.topic4_paragraph2));
        sessionList.add(new Session("topic4", contentList, "url"));
    }

    public static Session getSession(String sessionId) {
        for (Session session : sessionList) {
            if (session.getId().equals(sessionId)) return session;
        }
        return null;
    }

}
