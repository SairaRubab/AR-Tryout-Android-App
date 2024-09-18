package com.fyp.tryone.product;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;
import com.fyp.tryone.R;
import com.fyp.tryone.fragments.ImageListFragment;
import com.fyp.tryone.fragments.ViewPagerActivity;
import com.fyp.tryone.notification.NotificationCountSetClass;
import com.fyp.tryone.options.CartListActivity;
import com.fyp.tryone.startup.MainActivity;
import com.fyp.tryone.tensorflow.DetectorActivity;
import com.fyp.tryone.utility.ImageUrlUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import static com.fyp.tryone.options.CartListActivity.*;

public class ItemDetailsActivity extends AppCompatActivity {
    CartListActivity obj = new CartListActivity();

    int imagePosition;
    String stringImageUri;
    public final static int GLASSES_TYPE = 1;
    public final static int LIPSTICK_TYPE = 2;
    int mTypeCode = -1;
    int counter ;
    private ShareActionProvider mShareActionProvider;

    public static final String KEY_COUNT = "KEY_COUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        SimpleDraweeView mImageView = findViewById(R.id.image1);
        TextView textViewAddToCart = findViewById(R.id.text_action_bottom1);
        TextView textViewShare = findViewById(R.id.text_action1);
        Button tryOnButton = findViewById(R.id.button_id);

        if(tryOnButton != null) {
            tryOnButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ItemDetailsActivity.this, DetectorActivity.class);
                    intent.putExtra("position", imagePosition);
                    intent.putExtra("typeCode", mTypeCode);
                    startActivity(intent);
                }
            });
        }



        //Getting image uri from previous screen
        if (getIntent() != null) {
            stringImageUri = getIntent().getStringExtra(ImageListFragment.STRING_IMAGE_URI);
            imagePosition = getIntent().getIntExtra(ImageListFragment.STRING_IMAGE_POSITION,0);
            mTypeCode = ImageUrlUtils.getTypeCode(stringImageUri);
        }

        String a = Integer.toString(mTypeCode);
        String b = Integer.toString(imagePosition);
        final TextView newtext = findViewById(R.id.productid);
        newtext.setText("Product Number: "+a +"-"+ b);

        Uri uri = Uri.parse(stringImageUri);
        mImageView.setImageURI(uri);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(ItemDetailsActivity.this, ViewPagerActivity.class);
                    intent.putExtra("position", imagePosition);
                    startActivity(intent);

            }
        });

        textViewShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, ".");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        textViewAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.addCartListImageUri(stringImageUri);
                Toast.makeText(ItemDetailsActivity.this,"Item added to cart.",Toast.LENGTH_SHORT).show();

                MainActivity.notificationCountCart++;
                //adding cart prices
                NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
                counter += 1750;

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(KEY_COUNT, counter);
                editor.commit();
            }
        });

    }
}
