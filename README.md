# BottomMenu

最近项目里面用到了底部的弹出提示框，UI小姐姐本着设计样式还是ios的好看原则。设计了一个ios样式的底部弹出提示框。**OK OK anyway**，类似样式并不少见，实现方式有很多，网上随便找一个吧，还不满大街都是。嗯哼，确实不少。**但是!!!** 不是讲代码就是讲布局，或者使用方法挺麻烦。

用的时候还要自己手写这部分代码，麻烦不麻烦？作为一名注定要改变世界的程序猿，你让我天天写这个？这是不能忍的。就没有简单的，快捷的，高效的，一句话就能搞定的吗？

有需求就有产品，所以，

## 这个BottomMenu产生了。

[![](https://jitpack.io/v/zhaolei9527/BottomMenu.svg)](https://jitpack.io/#zhaolei9527/BottomMenu)
[![](https://img.shields.io/badge/Go%20to-%E7%AE%80%E4%B9%A6-brightgreen.svg)](http://www.jianshu.com/p/8c7a3d0fcc46)

## 相关内容参数详细介绍《简书》：[一句话搞定高仿ios底部弹出提示框](http://www.jianshu.com/p/8c7a3d0fcc46)


#### 先来看下效果：

![演示](https://github.com/zhaolei9527/BottomMenu/blob/master/app/src/main/res/drawable/device.gif)


# How to use： 


**Step 1. Add the JitPack repository to your build file**
**Add it in your root build.gradle at the end of repositories:**
 ```java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
**Step 2. Add the dependency**
```java
	dependencies {
	        compile 'com.github.zhaolei9527:BottomMenu:v1.0.1'
	}
```
**Activity文件代码：（一句话，有木有?很简单，有木有？）**

基本用法：
```java
new BottomMenuFragment(MainActivity.this)
        .addMenuItems(new MenuItem("从相册选择"))
        .addMenuItems(new MenuItem("拍照"))
        .setOnItemClickListener(new BottomMenuFragment.OnItemClickListener() {
            @Override
            public void onItemClick(TextView menu_item, int position) {
                Toast.makeText(MainActivity.this, menu_item.getText().toString().trim(), Toast.LENGTH_SHORT).show();
            }
        })
        .show();
```
带Title用法：
```java
new BottomMenuFragment(MainActivity.this)
        .setTitle("标题")
        .addMenuItems(new MenuItem("从相册选择"))
        .addMenuItems(new MenuItem("拍照"))
        .setOnItemClickListener(new BottomMenuFragment.OnItemClickListener() {
            @Override
            public void onItemClick(TextView menu_item, int position) {
                Toast.makeText(MainActivity.this, menu_item.getText().toString().trim(), Toast.LENGTH_SHORT).show();
            }
        })
        .show();
```
指定条目样式用法：
```java
new BottomMenuFragment(MainActivity.this)
        .setTitle("标题")
        .addMenuItems(new MenuItem("从相册选择", MenuItem.MenuItemStyle.COMMON))
        .addMenuItems(new MenuItem("拍照", MenuItem.MenuItemStyle.STRESS))
        .setOnItemClickListener(new BottomMenuFragment.OnItemClickListener() {
            @Override
            public void onItemClick(TextView menu_item, int position) {
                Toast.makeText(MainActivity.this, menu_item.getText().toString().trim(), Toast.LENGTH_SHORT).show();
            }
        })
        .show();
```
全部一句话搞定，还有更多功能可以发掘一下。

## 总结
**代码整体满足了一句话搞定高仿ios底部弹出提示框的功能，当然，**

**有了需求才有了功能，有了想法才有了创作，你的反馈会是使我进步的最大动力。**

**觉得还不够方便？还想要什么功能？告诉我！欢迎反馈，欢迎Star。**
