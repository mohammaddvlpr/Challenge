plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}


android {
    compileSdk = 34
    namespace = "com.jabama.challenge.login"

    defaultConfig {
        applicationId = "com.jabama.challenge.github"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.8"
    }
}

dependencies {
    implementation(libs.kotlin.stdlib.jdk7)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.koin.android)
    implementation(libs.lifecycle.viewmodel.ktx)



    implementation(libs.kotlin.stdlib.jdk7.v1350)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.logging.interceptor)
    implementation(libs.preference.ktx)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.retrofit2.kotlin.coroutines.adapter)

//    paging
    implementation(libs.paging.runtime.ktx)
//    compose paging
    implementation(libs.paging.compose)

//    compose
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation(libs.comopse.ui)
    implementation(libs.comopse.graphics)
    implementation(libs.comopse.ui.tooling.preview)
    implementation(libs.comopse.material3)
    implementation(libs.activity.compose)

//    compose image loading
    implementation(libs.coil.compose)
    implementation(project(":Data"))
    implementation(project(":Domain"))



    testImplementation(libs.junit)
    androidTestImplementation(libs.runner)
    androidTestImplementation(libs.espresso.core)
}
