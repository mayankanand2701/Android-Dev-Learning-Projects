package com.example.myapplication;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.myapplication.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getMemes();
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMemes();
            }
        });
        binding.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareMemes();
            }
        });
    }

    private void shareMemes()
    {
        Bitmap image=getBitMapFromView(binding.memeImageView);
        shareImageAndText(image);

    }

    private void shareImageAndText(Bitmap image) {
        Uri uri=getImageToShare(image);
        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM,uri);
        intent.setType("image/png");
        startActivity(intent.createChooser(intent,"Share image via :"));
    }

    private Uri getImageToShare(Bitmap image) {
        File imageFolder=new File(getCacheDir(),"images");
        Uri uri=null;
        try{
            imageFolder.mkdir();
            File file=new File(imageFolder,"meme.png");
            FileOutputStream outputStream=new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.PNG,100,outputStream);
            outputStream.flush();
            outputStream.close();
            uri= FileProvider.getUriForFile(this,"com.mayank.shareImage.fileProvider",file);
        }
        catch(Exception e){
            Toast.makeText(this, "Error ", Toast.LENGTH_SHORT).show();
        }
        return uri;
    }

    private Bitmap getBitMapFromView(ImageView memeImageView)
    {
        Bitmap returnedBitMap=Bitmap.createBitmap(memeImageView.getWidth(),memeImageView.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(returnedBitMap);
        Drawable background= memeImageView.getBackground();
        if(background!=null) background.draw(canvas);
        else canvas.drawColor(Color.WHITE);
        memeImageView.draw(canvas);
        return returnedBitMap;
    }

    private void getMemes()
    {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = " https://meme-api.com/gimme";
        binding.memeImageView.setVisibility(View.GONE);
        binding.loader.setVisibility(View.VISIBLE);

        // Request a string response from the provided URL.
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String imageUrl=response.getString("url");
                            Glide.with(getApplicationContext())
                                    .load(imageUrl)
                                    .into(binding.memeImageView);
                                     binding.loader.setVisibility(View.GONE);
                                     binding.memeImageView.setVisibility(View.VISIBLE);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(MainActivity.this, "Error ", Toast.LENGTH_SHORT).show();

            }
        });
        queue.add(jsonRequest);
    }
}