package com.example.hippo.ui.main

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hippo.PICK_IMAGE_ACTIVITY
import com.example.hippo.R
import com.example.hippo.util.ImageEncoder
import kotlinx.android.synthetic.main.image_loading_fragment.*
import java.io.FileDescriptor

class AvatarLoadingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.image_loading_fragment, container, false)

        root.setOnClickListener {
            imagePickingActivity()
        }

        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_ACTIVITY && resultCode == Activity.RESULT_OK && data != null) {
            // NOTE: Should be good enough regarding null-safety, not exactly an independent fragment
            val uri: Uri = data.data!!
            val parcelFileDescriptor = activity!!.contentResolver.openFileDescriptor(uri, "r")
            val fileDescriptor: FileDescriptor = parcelFileDescriptor!!.fileDescriptor

            // Using setImageBitmap here to make sure the user sees the image as it's supposed to be
            // I have suspicions that encoding changes the colors somewhat due to JPEG recoding
            // However, I am not good with colors or design, so maybe I'm wrong
            avatar.setImageBitmap(
                ImageEncoder.instance.decodeImage(
                    ImageEncoder.instance.encodeImage(
                        fileDescriptor
                    )
                )
            )
        }
    }

    private fun imagePickingActivity() {
        val getIntent = Intent(Intent.ACTION_GET_CONTENT)
        getIntent.type = "image/*"

        val pickIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        pickIntent.type = "image/*"

        val chooserIntent =
            Intent.createChooser(getIntent, resources.getString(R.string.select_avatar))
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(pickIntent))

        startActivityForResult(chooserIntent, PICK_IMAGE_ACTIVITY)
    }

}