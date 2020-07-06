package securityDemo.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Package: securityDemo.utils
 * @ClassName: ImgToAscii
 * @Description:
 * @UpdateDate: 2020/6/28 14:06
 */
public class ImgToAscii {
    public static void createAsciiPic(final String path, File file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        final String base = "@#&$%*o!;.";// 字符串由复杂到简单
        try {
            final BufferedImage image = ImageIO.read(new File(path));
            for (int y = 0; y < image.getHeight(); y += 2) {
                StringBuffer sb = new StringBuffer();
                for (int x = 0; x < image.getWidth(); x++) {
                    final int pixel = image.getRGB(x, y);
                    final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                    final int index = Math.round(gray * (base.length() + 1) / 255);
                    String s = index >= base.length() ? " " : String.valueOf(base.charAt(index));
                    System.out.print(s);
                    sb.append(s);
                }
                bw.write(sb.toString());
                bw.newLine();
                bw.flush();
                System.out.println();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\augurit\\Desktop\\banner.txt");
            if(!file.exists()){
                boolean newFile = file.createNewFile();
                if(!newFile){
                    System.out.println("生成结果文件出错");
                }
            }
//            String filePath="D:\\others\\img\\春日野穹2.jpg";
            String filePath="C:\\Users\\augurit\\Desktop\\1.jpg";
            createAsciiPic(filePath, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
