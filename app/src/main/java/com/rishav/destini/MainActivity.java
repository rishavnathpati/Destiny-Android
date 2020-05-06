package com.rishav.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.rishav.destini.R.*;

public class MainActivity extends AppCompatActivity
{

    private TextView mStoryTextView;
    private Button mTopButton;
    private Button mBottomButton;
    private int mStoryIndex = 1;
    RelativeLayout mRelativeLayout;
    private Button mInfoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        mStoryTextView = findViewById(id.STORY_TEXT_VIEW);
        mTopButton = findViewById(id.TOP_BUTTON);
        mBottomButton = findViewById(id.BOTTOM_BUTTON);
        mRelativeLayout=findViewById(id.RELATIVE_LAYOUT);
        mInfoButton=findViewById(id.info_button);

        mInfoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder devInfo = new AlertDialog.Builder(MainActivity.this);
                devInfo.setTitle("Dev Information");
                devInfo.setMessage("Developer: Rishav Nath Pati" +
                        "\nClick the links below to visit profiles");
                devInfo.setCancelable(true);
                devInfo.setNeutralButton("Facebook", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        goToUrl("https://www.facebook.com/rishav.pati.1");
                    }
                });
                devInfo.setPositiveButton("Github", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        goToUrl("https://github.com/rishavnathpati");
                    }
                });
                devInfo.setNegativeButton("LinkedIn", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        goToUrl("https://www.linkedin.com/in/rishav-nath-p-67223bb9/");
                    }
                });
                devInfo.show();
            }

            private void goToUrl(String url)
            {
                Uri uriUrl = Uri.parse(url);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        mTopButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (mStoryIndex == 1 || mStoryIndex == 2)
                {
                    mStoryTextView.setText(string.T3_Story);
                    mTopButton.setText(string.T3_Ans1);
                    mBottomButton.setText(string.T3_Ans2);
                    mStoryIndex = 3;
                } else if (mStoryIndex == 3)
                {
                    mStoryTextView.setText(string.T6_End);
                    mRelativeLayout.setBackgroundResource(drawable.story4);
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);
                }
            }
        });

        mBottomButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (mStoryIndex == 1)
                {
                    mStoryTextView.setText(string.T2_Story);
                    mTopButton.setText(string.T2_Ans1);
                    mBottomButton.setText(string.T2_Ans2);
                    mStoryIndex = 2;
                } else if (mStoryIndex == 2)
                {
                    mStoryTextView.setText(string.T4_End);
                    mRelativeLayout.setBackgroundResource(drawable.story4);
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);
                } else if (mStoryIndex == 3)
                {
                    mStoryTextView.setText(string.T5_End);
                    mRelativeLayout.setBackgroundResource(drawable.story4);
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);
                }
            }
        });
    }
}
