### Retrofit이란?

+ Retrofit은 REST API로, **서버와 클라이언트간 Http 통신을 위한 인터페이스**를 뜻한다.
+ 클라이언트에서 서버로 어떠한 요청을 보내면 서버는 그 요청에 대한 응답을 클라이언트로 보내주게 되는데, 이 일련의 과정들을 쉽게 사용 할 수 있도록 도와주는 역할을 하는 것이  Retrofit이다.
+ Retrofit은 Typesafe한 HttpClient 라이브러리다.
  + Typesafe: 네트워크로부터 전달된 데이터를 프로그램에서 필요한 형태의 객체로 받을 수 있다.

-----------
```자바코드```
### Gradle 에 라이브러리 추가하기

라이브러리를 Gradle에 추가한다.

```java
dependencies {

   compile 'com.squareup.retrofit2:retrofit:2.4.0

   compile 'com.squareup.retrofit2:converter-gson:2.4.0' (optional)

}
```

위 코드는 Gson 형태로 변환하기 위해 컨버터를 추가했다. 필요에 따라 추가 안 해도 된다.

#### 인터넷 사용 권한 추가하기

```xml
manifests.xml

<?xml version="1.0" encoding="utf-8"?>

<manifest xmlns:android="http://schemas.android.com/apk/res/android"

    package="rebuild.com.retrofit">

<!-- 인터넷 사용 권한 -->

    <uses-permission android:name="android.permission.INTERNET" />

</manifest>
```

#### 통신 데이터 준비하기

```json
  {
	   "movie_no" : 3,

       "title" : "미드나잇 선",

       "thumb_url" : "https://movie.naver.com/movie/bi/mi/basic.nhn?code=143416#"

      },
.... 중략
```

관리에 용이하게 하기 위해 Base URL을 string.xml에 등록한다.

```xml
<resources>
	<string name="baseUrl">http://re-build.tistory.com</string>
</resources>
```

---------------------------------

### Retrofit 객체 초기화하기

**Retrofit 객체를 초기화**한다.

```java
MainActivity.java

import retrofit2.Retrofit;
public class MainActivity extends AppCompatActivity {
   private Retrofit mRetrofit;
   
   @Override

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
setRetrofitInit();
   }

   privatate void setRetrofitInit() {
      mRetrofit = new Retrofit.Builder()
                 .baseUrl(<Base URL>)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
   } 

}
```

string.xml에 등록했던 Base URL을 이용해서 작성한다. 위와 같은 코드는 json 형태의 데이터를 변환하기 위해 ConverterFactory를 추가했다.

-----------

### 인터페이스 정의하기

**Http Method (GET, POST, PUT, DELETE 등)와 자원의 정보를 정의 할 인터페이스**를 구현해야한다.

class 생성 후 작성한다.

```java
RetrofitAPI.java

public interface RetrofitAPI {
   @GET("/movie.json")
   Call<String> getMovieList();

}
```

필요에 따라 변수들을 포함하여 정의할 수 있다.

------------

### 통신 요청 및 응답 콜백 구현하기

MainActivity로 돌아가 Rerofit 객체와 인터페이스를 연결하고, 영화 리스트 데이터를 요청한다.

```java
MainActivity.java

public class MainActivity extends AppCompatActivity {
   private Retrofit mRetrofit;
   private RetrofitAPI mRetrofitAPI;
   private Call<String> mCallMovieList;

   @Override

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
setRetrofitInit();
callMovieList();
   }
   
   privatate void setRetrofitInit() {
      mRetrofit = new Retrofit.Builder()
                 .baseUrl(<Base URL>)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
      mRetrofitAPI = mRetrofit.create(RetrofitAPI.class);
   }

   privatate void callMovieList() {
      mCallMoviewList = mRetrofitAPI.getMoviewList();
      mCallMoviewList.enqueue(mRetrofitCallback);
   }
   
   private Callback<String> mRetrofitCallback = new Callback<String>() {
   
      @Override

      public void onResponse(Call<String> call, Response<String> response) {
         String result = response.body();
         Log.d(TAG, result)
      }

      @Override

      public void onFailure(Call<String> call, Throwable t) {
         t.printStackTrace();
      }
   }
}
```

생성했던 인터페이스를 통해, Http 요청을 보내고 응답을 받을 Callback을 지정했습니다. 통신이 정상적으로 성공할 경우 onResponse()로, 통신에 실패 한 경우 onFailure()로 들어온다.

위 코드는 Callback타입을 String으로 했지만, 바꾸어도 괜찮다. 물론 인터페이스에 정의된 Call타입도 바꾸어야한다.

-----------

### 데이터 파싱하기

String 타입의 데이터를 사용하기 쉽도록 바꾸어야한다.

응답을 받을 json 데이터에 맞추어 class(MovieListVO)를 작성한다.

```java
MovieListVO.java

public class MovieListVO {
   private String category;
   private ArrayList<Movie> list;
    
   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public ArrayList<Movie> getList() {
      return list;
   }

   public void setList(ArrayList<Movie> list) {
      this.list = list;
   }

   public class Movie {
      private String movie_no;
      private String title;
      private String thumb_url;

      public String getMovie_no() {
         return movie_no;
      }

      public void setMovie_no(String movie_no) {
         this.movie_no = movie_no;
      }

      public String getTitle() {
         return title;
      }

       public void setTitle(String title) {
         this.title = title;
      }

      public String getThumb_url() {
         return thumb_url;
      }

      public void setThumb_url(String thumb_url) {
         this.thumb_url = thumb_url;
      }
   }
}
```

작성할 때, 중요한 점은 **응답 받을 데이터 구조와 같은 구조이어야 하며 변수 명도 같아야 한다.**

아까 응답 받은 데이터에 적용시키면 밑 코드와 같다.

```java
MainActivity.java

public class MainActivity extends AppCompatActivity {
   private Gson mGson;
   private Callback<String> mRetrofitCallback = new Callback<String>() {

      @Override

      public void onResponse(Call<String> call, Response<String> response) {
         String result = response.body();
         MovieListVO mMovieListVO = (MovieListVO) mGson.fromJson(result, MovieListVO.class)
      }

      @Override

      public void onFailure(Call<String> call, Throwable t) {
         t.printStackTrace();
      }
   }
}
```

Gson 객체를 초기화 시킨 후, from json()을 통해 변환해주면 된다. 이 후에는 원하는 모양으로 데이터를 가져다가 사용하면된다.
