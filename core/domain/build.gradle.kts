plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.saico.onshop.domain"
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
}

dependencies {

    //Modules
//    implementation(project(":app"))
    implementation (project(":core:common"))
    implementation (project(":core:model"))

    //Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.play.services.auth)
    implementation(libs.firebase.common)
    implementation(libs.firebase.auth.ktx)
    coreLibraryDesugaring(libs.com.android.tools.desugar)

    //Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)


    //Paging
    implementation( libs.androidx.paging)

    //Hilt
    implementation(libs.com.google.dagger.hilt.android)
    ksp(libs.com.google.dagger.hilt.compiler)
}