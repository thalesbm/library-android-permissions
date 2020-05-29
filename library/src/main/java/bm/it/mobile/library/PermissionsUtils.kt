package bm.it.mobile.library

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker

object PermissionsUtils {

    fun hasPermissions(activity: Activity, permissions: Array<String>, id: Int): Boolean {
        for (permission in permissions) {
            val hasPermissions = PermissionChecker.checkSelfPermission(activity, permission)
            if (hasPermissions != PackageManager.PERMISSION_GRANTED) {
                askPermissions(activity, permissions, id)
                return false
            }
        }
        return true
    }

    private fun askPermissions(activity: Activity, permissions: Array<String>, id: Int) {
        ActivityCompat.requestPermissions(activity, permissions, id)
    }

    fun verifyPermissions(grantResult: IntArray): Boolean {
        for (result in grantResult) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }
}