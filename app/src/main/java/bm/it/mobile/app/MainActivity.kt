package bm.it.mobile.app

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import bm.it.mobile.library.PermissionsUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // askOnePermission()
        askTwoPermission()
    }

    private fun askTwoPermission() {
        val permissions = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )
        val hasPermissions = PermissionsUtils.hasPermissions(this, permissions, 1000)
        if (hasPermissions) {
            Toast.makeText(this, "HAS PERMISSION ALREADY", Toast.LENGTH_LONG).show()
        }
    }

    private fun askOnePermission() {
        val permissions = arrayOf(Manifest.permission.CAMERA)
        val hasPermissions = PermissionsUtils.hasPermissions(this, permissions, 1000)
        if (hasPermissions) {
            Toast.makeText(this, "HAS PERMISSION ALREADY", Toast.LENGTH_LONG).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1000) {
            if (PermissionsUtils.verifyPermissions(grantResults)) {
                Toast.makeText(this, "PERMISSION HAS BEEN GIVEN", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "ONE OR MORE PERMISSION WERE DENIED", Toast.LENGTH_LONG).show()
            }
        }
    }
}