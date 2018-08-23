package com.andres.mercadolibre.view.util;

import android.widget.ImageView;
import com.andres.mercadolibre.R;
import com.squareup.picasso.Picasso;

public class ImageLoader {

  public static void loadImage(String url, ImageView imageView) {
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .into(imageView);
  }
}
