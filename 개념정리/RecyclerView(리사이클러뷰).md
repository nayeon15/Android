### RecyclerView(리사이클러뷰)

----------

* **RecyclerView**는 "많은 수의 데이터 집합을, 제한된 영역 내에서 유연하게 표시할 수 있도록 만들어주는 위젯"이다. 

* 정확하게 말하자면 사용자가 관리하는 많은 수의 데이터 집합을 **개별 아이템 단위로 구성하여 화면에 출력하는 뷰그룹**이며 한 화면에 표시되기 **힘든 많은 수의 데이터를 스크롤 가능한 리스트로 표시해주는 위젯**이다.
* **RecyclerView**는 ListView에 비해 더 발전되고 유연하다. 

![리사이클러뷰의 표시 형태](https://t1.daumcdn.net/cfile/tistory/993B0D425C88BD1B0C)

----------

### 리사이클러뷰를 위한 구성 요소

--------

* **리사이클러뷰**는 데이터 목록을 아이템 단위의 뷰로 구성하여 화면에 표시하기 위해 **어댑터**를 사용한다.
* 리사이클러뷰는 수평 방향 레이아웃 또는 격자 형태의 레이아웃으로도 나타낼 수 있다. (복잡한 형태의 레이아웃으로 직접 커스터마이징할 수도 있다.) 이를 위해 리사이클러뷰에서는 아이템 뷰가 나열되는 형태를 관리하기 위한 요소를 제공하는데, 이를 **"레이아웃매니저(Layout Manager)"**라고 부른다.
* 마지막으로 레이아웃매니저(LayoutManager)가 제공하는 레이아웃 형태로 어댑터를 통해 만들어진 각 아이템 뷰는 **"뷰홀더(ViewHolder)"**객체에 저장되어 화면에 표시되고, 필요에 따라 생성 또는 Recycle된다.

![리사이클러뷰의 구성 요소](https://t1.daumcdn.net/cfile/tistory/997123455C88BD1A01)

----------

### 리사이클러뷰 기본 사용법

------------

##### 리사이클러뷰 만들기

activity_main.xml에서

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <android.support.v7.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#F0F0F0"/>
</LinearLayout>
```

###### RecyclerView의 ItemView 만들기

item.xml 에서



```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="8dp"
    android:gravity="center_vertical"
    android:layout_marginBottom="8dp"
    android:background="@android:color/white">

    <LinearLayout
        android:layout_width="0dp"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:orientation="vertical"
        android:gravity="center_vertical">

        <TextView
            android:id="@+id/textView1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:includeFontPadding="false"
            android:text="TITLE"
            android:textSize="15sp"
            android:textColor="@android:color/black"
            android:textStyle="bold"/>

        <TextView
            android:id="@+id/textView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:includeFontPadding="false"
            android:text="content"
            android:textSize="13sp"
            android:textColor="@android:color/darker_gray"/>
    </LinearLayout>

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:src="@mipmap/ic_launcher"/>
</LinearLayout>
```
