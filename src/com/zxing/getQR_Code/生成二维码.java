package com.zxing.getQR_Code;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class 生成二维码 {

	public static void main(String[] args) {
		getQRCode();

	}
	
	public static void getQRCode(){
		//定义图片的宽度和高度
		int width=300;//定义图片的宽度
		int height=300;//定义图片的高度
		String format="png";//定义图片的格式
		
		System.out.println("输入内容：");
		Scanner scanner=new Scanner(System.in);
		String text=scanner.next();
		
		//定义二维码参数
		HashMap hints=new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//编码格式
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//纠错等级
		hints.put(EncodeHintType.MARGIN, 5);//边距，默认是5
		
		//生成二维码
		try {
			BitMatrix bitMatrix=new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);
//			String f="E:/two.png";
//			new File(f).delete();
//			Path file=new File(f).toPath();
//			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			OutputStream os=new FileOutputStream("two.png");
			MatrixToImageWriter.writeToStream(bitMatrix,format,os);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
