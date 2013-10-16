#ActionTitleBar#
It is base official ActionBar Impl

you can use the same actionbar api in the actionTitlebar.

If you want to use actionbar like titlebar.

This is your best choose.

but current no stable don't use

support android 2.2+

#screenshots#
![](actiontitlebarexample.png)
#中文#
对于android actionbar 的兼容实现，目前用得最多的就是[ActionBarSherlock](https://github.com/JakeWharton/ActionBarSherlock) 那么为什么还要重复造一个轮子呢?在实际项目开发中，[ActionBarSherlock](https://github.com/JakeWharton/ActionBarSherlock) 的实现无疑是目前最强大的actionbar 兼容实现，
但是，强大并不意味着好用。

1. [ActionBarSherlock](https://github.com/JakeWharton/ActionBarSherlock) 的完全兼容一种侵入式实现，对于一些老项目而言这种实现完全不能用。

2. [ActionBarSherlock](https://github.com/JakeWharton/ActionBarSherlock)太大了，有时候，我们并不需要完全的actionbar功能，但是，我们却要为我们不需要的功能进行买单（导致打包后的安装包增大了几百K）。

3. [ActionBarSherlock](https://github.com/JakeWharton/ActionBarSherlock)需要一定的学习曲线。虽然，[ActionBarSherlock](https://github.com/JakeWharton/ActionBarSherlock)对比官方actionbar的api 只是加上一个Sherlock的前缀，但是，对于刚上手ActionBar的人来说，具有一定的疑惑。大大增加了学习的难度。

基于以上几点，我决定动手写一个足够轻量级的actionbar实现，它可能并不能像[ActionBarSherlock](https://github.com/JakeWharton/ActionBarSherlock)那样完全实现actionbar的所有功能，但是，如果你只是用actionbar 的比较简单的功能的话，或许可以考虑使用。

##实现原理##

从最新版本的sdk 源码中提取了ActionBar 源码，实际上这是个抽象类，定义了actionbar 相关接口。

然后，我继承这个类实现了另外一个版本的actionbar。这样的好处，就是可以能够完全重用官方的api。

实际使用中你只需要：

>`ActionTitleBar.getActionBar(this, titleMenu);`替换调原来的
`getActionBar();` 

然后，其他操作与官方的一样。

目前为止已经实现了：

1. 基本的actionbar，title， up
2. 实现了actionbar的list 导航和 标准（home up） 导航。
3. 用ActionTitleMenu 类 模拟实现了actionbar 的 actionview。


**这个实现已经在实际项目中使用目前暂时没空写demo**

notic:

1. 2.x 版本中千万不要在主题里面把title 关闭，因为实现的原理是通过替换调原来的title（与官方的actionbar实现原理一样），为了兼容2.x版本记得不要关闭title 的显示。

2. 对于4.x，如果要更好的显示，可以选择在主题，关闭原actionbar的显示。



##TODO list##
1. impl Tab nav.
2. impl custom view
3. impl sub title
4. support menu config
5. support custom theme
6. support actionmode

[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/youxiachai/actiontitlebar/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

