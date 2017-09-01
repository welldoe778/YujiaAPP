package com.strong.yujiaapp.utils;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;

/**
 * Created by Administrator on 2017-08-30.
 */

public class FileUtil {
    /**
     * 保存到收藏夹
     *
     * @param context
     *            上下文对象
     * @param pkgInfo
     *            服务器上的包信息
     * @return 判断结果（true：需要更细；false：不需要更新）
     */
    public static void saveFile(Context context, String name, Object object) {
        // 保存在本地
        try {
            // 通过openFileOutput方法得到一个输出流，方法参数为创建的文件名（不能有斜杠），操作模式
            FileOutputStream fos = context.openFileOutput(name,
                    Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);// 写入
            fos.close(); // 关闭输出流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * 获得指定文件信息
     *
     * @param context
     *            上下文对象
     * @param name
     *            文件名
     * @return
     */
    public static Object getFile(Context context, String name) {
        Object object = null;
        // String filename = "oauth_file.cfg";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = context.openFileInput(name); // 获得输入流
            ois = new ObjectInputStream(fis);
            object = ois.readObject();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (OptionalDataException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }
}
