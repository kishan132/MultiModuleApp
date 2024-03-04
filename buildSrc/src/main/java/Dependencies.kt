
//managing using kotlin-dsl (domain specific language - manage config)

object Version{
    const val core = "1.12.0"
    const val appCompat = "1.6.1"
    const val androidMaterial = "1.11.0"
    const val constraintLayout = "2.1.4"

    const val testImplJunit = "4.13.2"
    const val androidTestImplJunit = "1.1.5"
    const val androidTestEspresso = "3.5.1"

    const val lottieVersion = "6.4.0"

    const val daggerVersion = "2.51"

    const val retrofitVersion = "2.9.0"

    const val coroutineVersion = "1.8.0"

    const val lifecycleVersion = "2.7.0"

    const val glideVersion = "4.16.0"
    const val glideCompVersion = "4.14.2"

    const val roomVersion = "2.6.1"
}

object Deps{
    const val core = "androidx.core:core-ktx:${Version.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val androidMaterial = "com.google.android.material:material:${Version.androidMaterial}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
}

object Coroutines{
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutineVersion}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutineVersion}"
}

object Room{
    const val room = "androidx.room:room-ktx:${Version.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.roomVersion}"
}

object CoroutinesLifecycleScope{
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0${Version.lifecycleVersion}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleVersion}"
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycleVersion}"
}

object Glide{
    const val glide = "com.github.bumptech.glide:glide:${Version.glideVersion}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Version.glideCompVersion}"
}

object TestImplementation{
    const val junit = "junit:junit:${Version.testImplJunit}"
}

object AndroidTestImplementation{
    const val junit = "androidx.test.ext:junit:${Version.androidTestImplJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.androidTestEspresso}"
}

object LotteAnimation{
    const val lotteAnimation = "com.airbnb.android:lottie:${Version.lottieVersion}"
}
object DaggerHilt{
    const val hilt = "com.google.dagger:hilt-android:${Version.daggerVersion}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Version.daggerVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.daggerVersion}"
}

object Retrofit{
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofitVersion}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Version.retrofitVersion}"
}