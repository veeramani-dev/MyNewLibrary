package com.example.libraryfiles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QRClass {
    private Context context;
    public QRClass(Context context) {
        this.context = context;
    }
    public Bitmap generateQR(String str)
    {
        WindowManager manager;
        QRGEncoder qrGenerator;
        if(!str.isEmpty()){
            manager =(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display=manager.getDefaultDisplay();
            Point point= new Point();
            display.getSize(point);
            int width=point.x;
            int height=point.y;
            int dimen=width<height? width:height;
            dimen=dimen*3/4;
            qrGenerator=new QRGEncoder(str,null, QRGContents.Type.TEXT,dimen);
            return qrGenerator.getBitmap();
        }else{
            Toast.makeText(context, "Text is empty", Toast.LENGTH_SHORT).show();
            return null;
        }
    }


}
