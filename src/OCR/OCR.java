package OCR;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OCR {
   private native String[] run(byte[] a);
   
   public static void main(String[] args) {
        System.loadLibrary("libtesseract302");
        System.loadLibrary("liblept168");
        System.loadLibrary("opencv_core2413");
        System.loadLibrary("opencv_highgui2413");
        System.loadLibrary("opencv_imgproc2413");
        System.loadLibrary("OCR");

        File fnew=new File("input/face.jpg");
        try {
            BufferedImage originalImage=ImageIO.read(fnew);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            ImageIO.write(originalImage, "jpg", baos );
            byte[] imageInByte=baos.toByteArray();

        String[] words = new OCR().run(imageInByte);
            for (int i = 0; i < words.length; i++) {
                System.err.println(i + " : " + words[i]);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }

   }
 }
