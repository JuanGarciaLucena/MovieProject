package com.juanlucena.movieproject.utils

import android.app.Activity
import android.os.Build
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.io.Serializable


class Utils {

    companion object {

        fun <T : Serializable?> getSerializable(activity: Activity, name: String, clazz: Class<T>): T {
            return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                activity.intent.getSerializableExtra(name, clazz)!!
            else
                activity.intent.getSerializableExtra(name) as T
        }

        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, url: String){
            Glide.with(imageView).load(url).into(imageView)
        }
    }
}