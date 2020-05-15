package com.example.hippo.util

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hippo.PICK_IMAGE_ACTIVITY
import com.example.hippo.R
import kotlinx.android.synthetic.main.image_loading_fragment.*
import java.io.ByteArrayOutputStream
import java.io.FileDescriptor

class ImageLoadingFragment : Fragment() {
    private var imageString: String = ""

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
            // TODO: MAKE NULL-SAFE!!
            val uri: Uri = data.data!!
            val parcelFileDescriptor = activity!!.contentResolver.openFileDescriptor(uri, "r")
            val fileDescriptor: FileDescriptor = parcelFileDescriptor!!.fileDescriptor
            val bitmap: Bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor)
            val baos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val imageBytes: ByteArray = baos.toByteArray()
            imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT)

            setImage(imageString)
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

    public fun setImage(imageBase64: String) {
        imageString = imageBase64
        val imageBytes = Base64.decode(imageString, Base64.DEFAULT)
        val decodedImage: Bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        avatar.setImageBitmap(decodedImage)
    }
}