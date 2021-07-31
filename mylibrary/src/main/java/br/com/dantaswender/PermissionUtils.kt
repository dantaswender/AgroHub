package br.com.dantaswender

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.*

/**
 * Created by Wender on 31,July,2021
 */
class PermissionUtils {

    fun checkPermission(
        context: Context,
        permission: String
    ): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun validate(activity: Activity, requestCode: Int, vararg permissions: String): Boolean {
        val list: MutableList<String> = ArrayList()
        for (permission in permissions) {
            if (!checkPermission(activity, permission)) {
                list.add(permission)
            }
        }
        if (list.isEmpty()) {
            return true
        }
//        val newPermissions:  Array<String?> = arrayOfNulls(list.size)
        //list.toArray<String>(newPermissions)

        ActivityCompat.requestPermissions(activity, list.toTypedArray(), requestCode)
        return false
    }

    fun isGpsPermissionOk(context: Context?): Boolean {
        val ok1 = checkPermission(context!!, Manifest.permission.ACCESS_FINE_LOCATION)
        val ok2 = checkPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
        return ok1 && ok2
    }

}