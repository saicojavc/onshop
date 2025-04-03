plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
    alias(libs.plugins.com.dagger.hilt)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.saico.onshop.core.database"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                //for export database schemas
                arguments += mapOf("room.schemaLocation" to "$projectDir/schemas")
            }
        }
    }
}

dependencies {
    //Modules
    implementation(project(":core:common"))
    implementation(project(":core:domain"))
    implementation(project(":core:model"))

//Database
    implementation(libs.bundles.androidx.room)
    implementation(libs.transport.runtime)
    ksp(libs.androidx.room.compiler)
    annotationProcessor(libs.androidx.room.compiler)
    annotationProcessor(libs.hilt.compiler)
    implementation(libs.androidx.datastore.core.android)
    implementation(libs.androidx.datastore.preferences.core.jvm)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt.android)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
}
// Habilitar el procesamiento de símbolos
ksp {
    arg("dagger.hilt.android.internal.disableAndroidSuperclassValidation", "true")
}