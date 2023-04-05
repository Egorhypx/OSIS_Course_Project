package by.egor.imageCompression;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

public class ImageLossyCompressor {

    public void compressImage(String imagePath) {
        try{
            File input = new File(imagePath);
            BufferedImage image = ImageIO.read(input);

            File compressedImageFolder = new File(input.getParentFile(), "Compressed");
            if(!compressedImageFolder.exists()){
                compressedImageFolder.mkdir();
            }

            File compressedImageFile = new File(compressedImageFolder, input.getName());
            OutputStream os =new FileOutputStream(compressedImageFile);

            Iterator<ImageWriter> writers =  ImageIO.getImageWritersByFormatName("jpg");
            ImageWriter writer = (ImageWriter) writers.next();

            ImageOutputStream ios = ImageIO.createImageOutputStream(os);
            writer.setOutput(ios);

            ImageWriteParam param = writer.getDefaultWriteParam();

            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(0.2f);
            writer.write(null, new IIOImage(image, null, null), param);

            os.close();
            ios.close();
            writer.dispose();
        }catch (FileNotFoundException e) {
           System.out.println("File not found\n");
        } catch (IOException e) {
            System.out.println("Smth wrong with the image, try another one\n Or wrong path input\n");
        }

    }
}
