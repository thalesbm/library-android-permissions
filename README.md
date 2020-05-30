# permissions

#### How to use?

```kotlin
val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA)

val hasPermissions = PermissionsUtils.hasPermissions(this, permissions, 1000)
if (hasPermissions) {
    Toast.makeText(this, "HAS PERMISSION ALREADY", Toast.LENGTH_LONG).show()
}


override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    if (requestCode == 1000) {
        if (PermissionsUtils.verifyPermissions(grantResults)) {
            Toast.makeText(this, "PERMISSION HAS BEEN GIVEN", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "ONE OR MORE PERMISSION WERE DENIED", Toast.LENGTH_LONG).show()
        }
    }
}
```


------

#### Instalation

###### Step 1. Add the JitPack repository to your build file
```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

###### Step 2. Add the dependency
```
dependencies {
    implementation 'com.github.thalesbm:android-connector-library:0.1.0'
}
```
