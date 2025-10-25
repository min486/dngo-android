import java.util.Properties

// Properties 객체를 생성해 key-value 쌍을 저장할 준비를 한다
val properties = Properties()
// 프로젝트의 루트 디렉토리에 있는 local.properties 파일을 가져온다
val propertiesFile = project.rootProject.file("local.properties")
// 파일이 존재하는지 확인 후 로드
if (propertiesFile.exists()) {
    // 파일의 InputStream을 열어 속성값을 안전하게 불러온다
    // use 함수를 사용하면 스트림이 자동으로 닫힌다
    propertiesFile.inputStream().use { properties.load(it) }
}

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.services)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.min.dnapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.min.dnapp"
        minSdk = 30
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val kakaoNativeAppKey = properties.getProperty("kakao.native.app.key")
        val naverClientId = properties.getProperty("naver.client.id")
        val naverClientSecret = properties.getProperty("naver.client.secret")

        // 네이티브 앱 키를 BuildConfig에 필드로 추가
        buildConfigField("String", "KAKAO_NATIVE_APP_KEY", "\"${kakaoNativeAppKey}\"")
        // AndroidManifest.xml에 전달할 플레이스홀더 정의
        manifestPlaceholders["kakaoNativeAppKey"] = kakaoNativeAppKey

        // 네이버
        buildConfigField("String", "NAVER_CLIENT_ID", "\"${naverClientId}\"")
        buildConfigField("String", "NAVER_CLIENT_SECRET", "\"${naverClientSecret}\"")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        // BuildConfig 파일 생성을 활성화
        buildConfig = true
    }
}

dependencies {
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    // kakao
    implementation(libs.kakao.sdk)
    // compose navigation
    implementation(libs.androidx.navigation.compose)
    // hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
    // splash screen
    implementation(libs.splash)
    // retrofit2 & kotlin serialization
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.kotlinx.serialization)
    implementation(libs.kotlinx.serialization.json)
    // okhttp (logging interceptor)
    implementation(libs.okhttp.logging)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
