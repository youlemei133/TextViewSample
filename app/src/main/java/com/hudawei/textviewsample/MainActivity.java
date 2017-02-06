package com.hudawei.textviewsample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textDrawable();

        textHtml();

        textSpan();

    }

    private void textSpan() {
        TextView textSpan=(TextView)findViewById(R.id.text_span);
        SpannableString span=new SpannableString("7.背景色 可点击 前景色 模糊 删除线 下划线 大字体 123456789 相对大小字体" +
                " 基于x轴缩放 字体样式 文本字体 下标2 上标2 电话");
        //设置背景色
        BackgroundColorSpan colorSpan=new BackgroundColorSpan(Color.parseColor("#00FF00"));
        span.setSpan(colorSpan,2,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置点击事件 a.实现onClick方法 b.需要设置TextView响应点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"响应点击",Toast.LENGTH_SHORT).show();
                Log.e("","执行拉");
            }
        };
        span.setSpan(clickableSpan,6,9,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置前景色,及字体颜色
        ForegroundColorSpan foreSpan=new ForegroundColorSpan(Color.parseColor("#0000FF"));
        span.setSpan(foreSpan,10,13,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置模糊效果，其中BlurMaskFilter构造方法的第一个参数radius代表模糊程度，第二个参数代表模糊的位置
        BlurMaskFilter blurMaskFilter=new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.OUTER);
        MaskFilterSpan blurSpan=new MaskFilterSpan(blurMaskFilter);
        span.setSpan(blurSpan,14,16,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置浮雕效果
//        EmbossMaskFilter embossFilter=new EmbossMaskFilter(new float[]{1.0f,5.0f,1.0f},0.5f,10f,7.5f);
//        MaskFilterSpan embossSpan=new MaskFilterSpan(embossFilter);
//        span.setSpan(embossSpan,17,21,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置删除线
        StrikethroughSpan strikethroughSpan =new StrikethroughSpan();
        span.setSpan(strikethroughSpan,17,20,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置下划线
        UnderlineSpan underlineSpan=new UnderlineSpan();
        span.setSpan(underlineSpan,21,24,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体绝对大小
        AbsoluteSizeSpan sizeSpan=new AbsoluteSizeSpan(30,true);
        span.setSpan(sizeSpan,25,28,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        DynamicDrawableSpan drawableSpan = new DynamicDrawableSpan() {
//            @Override
//            public Drawable getDrawable() {
//                return MainActivity.this.getResources().getDrawable(R.mipmap.ic_launcher);
//            }
//        };
//        span.setSpan(drawableSpan,29,30,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置图片替换文本
        Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(),R.mipmap.ic_launcher);
        ImageSpan imageSpan=new ImageSpan(this,bitmap);
        span.setSpan(imageSpan,29,38,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体相对大小，RelativeSizeSpan构造方法的第一个参数为文本字体的倍数 20*0.5
        RelativeSizeSpan relativeSizeSpan=new RelativeSizeSpan(0.5f);
        span.setSpan(relativeSizeSpan,39,45,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置X方向收缩字体
        ScaleXSpan scaleXSpan=new ScaleXSpan(1.5f);
        span.setSpan(scaleXSpan,46,52,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体样式，粗体 斜体
        StyleSpan styleSpan=new StyleSpan(Typeface.BOLD|Typeface.ITALIC);
        span.setSpan(styleSpan,53,57,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体family
        TypefaceSpan typefaceSpan =new TypefaceSpan("宋体");
        span.setSpan(typefaceSpan,58,62,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置下标
        SubscriptSpan subscriptSpan=new SubscriptSpan();
        span.setSpan(subscriptSpan,65,66,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置上标
        SuperscriptSpan superscriptSpan=new SuperscriptSpan();
        span.setSpan(superscriptSpan,69,70,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置一个链接，需要配合setMovementMethod方法使用
        URLSpan urlSpan=new URLSpan("tel:18373368716");
        span.setSpan(urlSpan,71,73,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textSpan.setText(span);
        //设置可响应点击事件
        textSpan.setMovementMethod(LinkMovementMethod.getInstance());

    }

    /**
     * 设置带图片的TextView
     */
    private void textDrawable() {
        TextView textView= (TextView) findViewById(R.id.text_delete);
//        Drawable[] drawables = textView.getCompoundDrawables();
//        textView.setCompoundDrawables(drawables[0],drawables[1],drawables[2],drawables[3]);
    }

    /**
     * 显示Html
     */
    private void textHtml() {
        TextView textHtml= (TextView) findViewById(R.id.text_html);
        String s1 = "6.<font color='blue'><b>百度一下，你就知道~：</b></font><br>";
        s1 += "<a href = 'tel:18373368716'>百度</a>";
        textHtml.setText(Html.fromHtml(s1));
        textHtml.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
