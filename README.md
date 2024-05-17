<h1>Upstox Demo </h1>
Code will show list of coins in recycler view
API needs to call to fetch list of data consist of coins

<h2>Features </h2>
1. Call API and show list of coins in recyclerview.

<h2>Installation </h2>
Clone the repository: <br>
git clone https://github.com/siddhpatil6/upstox.git <br>
Open the project in Android Studio. <br>
Build and run the project on an emulator or a physical device. <br>

<h2>Usage </h2>
Describe how to use the app, including any prerequisites or setup required. <br>

<h2>Libraries Used </h2>

```
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.google.code.gson:gson:2.10")
implementation ("com.squareup.okhttp3:okhttp:3.14.9")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("com.squareup.okhttp3:logging-interceptor:3.4.1")

implementation("com.google.dagger:hilt-android:2.51.1")
kapt("com.google.dagger:hilt-compiler:2.51.1")

// For instrumentation tests
androidTestImplementation("com.google.dagger:hilt-android-testing:2.51.1")
kaptAndroidTest("com.google.dagger:hilt-compiler:2.51.1")

// For local unit tests
androidTestImplementation("com.google.dagger:hilt-android-testing:2.51.1")
kaptAndroidTest("com.google.dagger:hilt-compiler:2.51.1")
```


<h2>MVVM Architecture:  </h2>
 <br>
<img width="782" alt="Screenshot 2024-04-18 at 6 55 39 PM" src="https://github.com/siddhpatil6/Crypto/assets/5618021/92acbce2-5a82-4578-a87d-f68e2e2a6596">

View :  MainAcitivity <br>
ViewModel : CryptoViewModel <br>
Domain : CryptoUseCase <br>
Repository : CryptoRepository <br>


<h2>Hilt : </h2>
Component : CryptoListComponent <br>
Modules : AppModule , CryptoModule <br>

<h2>Code Overview </h2>
<h4>MainActivity: </h4> The main activity of the app. It initializes the ViewModel and observes the list of coins.
<h4>CryptoViewModel: </h4> ViewModel class responsible for fetching the list of coins from the API.
<h4>CryptoAdapter: </h4> RecyclerView adapter for displaying the list of coins.
<h4>CryptoListViewModelFactory: </h4> Factory class for creating an instance of CryptoViewModel.



