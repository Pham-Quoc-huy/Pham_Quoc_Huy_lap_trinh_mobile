plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 35
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.play.services.gcm)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(platform(libs.androidx.compose.bom))

    // Dependencies cho Jetpack Compose
    implementation("androidx.compose.ui:ui:1.1.1")  // Cập nhật lên phiên bản mới nhất
    implementation("androidx.compose.material3:material3:1.0.0")  // Dùng Material3 nếu cần
    implementation("androidx.compose.ui:ui-tooling-preview:1.1.1")  // Cập nhật version
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.navigation:navigation-compose:2.4.0")

    // Debug dependencies
    debugImplementation("androidx.compose.ui:ui-tooling:1.1.1")

    // Optional: Nếu bạn cần hỗ trợ thêm cho các chức năng UI
    implementation("androidx.compose.foundation:foundation:1.1.1")  // Dành cho các thành phần UI bổ sung
    implementation("androidx.compose.material:material-icons-extended:1.1.1")  // Icon hỗ trợ
    implementation("androidx.compose.ui:ui:1.1.1")
    implementation("androidx.compose.material3:material3:1.0.0") // Phiên bản Material3
    implementation("androidx.compose.material:material:1.0.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.1.1")
    implementation("androidx.navigation:navigation-compose:2.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")// Retrofit
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0") // Gson converter
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0") // OkHttp logging interceptor (tùy chọn)

}
