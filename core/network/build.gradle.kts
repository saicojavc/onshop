plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.com.dagger.hilt)
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
}

android {
    namespace = "com.saico.onshop.network"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    //Modules
    implementation (project(":core:common"))
//    implementation( project(":core:domain"))
    implementation (project(":core:model"))

    //Core
    implementation(libs.androidx.core.ktx)
    coreLibraryDesugaring(libs.com.android.tools.desugar)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)

    //Retrofit
    implementation( libs.bundles.com.retrofit)

    //Coroutines
    implementation (libs.org.jetbrains.kotlin.coroutines.android)

    //Paging
    implementation( libs.androidx.paging)

    //Hilt
    implementation(libs.com.google.dagger.hilt.android)
    ksp(libs.com.google.dagger.hilt.compiler)
}