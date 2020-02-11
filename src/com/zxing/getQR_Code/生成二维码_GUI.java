package com.zxing.getQR_Code;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class 生成二维码_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	
	String savepath="one.png";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					生成二维码_GUI frame = new 生成二维码_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public 生成二维码_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u4E8C\u7EF4\u7801\u5185\u5BB9\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		label.setBounds(15, 30, 160, 30);
		contentPane.add(label);

		textField = new JTextField();
		textField.setBounds(15, 60, 355, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(15, 100, 100, 30);
		contentPane.add(button);

		JLabel label1 = new JLabel("(500字以内)");
		label1.setFont(new Font("宋体", Font.PLAIN, 12));
		label1.setBounds(130, 100, 160, 30);
		label1.setForeground(Color.RED);
		contentPane.add(label1);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(398, 30, 230, 230);
		contentPane.add(lblNewLabel);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().trim().equals("")) {
					javax.swing.JOptionPane.showMessageDialog(生成二维码_GUI.this, "输入不能为空!");
					return;
				}

					int width=200;
					int height=200;
					String format="png";

					//定义二维码的参数
					HashMap hints=new HashMap();
					hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
					hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
					hints.put(EncodeHintType.MARGIN, 1);

					//生成二维码
					try {
						BitMatrix bitMatrix=new MultiFormatWriter().encode(textField.getText(), BarcodeFormat.QR_CODE, width, height,hints);
						OutputStream os=new FileOutputStream(savepath);
						MatrixToImageWriter.writeToStream(bitMatrix,format,os);

						lblNewLabel.setIcon(new ImageIcon(ImageIO.read(new File(savepath))));

					} catch (Exception ex) {
						ex.printStackTrace();
					}

			}

		});
	}

}
