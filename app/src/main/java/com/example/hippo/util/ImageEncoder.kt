package com.example.hippo.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.io.FileDescriptor

class ImageEncoder {
    fun encodeImage(fileDescriptor: FileDescriptor): String {
        val bitmap: Bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor)
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val imageBytes: ByteArray = baos.toByteArray()
        return Base64.encodeToString(imageBytes, Base64.DEFAULT)
    }

    fun decodeImage(imageBase64: String): Bitmap {
        val imageBytes = Base64.decode(imageBase64, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }

    companion object {
        val instance: ImageEncoder by lazy { ImageEncoder() }
    }
}
