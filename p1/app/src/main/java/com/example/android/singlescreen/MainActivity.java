package com.example.android.singlescreen;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager;
        int images[] = {R.drawable.beans, R.drawable.download, R.drawable.images};
        MyCustomPageAdapter myCustomPageAdapter;


        viewPager = (ViewPager) findViewById(R.id.viewPager);

        myCustomPageAdapter = new MyCustomPageAdapter(MainActivity.this, images);
        viewPager.setAdapter(myCustomPageAdapter);

        ImageView add = findViewById(R.id.address);
        ImageView call = findViewById(R.id.call);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String address = getString(R.string.address);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:37.7749,-122.4192?q="+Uri.encode(address)));
                    startActivity(intent);
                }
            }
        );

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = getString(R.string.contact_no);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });

    }
}
