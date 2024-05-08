androis 7

permisos de internet

 <uses-permission android:name="android.permission.INTERNET" />
   

landscapist-glide
retrofit -> como.squareup.retrofit2
Serializacion: converter-gson  ->  com.squareup.retrofit2
navigation-compose no usar alphas

room-compiler 2.6.1 annotationProcessor


room-runtime 2.6.1 

en libs: 

room = "2.6.1"
androidx-room-compiler = { group = "androidx.room", name = "room-compiler", version.ref = "room" }
androidx-room-runtime = { group = "androidx.room", name = "room-runtime", version.ref = "room" }

en dependencias:

val roomVersion = "2.6.1"
    kapt("androidx.room:room-compiler:$roomVersion")


en plugins:

    id("org.jetbrains.kotlin.kapt")


 implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.landscapist.glide)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.room.runtime)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    annotationProcessor(libs.androidx.room.compiler)
    val roomVersion = "2.6.1"
    kapt("androidx.room:room-compiler:$roomVersion")
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

-----------------------------------------------------------

android:name=".MyApplication"

MyApplication:

package pe.edu.upc.eatsexplorer

import android.app.Application
import android.content.Context

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        private var application: Application? = null

        private fun getApplication(): Application {
            return application as Application
        }

        public fun getContext(): Context {
            return getApplication().applicationContext
        }
    }
}

 GlideImage(modifier = Modifier.size(92.dp), imageModel = { url })

