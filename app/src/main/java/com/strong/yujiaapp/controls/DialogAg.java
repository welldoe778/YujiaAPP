package com.strong.yujiaapp.controls;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.strong.yujiaapp.R;

/**
 * Created by Administrator on 2017/8/25.
 */

public class DialogAg {

    public static void getPromptDialog(final Context context, String msg) {

        View view = View.inflate(context, R.layout.dialog_prompt, null);

        final TextView tvInfo = (TextView) view.findViewById(R.id.tv_prompt_info);
        tvInfo.setText("msg");
        final TextView tv_know = (TextView) view.findViewById(R.id.tv_know);
        final MyDialog builder = new MyDialog(context, 0, 0, view, R.style.DialogTheme);

        //点击空白处是否关闭dialog
        builder.setCancelable(true);
        builder.show();
        //设置对话框显示的View
        //点击确定是的监听
        tv_know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
              /*  Toast.makeText(context, "确定按钮。。。", Toast.LENGTH_SHORT).show();*/
                builder.cancel();
            }
        });

    }

    /**
     * 客服电话 dialog
     *
     * @param context
     * @param msg
     */
    public static void getPhoneDialog(final Context context, final String msg) {

        View view = View.inflate(context, R.layout.dialog_call, null);
        final TextView tv_phone_number = (TextView) view.findViewById(R.id.tv_phone_number);
        tv_phone_number.setText(msg);
        final TextView call = (TextView) view.findViewById(R.id.call);
        final TextView cancel = (TextView) view.findViewById(R.id.cancel);
        final MyDialog builder = new MyDialog(context, 0, 0, view, R.style.DialogTheme);

        builder.setCancelable(false);
        builder.show();
        //设置对话框显示的View
        //点击确定是的监听
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //拨打客服电话
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + msg));
                context.startActivity(intent);
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.cancel();
            }
        });
    }


    /**
     * 提示说明信息
     */
    public static void getAskDialog(final Context context, String msg) {

        View view = View.inflate(context, R.layout.dialog_ask, null);

        //设置透明度
       /* View v = view.findViewById(R.id.ll_123123);
        v.getBackground().setAlpha(200);*/

        final TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvTitle.setText("删除地址");
        final TextView btnYes = (TextView) view.findViewById(R.id.f_quchecbutton_btn_queding);
        final TextView btlNo = (TextView) view.findViewById(R.id.f_quchecbutton_btn_quxiao);
        final MyDialog builder = new MyDialog(context, 0, 0, view, R.style.DialogTheme);

        builder.setCancelable(false);
        builder.show();
        //设置对话框显示的View
        //点击确定是的监听
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(context, "确定按钮。。。", Toast.LENGTH_SHORT).show();
                builder.cancel();
            }
        });


        btlNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "取消按钮。。。", Toast.LENGTH_SHORT).show();
                builder.cancel();
            }
        });


    }
}
