# 3DViewPager
# Android ViewPager实现3D画廊效果
 
 Android从3.0开始，就添加了很多动画，ViewPager当然也不例外，相对于非常平庸的默认切换动画，Google给我们提供了ViewPager实现动画效果的方法，我们可以通过实现ViewPager.PageTransformer来做出完全不同的切换动画效果，关键是要理解transformPage(View view, float position)的参数。view理所当然就是滑动中的那个view，position这里是float类型，不是平时理解的int位置，而是当前滑动状态的一个表示，比如当滑动到正全屏时，position是0，而向左滑动，使得右边刚好有一部被进入屏幕时，position是1，如果前一页和下一页基本各在屏幕占一半时，前一页的position是-0.5，后一页的posiotn是0.5，所以根据position的值我们就可以自行设置需要的ScaleX，ScaleY信息。

![image](https://github.com/AndyRenJie/3DViewPager/blob/master/20171201161010.jpg)
 
![image](https://github.com/AndyRenJie/3DViewPager/blob/master/20171201161018.jpg)
 
![image](https://github.com/AndyRenJie/3DViewPager/blob/master/20171201161023.jpg)

```
public class MyPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.85f;

    @Override
    public void transformPage(View page, float position) {
        float scaleFactor=Math.max(MIN_SCALE,1-Math.abs(position));
        float rotate=20*Math.abs(position);
        if (position<0){
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(rotate);
        }else if (position>=0 && position<1){
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(-rotate);
        }else if (position>=1) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(-rotate);
        }
    }
}
```
