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
        contentList.add(new TextContent(R.string.topic1_par1));
        contentList.add(new TextContent(R.string.topic1_par2));
        contentList.add(new ImageContent(R.drawable.t1f1));
        contentList.add(new TextContent(R.string.topic1_par3));
        contentList.add(new TextContent(R.string.topic1_par4));
        contentList.add(new ImageContent(R.drawable.t1f2));
        contentList.add(new CardContent("topic4", new ImageContent(R.drawable.t4f1), new TextContent(R.string.title_card_topic4)));
        contentList.add(new CardContent("topic6", new ImageContent(R.drawable.t6f1), new TextContent(R.string.title_card_topic6)));
        sessionList.add(new Session("topic1", R.string.title_topic1, contentList, "url"));
    }

    //Topic 2
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic2, true));
        contentList.add(new TextContent(R.string.topic2_par1));
        contentList.add(new TextContent(R.string.topic2_par2));
        contentList.add(new ImageContent(R.drawable.t2f1));
        contentList.add(new TextContent(R.string.topic2_par3));
        contentList.add(new TextContent(R.string.topic2_par4));
        sessionList.add(new Session("topic2", R.string.title_topic2, contentList, "url"));
    }

    //Topic 3
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic3, true));
        contentList.add(new TextContent(R.string.topic3_par1));
        contentList.add(new TextContent(R.string.topic3_par2));
        contentList.add(new ImageContent(R.drawable.t3f1));
        contentList.add(new TextContent(R.string.topic3_par3));
        contentList.add(new CardContent( "topic3_1", new ImageContent(R.drawable.t3_1f1), new TextContent(R.string.title_card_topic3_1)));
        contentList.add(new CardContent( "topic3_2", new ImageContent(R.drawable.t3_2f1), new TextContent(R.string.title_card_topic3_2)));
        sessionList.add(new Session("topic3", R.string.title_topic3, contentList, "url"));
    }

    //Topic 3.1
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic3_1, true));
        contentList.add(new TextContent(R.string.topic3_1_par1));
        contentList.add(new ImageContent(R.drawable.t3_1f1));
        contentList.add(new TextContent(R.string.topic3_1_par2));
        contentList.add(new TextContent(R.string.topic3_1_par3));
        contentList.add(new ImageContent(R.drawable.t3_1f2));
        contentList.add(new TextContent(R.string.topic3_1_par4, false, false));
        contentList.add(new CardContent( "topic3", new ImageContent(R.drawable.t3f1), new TextContent(R.string.title_card_topic3)));
        contentList.add(new CardContent( "topic3_2", new ImageContent(R.drawable.t3_2f1), new TextContent(R.string.title_card_topic3_2)));
        sessionList.add(new Session("topic3_1", R.string.title_topic3, contentList));
    }

    //Topic 3.2
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic3_2, true));
        contentList.add(new TextContent(R.string.topic3_2_par1));
        contentList.add(new TextContent(R.string.topic3_2_par2));
        contentList.add(new ImageContent(R.drawable.t3_2f1));
        contentList.add(new TextContent(R.string.topic3_2_par3));
        contentList.add(new CardContent( "topic3", new ImageContent(R.drawable.t3f1), new TextContent(R.string.title_card_topic3)));
        contentList.add(new CardContent( "topic3_1", new ImageContent(R.drawable.t3_1f1), new TextContent(R.string.title_card_topic3_1)));
        sessionList.add(new Session("topic3_2", R.string.title_topic3_2, contentList));
    }

    //Topic 4
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic4, true));
        contentList.add(new TextContent(R.string.topic4_par1));
        contentList.add(new ImageContent(R.drawable.t4f1));
        contentList.add(new TextContent(R.string.topic4_par2));
        contentList.add(new CardContent("topic4_1", new ImageContent(R.drawable.t4_1f1), new TextContent(R.string.title_card_topic4_1)));
        contentList.add(new CardContent("topic4_2", new ImageContent(R.drawable.t4_2f1), new TextContent(R.string.title_card_topic4_2)));
        contentList.add(new CardContent("topic4_3", new ImageContent(R.drawable.t4_3f1), new TextContent(R.string.title_card_topic4_3)));
        contentList.add(new CardContent("topic4_4", new ImageContent(R.drawable.t4_4f1), new TextContent(R.string.title_card_topic4_4)));
        contentList.add(new CardContent("topic4_5", new ImageContent(R.drawable.t4_5f1), new TextContent(R.string.title_card_topic4_5)));
        sessionList.add(new Session("topic4", R.string.title_topic4_friendly, contentList, "url"));
    }

    //Topic 4.1
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic4_1, true));
        contentList.add(new TextContent(R.string.topic4_1_par1));
        contentList.add(new TextContent(R.string.topic4_1_par2));
        contentList.add(new ImageContent(R.drawable.t4_1f1));
        contentList.add(new TextContent(R.string.topic4_1_par3));
        contentList.add(new TextContent(R.string.topic4_1_par4));
        contentList.add(new CardContent("topic4_2", new ImageContent(R.drawable.t4_2f1), new TextContent(R.string.title_card_topic4_2)));
        contentList.add(new CardContent("topic4_3", new ImageContent(R.drawable.t4_3f1), new TextContent(R.string.title_card_topic4_3)));
        contentList.add(new CardContent("topic4_4", new ImageContent(R.drawable.t4_4f1), new TextContent(R.string.title_card_topic4_4)));
        contentList.add(new CardContent("topic4_5", new ImageContent(R.drawable.t4_5f1), new TextContent(R.string.title_card_topic4_5)));
        sessionList.add(new Session("topic4_1", R.string.title_topic4_friendly, contentList));
    }
    //Topic 4.2
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic4_2, true));
        contentList.add(new TextContent(R.string.topic4_2_par1));
        contentList.add(new TextContent(R.string.topic4_2_par2));
        contentList.add(new ImageContent(R.drawable.t4_2f1));
        contentList.add(new TextContent(R.string.topic4_2_par3));
        contentList.add(new TextContent(R.string.topic4_2_par4));
        contentList.add(new CardContent("topic4_1", new ImageContent(R.drawable.t4_1f1), new TextContent(R.string.title_card_topic4_1)));
        contentList.add(new CardContent("topic4_3", new ImageContent(R.drawable.t4_3f1), new TextContent(R.string.title_card_topic4_3)));
        contentList.add(new CardContent("topic4_4", new ImageContent(R.drawable.t4_4f1), new TextContent(R.string.title_card_topic4_4)));
        contentList.add(new CardContent("topic4_5", new ImageContent(R.drawable.t4_5f1), new TextContent(R.string.title_card_topic4_5)));
        sessionList.add(new Session("topic4_2", R.string.title_topic4_friendly, contentList));
    }
    //Topic 4.3
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic4_3, true));
        contentList.add(new TextContent(R.string.topic4_3_par1));
        contentList.add(new TextContent(R.string.topic4_4_par2));
        contentList.add(new ImageContent(R.drawable.t4_4f1));
        contentList.add(new TextContent(R.string.topic4_4_par3));
        contentList.add(new CardContent("topic4_1", new ImageContent(R.drawable.t4_1f1), new TextContent(R.string.title_card_topic4_1)));
        contentList.add(new CardContent("topic4_2", new ImageContent(R.drawable.t4_2f1), new TextContent(R.string.title_card_topic4_2)));
        contentList.add(new CardContent("topic4_4", new ImageContent(R.drawable.t4_4f1), new TextContent(R.string.title_card_topic4_4)));
        contentList.add(new CardContent("topic4_5", new ImageContent(R.drawable.t4_5f1), new TextContent(R.string.title_card_topic4_5)));
        sessionList.add(new Session("topic4_3", R.string.title_topic4_friendly, contentList));
    }
    //Topic 4.4
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic4_4, true));
        contentList.add(new TextContent(R.string.topic4_4_par1));
        contentList.add(new TextContent(R.string.topic4_4_par2));
        contentList.add(new ImageContent(R.drawable.t4_4f1));
        contentList.add(new TextContent(R.string.topic4_4_par3));
        contentList.add(new TextContent(R.string.topic4_4_par4, false, false));
        contentList.add(new ImageContent(R.drawable.t4_4f2));
        contentList.add(new TextContent(R.string.topic4_4_par5, false, false));
        contentList.add(new CardContent("topic4_1", new ImageContent(R.drawable.t4_1f1), new TextContent(R.string.title_card_topic4_1)));
        contentList.add(new CardContent("topic4_2", new ImageContent(R.drawable.t4_2f1), new TextContent(R.string.title_card_topic4_2)));
        contentList.add(new CardContent("topic4_3", new ImageContent(R.drawable.t4_3f1), new TextContent(R.string.title_card_topic4_3)));
        contentList.add(new CardContent("topic4_5", new ImageContent(R.drawable.t4_5f1), new TextContent(R.string.title_card_topic4_5)));
        sessionList.add(new Session("topic4_4", R.string.title_topic4_friendly, contentList));
    }
    //Topic 4.5
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic4_5, true));
        contentList.add(new TextContent(R.string.topic4_5_par1));
        contentList.add(new ImageContent(R.drawable.t4_5f1));
        contentList.add(new TextContent(R.string.topic4_5_par2));
        contentList.add(new TextContent(R.string.topic4_5_par3, false, false));
        contentList.add(new CardContent("topic4_1", new ImageContent(R.drawable.t4_1f1), new TextContent(R.string.title_card_topic4_1)));
        contentList.add(new CardContent("topic4_2", new ImageContent(R.drawable.t4_2f1), new TextContent(R.string.title_card_topic4_2)));
        contentList.add(new CardContent("topic4_3", new ImageContent(R.drawable.t4_3f1), new TextContent(R.string.title_card_topic4_3)));
        contentList.add(new CardContent("topic4_4", new ImageContent(R.drawable.t4_4f1), new TextContent(R.string.title_card_topic4_4)));
        sessionList.add(new Session("topic4_5", R.string.title_topic4_friendly, contentList));
    }

    //Topic 5
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic5, true));
        contentList.add(new TextContent(R.string.topic5_par1));
        contentList.add(new ImageContent(R.drawable.t5f1));
        contentList.add(new TextContent(R.string.topic5_par2));
        contentList.add(new CardContent("topic5_1", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_1)));
        contentList.add(new CardContent("topic5_2", new ImageContent(R.drawable.t5_2f1), new TextContent(R.string.title_card_topic5_2)));
        contentList.add(new CardContent("topic5_3", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_3)));
        contentList.add(new CardContent("topic5_4", new ImageContent(R.drawable.t5_2f1), new TextContent(R.string.title_card_topic5_4)));
        contentList.add(new CardContent("topic5_5", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_5)));

        sessionList.add(new Session("topic5", R.string.title_topic5, contentList, "url"));
    }

    //Topic 5.1
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic5_1, true));
        contentList.add(new TextContent(R.string.topic5_1_par1));
        contentList.add(new ImageContent(R.drawable.t5_1f1));
        contentList.add(new TextContent(R.string.topic5_1_par2));
        contentList.add(new CardContent("topic5", new ImageContent(R.drawable.t5f1), new TextContent(R.string.title_card_topic5)));
        contentList.add(new CardContent("topic5_2", new ImageContent(R.drawable.t5_2f1), new TextContent(R.string.title_card_topic5_2)));
        contentList.add(new CardContent("topic5_3", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_3)));
        contentList.add(new CardContent("topic5_4", new ImageContent(R.drawable.t5_2f1), new TextContent(R.string.title_card_topic5_4)));
        contentList.add(new CardContent("topic5_5", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_5)));

        sessionList.add(new Session("topic5_1", R.string.title_topic5, contentList));
    }

    //Topic 5.2
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic5_2, true));
        contentList.add(new TextContent(R.string.topic5_2_par1));
        contentList.add(new ImageContent(R.drawable.t5_2f1));
        contentList.add(new TextContent(R.string.topic5_2_par2));
        contentList.add(new TextContent(R.string.topic5_2_par3));
        contentList.add(new TextContent(R.string.topic5_2_par4));
        contentList.add(new TextContent(R.string.topic5_2_par5));

        contentList.add(new CardContent("topic5", new ImageContent(R.drawable.t5f1), new TextContent(R.string.title_card_topic5)));
        contentList.add(new CardContent("topic5_1", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_1)));
        contentList.add(new CardContent("topic5_3", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_3)));
        contentList.add(new CardContent("topic5_4", new ImageContent(R.drawable.t5_2f1), new TextContent(R.string.title_card_topic5_4)));
        contentList.add(new CardContent("topic5_5", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_5)));

        sessionList.add(new Session("topic5_2", R.string.title_topic5, contentList));
    }

    //Topic 5.3
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic5_3, true));
        contentList.add(new TextContent(R.string.topic5_3_par1));
        contentList.add(new TextContent(R.string.topic5_3_par2));
        contentList.add(new TextContent(R.string.topic5_3_par3));
        contentList.add(new TextContent(R.string.topic5_3_par4));
        contentList.add(new TextContent(R.string.topic5_3_par5));
        contentList.add(new TextContent(R.string.topic5_3_par6));
        contentList.add(new TextContent(R.string.topic5_3_par7));
        contentList.add(new TextContent(R.string.topic5_3_par8));

        contentList.add(new CardContent("topic5", new ImageContent(R.drawable.t5f1), new TextContent(R.string.title_card_topic5)));
        contentList.add(new CardContent("topic5_1", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_1)));
        contentList.add(new CardContent("topic5_2", new ImageContent(R.drawable.t5_2f1), new TextContent(R.string.title_card_topic5_2)));
        contentList.add(new CardContent("topic5_4", new ImageContent(R.drawable.t5_2f1), new TextContent(R.string.title_card_topic5_4)));
        contentList.add(new CardContent("topic5_5", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_5)));

        sessionList.add(new Session("topic5_3", R.string.title_topic5, contentList));
    }

    //Topic 5.4
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic5_4, true));
        contentList.add(new TextContent(R.string.topic5_4_par1));
        contentList.add(new TextContent(R.string.topic5_4_par2));
        contentList.add(new CardContent("topic5", new ImageContent(R.drawable.t5f1), new TextContent(R.string.title_card_topic5)));
        contentList.add(new CardContent("topic5_1", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_1)));
        contentList.add(new CardContent("topic5_2", new ImageContent(R.drawable.t5_2f1), new TextContent(R.string.title_card_topic5_2)));
        contentList.add(new CardContent("topic5_3", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_3)));
        contentList.add(new CardContent("topic5_5", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_5)));

        sessionList.add(new Session("topic5_4", R.string.title_topic5, contentList));
    }

    //Topic 5.5
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic5_5, true));
        contentList.add(new TextContent(R.string.topic5_5_par1));
        contentList.add(new TextContent(R.string.topic5_5_par2));
        contentList.add(new TextContent(R.string.topic5_5_par3));
        contentList.add(new CardContent("topic5", new ImageContent(R.drawable.t5f1), new TextContent(R.string.title_card_topic5)));
        contentList.add(new CardContent("topic5_1", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_1)));
        contentList.add(new CardContent("topic5_2", new ImageContent(R.drawable.t5_2f1), new TextContent(R.string.title_card_topic5_2)));
        contentList.add(new CardContent("topic5_3", new ImageContent(R.drawable.t5_1f1), new TextContent(R.string.title_card_topic5_3)));
        contentList.add(new CardContent("topic5_4", new ImageContent(R.drawable.t5_2f1), new TextContent(R.string.title_card_topic5_4)));

        sessionList.add(new Session("topic5_5", R.string.title_topic5, contentList));
    }

    //Topic 6
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic6, true));
        contentList.add(new TextContent(R.string.topic6_par1));
        contentList.add(new TextContent(R.string.topic6_par2));
        contentList.add(new ImageContent(R.drawable.t6f1));
        contentList.add(new TextContent(R.string.topic6_par3));
        contentList.add(new CardContent("topic6_1", new ImageContent(R.drawable.t6_1f1), new TextContent(R.string.title_card_topic6_1)));
        contentList.add(new CardContent("topic6_2", new ImageContent(R.drawable.t6_2f1), new TextContent(R.string.title_card_topic6_2)));
        contentList.add(new CardContent("topic6_3", new ImageContent(R.drawable.t6_3f1), new TextContent(R.string.title_card_topic6_3)));
        contentList.add(new CardContent("topic6_4", new ImageContent(R.drawable.t6_4f1), new TextContent(R.string.title_card_topic6_4)));
        contentList.add(new CardContent("topic6_5", new ImageContent(R.drawable.t6_5f1), new TextContent(R.string.title_card_topic6_5)));
        contentList.add(new CardContent("topic6_6", new ImageContent(R.drawable.t6_6f1), new TextContent(R.string.title_card_topic6_6)));
        contentList.add(new CardContent("topic6_7", new ImageContent(R.drawable.t6_7f1), new TextContent(R.string.title_card_topic6_7)));

        sessionList.add(new Session("topic6", R.string.title_topic6, contentList, "url"));
    }

    //Topic 6.1
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic6_1, true));
        contentList.add(new TextContent(R.string.topic6_1_par1));
        contentList.add(new TextContent(R.string.topic6_1_par2));
        contentList.add(new ImageContent(R.drawable.t6_1f1));
        contentList.add(new TextContent(R.string.topic6_1_par3));
        contentList.add(new TextContent(R.string.topic6_1_par4));
        contentList.add(new TextContent(R.string.topic6_1_par5, false, false));
        contentList.add(new CardContent("topic6", new ImageContent(R.drawable.t6f1), new TextContent(R.string.title_card_topic6)));
        contentList.add(new CardContent("topic6_2", new ImageContent(R.drawable.t6_2f1), new TextContent(R.string.title_card_topic6_2)));
        contentList.add(new CardContent("topic6_3", new ImageContent(R.drawable.t6_3f1), new TextContent(R.string.title_card_topic6_3)));
        contentList.add(new CardContent("topic6_4", new ImageContent(R.drawable.t6_4f1), new TextContent(R.string.title_card_topic6_4)));
        contentList.add(new CardContent("topic6_5", new ImageContent(R.drawable.t6_5f1), new TextContent(R.string.title_card_topic6_5)));
        contentList.add(new CardContent("topic6_6", new ImageContent(R.drawable.t6_6f1), new TextContent(R.string.title_card_topic6_6)));
        contentList.add(new CardContent("topic6_7", new ImageContent(R.drawable.t6_7f1), new TextContent(R.string.title_card_topic6_7)));


        sessionList.add(new Session("topic6_1", R.string.title_topic6, contentList));
    }

    //Topic 6.2
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic6_2, true));
        contentList.add(new TextContent(R.string.topic6_2_par1));
        contentList.add(new TextContent(R.string.topic6_2_par2));
        contentList.add(new ImageContent(R.drawable.t6_2f1));
        contentList.add(new TextContent(R.string.topic6_2_par3));
        contentList.add(new TextContent(R.string.topic6_2_par4));
        contentList.add(new TextContent(R.string.topic6_2_par5));
        contentList.add(new CardContent("topic6", new ImageContent(R.drawable.t6f1), new TextContent(R.string.title_card_topic6)));
        contentList.add(new CardContent("topic6_1", new ImageContent(R.drawable.t6_1f1), new TextContent(R.string.title_card_topic6_1)));
        contentList.add(new CardContent("topic6_3", new ImageContent(R.drawable.t6_3f1), new TextContent(R.string.title_card_topic6_3)));
        contentList.add(new CardContent("topic6_4", new ImageContent(R.drawable.t6_4f1), new TextContent(R.string.title_card_topic6_4)));
        contentList.add(new CardContent("topic6_5", new ImageContent(R.drawable.t6_5f1), new TextContent(R.string.title_card_topic6_5)));
        contentList.add(new CardContent("topic6_6", new ImageContent(R.drawable.t6_6f1), new TextContent(R.string.title_card_topic6_6)));
        contentList.add(new CardContent("topic6_7", new ImageContent(R.drawable.t6_7f1), new TextContent(R.string.title_card_topic6_7)));


        sessionList.add(new Session("topic6_2", R.string.title_topic6, contentList));
    }

    //Topic 6.3
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic6_3, true));
        contentList.add(new TextContent(R.string.topic6_3_par1));
        contentList.add(new TextContent(R.string.topic6_3_par2));
        contentList.add(new ImageContent(R.drawable.t6_3f1));
        contentList.add(new TextContent(R.string.topic6_3_par3));
        contentList.add(new TextContent(R.string.topic6_3_par4, false, false));
        contentList.add(new CardContent("topic6", new ImageContent(R.drawable.t6f1), new TextContent(R.string.title_card_topic6)));
        contentList.add(new CardContent("topic6_1", new ImageContent(R.drawable.t6_1f1), new TextContent(R.string.title_card_topic6_1)));
        contentList.add(new CardContent("topic6_2", new ImageContent(R.drawable.t6_2f1), new TextContent(R.string.title_card_topic6_2)));
        contentList.add(new CardContent("topic6_4", new ImageContent(R.drawable.t6_4f1), new TextContent(R.string.title_card_topic6_4)));
        contentList.add(new CardContent("topic6_5", new ImageContent(R.drawable.t6_5f1), new TextContent(R.string.title_card_topic6_5)));
        contentList.add(new CardContent("topic6_6", new ImageContent(R.drawable.t6_6f1), new TextContent(R.string.title_card_topic6_6)));
        contentList.add(new CardContent("topic6_7", new ImageContent(R.drawable.t6_7f1), new TextContent(R.string.title_card_topic6_7)));


        sessionList.add(new Session("topic6_3", R.string.title_topic6, contentList));
    }

    //Topic 6.4
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic6_4, true));
        contentList.add(new TextContent(R.string.topic6_4_par1));
        contentList.add(new TextContent(R.string.topic6_4_par2));
        contentList.add(new ImageContent(R.drawable.t6_4f1));
        contentList.add(new TextContent(R.string.topic6_4_par3));
        contentList.add(new CardContent("topic6", new ImageContent(R.drawable.t6f1), new TextContent(R.string.title_card_topic6)));
        contentList.add(new CardContent("topic6_1", new ImageContent(R.drawable.t6_1f1), new TextContent(R.string.title_card_topic6_1)));
        contentList.add(new CardContent("topic6_2", new ImageContent(R.drawable.t6_2f1), new TextContent(R.string.title_card_topic6_2)));
        contentList.add(new CardContent("topic6_3", new ImageContent(R.drawable.t6_3f1), new TextContent(R.string.title_card_topic6_3)));
        contentList.add(new CardContent("topic6_5", new ImageContent(R.drawable.t6_5f1), new TextContent(R.string.title_card_topic6_5)));
        contentList.add(new CardContent("topic6_6", new ImageContent(R.drawable.t6_6f1), new TextContent(R.string.title_card_topic6_6)));
        contentList.add(new CardContent("topic6_7", new ImageContent(R.drawable.t6_7f1), new TextContent(R.string.title_card_topic6_7)));


        sessionList.add(new Session("topic6_4", R.string.title_topic6, contentList));
    }

    //Topic 6.5
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic6_5, true));
        contentList.add(new TextContent(R.string.topic6_5_par1));
        contentList.add(new ImageContent(R.drawable.t6_5f1));
        contentList.add(new TextContent(R.string.topic6_5_par2));
        contentList.add(new CardContent("topic6", new ImageContent(R.drawable.t6f1), new TextContent(R.string.title_card_topic6)));
        contentList.add(new CardContent("topic6_1", new ImageContent(R.drawable.t6_1f1), new TextContent(R.string.title_card_topic6_1)));
        contentList.add(new CardContent("topic6_2", new ImageContent(R.drawable.t6_2f1), new TextContent(R.string.title_card_topic6_2)));
        contentList.add(new CardContent("topic6_3", new ImageContent(R.drawable.t6_3f1), new TextContent(R.string.title_card_topic6_3)));
        contentList.add(new CardContent("topic6_4", new ImageContent(R.drawable.t6_4f1), new TextContent(R.string.title_card_topic6_4)));
        contentList.add(new CardContent("topic6_6", new ImageContent(R.drawable.t6_6f1), new TextContent(R.string.title_card_topic6_6)));
        contentList.add(new CardContent("topic6_7", new ImageContent(R.drawable.t6_7f1), new TextContent(R.string.title_card_topic6_7)));


        sessionList.add(new Session("topic6_5", R.string.title_topic6, contentList));
    }

    //Topic 6.6
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic6_6, true));
        contentList.add(new TextContent(R.string.topic6_6_par1));
        contentList.add(new ImageContent(R.drawable.t6_6f1));
        contentList.add(new TextContent(R.string.topic6_6_par2));
        contentList.add(new CardContent("topic6", new ImageContent(R.drawable.t6f1), new TextContent(R.string.title_card_topic6)));
        contentList.add(new CardContent("topic6_1", new ImageContent(R.drawable.t6_1f1), new TextContent(R.string.title_card_topic6_1)));
        contentList.add(new CardContent("topic6_2", new ImageContent(R.drawable.t6_2f1), new TextContent(R.string.title_card_topic6_2)));
        contentList.add(new CardContent("topic6_3", new ImageContent(R.drawable.t6_3f1), new TextContent(R.string.title_card_topic6_3)));
        contentList.add(new CardContent("topic6_4", new ImageContent(R.drawable.t6_4f1), new TextContent(R.string.title_card_topic6_4)));
        contentList.add(new CardContent("topic6_5", new ImageContent(R.drawable.t6_5f1), new TextContent(R.string.title_card_topic6_5)));
        contentList.add(new CardContent("topic6_7", new ImageContent(R.drawable.t6_7f1), new TextContent(R.string.title_card_topic6_7)));


        sessionList.add(new Session("topic6_6", R.string.title_topic6, contentList));
    }

    //Topic 6.7
    static {
        ArrayList<Content> contentList = new ArrayList<>();
        contentList.add(new TextContent(R.string.title_topic6_7, true));
        contentList.add(new TextContent(R.string.topic6_7_par1));
        contentList.add(new TextContent(R.string.topic6_7_par2));
        contentList.add(new ImageContent(R.drawable.t6_7f1));
        contentList.add(new TextContent(R.string.topic6_7_par3));
        contentList.add(new TextContent(R.string.topic6_7_par4));
        contentList.add(new CardContent("topic6", new ImageContent(R.drawable.t6f1), new TextContent(R.string.title_card_topic6)));
        contentList.add(new CardContent("topic6_1", new ImageContent(R.drawable.t6_1f1), new TextContent(R.string.title_card_topic6_1)));
        contentList.add(new CardContent("topic6_2", new ImageContent(R.drawable.t6_2f1), new TextContent(R.string.title_card_topic6_2)));
        contentList.add(new CardContent("topic6_3", new ImageContent(R.drawable.t6_3f1), new TextContent(R.string.title_card_topic6_3)));
        contentList.add(new CardContent("topic6_4", new ImageContent(R.drawable.t6_4f1), new TextContent(R.string.title_card_topic6_4)));
        contentList.add(new CardContent("topic6_5", new ImageContent(R.drawable.t6_5f1), new TextContent(R.string.title_card_topic6_5)));
        contentList.add(new CardContent("topic6_6", new ImageContent(R.drawable.t6_6f1), new TextContent(R.string.title_card_topic6_6)));


        sessionList.add(new Session("topic6_7", R.string.title_topic6, contentList));
    }

    public static Session getSession(String sessionId) {
        for (Session session : sessionList) {
            if (session.getId().equals(sessionId)) return session;
        }
        return null;
    }

}
