package com.ytz.spoilyou.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class HandlePhoto {
	public String handlePhoto(MultipartFile rdPhoto) throws IllegalStateException, IOException {
		// 项目根路径下的目录 -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
				String image_path = "static/photos";
				image_path="static/images/pets";
				String filename="";//加上前缀的文件名

				// 构建上传文件的存放 "文件夹" 路径
				String fileDirPath = new String("src/main/resources/" + image_path);

				File fileDir = new File(fileDirPath);
				if (!fileDir.exists()) {
					// 递归生成文件夹
					fileDir.mkdirs();
				}
				if (rdPhoto.isEmpty()) {
					// 设置错误状态码
					// return msg;
				} else {
					// 创建唯一文件名称
					char array_code[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
							'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A',
							'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
							'V', 'W', 'X', 'Y', 'Z' };
					String filecode = "";
					for (int i = 0; i < 10; i++) {
						int j = (int) (Math.random() * 52);
						filecode += array_code[j];
					}
					filecode += "_";

					// 拿到文件名
					filename = filecode + rdPhoto.getOriginalFilename();

					// 存放上传图片的文件夹
					// 输出文件夹绝对路径 -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
					// System.out.println(fileDir.getAbsolutePath());

					// 构建真实的文件路径
					File newFile=new File(fileDir.getAbsolutePath() + File.separator + filename);
					
					// System.out.println(newFile.getAbsolutePath());
					rdPhoto.transferTo(newFile);
				}
				return filename;
	}

}
