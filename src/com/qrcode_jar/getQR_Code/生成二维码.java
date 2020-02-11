package com.qrcode_jar.getQR_Code;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class 生成二维码 {

	public static void main(String[] args) throws Exception{
		Qrcode x=new Qrcode();
		x.setQrcodeErrorCorrect('M');//	纠错等级
		x.setQrcodeEncodeMode('B');	//	N代表数字，A代表a-z，B代表其他字符
		x.setQrcodeVersion(7);	//	版本，1~40，默认5
		String qrData="袁静，我喜欢你，你的名字我会一直记住，打死的不可能忘记的。"
				+ "虽然我们认识时间不长，但在这短暂几天的相处相识，我发现你是对自己有要求，有理想，有追求的人。"
				+ "我们第一次见面，也是我第一次见网友，有些放不开，见到你时，我内心既开心又激动，同时还有些羞涩。"
				+ "你的性格外向，开朗，乐观，显得理性的女孩儿。"
				+ "虽然我和你的性格不太一样，比较内向，但是有这种性格差异也不是件坏事呀。"
				+ "我们还有很多共同的爱好呢，乒乓球，羽毛球，台球，旅游等，你不说乒乓球台球我都快忘了这个爱好。"
				+ "第二次见面是你到学校来看我，陪我自习，别说我有多开心了，虽然没有表现出来，但真的是很开心很开心的。"
				+ "不过陪我来自习还是委屈你了，特地来学校看我，然后陪我自习怎么也有点怪怪的。"
				+ "和你在一起是很开心，我可能没有一副好嗓子为你唱歌，没有soul里面的小哥哥多才多艺，我也不知道会给你带来什么，"
				+ "但我会尽可能的去努力，做更好的自己，让你快乐。特别想和你在一起，做我女朋友好吗？";
		int width=67+12*(7-1);//公式居中
		int height=67+12*(7-1);
		
		BufferedImage bufferedImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D gs=bufferedImage.createGraphics();
		
		gs.setBackground(Color.WHITE);
		gs.setColor(Color.BLACK);
		gs.clearRect(0, 0, width, height);
		
		int pixoff=2;	//	偏移量
		
		byte[] d =qrData.getBytes("gb2312");
		if(d.length>0&&d.length<120){
			boolean[][] s=x.calQrcode(d);
			
			for(int i=0;i<s.length;i++){
				for(int j=0;j<s.length;j++){
					if(s[j][i]){
						gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);
					}
				}
			}
		}
		
		gs.dispose();
		bufferedImage.flush();
		
		ImageIO.write(bufferedImage, "png", new File("E:/jsp_QR_Code.png"));
		

	}

}
