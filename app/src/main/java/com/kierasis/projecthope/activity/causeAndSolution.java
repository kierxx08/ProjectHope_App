package com.kierasis.projecthope.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kierasis.projecthope.R;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class causeAndSolution extends AppCompatActivity {
    TextView pageTitle;
    HtmlTextView desc;
    RelativeLayout caSuRelative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cause_and_solution);

        Intent intent = getIntent();
        int total_score = intent.getIntExtra("total_score",0);

        caSuRelative = findViewById(R.id.caSuRelative);
        pageTitle = findViewById(R.id.page_title);
        desc = findViewById(R.id.description);

        if(total_score<=4){
            pageTitle.setText("Normal");
            caSuRelative.setBackgroundColor(Color.parseColor("#FFCF26"));
        }else if(total_score<=9){
            pageTitle.setText("Mild Depression");
            caSuRelative.setBackgroundColor(Color.parseColor("#00BDAC"));
            desc.setHtml("<p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;\n" +
                    "color:black\"><b>Mild depression may cause:</b></span><o:p></o:p></p>\n" +
                    "\n" +
                    "<p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\">-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">irritability\n" +
                    "or anger</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">hopelessness</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">feelings\n" +
                    "of guilt and despair</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">self-loathing</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">a\n" +
                    "loss of interest in activities you once enjoyed</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">difficulties\n" +
                    "concentrating at work</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">a\n" +
                    "lack of motivation</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">a\n" +
                    "sudden disinterest in socializing</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">aches\n" +
                    "and pains with seemingly no direct cause</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">daytime\n" +
                    "sleepiness and fatigue</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">insomnia</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">appetite\n" +
                    "changes</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">weight\n" +
                    "changes</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">reckless\n" +
                    "behavior, such as abuse of alcohol and drugs, or gambling</span><o:p></o:p></p>\n" +
                    "\n" +
                    "<p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"white-space:pre-wrap\"><span style=\"font-size:11.0pt;\n" +
                    "font-family:&quot;Arial&quot;,sans-serif;color:black\"><b>Experts Trusted Source have suggested that making changes in the following may help:</b></span></span><o:p></o:p></p>\n" +
                    "\n" +
                    "<p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"white-space:pre-wrap\"><span style=\"font-size:11.0pt;\n" +
                    "font-family:&quot;Arial&quot;,sans-serif;color:black\">-diet</span></span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">exercise\n" +
                    "levels</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">recreational\n" +
                    "activities, which can offer distraction and social interaction</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">music\n" +
                    "therapy</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">relaxation\n" +
                    "and meditation</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">sleep\n" +
                    "habits</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">contact\n" +
                    "with other people, especially if they can offer emotional support</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">interacting\n" +
                    "with pets and animals</span><br>\n" +
                    "-<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">reducing\n" +
                    "the use of alcohol and tobacco</span></p>");
        }else if(total_score<=14){
            pageTitle.setText("Moderate Depression");
            caSuRelative.setBackgroundColor(Color.parseColor("#9196ce"));
            desc.setHtml("<p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;\n" +
                    "color:black\"><b>Moderate depression may cause:</b></span><o:p></o:p></p><p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"white-space:pre-wrap\"><span style=\"font-size:11.0pt;\n" +
                    "font-family:&quot;Arial&quot;,sans-serif;color:black\">-Problems with self-esteem</span></span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Reduced\n" +
                    "productivity</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Feelings\n" +
                    "of worthlessness</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Increased\n" +
                    "sensitivities</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Excessive\n" +
                    "worrying</span><o:p></o:p></p><p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;\n" +
                    "color:black\"><b>Experts Trusted Source have suggested that making changes in the\n" +
                    "following may help:</b></span><o:p></o:p></p><p>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "</p><p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"white-space:pre-wrap\"><span style=\"font-size:11.0pt;\n" +
                    "font-family:&quot;Arial&quot;,sans-serif;color:black\">-Get Regular Exercise</span></span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Manage\n" +
                    "Stress Levels</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Take\n" +
                    "Care of Yourself</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Eat\n" +
                    "a healthy diet</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Seek\n" +
                    "out social support</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Engage\n" +
                    "in activities you enjoy</span><o:p></o:p></p>");

        }else if(total_score<=19){
            pageTitle.setText("Moderately Severe Depression");
            caSuRelative.setBackgroundColor(Color.parseColor("#fe5561"));
            desc.setHtml("<p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;\n" +
                    "color:black\"><b>Moderately severe depression may cause:</b></span><o:p></o:p></p><p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"white-space:pre-wrap\"><span style=\"font-size:11.0pt;\n" +
                    "font-family:&quot;Arial&quot;,sans-serif;color:black\">-Avoiding social activities</span></span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Changes\n" +
                    "in appetite</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Decreased\n" +
                    "productivity</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Despair\n" +
                    "and guilt</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Difficulty\n" +
                    "concentrating</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Difficulty\n" +
                    "sleeping</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Excessive\n" +
                    "worry</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Fatigue\n" +
                    "or lack of energy</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Feelings\n" +
                    "of hopelessness</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Irritability</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Lack\n" +
                    "of motivation</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Low\n" +
                    "self-esteem</span><o:p></o:p></p><p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;\n" +
                    "color:black\"><b>Experts Trusted Source have suggested that making changes in the\n" +
                    "following may help:</b></span><o:p></o:p></p><p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"white-space:pre-wrap\"><span style=\"font-size:11.0pt;\n" +
                    "font-family:&quot;Arial&quot;,sans-serif;color:black\">-Get Regular Exercise</span></span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Manage\n" +
                    "Stress Levels</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Take\n" +
                    "Care of Yourself</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Eat\n" +
                    "a healthy diet</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Seek\n" +
                    "out social support</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Engage\n" +
                    "in activities you enjoy</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Individuals\n" +
                    "and group therapy</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Peer\n" +
                    "support&nbsp;</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Medication\n" +
                    "for Depression</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-ANTIDEPRESSANTS</span><o:p></o:p></p><p>\n" +
                    "</p><p class=\"MsoNormal\"><o:p>&nbsp;</o:p></p>");
        }else if(total_score<=30){
            pageTitle.setText("Severe Depression");
            caSuRelative.setBackgroundColor(Color.parseColor("#98777a"));
            desc.setHtml("<p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;\n" +
                    "color:black\"><b>severe depression may cause:</b></span><span style=\"font-size:11.0pt\"><o:p></o:p></span></p><p style=\"margin-top:14.0pt;margin-right:0in;margin-bottom:20.0pt;margin-left:\n" +
                    "0in\"><span style=\"white-space:pre-wrap\"><span style=\"font-size:11.0pt;\n" +
                    "font-family:&quot;Arial&quot;,sans-serif;color:#231F20\">-delusions</span></span><span style=\"font-size:11.0pt\"><br>\n" +
                    "</span><span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:#231F20\">-feelings\n" +
                    "of stupor</span><span style=\"font-size:11.0pt\"><br>\n" +
                    "</span><span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:#231F20\">-hallucinations</span><span style=\"font-size:11.0pt\"><br>\n" +
                    "</span><span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:#231F20\">-suicidal\n" +
                    "thoughts or behaviors</span><span style=\"font-size:11.0pt\"><o:p></o:p></span></p><p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;\n" +
                    "color:black\"><b>Experts Trusted Source have suggested that making changes in the\n" +
                    "following may help:</b></span><o:p></o:p></p><p style=\"margin-top:12.0pt;margin-right:0in;margin-bottom:12.0pt;margin-left:\n" +
                    "0in\"><span style=\"white-space:pre-wrap\"><span style=\"font-size:11.0pt;\n" +
                    "font-family:&quot;Arial&quot;,sans-serif;color:black\">-Get Regular Exercise</span></span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Manage\n" +
                    "Stress Levels</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Take\n" +
                    "Care of Yourself</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Eat\n" +
                    "a healthy diet</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Seek\n" +
                    "out social support</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Engage\n" +
                    "in activities you enjoy</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Individuals\n" +
                    "and group therapy</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Peer\n" +
                    "support&nbsp;</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-Medication\n" +
                    "for Depression</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:black\">-ANTIDEPRESSANTS</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:#231F20\">-adjust\n" +
                    "to a crisis or other stressful event</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:#231F20\">-replace\n" +
                    "negative beliefs and behaviors with positive, healthy ones</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:#231F20\">-improve\n" +
                    "communication skills</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:#231F20\">-cope\n" +
                    "with challenges and solve problems</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:#231F20\">-increase\n" +
                    "self-esteem</span><br>\n" +
                    "<span style=\"font-size:11.0pt;font-family:&quot;Arial&quot;,sans-serif;color:#231F20\">-regain\n" +
                    "a sense of satisfaction and control in life</span><o:p></o:p></p><p>\n" +
                    "</p><p class=\"MsoNormal\"><o:p>&nbsp;</o:p></p>");

        }
    }
}