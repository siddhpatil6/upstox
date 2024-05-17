<h1>Forth Code Demo </h1>
Code will show list of images and title in recycler view
API needs to call to fetch list of data consist of title and url

<h2>Features </h2>
1. Call API and show list of images and title in recyclerview.

<h2>Evidence : </h2> 
[forthcode.webm](https://github.com/siddhpatil6/forthcode/assets/5618021/d0fb490e-9dac-4b50-96b0-49e95d48ba13)

<h2>Installation </h2>
Clone the repository: <br>
git clone https://github.com/siddhpatil6/forthcode.git <br>
Open the project in Android Studio. <br>
Build and run the project on an emulator or a physical device. <br>

<h2>Usage </h2>
Describe how to use the app, including any prerequisites or setup required. <br>

<h2>Libraries Used </h2>

```
implementation("com.jakewharton.picasso:picasso2-okhttp3-downloader:1.1.0")
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
<img width="782" alt="Screenshot 2024-04-18 at 6 55 39 PM" src="https://github.com/siddhpatil6/forthcode/assets/5618021/92acbce2-5a82-4578-a87d-f68e2e2a6596">

View :  MainAcitivity <br>
ViewModel : ForthCodeViewModel <br>
Domain : ForthCodeUseCase <br>
Repository : ForthCodeRepository <br>


<h2>Hilt : </h2>
Component : ForthCodeListComponent <br>
Modules : AppModule , ForthCodeModule <br>

<h2>Code Overview </h2>
<h4>MainActivity: </h4> The main activity of the app. It initializes the ViewModel and observes the list of photos.
<h4>ForthCodeViewModel: </h4> ViewModel class responsible for fetching the list of photos from the API.
<h4>ForthCodeAdapter: </h4> RecyclerView adapter for displaying the list of photos.
<h4>ForthCodeListViewModelFactory: </h4> Factory class for creating an instance of ForthCodeViewModel.

<h2>API Used </h2>
<h4>The app uses the following API to retrieve the list of photos: </h4>


API Base URL: https://jsonplaceholder.typicode.com <br>
Endpoint: /photos <br>
Method: GET <br>
Response Format: JSON <br>


