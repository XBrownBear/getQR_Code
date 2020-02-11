package com.qrcode_jar.getQR_Code;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class 识别二维码 {

	public static void main(String[] args) throws Exception{
		File file=new File("E:/jsp_QR_Code.png");
		
		BufferedImage bufferedImage=ImageIO.read(file);
		
		QRCodeDecoder codeDecoder=new QRCodeDecoder();
		
		String result=new String(codeDecoder.decode(new MyQRCodeImage(bufferedImage)), "gb2312");

		System.out.println(result);
	}

}
