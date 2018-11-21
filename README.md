# Material-Backdrop-Android

### This library is created based on Backdrop component from material design.[Backdrop](https://material.io/design/components/backdrop.html)

![alt text](https://github.com/kishan2612/Material-DropView-Android/blob/master/images/backdrop1.png)
![alt text](https://github.com/kishan2612/Material-DropView-Android/blob/master/images/backdrop2.png)

### Usage

1. Include repository
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
2. Include project as local library
```
dependencies {
	        implementation 'com.github.kishan2612:Material-Backdrop-Android:v1.1.0'
	}
```
3. Include the widget in your layout

```

 <com.evolve.backdroplibrary.BackdropContainer
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:id="@+id/backdropcontainer"
       app:menuIcon="@drawable/ic_menu_24px"
       app:closeIcon="@drawable/ic_close_24px"
       app:duration="500">

       <include layout="@layout/backlayer"/>
       <include layout="@layout/frontlayer"/>


   </com.evolve.backdroplibrary.BackdropContainer>
```
### The container must contain only two child or it may throw an Exception.
The developer can customize the backlayer and frontlayer of their choice. Use public methods to show and hide the backlayer.

4. In onCreate method 
```
 
 backdropContainer =(BackdropContainer)findViewById(R.id.backdropcontainer);

        backdropContainer.attachToolbar(toolbar)
                .dropInterpolator(new LinearInterpolator())
                .dropHeight(height)
                .build();
```

### Customization

 app:menuIcon="@drawable/ic_menu_24px" - You can use your own icon or app logo
 
 app:closeIcon="@drawable/ic_close_24px" - You can use your own icon or app logo
 
 app:duration="500" - default duration is 1000ms if duration is not specified
 
 dropInterpolator(new LinearInterpolator()) - You can use own interpolator
 
 dropHeight(height) - The height is sneek height of front layer.(Dp)
 eg :
 ```
 int height= this.getResources().getDimensionPixelSize(R.dimen.sneek_height);
 ```
### Compatabiliy

Api 16+

## ChangeLog

#### V1.0 :
      Initial build.
      
# License

```
MIT License

Copyright (c) 2018 kishan V

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
