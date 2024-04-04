plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)


}

android {
    namespace = "com.babyapps.wondrium"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.babyapps.wondrium"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
   // implementation ("com.google.android.material:material:1.4.0")

    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)



    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    // Glide
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")

    val hilt_version = "2.38.1"
    implementation ("com.google.dagger:hilt-android:$hilt_version")

    val hilt_viewmodels = "1.0.0-alpha03"
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:$hilt_viewmodels")

    // Activity KTX for viewModels()
    implementation ("androidx.activity:activity-ktx:1.3.1")

    // Architectural Components
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")

    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation ("androidx.fragment:fragment-ktx:1.6.2")

    implementation ("com.google.android.exoplayer:exoplayer:2.19.1")


    // Lifecycle
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
}
